package mirkozaper.from.hr.model;

public class Driver {

    private int idDriver;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String driverLicenseNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public Driver(String firstName, String lastName, String mobileNumber, String driverLicenseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.driverLicenseNumber = driverLicenseNumber;
    }
}
