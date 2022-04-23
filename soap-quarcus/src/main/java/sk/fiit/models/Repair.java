package sk.fiit.models;

public class Repair {
    private long id;
    private String description;
    private int state;
    private double cost;
    private long idCar;

    public Repair(long id, String description, int state, double cost, long idCar) {
        this.id = id;
        this.description = description;
        this.state = state;
        this.cost = cost;
        this.idCar = idCar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }
}
