package Week4.MyExceptions;

public class MyRuntimeExceptions extends RuntimeException {
    public MyRuntimeExceptions() {
    }

    public MyRuntimeExceptions(String message) {
        super(message);
    }

    public MyRuntimeExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRuntimeExceptions(Throwable cause) {
        super(cause);
    }
}
