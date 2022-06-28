package Week4.MySupermarket.Impl;

import Week4.MySupermarket.Interfaces.*;

import static Week4.MySupermarket.Util.ShoppingUtil.output;

public class AShopman implements Shopman {
    private static final int MAX_BUY_DEFAULT = 9;
    private Supermarket supermarket;

    public AShopman(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    @Override
    public void serveCustomer(Customer customer) {
        int maxTypeToBuy = MAX_BUY_DEFAULT;
        if (customer instanceof AbsCustomer) {
            maxTypeToBuy = ((AbsCustomer) customer).getGuangCount();
        }
        AShoppingCart shoppingCart = new AShoppingCart(maxTypeToBuy);
        customer.startShopping();

        while ((!customer.wantToCheckout()) && shoppingCart.canHold()) {
            Category category = customer.chooseCategory();
            // 简单的导购员，顾客说不想买就算了，不做推荐
            if (category == null) {
                continue;
            }
            Merchandise[] toChoose = supermarket.getRandomMerchandiseOfCategory(category);
            // 简单的导购员，一个个推荐，不说从价格高到低推荐之类的小技巧。
            for (Merchandise m : toChoose) {
                if (m == null) {
                    continue;
                }
                int buyCount = customer.buyMerchandise(m);
                if (buyCount > 0) {
                    // 一个类别只买一个商品
                    shoppingCart.add(m, buyCount);
                    break;
                }
            }
        }
        double originCost = shoppingCart.calculateOriginCost();
        double finalCost = originCost;

        double savedMoney = 0;
        if (customer instanceof HasCard) {
            Card card = ((HasCard) customer).getCard();
            savedMoney = card.processCardDiscount(originCost, finalCost, customer, shoppingCart);
            finalCost -= savedMoney;
        }

        double moneyEarned = customer.payFor(shoppingCart, finalCost);

        supermarket.addEarnedMoney(moneyEarned);

        output("顾客" + customer.getCustId() + "购物清单如下：");
        output(shoppingCart.toString());
        output("优惠金额为：" + savedMoney);
        output("实付金额为：" + moneyEarned);


        // >> TODO 思考题：上面的代码是否太过复杂了？如果有别的类型的shopmain，是否有代码可以重用？有的话应该怎么办？
    }
}
