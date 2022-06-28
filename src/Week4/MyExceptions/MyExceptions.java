package Week4.MyExceptions;

public class MyExceptions extends Exception{
    public MyExceptions(){
    }
    public MyExceptions(String message){
        super(message);
    }
    public MyExceptions(String message, Throwable cause){
        super(message, cause);
    }
    public MyExceptions(Throwable cause){
        super(cause);
    }
}