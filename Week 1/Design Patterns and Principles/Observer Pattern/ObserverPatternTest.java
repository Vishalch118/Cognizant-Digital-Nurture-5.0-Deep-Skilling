public class ObserverPatternTest {

    public static void main(String[] args) {

        StockMarket stock = new StockMarket("TCS");

        Observer mobileUser = new MobileApp("Vishal");
        Observer webUser = new WebApp("Rahul");

        stock.registerObserver(mobileUser);
        stock.registerObserver(webUser);

        System.out.println("Price changed to 3500");
        stock.setPrice(3500);

        System.out.println("\nPrice changed to 3600");
        stock.setPrice(3600);

        stock.deregisterObserver(webUser);

        System.out.println("\nPrice changed to 3700");
        stock.setPrice(3700);
    }
}