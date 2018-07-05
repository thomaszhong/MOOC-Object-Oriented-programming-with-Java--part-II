/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author Thomas Zhong
 */
public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int o1rating = 0;
        int o2rating = 0;

        for (Rating rating : this.ratings.get(o1)) {
            o1rating += rating.getValue();
        }

        for (Rating rating : this.ratings.get(o2)) {
            o2rating += rating.getValue();
        }

        double average1 = ((double) o1rating) / ((double) this.ratings.get(o1).size());
        double average2 = ((double) o2rating) / ((double) this.ratings.get(o2).size());

        if (average1 == average2) {
            return 0;
        } else if (average1 > average2) {
            return -1;
        } else {
            return 1;
        }
    }

}
