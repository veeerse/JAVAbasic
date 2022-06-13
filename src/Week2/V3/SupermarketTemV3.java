package Week2.V3;

public class SupermarketTemV3 {
    public String Supermarketname;
    public String SupermarketAddress;
    public int SupermarketParkings;
    public MerchandiseV3[] merchandiseV3;
    public int[] MerchandiseisSold;

    /**
     * 超市的构建方法
     * @param supermarketname
     * @param SupermarketAddress
     * @param SupermarketParkings
     * @param MerchandiseCount
     */
    public SupermarketTemV3(String supermarketname, String SupermarketAddress, int SupermarketParkings, int MerchandiseCount){
        this.Supermarketname=supermarketname;
        this.SupermarketAddress=SupermarketAddress;
        this.SupermarketParkings=SupermarketParkings;
        merchandiseV3=new MerchandiseV3[MerchandiseCount];
        for(int i=0; i<MerchandiseCount; i++){
            double buyPrice=Math.random() * 100;
            MerchandiseV3 m=new MerchandiseV3("ID=" + i,MerchandiseCount,buyPrice,buyPrice + 250 * (Math.random()));
            merchandiseV3[i]=m;
        }
    }
    public void describe(){
        System.out.println("本店叫:" + Supermarketname + "\n本店地址位于：" + SupermarketAddress
                + "\n本店拥有商品：" + merchandiseV3.length + "件\n本店拥有车位：" + SupermarketParkings + "个");
    }
}
