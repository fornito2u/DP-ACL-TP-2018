package model.action;

import model.CalcModel;

public class ActionChiffre implements Action {

    private static ActionChiffre instance=new ActionChiffre();

    public static ActionChiffre getInstance() {
        if (instance == null) {
            instance=new ActionChiffre();
        }
        return instance;
    }

    @Override
    public void doAction(CalcModel cm, String... liste) {
        if (liste != null && liste.length == 1) {
            try {
                if (liste[0].charAt(0) == 'h') {
                    int nb = Integer.parseInt("" + liste[0].charAt(1),16);
                    cm.addChiffre(nb,16);
                } else if (liste[0].charAt(0) == 'b') {
                    int nb = Integer.parseInt("" + liste[0].charAt(1),2);
                    cm.addChiffre(nb,2);
                } else {
                    int nb = Integer.parseInt("" + liste[0]);
                    cm.addChiffre(nb,10);
                }
            } catch (NumberFormatException ne) {
                System.out.println("La touche pressé n'est pas un nombre");
            }
        }
    }
}