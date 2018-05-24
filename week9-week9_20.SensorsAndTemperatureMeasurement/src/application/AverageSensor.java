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
import java.util.List;
import java.util.ArrayList;

public class AverageSensor implements Sensor {

    private List<Sensor> list;
    private List<Integer> readings;

    public AverageSensor() {
        this.list = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        this.list.add(additional);
    }
    
    public List<Integer> readings() {
        return this.readings;
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : this.list) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.list) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.list) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (this.list.size() == 0) {
            throw new IllegalStateException();
        }

        int sum = 0;
        int counter = 0;
        for (Sensor sensor : this.list) {
            if (sensor.isOn()) {
                sum += sensor.measure();
                counter++;
            }
        }
        this.readings.add(sum/counter);
        return sum/counter;
    }

}
