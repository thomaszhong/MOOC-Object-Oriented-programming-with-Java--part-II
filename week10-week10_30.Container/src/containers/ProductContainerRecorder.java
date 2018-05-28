/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Xuwei Zhong
 */
public class ProductContainerRecorder extends ProductContainer{
    
    private ContainerHistory history;
    
    public ProductContainerRecorder(String name, double tilavuus, double initialVolume) {
        super(name, tilavuus);
        super.volume = initialVolume;
        this.history = new ContainerHistory();
        this.history.add(initialVolume);
    }
    
    public String history() {
        return this.history.toString();
    }
    
    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        this.history.add(super.volume);
    }
    
    @Override
    public double takeFromTheContainer(double amount) {
        double returnValue = super.takeFromTheContainer(amount);
        this.history.add(super.volume);
        return returnValue;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history);
        System.out.println("Greatest product amount: " + this.history.maxValue());
        System.out.println("Smallest product amount: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
        System.out.println("Greatest change: " + this.history.greatestFluctuation());
        System.out.println("Variance: " + this.history.variance());
    }
    
}
