package Week3;

public class MerchandiseV4 {
    public String id;
    public int count;
    public double buyPrice;
    public double sellPrice;

    public MerchandiseV4(String id, int count, double buyPrice, double sellPrice) {
        this.id = id;
        this.count = count;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    /**
     * 如果不知道进价，就按卖价0.5倍处理
     *
     * @param id
     * @param count
     * @param soldPrice
     */
    public MerchandiseV4(String id, int count, double soldPrice) {
        this(id, count, soldPrice * 0.5, soldPrice);
    }

    public MerchandiseV4() {
        this("无名", 0, 0, 0);
    }

    /**
     * 描述商品各种属性的方法
     */
    public void describe() {
        System.out.println("商品id是" + id + "。 商品售价是" + sellPrice
                + "。商品进价是" + buyPrice + "。商品库存量是" + count +
                "。销售一个的毛利润是" + (sellPrice - buyPrice));
    }

    /**
     * 计算利润
     *
     * @return
     */
    public double calculateProfit() {
        double profit = this.sellPrice - this.buyPrice;
        return profit;
    }

    /**
     * @param num2buy
     * @param customerV4
     * @return
     */
    public double BuyAction(int num2buy, CustomerV4 customerV4) {
        boolean MoneyCheck = CheckmoneyAction(num2buy, customerV4);
        if (!MoneyCheck) {
            return -1;
        } else {
            if (num2buy > count) {
                System.out.println("商品库存不够，交易取消！");
                return -2;
            } else {
                double totalCost = num2buy * sellPrice;
                return totalCost;
            }
        }
    }

    public boolean CheckmoneyAction(int num2buy, CustomerV4 customerV4) {
        if (num2buy * sellPrice > customerV4.money) {
            System.out.println("钱不够，交易取消。");
            return false;
        } else {
            return true;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double soldPrice) {
        this.sellPrice = soldPrice;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double BuyPrice) {
        this.buyPrice = BuyPrice;
    }

}
