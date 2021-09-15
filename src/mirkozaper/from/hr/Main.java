package mirkozaper.from.hr;

import mirkozaper.from.hr.dao.SqlHandler;
import mirkozaper.from.hr.model.Driver;
import mirkozaper.from.hr.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        try {
            List<Vehicle> vehicles = importVehiclesFromCSV();
            SqlHandler.insertVehicles(vehicles,1000);
            List<Driver> drivers = importDriversFromCSV();
            SqlHandler.insertDrivers(drivers,1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Vehicle> importVehiclesFromCSV() throws IOException {
        List<Vehicle> list=new ArrayList<>();

        File csvFile = new File("Vehicle.csv");
        if (!csvFile.isFile())
        {
            System.err.println("File does not exist!");
            return list;
        }

        BufferedReader csvReader = new BufferedReader(new FileReader(csvFile));
        String row;
        csvReader.readLine(); //skip 1. line
        while ((row = csvReader.readLine()) != null) {
            String[] v = row.split(",");
            list.add(new Vehicle(v[1], v[2],Integer.parseInt(v[3]),Integer.parseInt(v[4])));
        }
        csvReader.close();

        return list;
    }

    private static List<Driver> importDriversFromCSV() throws IOException {
        List<Driver> list=new ArrayList<>();

        File csvFile = new File("Driver.csv");
        if (!csvFile.isFile())
        {
            System.err.println("File does not exist!");
            return list;
        }

        BufferedReader csvReader = new BufferedReader(new FileReader(csvFile));
        String row;
        csvReader.readLine(); //skip 1. line
        while ((row = csvReader.readLine()) != null) {
            String[] d = row.split(",");
            list.add(new Driver(d[1], d[2], d[3], d[4]));
        }
        csvReader.close();

        return list;
    }
}
