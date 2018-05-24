/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.util.*;
public class Changer {
    private ArrayList<Change> list;
    
    public Changer() {
        list = new ArrayList<Change>();
    }
    
    public void addChange(Change change) {
        list.add(change);
    }
    
    public String change(String characterString) {
        for (Change temp : list) {
            characterString = temp.change(characterString);
        }
        return characterString;
    }
}
