package com.acme.dbo.txlog.message;

public class ByteMessage implements Message{
    private final byte body;

    public ByteMessage(byte body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + body;
    }

}
