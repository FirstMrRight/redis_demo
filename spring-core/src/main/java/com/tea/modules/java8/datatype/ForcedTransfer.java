package com.tea.modules.java8.datatype;

/**
 * 数值之间的强转
 *
 * @author jaymin
 * @since 2021/3/21 15:40
 */
public class ForcedTransfer {

    public static void main(String[] args) {
        int n = 123456789;
        // 整型向上转换丢失了精度
        float f = n;
        System.out.println(f);
        int n1 = 1;
        float f1 = 2.2f;
        // 不同类型的数值进行运算，将向上转型
        System.out.println(n1 + f1);
        double x = 2021.0321;
        // 强转为整型
        int integerX = (int) x;
        System.out.println(integerX);
        x = 2021.8888;
        // 四舍五入
        int round = (int) Math.round(x);
        System.out.println(round);
        long l = Long.MAX_VALUE;
        int l1 = (int) l;
        System.out.println(l1);
        int i = 300;
        byte b = (byte) i;
        // 128*2 = 256,300-256=44
        System.out.println(b);

    }

    /**
     * 许多面试官喜欢问这个问题:
     * <pre>{@code
     *         short s1= 1;
     *         s1 = s1 + 1;
     * }</pre>
     * 因为1是int,而s1是short类型，在两个类型进行运算时，优先向上转型，那么这个结果计算出来，就是int类型，用short来接收无法通过编译.
     */
    private static void errorCode(){
        short s1= 1;
        s1 = (short) (s1 + 1);
    }

}
