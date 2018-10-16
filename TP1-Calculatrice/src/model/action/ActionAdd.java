package model.action;

import model.CalcModel;
import model.operator.OperatorAddition;

public class ActionAdd implements Action {

    private static ActionAdd instance=new ActionAdd();

    public static ActionAdd getInstance() {
        if (instance == null) {
            instance=new ActionAdd();
        }
        return instance;
    }

    @Override
    public void doAction(CalcModel cm, String... liste) {
        cm.setOperator(OperatorAddition.getInstance());
    }
}
