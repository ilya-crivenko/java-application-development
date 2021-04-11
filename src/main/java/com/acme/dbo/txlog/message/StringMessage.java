package com.acme.dbo.txlog.message;

public class StringMessage implements Message{
    private final String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "string: " + body;
    }
}
