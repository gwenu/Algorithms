package ag.algorithms.tree;

// TODO: Implements logic
// Search / Insert average: 1.39 * lg N; worst case: N
// Delete: square root of N
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	
	private Node root;
	
	public void insert(Key key, Value value) {
		if(root == null) root = new Node(key, value);
		// ... 
	}
	
	public Value search(Key key) {
		return null;
	}
	
	public void delete(Key key) {
		
	}
	
	// Before null on the right
	public Key max() {
		return null;
	}
	
	// Before null on the left
	public Key min() {
		return null;
	}
	
	// First low than key
	public Key floor(Key key) {
		return null;
	}
	
	// First greater than key
	public Key celling(Key key) {
		return null;
	}
	
	// Count of lower than key
	public int rank(Key key) {
		return 0;
	}
	
	public boolean contains(Key key) {
		return false;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int size() {
		return 0;
	}
	
	public Iterable<Key> keys() {
		return null;
	}

	private class Node {
		private Key key;
		private Value value;
		private Node leftChild;
		private Node rigthChild;
		
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}
}
