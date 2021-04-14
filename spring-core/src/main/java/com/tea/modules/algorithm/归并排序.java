package com.tea.modules.algorithm;

import com.tea.modules.util.RandomUtil;

import java.util.Arrays;
import java.util.HashSet;

/**
 * com.tea.modules.algorithm
 * 算法: 归并排序.<br>
 * 将给定的数据用分治法发进行切分，切分到不可分割的单元后，再进行比较后合并.<br>
 * 图解算法: <a href="https://www.cnblogs.com/chengxiao/p/6194356.html">图解排序算法(四)之归并排序</a><br>
 * JDK内置的Timsort:<a href="https://www.jianshu.com/p/892ebd063ad9">Timsort详解</a><br>
 * stackoverflow:<a href="https://stackoverflow.com/questions/7770230/comparison-between-timsort-and-quicksort">timsort和quicksort之间的比较</a>
 *
 * @author xiejiemin
 * @create 2021/2/19
 */
public class 归并排序 {

    public static void main(String[] args) {
        HashSet<Integer> randomSet = new HashSet<>();
        Integer[] array = RandomUtil.getRandomArrayByRange(0, 1000, 10);
        System.out.println("归并排序前:" + Arrays.toString(array));
        mergeSort(array);
        System.out.println("归并排序后:" + Arrays.toString(array));
    }

    private static void mergeSort(Integer[] arr) {
        Integer[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 归并排序
     *
     * @param array 原数组
     * @param start  开始索引
     * @param end 结束索引
     * @param temp  临时数组，与原数组长度一致
     */
    private static void sort(Integer[] array, int start, int end, Integer[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            // 递归对左边的数组进行归并排序
            sort(array, start, mid, temp);
            // 递归对右边的数组进行归并排序
            sort(array, mid + 1, end, temp);
            merge(array, start, mid, end, temp);
        }
    }

    /**
     * 将两个有序子数组合并操作.<br>
     * 思路: 假设现在得到两个数组.<br>
     * A: [2,5].<br>
     * B: [1,3].<br>
     * 在这步的操作就是:  <br>
     * 对比A和 B中的第一个数字: 1和 2.<br>
     * 此时得知 1 < 2 .<br>
     * 将1放入temp中.<br>
     * temp:[1].<br>
     * 再对比 2 和 3.<br>
     * temp:[1,2].<br>
     * 此时再对比 3 和 5.<br>
     * temp:[1,2,3].<br>
     * 最后,将 5 入数组.<br>
     * temp:[1,2,3,5].<br>
     * 归并排序就是把原数组切分成若干个小数组，然后进行合并。<br>
     *
     * @param array 原数组
     * @param start 开始索引
     * @param mid   中点
     * @param end   结束索引
     * @param temp  临时数组,主要是为了复用
     */
    private static void merge(Integer[] array, int start, int mid, int end, Integer[] temp) {
        // 左序列指针
        int i = start;
        // 右序列指针
        int j = mid + 1;
        // 临时数组指针
        int t = 0;
        // 比较大小,较小的数值进入临时数组,并且索引前移
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        // 将左边剩余元素填充进temp中,主要是收尾工作
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        // 将右序列剩余元素填充进temp中,主要是收尾工作
        while (j <= end) {
            temp[t++] = array[j++];
        }
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (start <= end) {
            array[start++] = temp[t++];
        }
    }
}
