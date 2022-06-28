package Week4.MyExceptions;

public class call3 {
    public void throwRTException() {
        System.out.println("call3.throwException start");
        try{
        Object n = null;
        n.toString();
        }catch(RuntimeException ex){
            throw new MyRuntimeExceptions("报一个Runtime Exception",ex);
        }

        System.out.println("call3.throwException end");
    }

    public static void throwException() throws ClassNotFoundException {
        System.out.println("call3.throwException start");
        Class.forName("com.neverland.Rabbit");
        System.out.println("call3.throwException end");
    }
}
