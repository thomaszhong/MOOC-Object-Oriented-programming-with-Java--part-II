/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.util.Map;
import java.util.HashMap;

public class ShoppingBasket {

    private Map<String, Purchase> map;

    public ShoppingBasket() {
        this.map = new HashMap<String, Purchase>();
    }

    public void add(String product, int price) {
        if (this.map.containsKey(product)) {
            this.map.get(product).increaseAmount();
        } else {
            Purchase purchase = new Purchase(product, 1, price);
            this.map.put(product, purchase);
        }
    }

    public int price() {
        int sum = 0;
        for (Purchase temp : this.map.values()) {
            sum += temp.price();
        }
        return sum;
    }

    public void print() {
        for (Purchase temp : this.map.values()) {
            System.out.println(temp);
        }
    }

}
