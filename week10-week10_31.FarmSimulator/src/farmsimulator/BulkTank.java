/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Xuwei Zhong
 */
public class BulkTank {
    
    private double capacity;
    private double milkVolume;
    
    public BulkTank() {
        this.capacity = 2000.0;
    }
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    public double getVolume() {
        return this.milkVolume;
    }
    
    public double howMuchFreeSpace() {
        return this.capacity - this.milkVolume;
    }
    
    public void addToTank(double amount) {
        if (amount < 0) return;
        if ((amount + this.milkVolume) > this.capacity) {
            this.milkVolume = this.capacity;
        } else {
            this.milkVolume += amount;
        }
    }
    
    public double getFromTank(double amount) {
        if (amount < 0) return 0.0;
        if (amount > this.milkVolume) {
            double everything = this.milkVolume;
            this.milkVolume = 0;
            return everything;
        } else {
            this.milkVolume -= amount;
            return amount;
        }
    }
    
    @Override
    public String toString() {
        return "" + Math.ceil(this.milkVolume) +"/" + Math.ceil(this.capacity); 
    }
}
