package com.acme.dbo.txlog.message;

public class IntMessage implements Message{
    private final int body;

    public IntMessage(int body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + body;
    }


}
