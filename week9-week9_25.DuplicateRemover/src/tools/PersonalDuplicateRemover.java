/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Xuwei Zhong
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    
    private List<String> list;
    private Set<String> set;
    
    public PersonalDuplicateRemover() {
        this.list = new ArrayList<String>();
        this.set = new HashSet<String>();
    }
    
    @Override
    public void add(String characterString) {
        this.list.add(characterString);
        this.set.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.list.size() - this.set.size();
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.set;
    }

    @Override
    public void empty() {
        this.list.clear();
        this.set.clear();
    }
    
}
