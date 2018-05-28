/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Xuwei Zhong
 */
public class MilkingRobot {
    
    private BulkTank tank;
    
    public MilkingRobot() {
        
    }
    
    public BulkTank getBulkTank() {
        return this.tank;
    }
    
    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }
    
    public void milk(Milkable milkable) {
        if (this.tank == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        double amount = milkable.milk();
        this.tank.addToTank(amount);
    }
    
}
