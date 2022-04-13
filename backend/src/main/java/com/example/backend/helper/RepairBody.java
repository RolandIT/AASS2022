package com.example.backend.helper;


public class RepairBody {
    private String description;
    private int state;
    private double cost;
    private long idCar;

    public RepairBody(String description, int state, double cost, long idCar) {
        this.description = description;
        this.state = state;
        this.cost = cost;
        this.idCar = idCar;
    }

    public RepairBody() {
        this.description = "Test desc";
        this.state = 1;
        this.cost = 420.69;
        this.idCar = 6;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getIdCar() {
        return this.idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }
}
