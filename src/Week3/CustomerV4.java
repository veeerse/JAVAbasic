package Week3;

public class CustomerV4 {
    public String name;
    public boolean driveCar;
    public double money;
    public void describe(){
        System.out.println(name+"。 顾客是否开车："+driveCar+"。 顾客有多少钱："+money);
    }

    /**
     * 主要用了this修改顾客对象的money
     * @param num2buy
     * @param c
     * @param m
     */
    public void CustomerBuy(int num2buy, CustomerV4 c, MerchandiseV4 m){
        double totalCost=m.BuyAction(num2buy,c);
        m.describe();
        System.out.println("帮顾客打包了：" + num2buy + "件" + "商品：" + m.id + "。总价是：" + totalCost);
        m.count -= num2buy;
        this.money-=totalCost;
        System.out.println("顾客还剩余金额："+this.money);
    }
}
