/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {

    private List<Card> list;

    public Hand() {
        this.list = new ArrayList<Card>();
    }

    public void add(Card card) {
        this.list.add(card);
    }

    public void print() {
        for (Card card : this.list) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(this.list);
    }

    public int getSum() {
        int sum = 0;
        for (Card card : this.list) {
            sum += card.getValue();
        }
        return sum;
    }

    @Override
    public int compareTo(Hand hand) {
        if (this.getSum() > hand.getSum()) {
            return 1;
        } else if (this.getSum() < hand.getSum()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public void sortAgainstSuit() {
        Collections.sort(this.list, new SortAgainstSuitAndValue());
    }
}
