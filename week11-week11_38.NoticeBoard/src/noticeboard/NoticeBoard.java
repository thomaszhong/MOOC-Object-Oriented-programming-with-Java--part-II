package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        
        JTextField textAreaTop = new JTextField("");
        JLabel textAreaBottom = new JLabel("I was copied here from the JTextArea");
        JButton copyButton = new JButton("Copy!");
        
        AreaCopier copier = new AreaCopier(textAreaTop, textAreaBottom);
        copyButton.addActionListener(copier);
        
        container.add(textAreaTop);
        container.add(copyButton);
        container.add(textAreaBottom);
        
        
    }
}
