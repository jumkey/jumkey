import java.net.*;

import java.io.*;

import java.util.Properties;

import java.util.Enumeration;


/**

 Http客户端程序已集成在Java语言中，可以通过URLConnection类调用。遗憾的

 是，由于SUN没有公布Http客户程序的源码，它实现的细节仍是一个谜。本文根据HTTP

 协议规范，用Java.net.Socket类实现一个HTTP协议客户端程序.


 <pre>


 1.Socket类:

 了解TCP/IP协议集通信的读者知道，协议间的通信是通过Socket完成的。在

 Java.net包中，Socket类就是对Socket的具体实现。它通过连接到主机后，返回一个

 I/O流，实现协议间的信息交换。


 2 . HTTP协议

 HTTP协议同其它TCP/IP协议集中的协议一样，是遵循客户/服务器模型工作的。客

 户端发往服务端的信息格式如下:

 ------------------------------

 请求方法 URL HTTP协议的版本号

 提交的元信息

 **空行**

 实体

 ------------------------------

 请求方法是对这次连接工作的说明，目前HTTP协议已经发展到1.1版，它包括GET、

 HEAD、POST、DELETE、OPTIONS、TRACE、PUT七种。元信息是关于当前请求的信息。通

 过分析元信息，可以检查实体数据是否完整，接收过程是否出错，类型是否匹配等。元

 信息的引入使HTTP协议通信更加稳妥可靠。实体是请求的具体内容。

 将上述报文发往Web服务器，如果成功，应答格式如下:

 --------------------------------

 HTTP协议的版本号 应答状态码 应答状态码说明

 接收的元信息

 **空行**

 实体

 --------------------------------

 以上报文发向客户端，并且接收成功，彼此间关闭连接，完成一次握手。

 下面用最常用的GET方法，来说明具体的报文应用

 ----------------------------------

 GET http://www.youhost.com HTTP/1.0

 accept: www/source; text/html; image/gif; image/jpeg; *／*

 User_Agent: myAgent

 **空行**

 -----------------------------------

 这个报文是向www.youhost.com主机请求一个缺省HTML文档。客户端HTTP协议版本

 号是1.0版，元信息包括可接收的文件格式，用户代理，每一段之间用回车换行符分

 隔，最后以一个空行结束。发向服务器后，如果执行过程正常，服务器返回以下代码:

 ------------------------------------

 HTTP/1.1 200 OK

 Date: Tue, 14 Sep 1999 02:19:57 GMT

 Server: Apache/1.2.6

 Connection: close

 Content-Type: text/html

 **空行**

 <html><head>...</head><body>...</body></html>

 ------------------------------------

 HTTP/1.1表示这个HTTP服务器是1.1版，200是服务器对客户请求的应答状态码，OK

 是对应答状态码的解释，之后是这个文档的元信息和文档正文。(相关应答状态码和元

 信息的解释请参阅Inetrnet标准草案:RFC2616)。


 注: 程序中只实现GET、HEAD、POST三种方法。其他几种因不常使用，暂且忽略。


 </pre>


 */

public class Http{

    protected Socket client;

    protected BufferedOutputStream sender;

    protected BufferedInputStream receiver;

    protected ByteArrayInputStream byteStream;

    protected URL target;

    private int responseCode = -1;

    private String responseMessage = "";

    private String serverVersion = "";

    private Properties header = new Properties();


    public Http(){}


    public Http(String url){

        GET(url);

    }


    /* GET方法根据URL，会请求文件、数据库查询结果、程序运行结果等多种内容 */

    public void GET(String url){

        try{

            checkHTTP(url);

            openServer(target.getHost(),target.getPort());

            String cmd = "GET " + getURLFormat(target) + " HTTP/1.0\r\n" +

            getBaseHeads() + "\r\n";

            sendMessage(cmd);

            receiveMessage();

        }

        catch(ProtocolException p){

            p.printStackTrace();

            return;

        }

        catch(UnknownHostException e){

            e.printStackTrace();

            return;

        }

        catch(IOException i){

            i.printStackTrace();

            return;

        }

    }


    /*

     * HEAD方法只请求URL的元信息，不包括URL本身。若怀疑本机和服务器上的

     * 文件相同，用这个方法检查最快捷有效。

     */

    public void HEAD(String url){

        try{

            checkHTTP(url);

            openServer(target.getHost(),target.getPort());

            String cmd = "HEAD " + getURLFormat(target) + " HTTP/1.0\r\n" +

            getBaseHeads() + "\r\n";

            sendMessage(cmd);

            receiveMessage();

        }

        catch(ProtocolException p){

            p.printStackTrace();

            return;

        }

        catch(UnknownHostException e){

            e.printStackTrace();

            return;

        }

        catch(IOException i){

            i.printStackTrace();

            return;

        }

    }


    /*

     * POST方法是向服务器传送数据，以便服务器做出相应的处理。例如网页上常用的

     * 提交表格。

     */

    public void POST(String url,String content){

        try{

            checkHTTP(url);

            openServer(target.getHost(),target.getPort());

            String cmd = "POST " + getURLFormat(target) + " HTTP/1.0\r\n" +

            getBaseHeads();

            cmd += "Content-type: application/x-www-form-urlencoded\r\n";

            cmd += "Content-length: " + content.length() + "\r\n\r\n";

            cmd += content + "\r\n";

            sendMessage(cmd);

            receiveMessage();

        }

        catch(ProtocolException p){

            p.printStackTrace();

            return ;

        }

        catch(UnknownHostException e){

            e.printStackTrace();

            return ;

        }

        catch(IOException i){

            i.printStackTrace();

            return ;

        }


    }


