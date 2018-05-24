/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

/**
 *
 * @author Xuwei Zhong
 */
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;
import java.util.ArrayList;

public class Packer {

    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> list = new ArrayList<Box>();
        Box box = new Box(this.boxesVolume);
        for (int i = 0; i < things.size(); i++) {
            if (!box.addThing(things.get(i))) {
                list.add(box);
                i--;
                box = new Box(this.boxesVolume);
            }
        }
        list.add(box);
        return list;
    }
}
