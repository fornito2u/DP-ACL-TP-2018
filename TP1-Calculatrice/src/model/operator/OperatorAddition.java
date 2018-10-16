package model.operator;

/**
 * Created by Kleyman on 23/09/2018.
 */
public class OperatorAddition implements Operator {

    private OperatorAddition() { }

    private static OperatorAddition instance;

    public static OperatorAddition getInstance() {
        if (instance == null) {
            instance=new OperatorAddition();
        }
        return instance;
    }

    @Override
    public double compute(double nb1, double nb2) {
        return nb1+nb2;
    }

}
