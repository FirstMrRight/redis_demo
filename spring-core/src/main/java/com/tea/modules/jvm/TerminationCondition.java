package com.tea.modules.jvm;

import com.tea.modules.model.po.Book;

/**
 * com.tea.modules.jvm
 * 在对象回收的时候触发finalize方法<br>
 * 这里说一下我对finalize的理解,首先Java的对象回收很难准确地通过程序调用来触发<br>
 * 多数情况下，由JVM自动去回收对象，那么在回收对象的过程中，Java提供了一个钩子函数-finalize<br>
 * 它可以确保对象在被回收的时候触发这个特殊的函数，并且在下次垃圾回收的时候才真正对这个对象进行回收<br>
 *     但是，注意，finalize并不一定会被触发，也就是说对象可能永远不会被回收.<br>
 * @author jaymin
 * @since 2021/4/30
 */
public class TerminationCondition {

    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup:
        novel.checkIn();
        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();
//        new Nap(1); // One second delay
    }
}
