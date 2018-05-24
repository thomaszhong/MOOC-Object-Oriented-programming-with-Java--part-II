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

public class FlightMap {
    
    private HashMap<String, Plane> map;
    private PlanList list;
    
    public FlightMap(PlanList list) {
        this.map = new HashMap<String, Plane>();
        this.list = list;
    }
    
    public void assign(String ID, String route) {
        Plane plane = this.list.getPlane(ID);
        this.map.put(route, plane);
    }
    
    public Plane getPlane(String route) {
        return this.map.get(route);
    }
    
    public void printMap() {
        for (String key : this.map.keySet()) {
            String planeInfo = this.map.get(key).toString();
            String routeInfo = "(" + key + ")";
            System.out.println(planeInfo + " " + routeInfo);
        }
    }
    
   
}
