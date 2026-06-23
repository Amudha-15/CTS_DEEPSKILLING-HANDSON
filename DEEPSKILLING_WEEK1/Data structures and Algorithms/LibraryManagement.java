import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagement {
    static class Book {
        int bookId;
        String title;
        String author;

        Book(int bookId, String title, String author) { this.bookId = bookId; this.title = title; this.author = author; }
        public String toString() { return String.format("%d:%s by %s", bookId, title, author); }
    }

    public static int linearSearch(Book[] arr, String title) {
        for (int i = 0; i < arr.length; i++) if (arr[i].title.equalsIgnoreCase(title)) return i;
        return -1;
    }

    public static int binarySearch(Book[] arr, String title) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = arr[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1; else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Book[] books = new Book[] {
            new Book(1, "Algorithms", "Cormen"),
            new Book(2, "Data Structures", "Weiss"),
            new Book(3, "Java Basics", "Author")
        };

        System.out.println("Linear search for Java Basics: " + linearSearch(books, "Java Basics"));
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
        System.out.println("Binary search for Algorithms: " + binarySearch(books, "Algorithms"));
    }
}
