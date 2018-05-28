/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuwei Zhong
 */
public class Group implements Movable {
    
    private List<Movable> list;
    
    public Group() {
        this.list = new ArrayList<Movable>();
    }
    
    public String toString() {
        String print = "";
        for (Movable movable : this.list) {
            print += movable.toString() + "\n";
        }
        return print;
    }
    
    public void addToGroup(Movable movable) {
        this.list.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable movable : this.list) {
            movable.move(dx, dy);
        }
    }
    
}
