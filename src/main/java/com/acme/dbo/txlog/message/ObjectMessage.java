package com.acme.dbo.txlog.message;

public class ObjectMessage implements Message{
    private final Object body;

    public ObjectMessage(Object body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "reference: " + body;
    }

    @Override
    public boolean isSameTypeOf(Message newMessage) {
        return newMessage instanceof ObjectMessage;
    }

    @Override
    public Message accumulate(Message newMessage) {
        return null;
    }
}
