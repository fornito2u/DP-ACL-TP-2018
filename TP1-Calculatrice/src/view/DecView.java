/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author cirstea
 */
import controller.ButtonListener;
import controller.KeyJTextListener;
import model.CalcModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DecView  extends JPanel implements Observer{


    private JPanel[] panels = new JPanel[6];
    private JTextField textField = new JTextField();
    private JButton[] numberButtons = new JButton[10];
    private JButton subtractButton = new JButton("-");
    private JButton addButton = new JButton("+");
    private JButton equateButton = new JButton(" = ");
    private JButton resetButton = new JButton("CE");

    private CalcModel calcModel;

    public DecView(CalcModel calcModel) {
        this.calcModel=calcModel;
        buildFrame(calcModel);
        calcModel.addObserver(this);
    }

    private void addKeyListenerToChildren(KeyJTextListener kjtl, JComponent jc ) {
        Component[] components=jc.getComponents();
        for (int i=0;i<components.length;i++) {
            components[i].addKeyListener(kjtl);
            addKeyListenerToChildren(kjtl,(JComponent)components[i]);
        }
    }

    public void buildFrame(CalcModel calcModel) {

        JPanel contentPane = this;
        // initialize panels
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        // initialize button 0-9
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(" " + i + " ");
            numberButtons[i].addActionListener(new ButtonListener(calcModel,(""+i)));
        }

        // default layout = BorderLayout.CENTER
        textField.setColumns(20);
        textField.setText("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);

        textField.setEditable(false);
        panels[0].add(textField);

        // layout = FlowLayout.LEFT
        panels[1].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[1].add(numberButtons[7]);
        panels[1].add(numberButtons[8]);
        panels[1].add(numberButtons[9]);
        panels[1].add(addButton);
        addButton.addActionListener(new ButtonListener(calcModel,"+"));

        // layout = FlowLayout.LEFT
        panels[2].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[2].add(numberButtons[4]);
        panels[2].add(numberButtons[5]);
        panels[2].add(numberButtons[6]);
        panels[2].add(subtractButton);
        subtractButton.addActionListener(new ButtonListener(calcModel,"-"));

        // layout = FlowLayout.LEFT
        panels[3].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[3].add(numberButtons[1]);
        panels[3].add(numberButtons[2]);
        panels[3].add(numberButtons[3]);
        panels[3].add(equateButton);

        equateButton.addActionListener(new ButtonListener(calcModel,"="));


        // layout = FlowLayout.LEFT
        panels[4].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[4].add(numberButtons[0]);
        panels[4].add(resetButton);
        resetButton.addActionListener(new ButtonListener(calcModel,"c"));

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        for (JPanel jPanel : panels) {
            contentPane.add(jPanel);
        }

        addKeyListenerToChildren(new KeyJTextListener(this.calcModel),contentPane);
    }

    public String getDisplay() {
        double nb1= calcModel.getNb1();
        double nb2=calcModel.getNb2();
        if (!calcModel.isNb2Set()) {
            if (nb1 == (int)(nb1)) {
                return ""+(int)(nb1);
            } else {
                return ""+nb1;
            }
        } else {
            if (nb2 == (int)(nb2)) {
                return ""+(int)(nb2);
            } else {
                return ""+nb2;
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        CalcModel cm=(CalcModel)o;
        String display=getDisplay();
        textField.setText(display);
    }
}
