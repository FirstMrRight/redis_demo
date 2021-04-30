package com.tea.modules.model;

/**
 * com.tea.modules.model
 *
 * @author jaymin
 * @since 2021/4/30
 */
public class Book {
    boolean checkedOut = false;

    public Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    public void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
        // Normally, you'll also do this:
        super.finalize(); // Call the base-class version
    }
}
