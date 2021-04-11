package com.acme.dbo.txlog.logger;

import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.printer.ConsolePrinter;
import com.acme.dbo.txlog.message.ByteMessage;
import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.StringMessage;

public class LoggerController {
    private final ConsolePrinter consolePrinter;


    public void log(Message message) {
        consolePrinter.printer(message.getDecoratedMessage());
    }

    public LoggerController(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }
}

