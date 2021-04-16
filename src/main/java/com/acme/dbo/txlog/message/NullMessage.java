package com.acme.dbo.txlog.message;

public class NullMessage implements Message{
    private int body;

    public NullMessage(){
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }

    @Override
    public boolean isSameTypeOf(Message newMessage) {
        return false;
    }

    @Override
    public Message accumulate(Message newMessage) {
        return null;
    }
}
