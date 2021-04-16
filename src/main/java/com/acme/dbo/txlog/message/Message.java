package com.acme.dbo.txlog.message;

public interface Message {
    String getDecoratedMessage();
    boolean isSameTypeOf(Message newMessage);
    Message accumulate(Message newMessage);
}
