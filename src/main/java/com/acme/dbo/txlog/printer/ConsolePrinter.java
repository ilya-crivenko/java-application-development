package com.acme.dbo.txlog.printer;

public class ConsolePrinter implements Printer{
    @Override
    public void printer(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
