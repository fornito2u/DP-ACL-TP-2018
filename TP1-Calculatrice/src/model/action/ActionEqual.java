package model.action;

import model.CalcModel;

public class ActionEqual implements Action {

    private static ActionEqual instance=new ActionEqual();

    public static ActionEqual getInstance() {
        if (instance == null) {
            instance=new ActionEqual();
        }
        return instance;
    }

    @Override
    public void doAction(CalcModel cm, String... liste) {
        cm.compute(null);
    }
}