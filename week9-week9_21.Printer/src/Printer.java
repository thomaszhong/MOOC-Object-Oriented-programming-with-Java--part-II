/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Printer {

    private Scanner scanner;
    private String fileName;

    public Printer(String fileName) throws Exception {
        this.fileName = fileName;
    }

    public void printLinesWhichContain(String word) throws FileNotFoundException {
        File f = new File(this.fileName);
        this.scanner = new Scanner(f);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains(word)) {
                System.out.println(line);
            }
        }
    }
}
