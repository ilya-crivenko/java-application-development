package ooadrefactoring.message;

public class IntMessage {
    private final int body;

    public IntMessage(int body) {
        this.body = body;
    }

    public int getBody() {
        return body;
    }

    public boolean isSameTypeOf(IntMessage newMessage) {
        return newMessage instanceof IntMessage;
    }

    public IntMessage accumulate(IntMessage newMessage) {
        return new IntMessage(this.body + newMessage.body);
    }

    @Override
    public String toString() {
        return "primitive: " + body;
    }
}
