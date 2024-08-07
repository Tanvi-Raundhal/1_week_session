
import java.util.*;

class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}

class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(int id, String name, String email) {
        customers.add(new Customer(id, name, email));
        System.out.println("Customer added successfully.");
    }

    public void removeCustomer(int id) {
        customers.removeIf(customer -> customer.getId() == id);
        System.out.println("Customer removed successfully.");
    }

    public Customer searchCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        System.out.println("Customer not found.");
        return null;
    }

    public void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers to display.");
            return;
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void sortCustomersByName() {
        customers.sort(Comparator.comparing(Customer::getName));
        System.out.println("Customers sorted by name.");
    }

    public void sortCustomersById() {
        customers.sort(Comparator.comparingInt(Customer::getId));
        System.out.println("Customers sorted by ID.");
    }
}

public class Main {
    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        
        // Adding some customers
        manager.addCustomer(1, "Alice Smith", "alice@example.com");
        manager.addCustomer(2, "Bob Johnson", "bob@example.com");
        manager.addCustomer(3, "Charlie Brown", "charlie@example.com");

        // Listing all customers
        System.out.println("Listing all customers:");
        manager.listAllCustomers();
        
        // Sorting customers by name
        manager.sortCustomersByName();
        System.out.println("\nListing all customers sorted by name:");
        manager.listAllCustomers();
        
        // Sorting customers by ID
        manager.sortCustomersById();
        System.out.println("\nListing all customers sorted by ID:");
        manager.listAllCustomers();
        
        // Searching for a customer by ID
        System.out.println("\nSearching for customer with ID 2:");
        Customer customer = manager.searchCustomerById(2);
        if (customer != null) {
            System.out.println(customer);
        }
        
        // Removing a customer by ID
        manager.removeCustomer(2);
        System.out.println("\nListing all customers after removal:");
        manager.listAllCustomers();
    }
}
