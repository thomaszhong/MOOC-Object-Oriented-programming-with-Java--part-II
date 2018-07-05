/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.*;

/**
 *
 * @author Thomas Zhong
 */
public class PersonComparator implements Comparator<Person> {

    private Map<Person, Integer> peopleIdentities;

    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }

    @Override
    public int compare(Person o1, Person o2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (this.peopleIdentities.get(o1) == this.peopleIdentities.get(o2)) {
            return 0;
        } else if (this.peopleIdentities.get(o1) > this.peopleIdentities.get(o2)) {
            return -1;
        } else {
            return 1;
        }
    }

}
