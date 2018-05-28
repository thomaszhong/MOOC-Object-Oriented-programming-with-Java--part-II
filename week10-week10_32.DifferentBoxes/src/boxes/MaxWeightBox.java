/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuwei Zhong
 */
public class MaxWeightBox extends Box {

    private int maxWeight;
    private List<Thing> list;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.list = new ArrayList<Thing>();
    }
    
    public int totalWeight() {
        int sum = 0;
        for (Thing thing : this.list) {
            sum += thing.getWeight();
        }
        return sum;
    }
    
    @Override
    public void add(Thing thing) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if ((thing.getWeight() + totalWeight()) <= this.maxWeight) {
            this.list.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.list.contains(thing);
    }
    
}
