package jumkey.servlet;

import java.io.File;
import javax.imageio.ImageIO;

public class Test {
	public static void main(String[] args) {
		String[] names = ImageIO.getWriterFormatNames();
		for (String name : names) {
			System.out.println(name);
		}
		File path = new File("//D:/TDDOWNLOAD");
		String[] list = path.list();
		for(String fn : list){
			System.out.println(fn);
		}
	}
}
