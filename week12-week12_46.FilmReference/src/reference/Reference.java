/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author Thomas Zhong
 */
public class Reference {

    private RatingRegister register;

    public Reference(RatingRegister register) {
        this.register = register;
    }

    public Film recommendFilm(Person person) {
        if (this.register.getPersonalRatings(person).isEmpty()) {
            Map<Film, List<Rating>> map = this.register.filmRatings();
            List<Film> listFilm = new ArrayList<Film>(map.keySet());
            Collections.sort(listFilm, new FilmComparator(map));
            return listFilm.get(0);
        }

        return getRecommendFilm(person);
    }

    public Film getRecommendFilm(Person person) {
        Map<Film, Rating> seenFilmsMap = this.register.getPersonalRatings(person);
        Map<Person, Integer> similarityMap = getSimilarity(person);
        
        List<Person> similarReviewers = new ArrayList<Person>(similarityMap.keySet());
        Collections.sort(similarReviewers, new PersonComparator(similarityMap));

        for (Person reviewer : similarReviewers) {
            for (Film film : this.register.getPersonalRatings(reviewer).keySet()) {
                if (seenFilmsMap.containsKey(film)) {
                    continue;
                }

                if (this.register.getPersonalRatings(reviewer).get(film).getValue() > 1) {
                    return film;
                }
            }
        }
        
        return null;

    }

    public Map<Person, Integer> getSimilarity(Person person) {
        List<Person> personList = this.register.reviewers();
        Map<Person, Integer> similarityMap = new HashMap<Person, Integer>();
        
        for (Person temp : personList) {
            if (temp.equals(person)) {
                continue;
            }
            int score = 0;
            for (Film film : this.register.filmRatings().keySet()) {
                score += this.register.getRating(person, film).getValue()
                        * this.register.getRating(temp, film).getValue();
            }
            if (score > 0) {
                similarityMap.put(temp, score);
            }

        }
        return similarityMap;
    }

}
