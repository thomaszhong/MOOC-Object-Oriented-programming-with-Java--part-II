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
import java.util.List;
import java.util.ArrayList;

public class RingingCentre {

    private Map<Bird, List<String>> map;

    public RingingCentre() {
        this.map = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if (!this.map.containsKey(bird)) {
            List<String> nameList = new ArrayList<String>();
            nameList.add(place);
            this.map.put(bird, nameList);
        } else {
            this.map.get(bird).add(place);
        }
    }

    public void observations(Bird bird) {
        System.out.print(bird);       
        System.out.print(" observations: ");
        if(this.map.containsKey(bird)){
            ArrayList<String> temp = (ArrayList)this.map.get(bird);
            System.out.println(""+ temp.size());
            for(String temp1 : temp){
                System.out.println(temp1);
            }
        }
        else{
            System.out.println(""+ 0);
        }
    }

}
