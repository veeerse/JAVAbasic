package Week4.ExceptionStack;

public class callException {
    public static void main(String[] args) throws ClassNotFoundException {
        makecall();
    }
    public static void makecall() throws ClassNotFoundException {
        call1 call1=new call1();
        System.out.println("Start!");
//        call1.call2RTException();
        call1.call2Exception();
        System.out.println("End!");
    }
}
