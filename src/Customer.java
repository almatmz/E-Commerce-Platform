import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String shippingAddress;
    private List<Order> orders;

    public Customer(int id, String name, String email, String shippingAddress) {
        super(id, name, email);
        this.shippingAddress = shippingAddress;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Product product, int quantity, String paymentMethod) {
        if (product.getStock() < quantity) {
            System.out.println("Insufficient stock.");
            return;
        }
        product.setStock(product.getStock() - quantity);
        Order order = new Order(product, quantity, this, paymentMethod);
        orders.add(order);
        System.out.println("Order placed.");
    }

    public void cancelOrder(Order order) {
        if (orders.contains(order)) {
            Product product = order.getProduct();  // FIXED: Retrieve product from order
            product.setStock(product.getStock() + order.getQuantity());
            orders.remove(order);
            System.out.println("Order cancelled.");
        } else {
            System.out.println("Order not found.");
        }
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Shipping Address: " + shippingAddress);
    }
}
