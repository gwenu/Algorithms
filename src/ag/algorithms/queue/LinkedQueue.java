package ag.algorithms.queue;

public class LinkedQueue implements StringQueueImplementable {
	
	private Node first;
	private Node last;

	@Override
	public void enqueue(String value) {
		Node current = new Node();
		current.value = value;
		
		if(first == null) {
			first = current;
		} else if(first.next == null) {
			first.next = last;
		}
		
		if(last != null) {
			last.next = current;
		}
		
		last = current;
	}

	@Override
	public String dequeue() {
		String value = null;
		
		if(first != null) {
			value = first.value;
			first = first.next;
		}
		
		return value;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	 }
	
	private class Node {
		String value;
		Node next;
	}
}
