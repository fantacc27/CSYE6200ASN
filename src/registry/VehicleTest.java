/**
 *
 * /*NUID:01664997 */
package edu.neu.csye6200.registry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Xiao Tan
 *
 */
public class VehicleTest {

    private VehicleTaxation vehTaxation;

    /**
     * Test Program Constructor
     */
    public VehicleTest() {
        ; // Create a vehicle taxation class

    }

    /**
     * The main run routine that executes our testing operations
     */
    public void run() {

        // Make three sample vehicles
        Vehicle c0 = new Vehicle("j.smith", 2016, "Ford", "Mustang", 5, 40, 20.0, 20000.00);
        Vehicle c1 = new Vehicle("k.ray", 2001, "Ford", "Explorer", 5, 60, 21.0, 3000.00);
        Vehicle c2 = new Vehicle("g.xi", 2015, "Volvo", "XC60", 5, 55, 29.0, 18000.00);
        Vehicle c3 = new Vehicle("x.zl", 2010, "Audi", "A4", 5, 50, 22.0, 22000.00);
        Vehicle c4 = new Vehicle("j.c", 2011, "BMW", "X5", 5, 52, 23.0, 23000.00);
        Vehicle c5 = new Vehicle("c.y", 2012, "BMW", "X6", 5, 53, 24.0, 24000.00);
        Vehicle c6 = new Vehicle("z.x", 2013, "Audi", "Q7", 5, 54, 25.0, 25000.00);
        Vehicle c7 = new Vehicle("h.x", 2015, "Audi", "A8", 5, 55, 26.0, 26000.00);
        Vehicle c8 = new Vehicle("x.b", 2014, "Ferrari", "430", 5, 56, 27.0, 27000.00);
        Vehicle c9 = new Vehicle("l.fc", 2011, "Ferrari", "485", 5, 56, 28.0, 28000.00);

        // Add the vehicles to our taxation registry
        VehicleTaxation vehTaxation = VehicleTaxation.instance();
        vehTaxation.addVehicle(c0);
        vehTaxation.addVehicle(c1);
        vehTaxation.addVehicle(c2);
        vehTaxation.addVehicle(c3);
        vehTaxation.addVehicle(c4);
        vehTaxation.addVehicle(c5);
        vehTaxation.addVehicle(c6);
        vehTaxation.addVehicle(c7);
        vehTaxation.addVehicle(c8);
        vehTaxation.addVehicle(c9);
        // Print the contents
        System.out.println("Initial display of the taxation list");
        vehTaxation.listTaxRegistry();

        //System.out.println("k.ray's vehicle is: " + vehTaxation.getVehicle("k.ray"));
        // Try deleting a vehicle instance
        /*vehTaxation.remove("k.ray");

        // Print the contents
        System.out.println("We removed k.ray");
        vehTaxation.listTaxRegistry();*/
        ArrayList car = vehTaxation.getList();
        int car_number = car.size();
        for (int i = 0; i < car_number - 1; i++) {  // Each pass pushes the highest value to the end of the list
            for (int j = 0; j < ((car_number - 1) - i); j++) { // After each pass, the number of unsorted items grows shorter
                Vehicle a = (Vehicle) car.get(j);
                String val0 = a.getOwnerId();
                Vehicle b = (Vehicle) car.get(j + 1);
                String val1 = b.getOwnerId();
                if (val0.compareTo(val1) > 0) { // We found items that are out of order, so swap them
                    car.set(j, b);
                    car.set((j + 1), a);
                }
            }
        }
        System.out.println("VehicleList in order by OwnerID");
        vehTaxation.listTaxRegistry();

        TaxRegistryIO tio = new TaxRegistryIO();
        String fn = "VehicleInformation";
        tio.FileHandler();
        //ArrayList al = vehTaxation.getList.save(car, fn);

        ArrayList<Vehicle> vehList = tio.load(fn);

        for (int i = 0; i < vehList.size(); i++) {
            Vehicle v = vehList.get(i);
            System.out.println(v);
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {
        VehicleTest vt = new VehicleTest();
        vt.run();
    }

}
