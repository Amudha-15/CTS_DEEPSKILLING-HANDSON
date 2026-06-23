import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {
    static class Product {
        int productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String toString() { return productName + "(" + productId + ")"; }
    }

    // Linear search over an array
    public static int linearSearch(Product[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].productName.equalsIgnoreCase(name)) return i;
        }
        return -1;
    }

    // Binary search requires sorted array by productName
    public static int binarySearch(Product[] arr, String name) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = arr[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1; else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] list = new Product[] {
            new Product(1, "Camera", "Electronics"),
            new Product(2, "Alpha", "Books"),
            new Product(3, "Battery", "Accessories"),
        };

        // linear search
        System.out.println("Linear search for Battery: index=" + linearSearch(list, "Battery"));

        // prepare sorted array for binary search
        Arrays.sort(list, Comparator.comparing(p -> p.productName.toLowerCase()));
        System.out.println("Array sorted for binary search.");
        System.out.println("Binary search for Camera: index=" + binarySearch(list, "Camera"));
    }
}
