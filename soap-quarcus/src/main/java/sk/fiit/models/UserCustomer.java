package sk.fiit.models;

public class UserCustomer {
    User user;
    Customer customer;
    boolean isCustomer;

    public UserCustomer(User user, Customer customer, boolean isCustomer) {
        this.user = user;
        this.customer = customer;
        this.isCustomer = isCustomer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }
}
