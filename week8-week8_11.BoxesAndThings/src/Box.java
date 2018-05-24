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

public class Box implements ToBeStored{

    private double maxWeight;
    private ArrayList<ToBeStored> list;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.list = new ArrayList<ToBeStored>();
    }

    public void add(ToBeStored item) {
        if (weight() + item.weight() < this.maxWeight) {
            this.list.add(item);
        }
    }
    
    public double weight() {
        double weight = 0.0;
        for (ToBeStored temp : this.list) {
            weight += temp.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.list.size() + " things, total weight "
                + weight() + " kg";
    }

}
