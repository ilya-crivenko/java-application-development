package ooadrefactoring.message;

public class ByteMessage {
    private final byte body;

    public ByteMessage(byte body) {
        this.body = body;
    }

    public byte getBody(){
        return body;
    }

    public boolean isSameTypeOf(ByteMessage byteMessage) {
        return byteMessage instanceof ByteMessage;
    }

    public ByteMessage accumulate(ByteMessage byteMessage) {
        return new ByteMessage((byte) (this.body + byteMessage.body));
    }

    @Override
    public String toString() {
        return "primitive: " + body;
    }
}
