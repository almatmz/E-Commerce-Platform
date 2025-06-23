import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<Product> managedProducts;

    public Admin(int id, String name, String email) {
        super(id, name, email);
        this.managedProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        managedProducts.add(product);
    }

    public void removeProduct(String productId) {
        managedProducts.removeIf(p -> p.getProductId().equals(productId));
        System.out.println("Product removed if it existed.");
    }

    public void updateStock(String productId, int newStock) {
        for (Product p : managedProducts) {
            if (p.getProductId().equals(productId)) {
                p.setStock(newStock);
                System.out.println("Stock updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void viewStockByProductId(String productId) {
        for (Product p : managedProducts) {
            if (p.getProductId().equals(productId)) {
                System.out.println("Stock for product " + productId + ": " + p.getStock());
                return;
            }
        }
        System.out.println("Product not found.");
    }
}
