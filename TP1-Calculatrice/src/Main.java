import controller.ActionSwitch;
import model.*;
import view.MainView;

/**
 * Created by Kleyman on 20/09/2018.
 */
public class Main {

    public static void main(String args[]) {
        ActionSwitch.bindDefaultKeyAndButtonsToActions();

        CalcModel cm=new CalcModel();

        MainView mv=new MainView(cm);
    }
}


