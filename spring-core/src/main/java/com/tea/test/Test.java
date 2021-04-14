package com.tea.test;

import com.google.common.collect.Lists;
import com.tea.modules.java8.format.NumberChineseFormatter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 5, 2, 3, 5, 66, 9, 21, 10};
        mergesort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并排序
     *
     * @param array 需要排序的数组
     * @param start 开始索引
     * @param end   结束索引
     */
    private static void mergesort(int[] array, int start, int end) {
        // 克隆出临时数组
        int[] temp = Arrays.copyOf(array, array.length);
        // 如果开始索引=结束索引，说明划分子序列已经达到最小了，即为1个,结束划分
        if (start == end) {
            return;
        }
        // 划分中位数
        int middle = (start + end) / 2;
        // 左边序列进行递归划分
        mergesort(array, start, middle);
        // 右边序列进行递归划分
        mergesort(array, middle + 1, end);
        merge(array, start, middle, end, temp);
        // 将有序序列传回数组array中,这里注意index.
        for (int i = start; i <= end; i++) {
            array[i] = temp[i];
        }
    }

    /**
     * 合并子序列
     *
     * @param array
     * @param start
     * @param middle
     * @param end
     * @param temp
     */
    private static void merge(int[] array, int start, int middle, int end, int[] temp) {
        System.out.println("start:" + start);
        // 左边序列开始索引
        int i = start;
        // 中点
        int j = middle + 1;
        // 临时数组
        int tempIndex = i;
        while (i <= middle && j <= end) {
            if (array[i] < array[j]) {
                temp[tempIndex++] = array[i++];
            } else {
                temp[tempIndex++] = array[j++];
            }
        }
        // 如果左边的序列没处理完，进行收尾工作
        while (i <= middle) {
            temp[tempIndex++] = array[i++];
        }
        // 如果右边的序列没处理完,进行收尾工作
        while (j <= end) {
            temp[tempIndex++] = array[j++];
        }
    }
}