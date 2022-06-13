package Week2.V1V2;
/**
 * 使用了方法,this
 */

import java.util.Scanner;

public class ASmallSupermarketV2 {
    public static void main(String[] args) {
        //创建超市实例并初始化
        SupermarketTem supermarket = new SupermarketTem();
        supermarket.supermarketname = "黑店";
        supermarket.SupermarketAddress = "纽约市人民大道886号";
        supermarket.merchandise = new Merchandise[2000];
        supermarket.SupermarketParkings = 100;
        supermarket.MerchandiseisSold = new int[supermarket.merchandise.length];
        //创建商品实例并初始化
        Merchandise[] allMerchandise = supermarket.merchandise;
        for (int i = 0; i < supermarket.merchandise.length; i++) {
            Merchandise m = new Merchandise();
            m.buyPrice = Math.random() * 100;
            m.sellPrice = m.buyPrice + 250 * (Math.random());
            m.id = "ID=" + i;
            m.count = 100;
            allMerchandise[i] = m;
        }
        //开始营业
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始营业！");
        int customerCount = 0;//统计顾客人数
        boolean open = true;//决定超市是否开门
        while (open) {
            supermarket.describe();
            //顾客来了
            Customer customer = new Customer();
            customer.driveCar = Math.random() > 0.5;
            customer.money = (Math.random() + 1) * 1000000;
            customer.name = "顾客编号：" + customerCount;
            customerCount += 1;
            customer.describe();
            //判断是否有停车位
            if (customer.driveCar == true && supermarket.SupermarketParkings == 0) {
                System.out.println("今日停车位已经满了，欢迎下次光临。");
                continue;
            } else if (customer.driveCar == true && supermarket.SupermarketParkings > 0) {
                System.out.println("欢迎" + customer.name + "入店！\n" + "本店停车50元！");
                supermarket.SupermarketParkings -= 1;
                customer.money -= 50;
                System.out.println("顾客还剩余：" + customer.money + "元");
            } else {
                System.out.println("欢迎" + customer.name + "入店！");
                System.out.println("------------------------------------");
            }
            //开始购物
            while (true) {
                System.out.println("请输入商品编号（从0-" + (supermarket.merchandise.length - 1) + "）:");
                int index = scanner.nextInt();
                if (index < -1 || index > supermarket.merchandise.length - 1) {
                    System.out.println("请输入正确范围内的商品编号：");
                    continue;
                } else {
                    System.out.println("请输入你要购买的数量：");
                    int num2buy = scanner.nextInt();
                    customer.CustomerBuy(num2buy, customer, allMerchandise[index]);
                }
            }
        }
    }
}



