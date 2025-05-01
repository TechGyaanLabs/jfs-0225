package com.careerit.sb.scopes;

public class QuickSort implements  Sort {

    public long[] sort(long[] arr) {

        if (arr.length < 2) {
            return arr;
        }

        long pivot = arr[arr.length / 2];
        long[] left = new long[arr.length];
        long[] right = new long[arr.length];
        int leftIndex = 0;
        int rightIndex = 0;

        for (long num : arr) {
            if (num < pivot) {
                left[leftIndex++] = num;
            } else if (num > pivot) {
                right[rightIndex++] = num;
            }
        }

        long[] sortedLeft = sort(trimArray(left, leftIndex));
        long[] sortedRight = sort(trimArray(right, rightIndex));

        return merge(sortedLeft, pivot, sortedRight);
    }
    private long[] merge(long[] left, long pivot, long[] right) {
        long[] result = new long[left.length + right.length + 1];
        int index = 0;

        for (long num : left) {
            result[index++] = num;
        }
        result[index++] = pivot;
        for (long num : right) {
            result[index++] = num;
        }

        return trimArray(result, index);
    }

    private long[] trimArray(long[] arr, int length) {
        long[] trimmedArray = new long[length];
        System.arraycopy(arr, 0, trimmedArray, 0, length);
        return trimmedArray;
    }
}
