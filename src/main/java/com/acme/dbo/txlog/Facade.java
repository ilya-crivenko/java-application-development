package com.acme.dbo.txlog;

import com.acme.dbo.txlog.logger.LoggerController;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.ConsolePrinter;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 1. print to console
 * 2. decorating
 * 3. accumulating
 * 4. --type overflow checking--
 * 5. state management (flushing)

 */

public class Facade {
    private static LoggerController controller = new LoggerController(new ConsolePrinter());

    public static void log(int message){
        controller.log(new IntMessage(message));
    }

    public static void log(String message){
        controller.log(new StringMessage(message));
    }

    public static void log (byte message){
        controller.log(new ByteMessage(message));
    }

    public static void log (char message){
        controller.log(new CharMessage(message));
    }

    public static void log (boolean message){
        controller.log(new BooleanMessage(message));
    }

    public static void log (Object message){
        controller.log(new ObjectMessage(message));
    }

    public static void flush() {
        controller.flush();
    }
}