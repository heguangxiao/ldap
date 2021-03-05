/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.common;

import java.util.List;

/**
 *
 * @author HTC-PC
 */
public class Tool {

    public static void out(String input) {
        String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        if (true) {
            System.out.println("Tool.debug: " + className + ".class:[d" + lineNumber + "] " + input);
        }
    }

    public static void out(int input) {
        String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        if (true) {
            System.out.println("Tool.debug: " + className + ".class:[d" + lineNumber + "] " + input);
        }
    }

    public static String showError(String functionName, String className, String messageError) {
        String result = "";
        if (Tool.checkNull(functionName)) {
            functionName = "Not input function name";
        }
        if (Tool.checkNull(className)) {
            className = "Not input class name";
        }
        if (Tool.checkNull(messageError)) {
            messageError = "Not input message input";
        }
        System.out.println("Error when call " + functionName + " in " + className + " class ::: " + messageError);
        return result;
    }

    public static boolean checkNull(String string) {
        return string == null || string.equalsIgnoreCase("") || string.equalsIgnoreCase("null");
    }

    public static int getMaxNumber(List<Integer> numbers) {
        int result = 0;
        if (!numbers.isEmpty()) {
            for (Integer number : numbers) {
                if (number > result) {
                    result = number;
                }
            }
        }
        return result;
    }
}
