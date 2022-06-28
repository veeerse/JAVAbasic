package Week4.MySupermarket.Interfaces;

public interface Supermarket {
    Merchandise[] getAllMerchandise();

    Merchandise[] getRandomMerchandiseOfCategory(Category category);

    void addEarnedMoney(double earnedMoney);

    void dailyReport();
}
