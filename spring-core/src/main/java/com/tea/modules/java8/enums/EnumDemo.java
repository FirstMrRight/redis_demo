package com.tea.modules.java8.enums;

import java.util.*;

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
    private static void doOperation() {
        double x = 2;
        double y = 4;
        OperationEnum[] values = OperationEnum.values();
        for (OperationEnum operation : values) {
            double apply = operation.apply(x, y);
            System.out.printf("%f %s %f = %f%n", x, operation.getSymbol(), y, apply);
        }
    }

    /**
     * 枚举与接口
     */
    private static void printEnumInfo() {
        EnumInfoService web = WeekEnum.WEB;
        web.printName();
    }

    /**
     * EnumSet 的设计充分考虑到了速度因素，因为它必须与非常高效的 bit 标志相竞争（其操作与 HashSet 相比，非常地快）.<br>
     * 就其内部而言，它（可能）就是将一个 long 值作为比特向量，所以 EnumSet 非常快速高效。<br>
     * 使用 EnumSet 的优点是，它在说明一个二进制位是否存在时，具有更好的表达能力，并且无需担心性能。
     */
    private static void enumSet() {
        // 空构造器
        EnumSet<WeekEnum> weekEnums = EnumSet.noneOf(WeekEnum.class);
        weekEnums.add(WeekEnum.MON);
        weekEnums.add(WeekEnum.TUE);
        weekEnums.add(WeekEnum.WEB);
        // of工厂，可以接收多个enum
        weekEnums.addAll(EnumSet.of(WeekEnum.THUR, WeekEnum.FRI, WeekEnum.SAT, WeekEnum.SUN));
        System.out.println(weekEnums);
        // range-范围
        weekEnums.removeAll(EnumSet.range(WeekEnum.MON, WeekEnum.WEB));
        System.out.println(weekEnums);
        // 创建一个与指定枚举集具有相同元素类型的枚举集，最初包含指定集中未包含的所有此类型的元素。
        weekEnums = EnumSet.complementOf(weekEnums);
        System.out.println(weekEnums);
    }

    /**
     * EnumMap 是一种特殊的 Map，它要求其中的键（key）必须来自一个 enum，<br>
     * 由于 enum 本身的限制，所以 EnumMap 在内部可由数组实现。<br>
     * 因此 EnumMap 的速度很快，我们可以放心地使用 enum 实例在 EnumMap 中进行查找操作。<br>
     * 不过，我们只能将 enum 的实例作为键来调用 put() 可方法，其他操作与使用一般的 Map 差不多。<br>
     * 这里我们的例子是使用EnumMap来实现一个简单的命令模式
     */
    private static void enumMap() {
        EnumMap<WeekEnum, CommandService> commandServiceEnumMap = new EnumMap<>(WeekEnum.class);
        commandServiceEnumMap.put(WeekEnum.MON, () -> System.out.println("周一白酒涨停"));
        commandServiceEnumMap.put(WeekEnum.TUE, () -> System.out.println("周二有色跌停"));
        commandServiceEnumMap.put(WeekEnum.WEB, () -> System.out.println("周三大盘震荡"));
        for (Map.Entry<WeekEnum, CommandService> weekEnumCommandService : commandServiceEnumMap.entrySet()) {
            WeekEnum week = weekEnumCommandService.getKey();
            System.out.println(week.name() + "的策略:");
            weekEnumCommandService.getValue().action();
        }
    }

    public static void main(String[] args) {
//        enumFunction();
//        printWorkDays(WeekEnum.MON);
//        doOperation();
//        printEnumInfo();
//        enumSet();
        enumMap();
    }

}
