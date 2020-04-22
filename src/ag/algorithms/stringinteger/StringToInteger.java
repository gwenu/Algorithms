package ag.algorithms.stringinteger;

import java.util.Arrays;
import java.util.List;

public class StringToInteger {

	public static final char WHITESPACE_CHAR = ' ';
	public static final char MINUS_CHAR = '-';
	public static final char PLUS_CHAR = '+';
	public static final int INT_MAX_SIZE = ("" + Integer.MAX_VALUE).toCharArray().length + 1;

	public static void main(String[] args) {
		StringToInteger instance = new StringToInteger();
		List<String> testStrings = Arrays.asList("42", " -42", "4193 with words", "words and 987", "-91283472332", "+",
				"-", "20000000000000000000", "0-1", "-91283472332", "  0000000000012345678", "-000000000000001", "+-2",
				"-+1", " +0 123", "-01324000");

		for (String str : testStrings) {
			System.out.println(instance.myAtoi(str));
		}
	}

	public int myAtoi(String str) {
		int result = 0;
		char[] chars = str.toCharArray();
		String number = "";

		for (int i = 0; i < chars.length; i++) {
			if (!Character.isDigit(chars[i]) && chars[i] != WHITESPACE_CHAR && chars[i] != MINUS_CHAR
					&& chars[i] != PLUS_CHAR) {
				break;
			} else {
				if (chars[i] != WHITESPACE_CHAR) {
					if (!number.isEmpty() && (chars[i] == MINUS_CHAR || chars[i] == PLUS_CHAR)) {
						break;
					} else if ((number.length() == 1
							&& (number.charAt(0) == MINUS_CHAR || number.charAt(0) == PLUS_CHAR || number.charAt(0) == '0')) && chars[i] == '0') {
						continue;
					} 
					number += chars[i];
				} else if (chars[i] == WHITESPACE_CHAR && !number.isEmpty()) {
					break;
				}
			}
		}

		if (!number.isEmpty() && !number.equals("-") && !number.equals("+")) {
			if (number.length() > INT_MAX_SIZE) {
				return number.charAt(0) == MINUS_CHAR ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}

			long value = Long.parseLong(number);
			if (value > Integer.MAX_VALUE) {
				result = Integer.MAX_VALUE;
			} else if (value < Integer.MIN_VALUE) {
				result = Integer.MIN_VALUE;
			} else {
				result = (int) value;
			}
		}

		return result;
	}
}
