package ag.algorithms.find;

// N^2
public class QuickFind {
	
	private int[] ids;
	
	public QuickFind(int[] ids) {
		this.ids = ids;
	}
	
	public void connect(int toId, int fromId) {
		int connectTo = ids[toId];
		int connectFrom = ids[fromId];
		
		for(int i = 0; i < ids.length; i++) {
			if(ids[i] == connectTo) {
				ids[connectFrom] = connectTo;
			}
		}
	}
	
	public boolean isConnected(int firstId, int secondId) {
		return ids[firstId] == ids[secondId];
	}
}
