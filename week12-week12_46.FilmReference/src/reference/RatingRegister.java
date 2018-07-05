/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.*;

/**
 *
 * @author Thomas Zhong
 */
public class RatingRegister {

    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, Map<Film, Rating>> personRatings;

    public RatingRegister() {
        this.filmRatings = new HashMap<Film, List<Rating>>();
        this.personRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Film film, Rating rating) {
        if (!this.filmRatings.containsKey(film)) {
            ArrayList<Rating> list = new ArrayList<Rating>();
            list.add(rating);
            this.filmRatings.put(film, list);
        } else {
            this.filmRatings.get(film).add(rating);
        }
    }

    public List<Rating> getRatings(Film film) {
        return this.filmRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return this.filmRatings;
    }

    public void addRating(Person person, Film film, Rating rating) {
        addRating(film, rating);
        if (!this.personRatings.containsKey(person)) {
            Map<Film, Rating> map = new HashMap<Film, Rating>();
            map.put(film, rating);
            this.personRatings.put(person, map);
        } else if (!this.personRatings.get(person).containsKey(film)) {
            this.personRatings.get(person).put(film, rating);
        }

    }

    public Rating getRating(Person person, Film film) {
        if (this.personRatings.containsKey(person)) {
            if (!this.personRatings.get(person).containsKey(film)) {
                return Rating.NOT_WATCHED;
            } else {
                return this.personRatings.get(person).get(film);
            }
        }
        return null;
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (this.personRatings.containsKey(person)) {
            return this.personRatings.get(person);
        }
        return new HashMap();
    }

    public List<Person> reviewers() {
        return new ArrayList<Person>(this.personRatings.keySet());
    }
}
