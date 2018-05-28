/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Xuwei Zhong
 */
public class ContainerHistory {

    private ArrayList<Double> list;

    public ContainerHistory() {
        this.list = new ArrayList<Double>();
    }

    public void add(double situation) {
        this.list.add(situation);
    }

    public void reset() {
        this.list.clear();
    }

    @Override
    public String toString() {
        return "" + this.list;
    }

    public double maxValue() {
        return Collections.max(this.list);
    }

    public double minValue() {
        return Collections.min(this.list);
    }

    public double average() {
        double sum = 0.0;
        for (Double temp : this.list) {
            sum += temp;
        }
        return sum / this.list.size();
    }

    public double greatestFluctuation() {
        double maxFluc = 0.0;
        for (int i = 0; i < this.list.size() - 1; i++) {
            double diff = this.list.get(i + 1) - this.list.get(i);
            if (abs(diff) > maxFluc) {
                maxFluc = abs(diff);
            }
        }
        return maxFluc;
    }

    public double variance() {
        if (this.list.size() < 2) {
            return 0.0;
        }
        double avg = average();
        double sum = 0.0;
        for (Double temp : this.list) {
            sum += pow((temp - avg), 2);
        }
        return sum / (this.list.size() - 1);
    }
    
}
