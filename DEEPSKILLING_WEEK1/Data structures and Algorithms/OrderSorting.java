import java.util.Arrays;

public class OrderSorting {
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public String toString() { return String.format("%d:%s=%.2f", orderId, customerName, totalPrice); }
    }

    // Bubble sort by totalPrice ascending
    public static void bubbleSort(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].totalPrice > arr[j+1].totalPrice) {
                    Order tmp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = tmp;
                }
            }
        }
    }

    // Quick sort by totalPrice
    public static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice <= pivot) {
                i++; Order tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
        Order tmp = arr[i+1]; arr[i+1] = arr[high]; arr[high] = tmp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = new Order[] {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 50.0),
            new Order(3, "Carol", 125.0)
        };

        Order[] copy = Arrays.copyOf(orders, orders.length);
        bubbleSort(copy);
        System.out.println("Bubble sorted: " + Arrays.toString(copy));

        copy = Arrays.copyOf(orders, orders.length);
        quickSort(copy, 0, copy.length - 1);
        System.out.println("Quick sorted: " + Arrays.toString(copy));
    }
}
