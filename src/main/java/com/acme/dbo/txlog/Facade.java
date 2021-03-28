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
    private static Integer intAccumulated = null;
    private static Integer byteAccumulated = null;
    private static String stringAccumulated = null;
    private static Integer stringDuplicatedCounter = 0;

    public static void log(int message) {
        if (intAccumulated == null || ((long) intAccumulated + (long) message > Integer.MAX_VALUE)) {
            flush();
            intAccumulated = message;
        } else {
            intAccumulated += message;
        }
    }

    public static void log(byte message) {
        if (byteAccumulated == null || (byteAccumulated + message > Byte.MAX_VALUE)) {
            flush();
            byteAccumulated = Integer.valueOf(message);
        } else {
            byteAccumulated += message;
        }
    }

    public static void log(String message) {
        if (stringAccumulated == null) {
            stringAccumulated = message;
        } else {
            if (!stringAccumulated.equals(message)) {
                flush();
                stringAccumulated = message;
            }
        }
        stringDuplicatedCounter++;
    }

    public static void log(Boolean message) {
        outputToConsole(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(char message) {
        outputToConsole(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(Object message) {
        outputToConsole(decorate(OBJECT_PREFIX, message, OBJECT_POSTFIX));
    }

    private static void outputToConsole(String message) {
        System.out.println(message);
    }

    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message + postfix;
    }

    public static void flush() {
        if (intAccumulated != null) {
            if (intAccumulated == Integer.MAX_VALUE) {
                outputToConsole(decorate(PRIMITIVE_PREFIX, Integer.MAX_VALUE, PRIMITIVE_POSTFIX));
            } else {
                outputToConsole(decorate(PRIMITIVE_PREFIX, intAccumulated, PRIMITIVE_POSTFIX));
            }
        }
        if (byteAccumulated != null) {
            if (byteAccumulated == Byte.MAX_VALUE) {
                outputToConsole(decorate(PRIMITIVE_PREFIX, Byte.MAX_VALUE, PRIMITIVE_POSTFIX));
            } else {
                outputToConsole(decorate(PRIMITIVE_PREFIX, byteAccumulated, PRIMITIVE_POSTFIX));
            }
        }
        if (stringDuplicatedCounter != null) {
            if (stringDuplicatedCounter != 0) {
                if (stringDuplicatedCounter == 1) {
                    outputToConsole(decorate(STRING_PREFIX, stringAccumulated, STRING_POSTFIX));
                } else {
                    outputToConsole(decorate(STRING_PREFIX, stringAccumulated + " (x" + stringDuplicatedCounter + ")", STRING_POSTFIX));
                }
            }
        }
        //stringAccumulated = null;
        byteAccumulated = null;
        intAccumulated = null;
        stringDuplicatedCounter = 0;
    }
}