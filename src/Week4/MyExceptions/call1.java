package Week4.MyExceptions;

public class call1 {
    Week4.MyExceptions.call2 call2 =new call2();
    public void call2RTException(){
        System.out.println("Call1.call2RTException Start!");
        call2.call3RTException();
        System.out.println("Call1.call2RTException End!");
    }
    public void call2Exception() throws ClassNotFoundException, MyExceptions {
        System.out.println("Call1.call2Exception Start!");
        try {
            call2.call3Exception();
        } catch (Exception ex) {
            throw new MyExceptions("报个Exception",ex);
        }
//        call2.call3Exception();
        System.out.println("Call1.call2Exception End!");
    }
}
