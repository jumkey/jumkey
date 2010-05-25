package jumkey.servlet;

import javax.imageio.ImageIO;

public class Test {
	public static void main(String[] args) {
		String[] names = ImageIO.getWriterFormatNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
