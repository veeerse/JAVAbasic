package Week4.ExceptionStack;

public class call3 {
    public void throwRTException() {
        System.out.println("call3.throwException start");
        Object n = null;
        n.toString();
        System.out.println("call3.throwException end");
    }

    public static void throwException() throws ClassNotFoundException {
        System.out.println("call3.throwException start");
        Class.forName("com.neverland.Rabbit");
        System.out.println("call3.throwException end");
    }
}
