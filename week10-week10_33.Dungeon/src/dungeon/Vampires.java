/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Xuwei Zhong
 */
public class Vampires {

    private List<Integer> xList;
    private List<Integer> yList;
    private int vampires;
    private int length;
    private int height;
    private Random random;

    public Vampires(int length, int height, int vampires) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.random = new Random();
        this.xList = new ArrayList<Integer>();
        this.yList = new ArrayList<Integer>();
        addVampires();
    }

    public void addVampires() {
        //Initialize vampires positions
        int i = 0;
        while (true) {
            boolean reset = false;
            int randomX = this.random.nextInt(this.length);
            int randomY = this.random.nextInt(this.height);

            if (randomX > 0 && randomX <= this.length && randomY > 0
                    && randomY <= this.height) {
                for (int j = 0; j < i; j++) {
                    if (this.xList.get(j) == randomX
                            && this.yList.get(j) == randomY) {
                        reset = true;
                    }
                }
                if (!reset) {
                    i++;
                    this.xList.add(randomX);
                    this.yList.add(randomY);
                }
            }

            if (i == this.vampires) {
                break;
            }

        }
    }

    public void move() {

        List<Integer> tempXList = new ArrayList<Integer>(this.xList);
        List<Integer> tempYList = new ArrayList<Integer>(this.yList);

        for (int i = 0; i < this.vampires; i++) {
            //Move vampires
            int randomDirection = this.random.nextInt(4);
            switch (randomDirection) {
                case 0:
                    this.yList.set(i, this.yList.get(i) - 1);
                    break;
                case 1:
                    this.xList.set(i, this.xList.get(i) - 1);
                    break;
                case 2:
                    this.yList.set(i, this.yList.get(i) + 1);
                    break;
                case 3:
                    this.xList.set(i, this.xList.get(i) + 1);
                    break;
            }
        }

        //Check if vampires step on each other or out of bounds
        for (int j = 0; j < this.vampires; j++) {
            
            if (this.xList.get(j) >= this.length || this.xList.get(j) < 0
                    || this.yList.get(j) >= this.height || this.yList.get(j) < 0) {
                this.xList.set(j, tempXList.get(j));
                this.yList.set(j, tempYList.get(j));
            }

            for (int k = 0; k < this.vampires; k++) {
                if (j == k) break;
                if (((this.xList.get(j) == this.xList.get(k))
                        && (this.yList.get(j) == this.yList.get(k)))) {
                    this.xList.set(j, tempXList.get(j));
                    this.yList.set(j, tempYList.get(j));
                }
            }
            
        }

    }

    public void killVampire(int index) {
        this.xList.remove(index);
        this.yList.remove(index);
        this.vampires--;
    }

    public List<Integer> getX() {
        return this.xList;
    }

    public List<Integer> getY() {
        return this.yList;
    }

    @Override
    public String toString() {
        String printVampires = "";
        for (int i = 0; i < this.vampires; i++) {
            printVampires += "v " + this.xList.get(i) + " " + this.yList.get(i) + "\n";
        }
        return printVampires;
    }

}
