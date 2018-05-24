/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class SkiJumpingUI {

    private Scanner scanner;
    private ArrayList<Jumper> list;

    public SkiJumpingUI() {
        this.scanner = new Scanner(System.in);
        this.list = new ArrayList<Jumper>();
    }

    public void start() {
        String name;
        System.out.println("Write the names of the participants one at a time; "
                + "an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            name = this.scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            this.list.add(new Jumper(name));
        }
        System.out.println("");
        System.out.println("The tournament begins!");
    }

    public void rounds() {
        int round = 0;
        String command;
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            command = this.scanner.nextLine();
            System.out.println("");

            if (command.equalsIgnoreCase("jump")) {
                round++;
                System.out.println("Round " + round);
                System.out.println("");
                System.out.println("Jumping order: ");
                Collections.sort(this.list);
                for (int i = 0; i < this.list.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + this.list.get(i));
                }
                System.out.println("");
                System.out.println("Results of round " + round);
                for (Jumper jumper : this.list) {
                    jumper.jump();
                }
                System.out.println("");
            } else {
                break;
            }
        }
        System.out.println("");
        System.out.println("Thanks!");
        System.out.println("");
    }

    public void printResults() {
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        Collections.sort(this.list);
        Collections.reverse(this.list);
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println((i + 1) + "           " + this.list.get(i));
            System.out.println("            " + this.list.get(i).getJumpLengths());
        }

    }

}
