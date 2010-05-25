package jumkey.servlet;

import java.io.File;

import javax.imageio.ImageIO;

public class Test {
	public static void main(String[] args) {
		String[] names = ImageIO.getWriterFormatNames();
		for (String name : names) {
			System.out.println(name);
		}
		File path = new File("//D:/TDDOWNLOAD/[Comic][龍珠完全版][鳥山明][文傳][C.C]Vol_01");
		String[] list = path.list();
		for(String fn : list){
			System.out.println(fn.split("\\.")[0]);
		}
	}
}
