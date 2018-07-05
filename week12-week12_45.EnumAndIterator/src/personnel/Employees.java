/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Thomas Zhong
 */
public class Employees {
    
    private List<Person> persons;
    
    public Employees() {
        this.persons = new ArrayList<Person>();
    }
    
    public void add(Person person) {
        this.persons.add(person);
    }
    
    public void add(List<Person> persons) {
        for (Person person : persons) {
            add(person);
        }
    }
    
    public void print() {
        Iterator<Person> iterator = this.persons.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = this.persons.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getEducation() == education) {
                System.out.println(person);
                
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = this.persons.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
    
}
