public class Product {
    private String productId;
    private String name;
    private double price;
    private int stock;

    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }


    public void reduceStock(int amount) {
        this.stock -= amount;
    }

    public void increaseStock(int amount) {
        this.stock += amount;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: " + price + ", Stock: " + stock);
    }
}
