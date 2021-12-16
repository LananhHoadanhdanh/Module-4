package management.model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    public static int count = 1;

    public Customer() {
        this.id = Customer.count;
    }

    public Customer(String name, String email, String address) {
        this.id = Customer.count;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
