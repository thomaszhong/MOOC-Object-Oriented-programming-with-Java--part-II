
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class GraphicCalculator implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        JTextField textOutput = new JTextField("0");
        textOutput.setEnabled(false);
        JTextField textInput = new JTextField("0");

        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton resetButton = new JButton("Z");
        resetButton.setEnabled(false);
        
        panel.add(plusButton);
        panel.add(minusButton);
        panel.add(resetButton);
        
        CalculatorListener listener = new CalculatorListener(textInput, 
                textOutput, resetButton);
        
        plusButton.addActionListener(listener);
        minusButton.addActionListener(listener);
        resetButton.addActionListener(listener);
        
        container.add(textOutput);
        container.add(textInput);
        container.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }

}
