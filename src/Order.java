public class Order {
    private Product product;
    private int quantity;
    private Customer customer;
    private String paymentMethod;

    public Order(Product product, int quantity, Customer customer, String paymentMethod) {
        this.product = product;
        this.quantity = quantity;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void displayOrderDetails() {
        System.out.println("Order - Product: " + product.getProductId() + ", Quantity: " + quantity + ", Payment: " + paymentMethod);
    }
}
