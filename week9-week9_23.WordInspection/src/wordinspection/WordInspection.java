/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

/**
 *
 * @author Xuwei Zhong
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class WordInspection {

    private File file;
    private Scanner reader;
    private List<String> content;

    public WordInspection(File file) throws FileNotFoundException {
        this.file = file;
        readFile();
    }

    public int wordCount() {
        int counter = 0;
        for (String line : this.content) {
            counter++;
        }
        return counter;
    }

    public List<String> wordsContainingZ() {
        List<String> wordList = new ArrayList<String>();
        for (String line : this.content) {
            if (line.contains("z")) {
                wordList.add(line);
            }
        }
        return wordList;
    }

    public List<String> wordsEndingInL() {
        List<String> wordList = new ArrayList<String>();
        for (String line : this.content) {
            if (line.charAt(line.length() - 1) == 'l') {
                wordList.add(line);
           }
        }
        return wordList;
    }
    
    public List<String> palindromes() {
        List<String> wordList = new ArrayList<String>();
        String reverseLine;
        for (String line : this.content) {
            reverseLine = "";
            for (int i = line.length() - 1; i >= 0; i--) {
                reverseLine += line.charAt(i);
            }
            if (line.equals(reverseLine)) {
                wordList.add(line);
            }
        }
        return wordList;        
    }
    
    public List<String> wordsWhichContainAllVowels() {
        List<String> wordList = new ArrayList<String>();
        String vowel = "aeiouyäö";
        boolean check;
        for (String line : this.content) {
            check = true;
            for (int i = 0; i < vowel.length(); i++) {
                if (line.indexOf(vowel.charAt(i)) == -1) {
                    check = false;
                }
            }
            if (check) {
                wordList.add(line);
            }
        }
        return wordList;        
    }

    public void readFile() throws FileNotFoundException {
        this.reader = new Scanner(this.file, "UTF-8");
        this.content = new ArrayList<String>();
        while (this.reader.hasNext()) {
            this.content.add(this.reader.nextLine());
        }
    }
}
