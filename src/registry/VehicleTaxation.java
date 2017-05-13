package edu.neu.csye6200.registry;

import static edu.neu.csye6200.registry.VehicleTaxation.instance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * A dual container class. We'll store Vehicles into a list, and a searchable
 * map at the same time
 *
 * @author mgmunson
 */
public class VehicleTaxation {
    

    private ArrayList<Vehicle> carList = new ArrayList<Vehicle>();	// An ordered listing of vehicles
    private HashMap<String, Vehicle> carMap = new HashMap<String, Vehicle>(); // a searchable map of vehicles
    private static VehicleTaxation instance = null;
    private static Logger log = Logger.getLogger(VehicleTaxation.class.getName());
    

    /**
     * Constructor
     */
    private VehicleTaxation() {
        
    }

    public static VehicleTaxation instance() {
        
        log.info("Constructing a TaxRegistryIO instance");
        if (instance == null) {
            instance = new VehicleTaxation();
        }
        return (instance);
    }

    /**
     * Determine if a vehicle is already present
     *
     * @param veh the vehicle to test
     * @return true if a vehicle instance is already present
     */
    private boolean hasVehicle(Vehicle veh) {
        if (veh == null) {
            return false; // if veh is undefined, then report that no vehicle is present
        }
        return (carMap.containsKey(veh.getOwnerId())); // Check the map for a match. If one is found, return true
    }

    /**
     * Locate the list index position of an existing Vehicle by owner ID
     *
     * @param ownerId the vehicle ownerId
     * @return the array index position, or -1 if no match was found
     */
    private int getVehicleIndex(String ownerId) {
        for (int i = 0; i < carList.size(); i++) {
            Vehicle veh = carList.get(i);
            if (veh.getOwnerId().equalsIgnoreCase(ownerId)) {
                return i;
            }
        }
        return -1; // no Match found, so return -1;
    }

    /**
     * Add a vehicle entry to our Taxation registry
     *
     * @param veh the vehicle instance to add
     */
    public void addVehicle(Vehicle veh) {

        if (hasVehicle(veh)) { // the vehicle already exists, so replace it
            int index = getVehicleIndex(veh.getOwnerId());
            carList.set(index, veh);
        } else {                 // the vehicle doesn't exist, so just add it
            carList.add(veh);
        }
        carMap.put(veh.getOwnerId(), veh); // Place into the map, replacing any previous entry
    }

    /**
     * Get a vehicle using its ownerId
     *
     * @param ownerId the key to locate a Vehicle instance
     * @return a found Vehicle match
     */
    public Vehicle getVehicle(String ownerId) {
        return carMap.get(ownerId);
    }

    public ArrayList getList() {
        return carList;
    }

    /**
     * Remove a vehicle
     *
     * @param veh
     */
    public void remove(Vehicle veh) {
        if (!hasVehicle(veh)) {
            return; // Nothing to remove so 
        }
        remove(veh.getOwnerId());
    }

    /**
     * Remove a vehicle with a specified ownerId
     *
     * @param ownerId a unique owner ID string
     */
    public void remove(String ownerId) {
        int index = getVehicleIndex(ownerId);
        carList.remove(index);
        carMap.remove(ownerId);
    }

    /**
     * Clear the entire VehicleTaxation registry
     */
    public void clear() {
        carList.clear();
        carMap.clear();
    }

    /**
     * List all of the vehicles using an attractive print routine
     */
    public void listTaxRegistry() {
        //  2016       Ford      Mustang 800.00 
        System.out.println(" Year       Make      -Model-    Tax($)     OwnerID");

        for (Vehicle veh : carList) {
            System.out.println(veh.toFormattedString()); // Print using the attractive String routine
        }
    }

}
