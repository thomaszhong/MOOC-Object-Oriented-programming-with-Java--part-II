/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Thomas Zhong
 */
public class MindfulDictionary {

    private Map<String, String> map;
    private File file;

    public MindfulDictionary() {
        this.map = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this.map = new HashMap<String, String>();
        this.file = new File(file);
    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(this.file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                add(parts[0], parts[1]);
            }

            return true;
        } catch (FileNotFoundException e) {
            return false;
        }

    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(this.file);
            for (String key : this.map.keySet()) {
                writer.write(key + ":" + this.map.get(key));
                writer.write("\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public void add(String word, String translation) {
        if (!this.map.containsKey(word)) {
            this.map.put(word, translation);
        }
    }

    public String translate(String word) {
        for (String temp : this.map.keySet()) {
            if (temp.equals(word)) {
                return this.map.get(temp);
            } else if (this.map.get(temp).equals(word)) {
                return temp;
            }
        }
        return null;
    }

    public void remove(String word) {
        List<String> list = new ArrayList<String>();
        for (String temp : this.map.keySet()) {
            if (this.map.get(temp).equals(word)) {
                list.add(temp);
            }
        }
        this.map.remove(word);
        for (String temp : list) {
            this.map.remove(temp);
        }
    }

}
