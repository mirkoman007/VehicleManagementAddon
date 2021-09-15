package mirkozaper.from.hr.model;

public class Vehicle {
    private int idVehicle;
    private String make;
    private String vehicleType;
    private int firstRegistration;
    private int mileage;

    public String getMake() {
        return make;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getFirstRegistration() {
        return firstRegistration;
    }

    public int getMileage() {
        return mileage;
    }

    public Vehicle(String make, String vehicleType, int firstRegistration, int mileage) {
        this.make = make;
        this.vehicleType = vehicleType;
        this.firstRegistration = firstRegistration;
        this.mileage = mileage;
    }
}