    protected void checkHTTP(String url) throws ProtocolException{

        try{

            URL target = new URL(url);

            if(target == null ||

               !target.getProtocol().toUpperCase().equals("HTTP")){

                throw new ProtocolException("这不是HTTP协议");

            }

            this.target = target;

        }

        catch(MalformedURLException m){

            throw new ProtocolException("协议格式错误");

        }

    }


    /*

     * 与Web服务器连接。若找不到Web服务器，InetAddress会引发UnknownHostException

     * 异常。若Socket连接失败，会引发IOException异常。

     */

    protected void openServer(String host,int port) throws UnknownHostException,

    IOException{

        header.clear();

        responseMessage = "";

        responseCode = -1;


        if(client != null){

            closeServer();

        }

        if(byteStream != null){

            byteStream.close();

            byteStream = null;

        }


        InetAddress address = InetAddress.getByName(host);

        client = new Socket(address,port == -1 ? 80 : port);

        client.setSoTimeout(5000);

        sender = new BufferedOutputStream(client.getOutputStream());

        receiver = new BufferedInputStream(client.getInputStream());

    }


    /* 关闭与Web服务器的连接 */

    protected void closeServer() throws IOException{

        if(client == null){

            return;

        }

        try{

            client.close();

            sender.close();

            receiver.close();

        }

        catch(IOException i){

            throw i;

        }


        client = null;

        sender = null;

        receiver = null;

    }


    protected String getURLFormat(URL target){

        String spec = "http://" + target.getHost();

        if(target.getPort() != -1){

            spec += ":" + target.getPort();

        }


        return spec += target.getFile();

    }


    /* 向Web服务器传送数据 */

    protected void sendMessage(String data) throws IOException{

        sender.write(data.getBytes(),0,data.length());

        sender.flush();

    }


    /* 接收来自Web服务器的数据 */

    protected void receiveMessage() throws IOException{

        byte data[] = new byte[1024];

        int count = 0;

        int word = -1;

        // 解析第一行

        while( (word = receiver.read()) != -1){

            if(word == '\r' || word == '\n'){

                word = receiver.read();

                if(word == '\n') {

                    word = receiver.read();

                }

                break;

            }

            if(count == data.length) {

                data = addCapacity(data);

            }

            data[count++] = (byte) word;

        }

        String message = new String(data,0,count);

        int mark = message.indexOf(32);

        serverVersion= message.substring(0,mark);

        while(mark < message.length() && message.charAt(mark + 1) == 32) {

            mark++;

        }

        responseCode = Integer.parseInt(message.substring(mark + 1,mark += 4));

        responseMessage = message.substring(mark,message.length()).trim();


        // 应答状态码和处理请读者添加

        switch(responseCode){

            case 400:

                throw new IOException("错误请求");

            case 404:

                throw new FileNotFoundException(getURLFormat(target));

            case 503:

                throw new IOException("服务器不可用");

        }

        if(word == -1){

            throw new ProtocolException("信息接收异常终止");

        }

        int symbol = -1;

        count = 0;

        // 解析元信息

        while(word != '\r' && word != '\n' && word > -1){

            if(word == '\t') {

                word = 32;

            }

            if(count == data.length) {

                data = addCapacity(data);

            }

            data[count++] = (byte) word;

            parseLine:{

                while( (symbol = receiver.read()) > -1){

                    switch(symbol){

                        case '\t':

                            symbol = 32;

                            break;

                        case '\r':

                        case '\n':

                            word = receiver.read();

                            if(symbol == '\r' && word == '\n'){

                                word = receiver.read();

                                if(word == '\r') {

                                    word = receiver.read();

                                }

                            }

                            if(word == '\r' || word == '\n' || word > 32){

                                break parseLine;

                            }

                            symbol = 32;

                            break;

                    }

                    if(count == data.length) {

                        data = addCapacity(data);

                    }

                    data[count++] = (byte) symbol;

                }

                word = -1;

            }

            message = new String(data,0,count);

            mark = message.indexOf(':');

            String key = null;

            if(mark > 0) {

                key = message.substring(0,mark);

            }

            mark++;

            while(mark < message.length() && message.charAt(mark) <= 32) {

                mark++;

            }

            String value = message.substring(mark,message.length());

            header.put(key,value);

            count = 0;

        }

        // 获得正文数据

        while( (word = receiver.read()) != -1){

            if(count == data.length) {

                data = addCapacity(data);

            }

            data[count++] = (byte) word;

        }

        if(count > 0) {

            byteStream = new ByteArrayInputStream(data,0,count);

        }

        data = null;

        closeServer();

    }


    public String getResponseMessage(){

        return responseMessage;

    }


    public int getResponseCode(){

        return responseCode;

    }


    public String getServerVersion(){

        return serverVersion;

    }


    public InputStream getInputStream(){

        return byteStream;

    }


    public synchronized String getHeaderKey(int i){

        if(i >= header.size()){

            return null;

        }

        Enumeration enumss = header.propertyNames();

        String key = null;

        for(int j = 0; j <= i; j++){

            key = (String) enumss.nextElement();

        }

        return key;

    }


    public synchronized String getHeaderValue(int i){

        if(i >= header.size()){

            return null;

        }

        return header.getProperty(getHeaderKey(i));

    }


    public synchronized String getHeaderValue(String key){

        return header.getProperty(key);

    }


    protected String getBaseHeads(){

        String inf = "User-Agent: ZealHttp/1.0\r\nAccept: www/source; text/html; image/gif; */*\r\n";

        return inf;

    }


    private byte[] addCapacity(byte rece[]){

        byte temp[] = new byte[rece.length + 1024];

        System.arraycopy(rece,0,temp,0,rece.length);

        return temp;

    }

}