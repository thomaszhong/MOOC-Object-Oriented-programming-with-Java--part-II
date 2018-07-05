/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;


/**
 *
 * @author Thomas Zhong
 */
public class AtLeastOne implements Criterion {

    private Criterion[] criterion;
    
    public AtLeastOne(Criterion... criterion) {
        this.criterion = criterion;
    }
    
    @Override
    public boolean complies(String line) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < this.criterion.length; i++) {
            if (this.criterion[i].complies(line)) {
                return true;
            }
        }
        return false;
    }
    
}
