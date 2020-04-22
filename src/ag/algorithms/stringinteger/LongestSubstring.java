package ag.algorithms.stringinteger;

public class LongestSubstring {

	public static void main(String[] args) {
		String testString = "dvdf";
		
		System.out.println("Result: " + lengthOfLongestSubstring(testString));
	}
	
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty() || s == null) {
            return 0;
        }
        
		char[] chars = s.toCharArray();
		String result = String.valueOf(chars[0]);
		String tmp = result;

		for (int i = 1; i < chars.length; i++) {
			if (tmp.indexOf(chars[i]) != -1) {
				tmp = tmp.substring(tmp.indexOf(chars[i]) + 1);
			}

			tmp += String.valueOf(chars[i]);

			if (result.length() < tmp.length()) {
				result = tmp;
			}
		}

		return result.length() < tmp.length() ? tmp.length() : result.length();
    }
}
