package Week4.ExceptionStack;

public class call2 {
    public void call3RTException() {
        call3 call3 = new call3();
        System.out.println("Call2.call3RTException Start!");
        call3.throwRTException();
        System.out.println("Call2.call3RTException End!");
    }
    public void call3Exception()throws ClassNotFoundException{
        System.out.println("Call2.call3Exception Start!");
        call3.throwException();
        System.out.println("Call2.call3Exception End!");
    }
}
