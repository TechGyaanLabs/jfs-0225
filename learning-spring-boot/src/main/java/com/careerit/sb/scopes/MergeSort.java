package com.careerit.sb.scopes;

public class MergeSort implements Sort {

    public long[] sort(long[] arr) {

        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;
        long[] left = new long[mid];
        long[] right = new long[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        return merge(sort(left), sort(right));
    }
    private long[] merge(long[] left, long[] right) {
        long[] result = new long[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
