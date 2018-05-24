/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Xuwei Zhong
 */
public class ConstantSensor implements Sensor {
    
    private int number;
    
    public ConstantSensor(int number) {
        this.number = number;
    }
    
    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {
        
    }

    @Override
    public void off() {
        
    }

    @Override
    public int measure() {
        return this.number;
    }
    
}
