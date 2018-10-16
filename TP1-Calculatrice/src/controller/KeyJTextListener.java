package controller;

import model.CalcModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyJTextListener extends KeyAdapter {

    private CalcModel cm;

    public KeyJTextListener(CalcModel cm) {
        this.cm = cm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ActionSwitch.actionSwitch(cm,""+e.getKeyChar());
    }
}
