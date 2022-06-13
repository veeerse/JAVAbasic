package Week2.V3;

public class MerchandiseV3 {
    public String id;
    public int count;
    public double buyPrice;
    public double sellPrice;

    public MerchandiseV3(String id, int count, double buyPrice, double sellPrice) {
        this.id = id;
        this.count = count;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public MerchandiseV3() {
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
     * @param num2buy
     * @param customerV3
     * @return
     */
    public double BuyAction(int num2buy, CustomerV3 customerV3) {
        boolean MoneyCheck = CheckmoneyAction(num2buy, customerV3);
        if (!MoneyCheck) {
            return -1;
        } else {
            if (num2buy > count) {
                System.out.println("商品库存不够，交易取消！");
                return -1;
            } else {
                describe();
                double totalCost = num2buy * sellPrice;
                System.out.println("帮顾客打包了：" + num2buy + "件" + "商品：" + id + "。总价是：" + totalCost);
                count -= num2buy;
                return totalCost;
            }
        }
    }

    public boolean CheckmoneyAction(int num2buy, CustomerV3 customerV3) {
        if (num2buy * sellPrice > customerV3.money) {
            System.out.println("钱不够，交易取消。");
            return false;
        } else {
            return true;
        }
    }

}
