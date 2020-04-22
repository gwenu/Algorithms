package ag.algorithms.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	@SuppressWarnings("serial")
	private Map<Character, Character> parentheseMap = new HashMap<Character, Character>() {
		{
			put(')', '(');
			put(']', '[');
			put('}', '{');
		}
	};

	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		List<String> testStrings = Arrays.asList("()", "()[]{}", "({[]})", "{[]}()", "(]", "([)]", "", "(", ")(");

		for (String testStr : testStrings) {
			System.out.println("Case: " + testStr + "   ---> " + validParentheses.isValid(testStr));
		}
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (parentheseMap.containsKey(c)) {
				char topElement = stack.empty() ? '#' : stack.pop();
				if (topElement != parentheseMap.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		
		return stack.isEmpty();
	}
}
