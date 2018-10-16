package model.action;

import model.CalcModel;
import model.operator.OperatorSubstraction;

public class ActionSub implements Action {

    private static ActionSub instance=new ActionSub();

    public static ActionSub getInstance() {
        if (instance == null) {
            instance=new ActionSub();
        }
        return instance;
    }

    @Override
    public void doAction(CalcModel cm, String... liste) {
        cm.setOperator(OperatorSubstraction.getInstance());
    }
}