package com.acme.dbo.txlog.message;

public class ByteMessage implements Message {
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
        int sumOfAccumulate = this.body + ((ByteMessage) newMessage).body;
        if (sumOfAccumulate > Byte.MAX_VALUE) {
            System.out.println(this.getDecoratedMessage());
            return new ByteMessage(Byte.MAX_VALUE);
        } else {
            return new ByteMessage((byte) (this.body + ((ByteMessage) newMessage).body));
        }
    }
}
