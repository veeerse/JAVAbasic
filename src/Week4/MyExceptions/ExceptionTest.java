package Week4.MyExceptions;

public class ExceptionTest {
    public static void main(String[] args) throws MyExceptions, ClassNotFoundException {
        call1 call1=new call1();
        System.out.println("Start");
        call1.call2Exception();
        System.out.println("End");
    }
}
