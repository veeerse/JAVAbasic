package Week4.MySupermarket.Impl;

import Week4.MySupermarket.Interfaces.Card;
import Week4.MySupermarket.Interfaces.Customer;
import Week4.MySupermarket.Interfaces.ShoppingCart;

public class CashCard implements Card {
    private double point;

    public CashCard(double point) {
        this.point = point;
    }

    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount, Customer customer, ShoppingCart shoppingCart) {
        // 如果折扣下来剩下的钱比点数少，那么就抵扣掉需要付的剩下的钱
        if (totalCostAfterDiscount < point) {
            point -= totalCostAfterDiscount;
            return point;
        } else {
            // 否则就抵扣掉所有的点
            point = 0;
            return point;
        }
    }
}
