package com.acme.dbo.txlog.logger;

import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.ConsolePrinter;

import static com.sun.deploy.trace.Trace.flush;

public class LoggerController {
    private final ConsolePrinter consolePrinter;
    private Message currentState = new NullMessage();

    public void log(Message message) {
        if (this.currentState.isSameTypeOf(message)) {
            currentState = currentState.accumulate(message);
        } else {
            flush();
            currentState = message;
        }
    }

    public LoggerController(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void flush() {
        if (!(currentState instanceof NullMessage)) {
            consolePrinter.printer(currentState.getDecoratedMessage());
        }
        currentState = new NullMessage();
    }
}

