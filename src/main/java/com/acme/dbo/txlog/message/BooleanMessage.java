package com.acme.dbo.txlog.message;

public class BooleanMessage implements Message{
    private final boolean body;

    public BooleanMessage(boolean body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + body;
    }

    @Override
    public boolean isSameTypeOf(Message newMessage) {
        return newMessage instanceof BooleanMessage;
    }

    @Override
    public Message accumulate(Message newMessage) {
        return null;
    }
}
