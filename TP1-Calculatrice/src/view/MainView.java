/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author cirstea
 */
import model.CalcModel;

import java.awt.*;
import javax.swing.*;

public class MainView {

    private JFrame frame = new JFrame("Calculator");
    private DecView decView;
    private HexaView hexaView;
    private BinView binView;

    private CalcModel calcModel;

    public MainView(CalcModel calcModel) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.calcModel=calcModel;
        this.decView=new DecView(calcModel);
        this.hexaView=new HexaView(calcModel);
        this.binView=new BinView(calcModel);
        JPanel jpanel=new JPanel();
        jpanel.setLayout(new GridLayout(1,3));
        jpanel.add(decView);
        jpanel.add(hexaView);
        jpanel.add(binView);
        frame.add(jpanel);
        frame.pack();
        frame.setVisible(true);
    }

}
