package com.subham.dsnalgo.array.rearrangements;

/**
 * @author <b>Subham Santra</b>
 * 
 * 
 * @apiNote Given an array of random numbers, Push all the zero’s of a given
 *          array to the end of the array. For example, if the given arrays is
 *          {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8,
 *          4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be
 *          same. Expected time complexity is O(n) and extra space is O(1).
 * 
 * @see <a>https://www.geeksforgeeks.org/move-zeroes-end-array/</a>
 *
 * @implNote We can simply apply a smart quick partition algorithm because we've
 *           to maintain relative order.
 */
public class MoveAllZerosToEndOfTheArray {
    private static final ArrayDebugUtil ARRAY_UTIL = new ArrayDebugUtil();

    private void solve(int[] a) {
	int j = 0;
	for (int i = 0; i < a.length; ++i) {
	    if (a[i] > 0) {
		ARRAY_UTIL.swap(a, j, i);
		++j;
	    }
	}
	ARRAY_UTIL.print(a);
    }

    public static void main(String[] args) {
	MoveAllZerosToEndOfTheArray moveAllZerosToEndOfTheArray = new MoveAllZerosToEndOfTheArray();

	// Test with a generic case
	moveAllZerosToEndOfTheArray.solve(new int[] { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 });
	// Test with all zeroes
	moveAllZerosToEndOfTheArray.solve(new int[] { 0, 0, 0, 0, 0, 0 });
	// Test with all non-zeroes
	moveAllZerosToEndOfTheArray.solve(new int[] { 1, 9, 8, 4, 2, 7, 6 });
	// Test with an empty array
	moveAllZerosToEndOfTheArray.solve(new int[] {});
    }
}
