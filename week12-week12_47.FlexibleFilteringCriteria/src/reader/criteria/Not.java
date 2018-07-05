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
public class Not implements Criterion {

    private Criterion criterion;
    
    public Not(Criterion criterion) {
        this.criterion = criterion;
    }
    
    @Override
    public boolean complies(String line) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return !this.criterion.complies(line);
    }
    
}
