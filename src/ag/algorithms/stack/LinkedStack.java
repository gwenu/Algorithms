package ag.algorithms.stack;

/* Use linked stack when size doesn't matters (stack size is between 40N, where N is array size) 
and it is necessary to process insertion/deletion in constant time */
public class LinkedStack implements StringStackImplementable {
	
	private Node first = null;
	
	public void push(String value) {
		if(first == null) {
			first = new Node(value, null);
		} else {
			Node current = first;
			first = new Node(value, current);
		}
	}
	
	public String pop() {
		String value = null;
		
		if(first != null) {
			value = first.value;
			first = first.previous;
		}
		
		return value;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	//TODO: iterate through nodes.
	public int size() {
		return 0;
	}
	
	private class Node {
		String value;
		Node previous;
		
		public Node(String value, Node previous) {
			this.value = value;
			this.previous = previous;
		}
	}
}
