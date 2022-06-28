package Week4.ExceptionStack;

public class call1 {
    call2 call2 =new call2();
    public void call2RTException(){
        System.out.println("Call1.call2RTException Start!");
        call2.call3RTException();
        System.out.println("Call1.call2RTException End!");
    }
    public void call2Exception() throws ClassNotFoundException{
        System.out.println("Call1.call2Exception Start!");
        try {
            call2.call3Exception();
        } catch (ClassNotFoundException ex) {
            System.out.println("got exception in call1: "+ex.getMessage());
        }
//        call2.call3Exception();
        System.out.println("Call1.call2Exception End!");
    }
}
