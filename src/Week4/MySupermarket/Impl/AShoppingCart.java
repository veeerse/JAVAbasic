package Week4.MySupermarket.Impl;

import Week4.MySupermarket.Interfaces.Merchandise;
import Week4.MySupermarket.Interfaces.ShoppingCart;

import java.util.Date;

public class AShoppingCart implements ShoppingCart {
    private Merchandise[] buy;
    private int[] count;
    private int curr;
    private int max;


    public AShoppingCart(int maxTypeToBuy) {
        this.buy = new Merchandise[maxTypeToBuy];
        this.count = new int[maxTypeToBuy];
        this.max = maxTypeToBuy;
        this.curr = 0;
    }

    @Override
    public boolean canHold() {
        return curr < max;
    }

    @Override
    public boolean add(Merchandise m, int countToBuy) {
        if (!canHold()) {
            return false;
        }
        buy[curr] = m;
        this.count[curr] = countToBuy;
        curr++;
        m.buy(countToBuy);
        return true;
    }

    @Override
    public double calculateOriginCost() {
        double ret = 0;
        int pos = -1;
        for (Merchandise m : buy) {
            pos++;
            if (m == null) {
                continue;
            }
            ret += m.getPurchasePrice() * count[pos];
        }
        return ret;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=========================\n");
        sb.append("购物时间：").append(new Date()).append("\n");
        int pos = -1;
        for (Merchandise m : buy) {
            pos++;
            if (m == null) {
                continue;
            }
            sb.append(m.getCategory().name()).append("\t").append(m.getName()).append("\t")
                    .append(count[pos]).append("\t").append(m.getPurchasePrice() * count[pos]).append("\n");

        }
        sb.append("应付总额为：").append(calculateOriginCost()).append("\n");
        sb.append("=========================");
        return sb.toString();
    }
}
