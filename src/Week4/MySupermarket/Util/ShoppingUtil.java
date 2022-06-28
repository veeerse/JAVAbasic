package Week4.MySupermarket.Util;

import Week4.MySupermarket.Impl.*;
import Week4.MySupermarket.Interfaces.Category;
import Week4.MySupermarket.Interfaces.Customer;
import Week4.MySupermarket.Interfaces.Merchandise;
import Week4.MySupermarket.Interfaces.Supermarket;

import java.util.Scanner;

public class ShoppingUtil {
    private static final Scanner in = new Scanner(System.in);

    public static Scanner input() {
        return in;
    }

    public static void output(Object o) {
        System.out.println(String.valueOf(o));
    }

    public static Category getRandomCategory() {
        return Category.values()[(int) (Math.random() * 1000) % Category.values().length];
    }

    public static Supermarket createSuperMarket() {
        int merchandisePerCategory = 10;
        Merchandise[] all = new Merchandise[Category.values().length * merchandisePerCategory];

        for (Category category : Category.values()) {
            for (int i = 0; i < merchandisePerCategory; i++) {

                double soldPrice = Math.random() * (category.getHigherPrice() - category.getLowerPrice())
                        + category.getLowerPrice();

                double purchasePrice = soldPrice * 0.7;

                all[category.ordinal() * merchandisePerCategory + i] = new SimpleMerchandise(
                        category.name() + i, soldPrice, purchasePrice, 200, category
                );
            }
        }

        ASupermarket superMarket = new ASupermarket(all);
        output("请输入超市的名字：");
        String s = input().next();
        if (s.trim().length() > 0) {
            superMarket.setName(s.trim());
        }
        return superMarket;
    }
    public static Customer createCustomer(boolean auto) {
        if (auto) {
            String custId = "CUST" + (int) (Math.random() * 10000);
            Category shouldBuy = getRandomCategory();
            if (Math.random() < 0.5) {
                return new ACustomer(custId, shouldBuy);
            } else {
                ThinkAndBuyCustomer ret = new ThinkAndBuyCustomer(custId, shouldBuy);
                ret.setCard(getRandomVIPCard());
                return ret;
            }
        }
        return null;
    }
    public static VIPCard getRandomVIPCard() {
        return VIPCard.values()[(int) (Math.random() * 1000) % VIPCard.values().length];
    }
}
