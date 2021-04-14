package com.tea.modules.util;

import java.util.HashSet;
import java.util.Set;

/**
 * com.tea.modules.util.
 * 随机数工具类.<br>
 *
 * @author xiejiemin
 * @create 2021/2/20
 */
public class RandomUtil {

    /**
     * 产生包含 N 个随机数的数组
     *
     * @param count 随机数数量
     * @return 包含 N 个随机数的数组
     */
    public static int[] getRandomArray(int count) {
        int[] array = new int[count];
        for (int index = 0; index < count; index++) {
            array[index] = (int) (Math.random() * count);
        }
        return array;
    }


    /**
     * 随机指定范围内N个不重复的数
     * 利用HashSet的特征，只能存放不同的值
     *
     * @param min   指定范围最小值
     * @param max   指定范围最大值
     * @param count 随机数个数
     * @return 随机数数组
     */
    public static Integer[] getRandomArrayByRange(int min, int max, int count) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int randomNumber;
            do {
                randomNumber = doRandom(min, max);
            } while (!set.add(randomNumber));
        }
        Integer[] array = new Integer[count];
        set.toArray(array);
        return array;
    }

    /**
     * 产生随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机数
     */
    private static int doRandom(int min, int max) {
        // 调用Math.random()方法
        int result = (int) (Math.random() * (max - min)) + min;
        return result;
    }
}
