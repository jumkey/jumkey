import javax.media.Player;
import javax.media.CaptureDeviceInfo;
import javax.media.MediaLocator;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.media.control.FrameGrabbingControl;
import javax.media.Buffer;
import javax.media.util.BufferToImage;
import javax.media.format.VideoFormat;
import java.io.*;
import com.sun.image.codec.jpeg.*;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import java.applet.*;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */

public class Camera extends JFrame {
	private static Player player = null;
	private CaptureDeviceInfo device = null;
	private MediaLocator locator = null;
	private Buffer buffer = null;
	private BufferToImage b2i = null;
	private Image image;
	private ImageIcon iicon = new ImageIcon();
	boolean proportion = true;
	String str1 = "vfw:Logitech USB Video Camera:0";
	String str2 = "vfw:Microsoft WDM Image Capture (Win32):0";
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	Component component1;
	JLabel jLabel1 = new JLabel();

	public Camera() {
		super("troy的摄像机(无保存功能)");
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Image resize(int width, int height, Image source, boolean flag) {
		this.proportion = flag;
		int new_w;
		int new_h;
		Toolkit tk = Toolkit.getDefaultToolkit();
		Applet app = new Applet();
		MediaTracker mt = new MediaTracker(app);
		Image img = source;
		try {
			mt.addImage(img, 0);
			mt.waitForID(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (img.getWidth(null) == -1) {
			System.out.println(" can't read,retry!" + "<BR>");
			return null;
		} else {

			if (this.proportion == true) { // 判断是否是等比缩放.
				// 为等比缩放计算输出的图片宽度及高度
				double rate1 = ((double) img.getWidth(null)) / (double) width
						+ 0.1;
				double rate2 = ((double) img.getHeight(null)) / (double) height
						+ 0.1;
				double rate = rate1 > rate2 ? rate1 : rate2;
				new_w = (int) (((double) img.getWidth(null)) / rate);
				new_h = (int) (((double) img.getHeight(null)) / rate);
			} else {
				new_w = width; // 输出的图片宽度
				new_h = height; // 输出的图片高度
			}
		}
		BufferedImage buffImg = new BufferedImage(new_w, new_h,
				BufferedImage.TYPE_INT_RGB);

		Graphics g = buffImg.createGraphics();

		g.setColor(Color.white);
		g.fillRect(0, 0, new_w, new_h);

		g.drawImage(img, 0, 0, new_w, new_h, null);

		g.dispose();
		try {
			OutputStream tempout = new FileOutputStream("C:/Photo/temp.jpg");
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(tempout);
			encoder.encode(buffImg);
			tempout.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk.createImage("C:/Photo/temp.jpg");
	}

	public static void main(String[] args) {
		Camera camera1 = new Camera();
	}

	private void jbInit() throws Exception {

		component1 = Box.createGlue();
		// =====================初始化设备===================//
		component1.addNotify();
		device = CaptureDeviceManager.getDevice(str2);
		locator = device.getLocator();
		try {
			player = Manager.createRealizedPlayer(locator);
			player.start();

			if ((component1 = player.getVisualComponent()) != null) {
				this.getContentPane().add(component1, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		jButton1.setBounds(new Rectangle(294, 28, 73, 25));
		jButton1.setText("拍照");
		jButton1.addActionListener(new Camera_jButton1_actionAdapter(this));
		this.getContentPane().setLayout(null);
		jButton2.setBounds(new Rectangle(295, 82, 73, 25));
		jButton2.setText("保存");
		jButton2.addActionListener(new Camera_jButton2_actionAdapter(this));
		component1.setBounds(new Rectangle(27, 23, 243, 235));
		jLabel1.setIconTextGap(4);
		jLabel1.setText("空");
		jLabel1.setVerticalTextPosition(SwingConstants.CENTER);

		jLabel1.setBounds(new Rectangle(293, 139, 80, 95));

		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jLabel1, null);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	void jButton1_actionPerformed(ActionEvent e) {
		iicon = new ImageIcon();
		FrameGrabbingControl fgc = (FrameGrabbingControl) player
				.getControl("javax.media.control.FrameGrabbingControl");
		buffer = fgc.grabFrame(); // 获取当前祯并存入Buffer类
		b2i = new BufferToImage((VideoFormat) buffer.getFormat());
		image = b2i.createImage(buffer); // show the image
		iicon = new ImageIcon();
		/*
		 * Toolkit tk = Toolkit.getDefaultToolkit(); Applet app = new Applet();
		 * MediaTracker mt = new MediaTracker(app);
		 */
		iicon.setImage(this.resize(85, 95, image, true));
		jLabel1.setIcon(iicon);

	}

	void jButton2_actionPerformed(ActionEvent e) {

		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileHidingEnabled(true);

		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = filechooser.showSaveDialog(null);
		if (result == JFileChooser.CANCEL_OPTION) {
			return;
		}
		File file = filechooser.getSelectedFile();
		if (file == null || file.getName().equals("")) {
			JOptionPane.showMessageDialog(null, "无效的文件名", "警告",
					JOptionPane.ERROR_MESSAGE);
		} else {

			String s = file.getAbsolutePath();

			BufferedImage bi = (BufferedImage) createImage(
					image.getWidth(null), image.getHeight(null));
			Graphics2D g2 = bi.createGraphics();
			g2.drawImage(image, null, null);
			FileOutputStream out = null;
			try {
				out = new FileOutputStream(s);
			} catch (java.io.FileNotFoundException io) {
				System.out.println("File Not Found");
			}

			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);
			param.setQuality(1f, false); // 不压缩图像
			encoder.setJPEGEncodeParam(param);
			try {
				encoder.encode(bi);
				out.close();
			} catch (java.io.IOException io) {
				System.out.println("IOException");
			}
		}

	}

}

class Camera_jButton1_actionAdapter implements java.awt.event.ActionListener {
	Camera adaptee;

	Camera_jButton1_actionAdapter(Camera adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class Camera_jButton2_actionAdapter implements java.awt.event.ActionListener {
	Camera adaptee;

	Camera_jButton2_actionAdapter(Camera adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}