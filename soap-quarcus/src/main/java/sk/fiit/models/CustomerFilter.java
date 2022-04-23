package sk.fiit.models;

public class CustomerFilter {
    private String surname;

    public CustomerFilter(String surname) {
        this.surname = surname;
    }

    public CustomerFilter() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
