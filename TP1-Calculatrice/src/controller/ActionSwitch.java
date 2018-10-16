package controller;

import model.*;
import model.action.*;

import java.util.HashMap;

public class ActionSwitch {

    private static HashMap<String, Action> actionMap=new HashMap<String, Action>();

    public static void putAction(Action action, String... car) {
        for (int i=0;i<car.length;i++) {
            actionMap.put(car[i],action);
        }
    }

    public static void actionSwitch(CalcModel cm, String keycode) {
        Action action=actionMap.get(keycode);
        if (action != null) {
            action.doAction(cm, keycode);
        }
    }

    public static void bindDefaultKeyAndButtonsToActions() {
        ActionSwitch.putAction(ActionAdd.getInstance(),"+");
        ActionSwitch.putAction(ActionSub.getInstance(),"-");
        ActionSwitch.putAction(ActionReset.getInstance(),"c");
        ActionSwitch.putAction(ActionEqual.getInstance(),"=","\n");
        for (int i=0;i<=9;i++) {
            ActionSwitch.putAction(ActionChiffre.getInstance(),(""+i));
        }
        for (int i=0;i<=16;i++) {
            ActionSwitch.putAction(ActionChiffre.getInstance(),("h"+Integer.toHexString(i)));
        }
        for (int i=0;i<=1;i++) {
            ActionSwitch.putAction(ActionChiffre.getInstance(),("b"+i));
        }
    }
}
