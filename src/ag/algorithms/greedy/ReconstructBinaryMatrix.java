package ag.algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the following details of a matrix with n columns and 2 rows :

	The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
	The sum of elements of the 0-th(upper) row is given as upper.
	The sum of elements of the 1-st(lower) row is given as lower.
	The sum of elements in the i-th column(0-indexed) is colsum[i], where columns is given as an integer array with length n.
	Your task is to reconstruct the matrix with upper, lower and colsum.
 * */
public class ReconstructBinaryMatrix {

	public static void main(String[] args) {
		List<List<Integer>> recoveredMatrix = recoverMatrix(3, 2, new int[] { 2, 1, 1, 0, 1 }); // Recovered matrix
		List<List<Integer>> cannotRecoveredMatrix = recoverMatrix(2, 3, new int[] { 2, 2, 1, 1 }); // Empty matrix: can not be recovered

		System.out.println("3, 2, [2, 1, 1, 0, 1] -> " + recoveredMatrix);
		System.out.println("2, 3, [2, 2, 1, 1] -> " + cannotRecoveredMatrix);
	}

	private static List<List<Integer>> recoverMatrix(int upper, int lower, int[] colsum) {
		List<List<Integer>> result = new ArrayList<>();
		int n = colsum.length;

		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (colsum[i] == 2) {
				first.add(1);
				second.add(1);
				upper--;
				lower--;
			} else if (colsum[i] == 0) {
				first.add(0);
				second.add(0);
			} else {
				if (upper > lower) {
					first.add(1);
					upper--;
					second.add(0);
				} else {
					second.add(1);
					lower--;
					first.add(0);
				}
			}

			// When matrix can't be recovered upper or lower will be less than 0
			if (upper < 0 || lower < 0) {
				return result;
			}
		}

		// When matrix can be recovered
		if (lower == 0 && upper == 0) {
			result.add(first);
			result.add(second);
		}

		return result;
	}
}
