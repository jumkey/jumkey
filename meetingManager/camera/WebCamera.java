import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.media.Buffer;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class WebCamera extends Applet implements ActionListener {

	public static Player player = null;

	/** * 设备选择 */
	private Choice choice = null;

	private MediaLocator ml = null;

	/** * 拍照按钮 */
	private Button capture = null;

	/** * 保存按钮 */
	private Button save = null;

	/** * 名称输入框 */
	private TextField num = null;

	private Buffer buf = null;

	private Image img = null;

	private BufferToImage btoi = null;

	private ImagePanel imgpanel = null;

	/** * 选取框的x,y,width,height参数的默认值 */
	private int rectX;

	private int rectY;

	private int rectWidth = 240;

	private int rectHeight = 205;

	private int imgWidth = 280;

	private int imgHeight = 205;

	/** * 默认保存文件名 */
	private String path = "D:/apache-tomcat-6.0.29/webapps/meetingManager/Photos/";
	private String fname = "test";
	private String s_url = null;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
		// 顺便设置了文本框
		num.setText(fname);
	}

	public WebCamera() {
		super();
	}

	public void init() {
		s_url = getParameter("s_url");
		System.err.println(" ========= "+s_url);
		setSize(840, 485);
		setLayout(new BorderLayout());

		imgpanel = new ImagePanel();
		capture = new Button("拍照");
		capture.addActionListener(this);
		save = new Button("保存");
		save.addActionListener(this);
		num = new TextField();
		num.setEnabled(false);

		choice = new Choice();
		CaptureDeviceInfo[] a = getVideoDevices();
		for (CaptureDeviceInfo cdi : a) {
			choice.add(cdi.getName());
		}
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(((Choice) e.getSource()).getSelectedIndex());
			}
		});

		ml = getVideoDevices()[0].getLocator();
		try {
			player = Manager.createRealizedPlayer(ml);
			player.start();

			add(choice, BorderLayout.NORTH);
			Component comp = player.getVisualComponent();
			add(comp, BorderLayout.CENTER);
			Panel panel_r = new Panel(new BorderLayout());
			panel_r.add(save, BorderLayout.NORTH);
			panel_r.add(imgpanel, BorderLayout.CENTER);
			panel_r.add(capture, BorderLayout.SOUTH);
			add(panel_r, BorderLayout.EAST);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭摄像头
	 */
	public void destroy() {
		player.close();
		player.deallocate();
	}

	/**
	 * 点击拍照
	 */
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		if (c == capture) { // Grab a frame
			FrameGrabbingControl fgc = (FrameGrabbingControl) player
					.getControl("javax.media.control.FrameGrabbingControl");
			buf = fgc.grabFrame();// Convert it to an image
			btoi = new BufferToImage((VideoFormat) buf.getFormat());
			img = btoi.createImage(buf);// show the image
			System.err.println(imgpanel.getPreferredSize().getWidth());
			System.err.println(imgpanel.getPreferredSize().getHeight());
			System.err.println(imgpanel.getSize().getWidth());
			System.err.println(imgpanel.getSize().getHeight());
			imgpanel.setImage(ImageHelper.scale(ImageHelper
					.toBufferedImage(img), imgWidth, imgHeight,
					ImageHelper.GEOMETRIC_SCALING_X)); // save image
		} else if (c == save) {
			if (img != null) {
				fname = num.getText().equals("") ? fname : num.getText();
				saveJPG(img, path + fname + ".jpg");
			}
		}
	}

	// 取系统所有可采集的硬件设备列表
	private CaptureDeviceInfo[] getDevices() {
		Vector<CaptureDeviceInfo> devices = CaptureDeviceManager
				.getDeviceList(null);
		CaptureDeviceInfo[] info = new CaptureDeviceInfo[0];
		return devices.toArray(info);
	}

	// 从已知设备中取所有视频设备的列表
	private CaptureDeviceInfo[] getVideoDevices() {
		CaptureDeviceInfo[] info = getDevices();
		CaptureDeviceInfo[] videoDevInfo;
		Vector<CaptureDeviceInfo> vc = new Vector<CaptureDeviceInfo>();
		for (int i = 0; i < info.length; i++) {
			// 取设备支持的格式，如果有一个是视频格式，则认为此设备为视频设备
			Format[] fmt = info[i].getFormats();
			for (int j = 0; j < fmt.length; j++) {
				if (fmt[j] instanceof VideoFormat) {
					vc.add(info[i]);
				}
				break;
			}
		}
		videoDevInfo = new CaptureDeviceInfo[vc.size()];
		for (int i = 0; i < vc.size(); i++) {
			videoDevInfo[i] = (CaptureDeviceInfo) vc.get(i);
		}
		return videoDevInfo;
	}

	/**
	 * * 保存图像 *
	 * 
	 * @param img *
	 * @param s
	 */
	public void saveJPG(Image img, String s) {
		BufferedImage bi = new BufferedImage(img.getWidth(null), img
				.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bi.createGraphics();
		g2.clipRect(rectX, rectY, rectWidth, rectHeight);
		g2.drawImage(img, null, null);
		int moveX = rectX > 0 ? rectX : 0;
		int moveY = rectY > 0 ? rectY : 0;
		int cutWidth = rectX + rectWidth > imgWidth ? rectWidth
				- ((rectX + rectWidth) - imgWidth) : rectWidth;
		int cutHeight = rectY + rectHeight > imgHeight ? rectHeight
				- ((rectY + rectHeight) - imgHeight) : rectHeight;
		bi = bi.getSubimage(moveX, moveY, cutWidth, cutHeight);

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(s);
		} catch (java.io.FileNotFoundException io) {
			System.out.println("File Not Found");
		}
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);
		param.setQuality(1f, false);
		encoder.setJPEGEncodeParam(param);
		try {
			encoder.encode(bi);
			out.close();
		} catch (java.io.IOException io) {
			System.out.println("IOException");
		}
	}

	/**
	 * 
	 * 拍照完成后显示照片的组件，可以拖动范围框，选择要截取的部分
	 */
	class ImagePanel extends Panel {
		private Image image = null;

		int x, y;

		public ImagePanel() {
			setLayout(null);
			setSize(imgWidth, imgHeight);
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x = e.getX() - rectX;
					y = e.getY() - rectY;
				}

				public void mouseReleased(MouseEvent e) {
				}
			});
			addMouseMotionListener(new MouseMotionListener() {
				public void mouseDragged(MouseEvent e) {
					if (x > 0 && x < rectWidth && y > 0 && y < rectHeight) {
						rectX = e.getX() - x;
						rectY = e.getY() - y;
						repaint();
					}
				}

				public void mouseMoved(MouseEvent e) {
				}
			});
		}

		public void setImage(Image image) {
			this.image = image;
			repaint();
		}

		Image ImageBuffer = null;
		Graphics GraImage = null;

		public void update(Graphics g) { // 覆盖update方法，截取默认的调用过程
			ImageBuffer = createImage(this.getWidth(), this.getHeight()); // 创建图形缓冲区
			GraImage = ImageBuffer.getGraphics(); // 获取图形缓冲区的图形上下文
			paint(GraImage); // 用paint方法中编写的绘图过程对图形缓冲区绘图
			GraImage.dispose(); // 释放图形上下文资源
			g.drawImage(ImageBuffer, 0, 0, this); // 将图形缓冲区绘制到屏幕上
		}

		public void paint(Graphics g) { // 在paint方法中实现绘图过程
			if (image != null) {
				g.drawImage(image, 0, 0, this);
				g.setColor(Color.RED);
				g.drawRect(rectX, rectY, rectWidth, rectHeight);
			}
		}
	}
}