/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
public class Calculator {
    private int counter;
    private Reader reader;

    public Calculator() {
        this.counter = 0;
        this.reader = new Reader();
    }



    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }
            if (command.equals("sum")) {
                sum();
                this.counter++;
            } else if (command.equals("difference")) {
                difference();
                this.counter++;
            } else if (command.equals("product")) {
                product();
                this.counter++;
            }
        }

        statistics();
    }

    private void sum() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.println("");
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        System.out.println("");
        System.out.println("sum of the values " + (value1 + value2));
    }

    private void difference() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.println("");
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        System.out.println("");
        System.out.println("difference of the values " + (value1 - value2));
    }

    private void product() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.println("");
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        System.out.println("");
        System.out.println("product of the values " + (value1 * value2));
    }

    private void statistics() {
        System.out.println("Calculations done " + this.counter);
    }

}
