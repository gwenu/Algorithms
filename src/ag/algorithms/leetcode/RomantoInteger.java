package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

	@SuppressWarnings("serial")
	Map<String, Integer> romanToInteger = new HashMap<String, Integer>() {
		{
			put("I", 1);
			put("V", 5);
			put("X", 10);
			put("L", 50);
			put("C", 100);
			put("D", 500);
			put("M", 1000);
			put("I", 1);
		}
	};

	public static void main(String[] args) {
		RomantoInteger instance = new RomantoInteger();

		String romanDigits = "LVIII";
		System.out.println(instance.romanToInt(romanDigits));
	}

	public int romanToInt(String s) {
		int result = 0;
		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == 'I' && chars[i + 1] == 'V') {
				result += 4;
				chars[i] = '0';
				chars[i + 1] = '0';
				i++;
			} else if (chars[i] == 'I' && chars[i + 1] == 'X') {
				result += 9;
				chars[i] = '0';
				chars[i + 1] = '0';
				i++;
			} else if (chars[i] == 'X' && chars[i + 1] == 'L') {
				result += 40;
				chars[i] = '0';
				chars[i + 1] = '0';
				i++;
			} else if (chars[i] == 'X' && chars[i + 1] == 'C') {
				result += 90;
				chars[i] = '0';
				chars[i + 1] = '0';
				i++;
			} else if (chars[i] == 'C' && chars[i + 1] == 'D') {
				result += 400;
				chars[i] = '0';
				chars[i + 1] = '0';
				i++;
			} else if (chars[i] == 'C' && chars[i + 1] == 'M') {
				result += 900;
				chars[i] = '0';
				chars[i + 1] = '0';
				i++;
			}
		}

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != '0')
				result += romanToInteger.get(String.valueOf(chars[i]));
		}

		return result;
	}

}
