import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public String toString() {
            return String.format("Product{id=%d, name=%s, qty=%d, price=%.2f}", productId, productName, quantity, price);
        }
    }

    static class Inventory {
        private final Map<Integer, Product> products = new HashMap<>();

        public void addProduct(Product p) {
            products.put(p.productId, p);
        }

        public boolean updateProduct(int productId, String name, Integer qty, Double price) {
            Product p = products.get(productId);
            if (p == null) return false;
            if (name != null) p.productName = name;
            if (qty != null) p.quantity = qty;
            if (price != null) p.price = price;
            return true;
        }

        public boolean deleteProduct(int productId) {
            return products.remove(productId) != null;
        }

        public Product getProduct(int productId) {
            return products.get(productId);
        }
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Product p1 = new Product(1, "Widget", 100, 2.5);
        Product p2 = new Product(2, "Gadget", 50, 5.0);

        inv.addProduct(p1);
        inv.addProduct(p2);

        System.out.println("Initial: " + inv.getProduct(1));
        inv.updateProduct(1, null, 90, null);
        System.out.println("After update: " + inv.getProduct(1));
        inv.deleteProduct(2);
        System.out.println("Product 2 exists? " + (inv.getProduct(2) != null));
    }
}
