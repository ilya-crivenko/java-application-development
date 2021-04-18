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
        long sumOfAccumulate = (long) this.body + ((IntMessage)newMessage).body;
        if (sumOfAccumulate > Integer.MAX_VALUE) {
            System.out.println(this.getDecoratedMessage());
            return new IntMessage(Integer.MAX_VALUE);
        } else {
            return new IntMessage(this.body + ((IntMessage)newMessage).body);
        }
    }
}

/*
    public static void log(int message) {
        if (intAccumulated == null || ((long) intAccumulated + (long) message > Integer.MAX_VALUE)) {
            flush();
            intAccumulated = message;
        } else {
            intAccumulated += message;
        }
    }

 */