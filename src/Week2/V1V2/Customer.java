package Week2.V1V2;

public class Customer {
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
    public void CustomerBuy(int num2buy, Customer c,Merchandise m){
        double totalCost=m.BuyAction(num2buy,c);
        this.money-=totalCost;
        System.out.println("顾客还剩余金额："+this.money);
    }
}
