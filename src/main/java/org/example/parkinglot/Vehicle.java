package org.example.parkinglot;

public class Vehicle {
    private String type;
    private String vehicleNo;
    private String color;

    public Vehicle(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
