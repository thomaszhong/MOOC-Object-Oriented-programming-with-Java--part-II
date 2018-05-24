/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        while (true) {
            System.out.println("Statement: ");
            System.out.println("add - adds a word pair to the dictionary");
            System.out.println("translate - asks a word and prints its translation");
            System.out.println("quit - quits the text user interface");
            String command = this.reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (command.equals("add")) {
                add();
            } else if (command.equals("translate")) {
                translate();
            }
        }

    }

    public void add() {
        System.out.println("In Finnish: ");
        String word = this.reader.nextLine();
        System.out.println("Translation: ");
        String translation = this.reader.nextLine();
        this.dictionary.add(word, translation);
    }

    public void translate() {
        System.out.println("Give a word: ");
        String word = this.reader.nextLine();
        System.out.println("Translation: " + this.dictionary.translate(word));
    }

}
