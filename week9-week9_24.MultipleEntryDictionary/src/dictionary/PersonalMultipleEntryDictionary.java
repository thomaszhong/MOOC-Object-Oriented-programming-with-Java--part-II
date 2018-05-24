/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Xuwei Zhong
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set<String>> map;

    public PersonalMultipleEntryDictionary() {
        this.map = new HashMap<String, Set<String>>();
    }

    @Override
    public void add(String word, String entry) {
        if (!this.map.containsKey(word)) {
            Set<String> set = new HashSet<String>();
            set.add(entry);
            this.map.put(word, set);
        } else {
            this.map.get(word).add(entry);
        }
    }

    @Override
    public Set<String> translate(String word) {
        return this.map.get(word);
    }

    @Override
    public void remove(String word) {
        if (this.map.containsKey(word)) {
            this.map.remove(word);
        }
    }
}
