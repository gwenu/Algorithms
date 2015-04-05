package ag.algorithms.stack;

/* Use array stack when size matters (stack size is between 8N to 32N, where N is array size) 
 and it is not  necessary to process insertion/deletion in constant time */
public class ArrayStack implements StringStackImplementable {

	private static final int INIT_ARRAY_CAPACITY = 10;
	private int first;

	private String[] stringStack;

	public ArrayStack() {
		this.stringStack = new String[INIT_ARRAY_CAPACITY];
	}

	@Override
	public String pop() {
		String value = null;
		
		// Resize array
		if (first == stringStack.length / 4) {
			resize(stringStack.length / 2);
		}

		first--;
		value = stringStack[first];
		stringStack[first] = null;

		return value;
	}

	@Override
	public void push(String value) {
		// Resize array
		if (first == stringStack.length) {
			resize(stringStack.length * 2);
		}

		stringStack[first] = value;
		first++;
	}

	@Override
	public boolean isEmpty() {
		return first == 0;
	}

	@Override
	public int size() {
		return stringStack.length;
	}

	// Resizing array implementation
	private void resize(int size) {
		String[] copy = new String[size];

		for (int i = 0; i < stringStack.length && i < size; i++) {
			copy[i] = stringStack[i];
		}

		stringStack = copy;
	}
}
