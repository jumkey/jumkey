package blog;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.DAO.FileDAO;
import blog.DAO.FileDAOImpl;
import blog.pojo.EEFile;

import com.google.appengine.api.datastore.Blob;

@SuppressWarnings("serial")
public class Upload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Upload() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("get");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("test"));
		System.out.println(request.getHeader("Content-Type"));

		String filename = URLDecoder.decode(request.getHeader("X-File-Name"),"UTF-8");
		InputStream inputStream = request.getInputStream();
		
		
		// inputstream to byte[]
		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
		int ch;
		while ((ch = inputStream.read()) != -1) {
			bytestream.write(ch);
		}
		byte[] file = bytestream.toByteArray();
		bytestream.close();
		inputStream.close();
		
		EEFile eef=new EEFile();
		eef.setFilename(filename);
		eef.setDescription("sasd");
		eef.setUploadDate(new Date());
		eef.setMimeType(filename);
		eef.setFile(new Blob(file));
		
		FileDAO fd=new FileDAOImpl();
		fd.addFile(eef);

		response.getWriter().println("{\"file\":\""+URLDecoder.decode(request.getHeader("X-File-Name"),"UTF-8")+"\"}");
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
