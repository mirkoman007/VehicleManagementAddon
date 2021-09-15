package mirkozaper.from.hr;

import mirkozaper.from.hr.dao.SqlHandler;
import mirkozaper.from.hr.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	
        List<Driver> drivers=importDriversFromCSV();
        SqlHandler.insertDrivers(drivers,1000);
    }

    private static List<Driver> importDriversFromCSV() {
        List<Driver> list=new ArrayList<>();
        list.add(new Driver("Josip","Mandac","+385956788333","54785632"));
        return list;
    }
}
