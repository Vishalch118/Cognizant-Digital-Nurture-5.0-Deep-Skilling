public class ProxyPatternTest {

    public static void main(String[] args) {

        Image image = new ProxyImage("nature.png");

        System.out.println("First Display:");
        image.display();

        System.out.println();

        System.out.println("Second Display:");
        image.display();
    }
}