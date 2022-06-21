package Week3;

public class SupermarketTemV4 {
    public String Supermarketname;
    public String SupermarketAddress;
    public int SupermarketParkings;
    public MerchandiseV4[] merchandiseV4;
    public int[] MerchandiseisSold;

    /**
     * 超市的构建方法
     * @param supermarketname
     * @param SupermarketAddress
     * @param SupermarketParkings
     * @param MerchandiseCount
     */
    public SupermarketTemV4(String supermarketname, String SupermarketAddress, int SupermarketParkings, int MerchandiseCount){
        this.Supermarketname=supermarketname;
        this.SupermarketAddress=SupermarketAddress;
        this.SupermarketParkings=SupermarketParkings;
        merchandiseV4 =new MerchandiseV4[MerchandiseCount];
        for(int i=0; i<MerchandiseCount-10; i++){
            double buyPrice=Math.random() * 100;
            MerchandiseV4 m=new MerchandiseV4("ID=" + i,MerchandiseCount,buyPrice,buyPrice + 250 * (Math.random()));
            merchandiseV4[i]=m;
        }
        //添加手机类商品
        for(int i=MerchandiseCount-10; i<MerchandiseCount; i++){
            double buyPrice=Math.random() * 5000;
            Phone m=new Phone(            "手机"+(MerchandiseCount-10-i),"编号"+i,100, buyPrice + 1000 * (Math.random()), buyPrice,
                    4.5,3.5,4,128,"索尼","安卓");
            merchandiseV4[i]=m;
        }
    }
    public void describe(){
        System.out.println("本店叫:" + Supermarketname + "\n本店地址位于：" + SupermarketAddress
                + "\n本店拥有商品：" + merchandiseV4.length + "件\n本店拥有车位：" + SupermarketParkings + "个");
    }
}
