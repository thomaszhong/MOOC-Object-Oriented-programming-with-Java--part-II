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

public class Suitcase {

    private int maxWeight;
    private ArrayList<Thing> list;
    private int totalWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.totalWeight = 0;
        this.list = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        if (thing.getWeight() + this.totalWeight <= this.maxWeight) {
            this.list.add(thing);
            this.totalWeight += thing.getWeight();
        }
    }

    public String toString() {
        int counter = this.list.size();
        if (counter == 0) {
            return "empty (0 kg)";
        } else if (counter == 1) {
            return counter + " thing (" + this.totalWeight + " kg)";
        }
        return counter + " things (" + this.totalWeight + " kg)";
    }

    public void printThings() {
        for (Thing temp : this.list) {
            System.out.println(temp);
        }
    }

    public int totalWeight() {
        return this.totalWeight;
    }

    public Thing heaviestThing() {
        Thing heaviest = null;
        if (this.list.size() > 0) {
            heaviest = this.list.get(0);
            for (Thing thing : this.list) {
                if (heaviest.getWeight() < thing.getWeight()) {
                    heaviest = thing;
                }
            }
        }
        return heaviest;
    }
}
