/**

 * 本程序实现简单的HTTP代理客户端浏览器

 * 步骤：

 * 1、调用java.net包中的URL类并生成对象url;

 * 2、调用url.openConnection()方法实现直接连接;

 * 3、调用url.openConnection(Proxy)方法实现代理连接;

 * 4、Proxy(Proxy.Type.HTTP, proxyAddress)实现HTTP代理的对象;

 * 5、文件浏览功能的实现原理：将需要浏览的文件下载到本机，然后读取出来并显示在面板上;

 * 作者：蓝蔡


 */
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import java.net.*;

public class ProxyTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JFrame proxyFrame = new JFrame("代理客户端");

		final JTextArea showArea = new JTextArea(10, 20);

		JPanel northPanel = new JPanel(new FlowLayout());

		JScrollPane centerPanel = new JScrollPane(showArea);

		JPanel southPanel = new JPanel(new FlowLayout());

		JLabel addressLabel = new JLabel("输入网址：");

		JLabel selectLabel = new JLabel("选择代理类型：");

		JLabel proxyLabel = new JLabel("代理");

		JLabel noProxyLabel = new JLabel("直连");

		JButton showButton = new JButton("浏览");

		final JRadioButton proxyRadioButton = new JRadioButton();
		final JRadioButton noProxyRadioButton = new JRadioButton();
		final JTextField addressField = new JTextField(15);
		proxyFrame.setSize(350, 350);
		proxyFrame.setLocation(150, 150);
		proxyFrame.setLayout(new BorderLayout());
		showArea.setWrapStyleWord(true);
		// NorthPanel
		northPanel.add(addressLabel);
		northPanel.add(addressField);
		northPanel.add(showButton);
		proxyFrame.getContentPane().add(northPanel, "North");
		// CenterPanel
		// proxyFrame.getContentPane().add(centerPanel,BorderLayout.CENTER);
		// SouthPanel
		southPanel.add(selectLabel);
		southPanel.add(proxyRadioButton);
		southPanel.add(proxyLabel);
		southPanel.add(noProxyRadioButton);
		southPanel.add(noProxyLabel);
		proxyFrame.getContentPane().add(southPanel, "South");
		proxyFrame.setDefaultCloseOperation(proxyFrame.EXIT_ON_CLOSE);
		proxyFrame.show();
		// 点击“浏览”按钮的事件响应代码
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = addressField.getText();
				URL url = null;
				URLConnection urlCon = null;
				try {
					showArea.setText("");
					// 直接连接
					if (!(proxyRadioButton.isSelected())
							&& (noProxyRadioButton.isSelected())) {
						url = new URL(str);
						urlCon = url.openConnection();
					}
					// 代理连接默认为HTTP
					else if ((proxyRadioButton.isSelected())
							&& !(noProxyRadioButton.isSelected())) {
						SocketAddress proxyAddress = new InetSocketAddress(
								"192.168.90.146", 8084);
						Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddress);
						url = new URL(str);
						urlCon = url.openConnection(proxy);
					} else
						JOptionPane.showMessageDialog(null, "请选择连接类型");

					// 以下显示连接的属性：主机名，端口，连接的文件类型，连接的文件长度
					final String line = System.getProperty("line.separator");
					showArea.append("host :" + url.getHost());
					showArea.append(line);
					showArea.append("port :" + url.getPort());
					showArea.append(line);
					showArea.append("Contenttype :" + urlCon.getContentType());
					showArea.append(line);
					showArea.append("Contentlength :"
							+ urlCon.getContentLength());

					final InputStream in = urlCon.getInputStream();
					final FileOutputStream out = new FileOutputStream(
							"Temp.txt");
					final FileInputStream display = new FileInputStream(
							"Temp.txt");
					// 利用文件下载和读取的方式实现浏览功能
					// 此处利用线程实现是为了实现多个任务的并发进行
					Runnable r = new Runnable() {

						int data;
						byte[] data2 = new byte[10 * 1024];
						int len;

						// 此处利用实现synchronized同步,避免不同线程之间冲突
						synchronized public void run() {
							try {
								while ((data = in.read()) != -1)
									out.write(data);
								out.close();
								in.close();
								len = display.read(data2);
								display.close();
								showArea.append(new String(data2, 0, len));
							} catch (Exception ex) {
								System.out.println("读失败");
							}
						}
					};

					Thread t = new Thread(r);
					t.start();
				} catch (Exception ex) {
					ex.getStackTrace();
				}

			}
		});

	}
}