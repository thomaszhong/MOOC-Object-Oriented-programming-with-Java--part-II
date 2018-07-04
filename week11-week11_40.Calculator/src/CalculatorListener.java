
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thomas Zhong
 */
public class CalculatorListener implements ActionListener {

    private JTextField input;
    private JTextField output;
    private JButton resetButton;

    public CalculatorListener(JTextField input, JTextField output, JButton resetButton) {
        this.input = input;
        this.output = output;
        this.resetButton = resetButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            int num1 = Integer.parseInt(this.input.getText());
            int num2 = Integer.parseInt(this.output.getText());
            if (e.getActionCommand().equals("+")) {
                this.output.setText(num1 + num2 + "");
            } else if (e.getActionCommand().equals("-")) {
                this.output.setText(num2 - num1 + "");
            } else {
                this.output.setText(0 + "");
            }
        } catch (Exception ee) {

        }
        this.input.setText("");

        if (Integer.parseInt(this.output.getText()) == 0) {
            this.resetButton.setEnabled(false);
        } else {
            this.resetButton.setEnabled(true);
        }
    }

}
