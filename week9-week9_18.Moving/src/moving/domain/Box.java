/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author Xuwei Zhong
 */
import java.util.List;
import java.util.ArrayList;

public class Box implements Thing {
    
    private List<Thing> list;
    private int maximumCapacity;
    
    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.list = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if (getVolume() + thing.getVolume() > this.maximumCapacity) {
            return false;
        } else {
            this.list.add(thing);
            return true;
        }
    }
    

    @Override
    public int getVolume() {
        int volume = 0;
        for (Thing thing : this.list) {
            volume += thing.getVolume();
        }
        return volume;
    }
}
