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

public class Container {

    private int maxWeight;
    private ArrayList<Suitcase> list;
    private int totalWeight;

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        this.totalWeight = 0;
        this.list = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.totalWeight + suitcase.totalWeight() <= this.maxWeight) {
            this.list.add(suitcase);
            this.totalWeight += suitcase.totalWeight();
        }
    }
    
    public String toString() {
        return this.list.size() + " suitcases (" + this.totalWeight + " kg)";
    }
    
    public void printThings() {
        for (Suitcase temp : this.list) {
            temp.printThings();
        }
    }

}
