package Week4.ExceptionCatch;

public class NewAndThrow {
    public static void main(String[] args) throws Exception {
        //causeException();
        RunTimeEx();
    }

    public static void causeException() throws Exception{
        throw new Exception("This is a checked Exception!");
    }

    /**
     * unchecked exception 可以不必在main中throws出去
      * @throws Exception
     */
    public static void RunTimeEx() throws Exception{
        throw new RuntimeException("This is a RunTimeException!");
    }
}
