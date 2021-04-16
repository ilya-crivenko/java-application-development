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

    @Override
    public boolean isSameTypeOf(Message newMessage) {
        return newMessage instanceof IntMessage;
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new IntMessage(this.body + ((IntMessage)newMessage).body);
    }
}
