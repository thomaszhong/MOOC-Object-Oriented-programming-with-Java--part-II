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
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> priceMap;
    private Map<String, Integer> stockMap;

    public Storehouse() {
        this.priceMap = new HashMap<String, Integer>();
        this.stockMap = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        this.priceMap.put(product, price);
        this.stockMap.put(product, stock);
    }

    public int price(String product) {
        if (this.priceMap.containsKey(product)) {
            return this.priceMap.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (this.stockMap.containsKey(product)) {
            return this.stockMap.get(product);
        } else {
            return 0;
        }
    }
    
    public boolean take(String product) {
        if (this.stockMap.containsKey(product)) {
            if (this.stockMap.get(product) > 0) {
                int num = this.stockMap.get(product);
                this.stockMap.replace(product, --num);
                return true;
            }
        } 
        return false;
    }
    
    public Set<String> products() {
        return this.priceMap.keySet();
    }
    
}
