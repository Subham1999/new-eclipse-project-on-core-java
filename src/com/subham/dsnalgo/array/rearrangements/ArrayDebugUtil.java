package com.subham.dsnalgo.array.rearrangements;

import java.util.Arrays;

/**
 * @author <b>Subham Santra</b>
 * 
 * 
 * @apiNote Group all common operations on an array
 *
 */
public final class ArrayDebugUtil {
    public void print(int[] a) {
	System.out.println(Arrays.toString(a));
    }

    public void swap(int[] a, int from, int to) {
	if (0 <= from && from < a.length) {
	    if (0 <= to && to < a.length) {
		int tmp = a[from];
		a[from] = a[to];
		a[to] = tmp;
	    }
	}
    }
}
