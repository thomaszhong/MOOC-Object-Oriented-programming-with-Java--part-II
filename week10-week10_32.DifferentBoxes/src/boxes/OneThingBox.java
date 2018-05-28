/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author Xuwei Zhong
 */
public class OneThingBox extends Box {

    private Thing thing;
    
    public OneThingBox() {
        
    }
    
    @Override
    public void add(Thing thing) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (this.thing == null) {
            this.thing = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (this.thing == null) {
            return false;
        }
        return this.thing.equals(thing);
    }
    
}
