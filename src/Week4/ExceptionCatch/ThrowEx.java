package Week4.ExceptionCatch;

public class ThrowEx {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("11111111");
        clazz.getField("1123");
    }
}
