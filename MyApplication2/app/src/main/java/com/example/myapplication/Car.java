package com.example.myapplication;

public class Car {

    private String model;
    private int maxSpeed;
    private double engineValue;

    public Car(String model, int maxSpeed, double engineValue) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.engineValue = engineValue;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getEngineValue() {
        return engineValue;
    }

    public void setEngineValue(double engineValue) {
        this.engineValue = engineValue;
    }
}
