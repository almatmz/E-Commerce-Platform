public class User {
    protected int id;
    protected String name;
    protected String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
