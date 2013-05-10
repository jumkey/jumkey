package org.cafeboy.util;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ValidateCode {

	public String crackValidateCode(String filePath) throws IOException {
		InputStream input = new FileInputStream(filePath);
		return crackValidateCode(input);
	}

	public String crackValidateCode(InputStream input) throws IOException {
		final int WORD_WIDTH = 9;
		final int WORD_HIGHT = 13;
		final int OFFSET_X = 7;
		final int OFFSET_Y = 3;
		final int WORD_SPACING = 4;

		BufferedImage img = ImageIO.read(input);

		int[][] DataArray = new int[img.getHeight()][img.getWidth()];
		String[] Keys = {
				"000111000011111110011000110110000011110000011110000011110000011110000011110000011110000011011000110011111110000111000",
				"000111000011111000011111000000011000000011000000011000000011000000011000000011000000011000000011000011111111011111111",
				"011111000111111100100000110000000111000000110000001100000011000000110000001100000011000000110000000011111110111111110",
				"011111000111111110100000110000000110000001100011111000011111100000001110000000111000000110100001110111111100011111000",
				"000001100000011100000011100000111100001101100001101100011001100011001100111111111111111111000001100000001100000001100",
				"111111110111111110110000000110000000110000000111110000111111100000001110000000111000000110100001110111111100011111000",
				"000111100001111110011000010011000000110000000110111100111111110111000111110000011110000011011000111011111110000111100",
				"011111111011111111000000011000000010000000110000001100000001000000011000000010000000110000000110000001100000001100000",
				"001111100011111110011000110011000110011101110001111100001111100011101110110000011110000011111000111011111110001111100",
				"001111000011111110111000111110000011110000011111000111011111111001111011000000011000000110010000110011111100001111000"};
		for (int i = 0; i < img.getHeight(); ++i) {
			for (int j = 0; j < img.getWidth(); ++j) {
				ColorModel s = img.getColorModel();

				Object data = img.getRaster().getDataElements(j, i, null);
				int rgb = img.getRGB(j, i);
				// s.getRed(rgb);//图像的问题
				// 异常http://blog.csdn.net/fykhlp/article/details/6204714
				int _alpha = (rgb >> 24) & 0xFF;
				int _red = (rgb >> 16) & 0xFF;
				int _green = (rgb >> 8) & 0xFF;
				int _blue = (rgb) & 0xFF;
				// 测试是否相同
				if (!(s.getAlpha(data) + "-" + s.getRed(data) + "-" + s.getGreen(data) + "-" + s.getBlue(data)).equals(_alpha + "-" + _red + "-" + _green + "-" + _blue)) {
					System.out.println(false);
				}
				if (s.getRed(data) < 125 || s.getGreen(data) < 125 || s.getBlue(data) < 125) {
					DataArray[i][j] = 1;
				} else {
					DataArray[i][j] = 0;
				}
			}
		}

		String result = "";
		// 查找6个数字
		String[] codeArray = { "", "", "", "", "", "" };
		for (int i = 0; i < 6; ++i) {
			int x = (i * (WORD_WIDTH + WORD_SPACING)) + OFFSET_X;
			int y = OFFSET_Y;
			for (int h = y; h < (OFFSET_Y + WORD_HIGHT); ++h) {
				for (int w = x; w < (x + WORD_WIDTH); ++w) {
					codeArray[i] += DataArray[h][w];
				}
			}
		}
		// 进行关键字匹配
		for (String numString : codeArray) {
			float max = 0.0f;
			int num = 0;
			for (int i = 0; i < Keys.length; ++i) {
				float percent = 0.0f;
				percent = SimilarText.similarText(Keys[i], numString);
				// percent = (float) LevenshteinDistance.sim(Keys[i],
				// numString);//Levenshtein distance算法
				if (percent > max) {
					max = percent;
					num = i;
					if (percent > 95)
						break;
				}
			}
			result += num;
		}
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String s = new ValidateCode().crackValidateCode("src/rand.jpg");
		System.out.println(s);
	}

}
