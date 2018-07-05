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
public class EndsWithQuestionOrExclamationMark implements Criterion {

    
    @Override
    public boolean complies(String line) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (line.isEmpty()) return false;
        return line.charAt(line.length() - 1) == '?' || line.charAt(line.length() - 1) == '!';
    }
    
}
