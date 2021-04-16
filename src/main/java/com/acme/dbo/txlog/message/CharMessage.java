package com.acme.dbo.txlog.message;

public class CharMessage implements Message{
    private final char body;

    public CharMessage(char body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "char: " + body;
    }

    @Override
    public boolean isSameTypeOf(Message newMessage) {
        return newMessage instanceof CharMessage;
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new CharMessage((char) (this.body + ((CharMessage)newMessage).body));
    }
}
