package com.tea.modules.algorithm;

/**
 * 快速排序
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] array = {9, 22, 4, 5, 78, 32, 3};
        FastSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i + " ");
        }
    }

    private static int Partition(int r[], int start, int end) {
        //起始坐标
        int i = start, j = end;
        while (i < j) {
            while (i < j && r[i] <= r[j]) {
                //右侧扫描
                j--;
            }
            if (i < j) {
                int temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                i++;
            }
            while (i < j && r[i] <= r[j]) {
                //左侧扫描
                i++;
            }
            if (i < j) {
                int temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                j--;
            }
        }
        return i;
    }

    private static void FastSort(int r[], int start, int end) {
        int pivot;//轴值
        if (start < end) {
            pivot = Partition(r, start, end);
            FastSort(r, start, pivot - 1);
            FastSort(r, pivot + 1, end);
        }
    }
}







