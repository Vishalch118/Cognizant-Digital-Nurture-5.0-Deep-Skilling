public class Main {

    // Linear Search
    static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search
    static Book binarySearch(Book[] books, String title) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int result =
                    books[mid].title.compareToIgnoreCase(title);

            if (result == 0)
                return books[mid];

            else if (result < 0)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        // Sorted by title
        Book[] books = {
                new Book(101, "C Programming", "Dennis"),
                new Book(102, "Java", "James Gosling"),
                new Book(103, "Python", "Guido")
        };

        String searchTitle = "Java";

        Book b1 = linearSearch(books, searchTitle);

        System.out.println("Linear Search:");
        if (b1 != null)
            b1.display();

        Book b2 = binarySearch(books, searchTitle);

        System.out.println("\nBinary Search:");
        if (b2 != null)
            b2.display();
    }
}