package Week2.V1V2;

public class SupermarketTem {
    public String supermarketname;
    public String SupermarketAddress;
    public int SupermarketParkings;
    public double income;
    public Merchandise[] merchandise;
    public int[] MerchandiseisSold;

    public void describe(){
        System.out.println("本店叫:" + supermarketname + "\n本店地址位于：" + SupermarketAddress
                + "\n本店拥有商品：" + merchandise.length + "件\n本店拥有车位：" + SupermarketParkings + "个");
    }
}
