package com.tea.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * com.tea.exceptions
 *
 * @author jaymin
 * @since 2021/5/15
 */
public class ExceptionDemonstration {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("/notexist");
        } catch (FileNotFoundException e) {
        }
    }
}
