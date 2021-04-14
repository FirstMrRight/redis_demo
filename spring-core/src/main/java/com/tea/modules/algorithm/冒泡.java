package com.tea.modules.algorithm;

/**
 * 冒泡排序
 */
public class 冒泡 {
    public static void main(String[] args) {
        int[] array = {1, 5, 6, 2, 36, 7, 88, 21, 32, 1};
        if (array == null && array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i : array) {
            System.out.println(i);
        }
    }


}
