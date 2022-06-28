package Week4.MySupermarket.Interfaces;

public interface ShoppingCart {

    boolean canHold();

    boolean add(Merchandise m, int countToBuy);

    double calculateOriginCost();

    String toString();

}