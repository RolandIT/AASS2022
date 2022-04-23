package sk.fiit.models;

public class RegisterForm {
    private String name;
    private String surname;
    private String phoneNumber;
    private String opNumber;
    private String username;
    private String password;
    private int type;

    public RegisterForm() {
        this.name = "name";
        this.surname = "surname";
        this.phoneNumber = "phoneNumber";
        this.opNumber = "opNumber";
        this.username = "username";
        this.password = "password";
        this.type = -1;
    }

    public RegisterForm(String name, String surname, String phoneNumber, String opNumber, String username, String password, int type) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.opNumber = opNumber;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public RegisterForm(String name, String surname, String phoneNumber, String opNumber, String username, int type) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.opNumber = opNumber;
        this.username = username;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOpNumber() {
        return opNumber;
    }

    public void setOpNumber(String opNumber) {
        this.opNumber = opNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
