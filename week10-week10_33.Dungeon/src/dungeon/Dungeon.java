/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

/**
 *
 * @author Xuwei Zhong
 */
public class Dungeon {

    private int length;
    private int height;
    private int moves;
    private boolean vampireMove;
    private Player player;
    private Vampires vampires;
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves,
            boolean vampireMove) {
        this.length = length;
        this.height = height;
        this.moves = moves;
        this.vampireMove = vampireMove;
        this.reader = new Scanner(System.in);
        this.player = new Player(this.length, this.height);
        this.vampires = new Vampires(this.length, this.height, vampires);
    }

    public void run() {
        while (true) {
            System.out.println(this.moves);
            System.out.println("");
            printCoordinates();
            printMap();
            String input = this.reader.nextLine();
            char[] charArray = input.toCharArray();

            for (int i = 0; i < input.length(); i++) {
                this.player.move(charArray[i]);
                if (this.vampireMove) {
                    this.vampires.move();
                }
                killVampire();
            }

            this.moves--;

            if (this.vampires.getX().isEmpty()) {
                System.out.println("YOU WIN");
                break;
            } else if (this.moves == 0) {
                System.out.println("YOU LOSE");
                break;
            }
        }
    }

    public void killVampire() {
        List<Integer> vampiresX = this.vampires.getX();
        List<Integer> vampiresY = this.vampires.getY();
        for (int i = 0; i < vampiresX.size(); i++) {
            if (this.player.getX() == vampiresX.get(i) &&
                    this.player.getY() == vampiresY.get(i)) {
                this.vampires.killVampire(i);
            }
        }
    }

    public void printCoordinates() {
        System.out.println(this.player);
        System.out.println(this.vampires);
    }

    public void printMap() {
        String map = "";
        int playerX = this.player.getX();
        int playerY = this.player.getY();
        List<Integer> vampiresX = this.vampires.getX();
        List<Integer> vampiresY = this.vampires.getY();
        
        for (int j = 0; j < this.height; j++) {
            for (int i = 0; i < this.length; i++) {
                
                //Determine if the vampire is at this location
                boolean ifVampire = false;
                for (int k = 0; k < vampiresX.size(); k++) {
                    if (i == vampiresX.get(k) && j == vampiresY.get(k)) {
                        ifVampire = true;
                    }
                }
                
                //Print player and vampires
                if (playerX == i && playerY == j) {
                    map += "@";
                } else if(ifVampire) {
                    map += "v";
                } else {
                    map +=".";
                }
 
            }
            map += "\n";
        }
        System.out.println(map);
    }

}
