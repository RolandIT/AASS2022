package sk.fiit.models;

public class RegisterCar {
    private String spz;
    private int yearOfManufacture;
    private String brand;
    private long idOwner;

    public RegisterCar(){

    }
    public RegisterCar(String spz, int yearOfManufacture, String brand, long idOwner) {
        this.spz = spz;
        this.yearOfManufacture = yearOfManufacture;
        this.brand = brand;
        this.idOwner = idOwner;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(long idOwner) {
        this.idOwner = idOwner;
    }
}
