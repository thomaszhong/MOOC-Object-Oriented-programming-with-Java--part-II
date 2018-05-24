/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.util.ArrayList;
        
public class PlanList {
    
    private ArrayList<Plane> list;
    
    public PlanList() {
        this.list = new ArrayList<Plane>();
    }
    
    public void addPlane(Plane plane) {
        this.list.add(plane);
    }
    
    public void printList() {
        for (Plane plane : this.list) {
            System.out.println(plane);
        }
    }
    
    public Plane getPlane(String name) {
        for (Plane plane : this.list) {
            if (plane.getID().equals(name)) {
                return plane;
            }
        }
        return null;
    }
    
}
