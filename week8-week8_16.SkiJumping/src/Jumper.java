/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Jumper implements Comparable<Jumper> {

    private String name;
    private int score;
    private ArrayList<Integer> list;
    private Random rand;

    public Jumper(String name) {
        this.name = name;
        this.score = 0;
        this.list = new ArrayList<Integer>();
        this.rand = new Random();
    }

    public void jump() {
        int length = rand.nextInt(61) + 60;
        int[] vote;
        vote = new int[5];
        vote[0] = rand.nextInt(11) + 10;
        vote[1] = rand.nextInt(11) + 10;
        vote[2] = rand.nextInt(11) + 10;
        vote[3] = rand.nextInt(11) + 10;
        vote[4] = rand.nextInt(11) + 10;

        System.out.println("  " + this.name);
        System.out.println("    length: " + length);
        System.out.println("    judge votes: " + Arrays.toString(vote));

        Arrays.sort(vote);
        this.score += length + vote[1] + vote[2] + vote[3];
        this.list.add(length);
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.score + " points)";
    }

    public String getJumpLengths() {
        String jumpLengths = "";
        for (int i = 0; i < this.list.size(); i++) {
            jumpLengths += this.list.get(i);
            if (i == this.list.size() - 1) {
                jumpLengths += " m";
            } else {
                jumpLengths += " m, ";
            }
        }
        return "jump lengths: " + jumpLengths;
    }

    @Override
    public int compareTo(Jumper jumper) {
        if (this.score > jumper.getScore()) {
            return 1;
        } else if (this.score < jumper.getScore()) {
            return -1;
        } else {
            return 0;
        }
    }

}
