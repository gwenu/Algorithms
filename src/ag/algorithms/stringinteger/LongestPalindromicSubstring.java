package ag.algorithms.stringinteger;

import java.util.Arrays;
import java.util.List;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring inst = new LongestPalindromicSubstring();
		List<String> testStr = Arrays.asList("babad", "cbbd", "", null, "abcde", "a", "ccc", "abadd");

		for (String test : testStr) {
			System.out.println(inst.longestPalindrome(test));
		}
	}

	public String longestPalindrome(String s) {
		String result = "";
		
		if(s == null) {
			return result;
		} else if(s.length() == 1) {
			return s;
		} else if(allCharactersSame(s)) {
			return s;
		}
		
		char[] chars = s.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			char[] tmp = new char[chars.length];
			int k = 0;
			tmp[k] = chars[i];

			for (int j = i; j < chars.length - 1; j++) {
				tmp[++k] = chars[j+1];

				if (isPolindrome(tmp, k)) {
					String polindrome = String.valueOf(tmp).trim();
					result = polindrome.length() > result.length() ? polindrome.trim() : result.trim();
				}
			}
		}
		
		if(!s.isEmpty() && result == "") {
			result = String.valueOf(chars[0]);
		}

		return result.trim();
	}

	private boolean isPolindrome(char[] chars, int lastIndex) {
		boolean isPolindrome = false;
		for (int i = 0, j = lastIndex; i < j; i++, j--) {
			if (chars[i] == chars[j]) {
				isPolindrome = true;
				continue;
			} else {
				isPolindrome = false;
				break;
			}
		}
		return isPolindrome;
	}
	
	private boolean allCharactersSame(String s) {
	    int n = s.length();
	    for (int i = 1; i < n; i++)
	        if (s.charAt(i) != s.charAt(0))
	            return false;
	         
	    return true;
	}
}
