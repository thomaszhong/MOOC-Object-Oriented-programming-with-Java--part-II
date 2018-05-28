/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuwei Zhong
 */
public class Farm implements Alive {

    private Barn barn;
    private String owner;
    private List<Cow> cowList;

    public Farm(String owner, Barn barn) {
        this.barn = barn;
        this.owner = owner;
        this.cowList = new ArrayList<Cow>();
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public void installMilkingRobot(MilkingRobot milkingrobot) {
        this.barn.installMilkingRobot(milkingrobot);
    }

    public void addCow(Cow cow) {
        this.cowList.add(cow);
    }

    public void manageCows() {
        this.barn.takeCareOf(this.cowList);
    }

    @Override
    public void liveHour() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (Cow cow : this.cowList) {
            cow.liveHour();
        }
    }

}
