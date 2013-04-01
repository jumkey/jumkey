package org.cafeboy.util;

/**
 * <pre>
 * （1）找出两个字符串中相同部分最长的一段；
 * （2）再用同样的方法在剩下的两段中分别找出相同部分最长的一段，以此类推，直到没有任何相同部分；
 * （3）相似度 = 所有相同部分的长度之和 * 2 / 两个字符串的长度之和；
 * </pre>
 * 
 * @author Jumkey
 * 
 */
public class SimilarText {

	public static float similarText(String first, String second) {
		first = first.toLowerCase();
		second = second.toLowerCase();
		return (float) (similar(first, second) * 200) / (first.length() + second.length());
	}

	private static int similar(String first, String second) {
		int p, q, l, sum;
		int pos1 = 0;
		int pos2 = 0;
		int max = 0;
		char[] arr1 = first.toCharArray();
		char[] arr2 = second.toCharArray();
		int firstLength = arr1.length;
		int secondLength = arr2.length;

		for (p = 0; p < firstLength; p++) {
			for (q = 0; q < secondLength; q++) {
				for (l = 0; (p + l < firstLength) && (q + l < secondLength) && (arr1[p + l] == arr2[q + l]); l++)
					;
				if (l > max) {
					max = l;
					pos1 = p;
					pos2 = q;
				}

			}
		}
		sum = max;
		if (sum > 0) {
			if (pos1 > 0 && pos2 > 0) {
				sum += similar(first.substring(0, pos1 > firstLength ? firstLength : pos1), second.substring(0, pos2 > secondLength ? secondLength : pos2));
			}

			if ((pos1 + max < firstLength) && (pos2 + max < secondLength)) {
				sum += similar(first.substring(pos1 + max, firstLength), second.substring(pos2 + max, secondLength));
			}
		}
		return sum;
	}
}
