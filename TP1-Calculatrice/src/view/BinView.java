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

public class BinView extends JPanel implements Observer{

    private JPanel[] panels = new JPanel[6];
    private JTextField textField = new JTextField();
    private JButton[] numberButtons = new JButton[2];
    private JButton subtractButton = new JButton("-");
    private JButton addButton = new JButton("+");
    private JButton equateButton = new JButton(" = ");
    private JButton resetButton = new JButton("CE");

    private CalcModel calcModel;

    public BinView(CalcModel calcModel) {
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
            numberButtons[i].addActionListener(new ButtonListener(calcModel,("b"+i)));
        }

        // default layout = BorderLayout.CENTER
        textField.setColumns(20);
        textField.setText("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);

        textField.setEditable(false);
        panels[0].add(textField);

        // layout = FlowLayout.LEFT
        panels[1].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[1].add(numberButtons[0]);
        panels[1].add(numberButtons[1]);
        panels[1].add(addButton);
        addButton.addActionListener(new ButtonListener(calcModel,"+"));

        // layout = FlowLayout.LEFT
        panels[2].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[2].add(subtractButton);
        panels[2].add(equateButton);
        panels[2].add(resetButton);
        subtractButton.addActionListener(new ButtonListener(calcModel,"-"));
        resetButton.addActionListener(new ButtonListener(calcModel,"c"));
        equateButton.addActionListener(new ButtonListener(calcModel,"="));

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
                return ""+Integer.toBinaryString((int)nb1).toUpperCase();
            } else {
                return ""+Integer.toBinaryString((int)nb1).toUpperCase();
            }
        } else {
            if (nb2 == (int)(nb2)) {
                return ""+Integer.toBinaryString((int)nb2).toUpperCase();
            } else {
                return ""+Integer.toBinaryString((int)nb2).toUpperCase();
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
