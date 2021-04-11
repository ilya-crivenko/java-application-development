package ooadrefactoring;

public class LoggerController {
    private final ConsolePrinter consolePrinter;
    private LoggerState currentState;
    private IntMessage currentStateIntValue;
    private StringMessage currentStateStringValue;
    private ByteMessage currentStateByteValue;

    public LoggerController(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void log(IntMessage intMessage) {
        if (currentState == LoggerState.INT){
//      if (currentStateIntValue.isSameTypeOf(intMessage){ //accum
        currentStateIntValue = currentStateIntValue.accumulate(intMessage);
        } else { //flush

        }
    }

    public void log(StringMessage stringMessage) {

        if (currentState == LoggerState.STRING){
//      if (currentStateStringValue.isSameTypeOf(stringMessage){ //accum
            currentStateStringValue = currentStateStringValue.accumulate(stringMessage);
        } else { //flush

        }
    }

    public void log(ByteMessage byteMessage) {
        if (currentState == LoggerState.BYTE){
//      if (currentStateByteValue.isSameTypeOf(byteMessage){ //accum
            currentStateByteValue = currentStateByteValue.accumulate(byteMessage);
        } else { //flush

        }
    }


}

