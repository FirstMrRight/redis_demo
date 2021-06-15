package com.tea.modules.java8.enums;

/**
 * com.tea.modules.java8.enums <br>
 * 实战枚举类
 *
 * @author jaymin
 * @since 2021/6/9
 */
public class EnumDemo {

    /**
     * 了解枚举的基本功能
     */
    private static void enumFunction() {
        // 获取所有的枚举信息
        WeekEnum[] weekDays = WeekEnum.values();
        for (WeekEnum weekDay : weekDays) {
            String enumName = "当前枚举名称:" + weekDay.name();
            String enumIndex = " 枚举位置:" + weekDay.ordinal();
            String enumClass = " 枚举类型:" + weekDay.getDeclaringClass();
            System.out.println(enumName + enumIndex + enumClass);
        }
        WeekEnum mon = WeekEnum.valueOf("MON");
        System.out.println(mon.name());
        WeekEnum monB = Enum.valueOf(WeekEnum.class, "MON");
        System.out.println(monB);
    }

    /**
     * 输入工作日，输出工作时间 <br>
     * 枚举的本质就是int,配合switch的时候,编译会做类似于ordinal来确定int值
     */
    private static void printWorkDays(WeekEnum weekEnum) {
        switch (weekEnum) {
            case MON:
                System.out.println("今天是工作日-8:30-5:30");
                break;
            case TUE:
                System.out.println("今天是工作日-8:30-5:30");
                break;
            case WEB:
                System.out.println("今天是工作日-8:30-5:30");
                break;
            case THUR:
                System.out.println("今天是工作日-8:30-5:30");
                break;
            case FRI:
                System.out.println("今天是工作日-8:30-5:30");
                break;
            default:
                System.out.println("休息");
        }
    }

    /**
     * 枚举中重写抽象方法
     */
    private static void doOperation(){
        double x = 2;
        double y = 4;
        OperationEnum[] values = OperationEnum.values();
        for (OperationEnum operation : values) {
            double apply = operation.apply(x, y);
            System.out.printf("%f %s %f = %f%n",x,operation.getSymbol(),y, apply);
        }
    }
    public static void main(String[] args) {
//        enumFunction();
//        printWorkDays(WeekEnum.MON);
        doOperation();
    }
}
