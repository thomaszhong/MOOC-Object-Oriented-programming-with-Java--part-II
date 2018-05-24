/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author Xuwei Zhong
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analysis {
    
    private Scanner reader;
    private File file;
    
    public Analysis(File file) throws FileNotFoundException {
        this.file = file;
    }
    
    public int lines() throws FileNotFoundException {
        this.reader = new Scanner(this.file);
        int numLines = 0;
        while (this.reader.hasNext()) {
            String line = this.reader.nextLine();
            numLines++;
        }
        return numLines;
    }
    
    public int characters() throws FileNotFoundException {
        this.reader = new Scanner(this.file);
        int numCharacters = 0;
        while (this.reader.hasNext()) {
            String line = this.reader.nextLine();
            numCharacters += line.length() + 1;
        }
        return numCharacters;        
    }
}
