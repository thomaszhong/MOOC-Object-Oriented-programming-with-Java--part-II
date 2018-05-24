/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegister {

    private HashMap<RegistrationPlate, String> map;

    public VehicleRegister() {
        this.map = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (this.map.containsKey(plate)) {
            return false;
        } else {
            this.map.put(plate, owner);
            return true;
        }
    }

    public String get(RegistrationPlate plate) {
        if (!this.map.containsKey(plate)) {
            return null;
        } else {
            return this.map.get(plate);
        }
    }

    public boolean delete(RegistrationPlate plate) {
        if (!this.map.containsKey(plate)) {
            return false;
        } else {
            this.map.remove(plate);
            return true;
        }
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate temp : this.map.keySet()) {
            System.out.println(temp);
        }
    }

    public void printOwners() {
        ArrayList<String> owner = new ArrayList<String>();

        for (RegistrationPlate key : this.map.keySet()) {
            String ownerName = this.map.get(key);
            if (!owner.contains(ownerName)) {
                owner.add(ownerName);
            }
        }

        for (String name : owner) {
            System.out.println(name);
        }
    }
}
