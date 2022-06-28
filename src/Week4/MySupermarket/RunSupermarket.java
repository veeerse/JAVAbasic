package Week4.MySupermarket;

import Week4.MySupermarket.Impl.AShopman;
import Week4.MySupermarket.Interfaces.Customer;
import Week4.MySupermarket.Interfaces.Shopman;
import Week4.MySupermarket.Interfaces.Supermarket;

import static Week4.MySupermarket.Util.ShoppingUtil.*;

public class RunSupermarket {
    public static void main(String[] args) {
        Supermarket supermarket = createSuperMarket();

        Shopman shopman = new AShopman(supermarket);

        boolean open = true;
        while (open) {
            new ShoppingTask(shopman).executeTask();
            output("是否继续营业？(Yes)");
            open = !input().next().trim().equalsIgnoreCase("no");
        }

        supermarket.dailyReport();

    }
}
    class ShoppingTask {

        private Shopman shopman;

        public ShoppingTask(Shopman shopman) {
            this.shopman = shopman;
        }

        public void executeTask() {
            Customer customer = createCustomer(true);

            shopman.serveCustomer(customer);

        }
}

