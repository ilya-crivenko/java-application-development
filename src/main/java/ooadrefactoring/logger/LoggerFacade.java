package ooadrefactoring.logger;

import ooadrefactoring.printer.ConsolePrinter;
import ooadrefactoring.message.ByteMessage;
import ooadrefactoring.message.IntMessage;
import ooadrefactoring.message.StringMessage;

/**
 * 1. print to console
 * 2. decorating
 * 3. accumulating
 * 4. --type overflow checking--
 * 5. state management (flushing)

 */

public class LoggerFacade {
    private static LoggerController controller = new LoggerController(new ConsolePrinter());

    public void log(int message){
        controller.log(new IntMessage(message));
    }

    public void log (String message){
        controller.log(new StringMessage(message));
    }

    public void log (Byte message){
        controller.log(new ByteMessage(message));
    }
}
