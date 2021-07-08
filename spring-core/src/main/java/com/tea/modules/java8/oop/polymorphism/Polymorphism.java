package com.tea.modules.java8.oop.polymorphism;

/**
 * com.tea.modules.java8.oop <br>
 * 理解多态
 * @author jaymin
 * @since 2021/7/1
 */
public class Polymorphism {

    /**
     * 传入实现同一个接口的不同实例，触发不一样的效果
     * @param args
     */
    public static void main(String[] args) {
        applyCreditCard(new PFBank());
        applyCreditCard(new ChineseBank());
        applyCreditCard(new ZSBank());
        new RoundGlyph(5);
    }

    private static void applyCreditCard(IBank bank){
        bank.applyCreditCard();
    }

    static class Glyph {
        void draw() {
            System.out.println("Glyph.draw()");
        }

        Glyph() {
            System.out.println("Glyph() before draw()");
            draw();
            System.out.println("Glyph() after draw()");
        }
    }

    static class RoundGlyph extends Glyph {
        private int radius = 1;

        RoundGlyph(int r) {
            radius = r;
            System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
        }

        @Override
        void draw() {
            System.out.println("RoundGlyph.draw(), radius = " + radius);
        }
    }
}
