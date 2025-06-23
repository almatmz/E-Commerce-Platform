import java.util.*;

public class Main {
    private static List<Admin> admins = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeData();

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Admin");
            System.out.println("2. Add Customer");
            System.out.println("3. Add Product");
            System.out.println("4. Display Admins");
            System.out.println("5. Display Customers");
            System.out.println("6. Display Products");
            System.out.println("7. Admin - Remove Product");
            System.out.println("8. Admin - Update Stock");
            System.out.println("9. Admin - Check Stock by Product ID");
            System.out.println("10. Customer - Place Order");
            System.out.println("11. Customer - Cancel Last Order");
            System.out.println("12. Customer - View Orders");
            System.out.println("13. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAdmin();
                case 2 -> addCustomer();
                case 3 -> addProduct();
                case 4 -> displayAdmins();
                case 5 -> displayCustomers();
                case 6 -> displayProducts();
                case 7 -> adminRemoveProduct();
                case 8 -> adminUpdateStock();
                case 9 -> checkStockByProductId();
                case 10 -> customerPlaceOrder();
                case 11 -> customerCancelOrder();
                case 12 -> customerViewOrders();
                case 13 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void initializeData() {
        Admin a1 = new Admin(1, "Almat", "almmuzdubai@gmail.com");
        Admin a2 = new Admin(2, "Ronaldo", "cr7@goat.com");
        admins.add(a1);
        admins.add(a2);

        Customer c1 = new Customer(1, "Mbappe", "km10@gmail.com", "Astana");
        Customer c2 = new Customer(2, "Vini", "vini7@mail.ru", "Karaganda");
        customers.add(c1);
        customers.add(c2);

        Product p1 = new Product("P001", "Laptop", 1200.0, 10);
        Product p2 = new Product("P002", "Phone", 800.0, 15);
        Product p3 = new Product("P003", "Tablet", 500.0, 8);
        products.addAll(Arrays.asList(p1, p2, p3));

        a1.addProduct(p1);
        a1.addProduct(p2);
        a2.addProduct(p3);
    }

    private static void addAdmin() {
        System.out.print("Enter Admin ID, Name, Email: ");
        Admin admin = new Admin(scanner.nextInt(), scanner.next(), scanner.next());
        admins.add(admin);
        System.out.println("Admin added.");
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID, Name, Email, Shipping Address: ");
        Customer customer = new Customer(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next());
        customers.add(customer);
        System.out.println("Customer added.");
    }

    private static void addProduct() {
        System.out.print("Enter Product ID, Name, Price, Stock: ");
        Product product = new Product(scanner.next(), scanner.next(), scanner.nextDouble(), scanner.nextInt());
        products.add(product);
        System.out.println("Product added.");
    }

    private static void displayAdmins() {
        for (Admin admin : admins) admin.displayDetails();
    }

    private static void displayCustomers() {
        for (Customer customer : customers) customer.displayDetails();
    }

    private static void displayProducts() {
        for (Product product : products) product.displayDetails();
    }

    private static void adminRemoveProduct() {
        System.out.print("Enter Admin email: ");
        Admin admin = findAdminByEmail(scanner.next());
        if (admin != null) {
            System.out.print("Enter Product ID to remove: ");
            admin.removeProduct(scanner.next());
        }
    }

    private static void adminUpdateStock() {
        System.out.print("Enter Admin email: ");
        Admin admin = findAdminByEmail(scanner.next());
        if (admin != null) {
            System.out.print("Enter Product ID and new stock: ");
            admin.updateStock(scanner.next(), scanner.nextInt());
        }
    }

    private static void checkStockByProductId() {
        System.out.print("Enter Product ID to check stock: ");
        String id = scanner.next();
        Product product = findProductById(id);
        if (product != null) {
            System.out.println("Stock for " + product.getName() + ": " + product.getStock());
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void customerPlaceOrder() {
        System.out.print("Enter Customer email: ");
        Customer customer = findCustomerByEmail(scanner.next());
        if (customer != null) {
            System.out.print("Enter Product ID and Quantity: ");
            String pid = scanner.next();
            int qty = scanner.nextInt();
            Product product = findProductById(pid);
            if (product != null && product.getStock() >= qty) {
                System.out.print("Enter payment method (CreditCard or PayPal): ");
                String method = scanner.next();
                Payment payment = method.equalsIgnoreCase("PayPal") ?
                        new PayPalPayment(customer.getEmail()) :
                        new CreditCardPayment("0000-1111-2222-3333", customer.getName());
                payment.processPayment(product.getPrice() * qty);
                customer.placeOrder(product, qty, method);
            } else {
                System.out.println("Not enough stock or product not found.");
            }
        }
    }

    private static void customerCancelOrder() {
        System.out.print("Enter Customer email: ");
        Customer customer = findCustomerByEmail(scanner.next());
        if (customer != null && !customer.getOrders().isEmpty()) {
            Order lastOrder = customer.getOrders().get(customer.getOrders().size() - 1);
            customer.cancelOrder(lastOrder);
        } else {
            System.out.println("No orders found.");
        }
    }

    private static void customerViewOrders() {
        System.out.print("Enter Customer email: ");
        Customer customer = findCustomerByEmail(scanner.next());
        if (customer != null && !customer.getOrders().isEmpty()) {
            for (Order order : customer.getOrders()) order.displayOrderDetails();
        } else {
            System.out.println("No orders found.");
        }
    }

    private static Admin findAdminByEmail(String email) {
        return admins.stream().filter(a -> a.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    private static Customer findCustomerByEmail(String email) {
        return customers.stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    private static Product findProductById(String id) {
        return products.stream().filter(p -> p.getProductId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}
