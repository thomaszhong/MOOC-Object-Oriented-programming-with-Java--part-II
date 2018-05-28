/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author Xuwei Zhong
 */
public class Cow implements Milkable, Alive {

    private String name;
    private double capacity;
    private double amount;

    public Cow() {
        Random random = new Random();
        this.capacity = random.nextInt(26) + 15;
        this.amount = 0;
        
        String[] nameList = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
        
        this.name = nameList[random.nextInt(32)];
    }

    public Cow(String name) {
        this.name = name;
        Random random = new Random();
        this.capacity = random.nextInt(26) + 15;
        this.amount = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.amount) + "/" + Math.ceil(this.capacity);
    }

    @Override
    public double milk() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        double everything = this.amount;
        this.amount = 0;
        return everything;
    }

    @Override
    public void liveHour() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Random random = new Random();
        double addAmount = 0.7 + (2.0 - 0.7) * random.nextDouble();
        if (addAmount + this.amount > this.capacity) {
            this.amount = this.capacity;
        } else {
            this.amount += addAmount;
        }
    }
}
