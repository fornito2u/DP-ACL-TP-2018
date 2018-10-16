package model.action;

import model.CalcModel;

public class ActionReset implements Action {

    private static ActionReset instance=new ActionReset();

    public static ActionReset getInstance() {
        if (instance == null) {
            instance=new ActionReset();
        }
        return instance;
    }

    @Override
    public void doAction(CalcModel cm, String... liste) {
        cm.reset();
    }
}