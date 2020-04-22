package ag.algorithms.array;

public class MergeIntervalsArray {

	private int[][] intervals;

	public MergeIntervalsArray(int[][] intervals) {
		this.intervals = intervals;
	}

	public int[][] perform() {
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i] == null) {
				continue;
			}

			for (int k = i + 1; k < intervals.length; k++) {
				if (intervals[k] == null) {
					continue;
				}

				if (intervals[i][1] >= intervals[k][0]) {
					intervals[i] = new int[] { intervals[i][0], intervals[k][1] };
					intervals[k] = null;
					break;
				}
			}
		}

		return createNewArrayWithoutNullValues(intervals);
	}

	private int[][] createNewArrayWithoutNullValues(int[][] intervals) {
		int lastIndex = 0;
		int[][] helperArray = new int[intervals.length][2];
		
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i] != null) {
				helperArray[lastIndex] = intervals[i];
				lastIndex++;
			}
		}
		
		int[][] resultArray = new int[lastIndex][2];
		System.arraycopy(helperArray, 0, resultArray, 0, lastIndex);
		helperArray = null;
		
		return resultArray;
	}
}
