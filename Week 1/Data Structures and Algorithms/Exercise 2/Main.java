public class Main {

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Electronics"),
                new Product(103, "Keyboard", "Electronics"),
                new Product(104, "Monitor", "Electronics"),
                new Product(105, "Printer", "Electronics")
        };

        int targetId = 104;

        // Linear Search
        Product result1 =
                SearchOperations.linearSearch(products, targetId);

        System.out.println("Linear Search Result:");
        System.out.println(result1);

        // Binary Search
        Product result2 =
                SearchOperations.binarySearch(products, targetId);

        System.out.println("\nBinary Search Result:");
        System.out.println(result2);
    }
}