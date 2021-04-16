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

    @Override
    public boolean isSameTypeOf(Message newMessage) {
        return newMessage instanceof ByteMessage;
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new ByteMessage((byte) (this.body + ((ByteMessage)newMessage).body));
    }
}
