package org.example.order;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 1, 9, 10, 5, 3, 7};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
