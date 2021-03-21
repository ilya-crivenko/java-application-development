package com.acme.dbo.txlog;

public class Facade {
/*
    public static void log(Object object) {
        outputToConsole(decorate(object));
    }

    private static String decorate (Object message) {
        String prefix = "reference: ";
         if ((message instanceof Integer) || (message instanceof Byte) || (message instanceof Boolean)) {
            prefix = "primitive: ";
        } else if (message instanceof String) {
            prefix = "string: ";
        } else if (message instanceof Character) {
            prefix = "char: ";
        }
         return prefix + message;
     }
*/
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String OBJECT_PREFIX = "reference: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String CHAR_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static final String OBJECT_POSTFIX = "";

    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message + postfix;
    }

    public static void log(int message) {
        outputToConsole(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }
    public static void log(byte message) {
        outputToConsole(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }
    public static void log(Boolean message) {
        outputToConsole(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }
    public static void log(char message) {
        outputToConsole(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }
    public static void log(String message) {
        outputToConsole(decorate(STRING_PREFIX, message, STRING_POSTFIX));
    }
    public static void log(Object message) {
        outputToConsole(decorate(OBJECT_PREFIX, message, OBJECT_POSTFIX));
    }

    private static void outputToConsole(String message) {
        System.out.println(message);
    }
}