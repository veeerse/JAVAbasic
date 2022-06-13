package Week2.V1V2;
/**没有使用方法！！！！
 *
 */

import Week2.V1V2.Customer;
import Week2.V1V2.Merchandise;
import Week2.V1V2.SupermarketTem;

import java.util.Scanner;

public class ASmallSupermarket {
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
            m.sellPrice = m.buyPrice + 100;
            m.id = "ID=" + i;
            m.count = 100;
            allMerchandise[i] = m;
        }
        //开始营业
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始营业！");
        int customerCount = 0;
        boolean open = true;
        while (open) {
            System.out.println("本店叫:" + supermarket.supermarketname + "\n本店地址位于：" + supermarket.SupermarketAddress + "\n本店拥有商品：" + supermarket.merchandise.length + "件\n本店拥有车位：" + supermarket.SupermarketParkings + "个");
            //顾客来了
            Customer customer = new Customer();
            customer.driveCar = Math.random() > 0.5;
            customer.money = (Math.random() + 1) * 100000;
            customer.name = "顾客：" + customerCount;
            customerCount += 1;
            //判断是否有停车位
            if (customer.driveCar == true && supermarket.SupermarketParkings == 0) {
                System.out.println("今日停车位已经满了，欢迎下次光临。");
                continue;
            } else if (customer.driveCar == true && supermarket.SupermarketParkings > 0) {
                System.out.println("欢迎" + customer.name + "入店！\n" + "本店停车50元！");
                supermarket.SupermarketParkings -= 1;
                customer.money -= 50;
            } else {
                System.out.println("欢迎" + customer.name + "入店！\n");
            }
            //开始购物
            double totalCost = 0;
            while (true) {
                System.out.println("请输入商品编号（从0-" + (supermarket.merchandise.length - 1) + "）:");
                int index = scanner.nextInt();
                if (index < 0 || index > supermarket.merchandise.length - 1) {
                    System.out.println("请输入正确范围内的商品编号：");
                    continue;
                } else {
                    System.out.println("请输入你要购买的数量：");
                    System.out.println(allMerchandise[index].id+"的价格为："+allMerchandise[index].sellPrice+"，还剩余："+allMerchandise[index].count+"件商品。");
                    System.out.println("你有："+customer.money+"元。");
                    int num2buy = scanner.nextInt();
                    if (num2buy > allMerchandise[index].count && customer.money >= allMerchandise[index].count * allMerchandise[index].sellPrice) {
                        customer.money -= num2buy * allMerchandise[index].sellPrice;
                        allMerchandise[index].describe();
                        System.out.println(allMerchandise[index].id + "还剩下：" + allMerchandise[index].count + "件，全部帮你打包。");
                        System.out.println("你还剩：" + customer.money);
                        num2buy = allMerchandise[index].count;
                        allMerchandise[index].count = 0;
                    } else if (customer.money < num2buy * allMerchandise[index].sellPrice) {
                        System.out.println("你钱不够，看看别的吧。");
                        continue;
                    } else {
                        customer.money -= num2buy * allMerchandise[index].sellPrice;
                        allMerchandise[index].describe();
                        System.out.println("帮你打包了：" + num2buy + "件" + allMerchandise[index].id);
                        System.out.println("你还剩：" + customer.money);
                        allMerchandise[index].count -= num2buy;
                    }
                }
            }
        }
    }
}

