package ooadrefactoring;

public class StringMessage {
    private final String body;

    public StringMessage(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public boolean isSameTypeOf(StringMessage newMessage) {
        return newMessage instanceof StringMessage;
    }

    public StringMessage accumulate(StringMessage newMessage) {
        StringMessage stringMessage = new StringMessage(this.body + newMessage.body);
        return stringMessage;
    }

    @Override
    public String toString() {
        return "String: " + body;
    }
}
