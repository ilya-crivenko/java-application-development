package com.acme.dbo.txlog.message;

public class StringMessage implements Message{
    private final String body;
    private static int count = 1;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        String decoratedBody;
        if (count > 1) {
            decoratedBody = "string: " + body + " (x" + count + ")";
            count = 1;
        } else decoratedBody = "string: " + body;
        return decoratedBody;
    }

    @Override
    public boolean isSameTypeOf(Message newMessage) {
        return newMessage instanceof StringMessage;
    }

    @Override
    public Message accumulate(Message newMessage) {
        StringMessage newStringMessage = (StringMessage) newMessage;
        if (this.stringIsSame(newStringMessage)) {
            count++;
        } else {
            System.out.println(this.getDecoratedMessage());
        }
        return newMessage;
    }

    private boolean stringIsSame (StringMessage stringMessage){
        return this.body.equals(stringMessage.body);
    }
}
