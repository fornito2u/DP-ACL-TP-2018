package controller;

import model.CalcModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private CalcModel cm;
    private String keycode;

    public ButtonListener(CalcModel cm, String keycode) {
        this.cm = cm;
        this.keycode=keycode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ActionSwitch.actionSwitch(cm,keycode);
    }
}