package com.acme.dbo.txlog.message;

public class CharMessage implements Message{
    private final char body;

    public CharMessage(char body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "char: " + body;
    }
}
