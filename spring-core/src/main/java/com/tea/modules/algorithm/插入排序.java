package com.tea.modules.algorithm;

import com.tea.modules.util.RandomUtil;

import java.util.Arrays;

/**
 * com.tea.modules.algorithm.<br>
 * 练习插入排序.<br>
 * 插入排序博客地址:<a href="https://www.runoob.com/data-structures/insertion-sort.html">插入排序</a><br>
 * 插入排序大致逻辑:<br>
 * array:[0,1,2,3,4].<br>
 * 第一轮: 那么从1开始向前检索,找到比1大的数进行交换.<br>
 * 第二轮: 从2开始向前检索，找到比2大的数进行交换.<br>
 * 第三轮: 从3开始向前检索，找到比3大的数进行交换.<br>
 * 第四轮: 从4开始向前检索,找到比4大的数进行交换.<br>
 * 在所有检索的过程中,如果遇到值比当前检索值小的，就会直接中断，进入下一次检索.<br>
 * 所以插入排序适合原本就排序好的序列.<br>
 *
 * @author xiejiemin
 * @create 2021/2/20
 */
public class 插入排序 {
    public static void main(String[] args) {
        Integer[] array = RandomUtil.getRandomArrayByRange(0, 100, 10);
        System.out.println("插入排序前:" + Arrays.toString(array));
        insertSort(array);
        System.out.println("插入排序后:" + Arrays.toString(array));
    }

    /**
     * 插入排序
     *
     * @param array 需要排序的数组
     */
    private static void insertSort(Integer[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            // 向前比较找到插入位置
            for (int j = i; j > 0; j--) {
                // swap
                if (array[j].compareTo(array[j - 1]) < 0) {
                    Integer temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
