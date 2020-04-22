package ag.algorithms;

import ag.algorithms.array.MergeIntervalsArray;

public class LeetCodeRunner {

	public static void main(String[] args) {
		LeetCodeRunner runner = new LeetCodeRunner();
		runner.mergeIntervals();
	}

	private void mergeIntervals() {
		int[][] intervals = { { 1, 5 }, { 3, 8 }, { 10, 12 }, { 14, 20 }, { 17, 21 }, {24, 28}, {26, 28}};
		System.out.println("Using array implementation for merge intervals:\nIntervals:");
		printArray(intervals);
		
		MergeIntervalsArray mergeIntervals = new MergeIntervalsArray(intervals);
		intervals = mergeIntervals.perform();

		System.out.println("\n\nMerge intervals result:");
		printArray(intervals);
	}
	
	private void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(String.format("[%d, %d]", array[i][0], array[i][1]) + " ");
		}
	}
}
