package mirkozaper.from.hr.dao;

import mirkozaper.from.hr.model.Driver;
import mirkozaper.from.hr.model.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SqlHandler {
    private static final String INSERT_DRIVERS = "INSERT INTO Driver (FirstName,LastName,MobileNumber,DriverLicenseNumber) VALUES (?, ?, ?, ?)";
    private static final String INSERT_VEHICLES = "INSERT INTO Vehicle (Make,VehicleType,FirstRegistration,Mileage) VALUES (?, ?, ?, ?)";


    public static void insertVehicles(List<Vehicle> vehicles, int chunkSize) {
        DataSource dataSource=DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
            PreparedStatement stmt=con.prepareStatement(INSERT_VEHICLES)) {

            int counter = 0;
            for (Vehicle vehicle : vehicles) {
                stmt.setString(1, vehicle.getMake());
                stmt.setString(2, vehicle.getVehicleType());
                stmt.setInt(3, vehicle.getFirstRegistration());
                stmt.setInt(4, vehicle.getMileage());
                stmt.addBatch();
                if (++counter == chunkSize) {
                    stmt.executeBatch();
                    System.out.println("checkpoint: " + counter);
                    counter = 0;
                }
            }
            if (counter > 0) {
                stmt.executeBatch();
                System.out.println("checkpoint: " + counter);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insertDrivers(List<Driver> drivers, int chunkSize) {
        DataSource dataSource=DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
            PreparedStatement stmt=con.prepareStatement(INSERT_DRIVERS)) {

            int counter = 0;
            for (Driver driver : drivers) {
                stmt.setString(1, driver.getFirstName());
                stmt.setString(2, driver.getLastName());
                stmt.setString(3, driver.getMobileNumber());
                stmt.setString(4, driver.getDriverLicenseNumber());
                stmt.addBatch();
                if (++counter == chunkSize) {
                    stmt.executeBatch();
                    System.out.println("checkpoint: " + counter);
                    counter = 0;
                }
            }
            if (counter > 0) {
                stmt.executeBatch();
                System.out.println("checkpoint: " + counter);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
