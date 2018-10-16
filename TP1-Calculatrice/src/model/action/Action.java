package model.action;

import model.CalcModel;

public interface Action {

    void doAction(CalcModel cm , String... liste);
}
