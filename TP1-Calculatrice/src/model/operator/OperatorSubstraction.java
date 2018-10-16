package model.operator;

/**
 * Created by Kleyman on 23/09/2018.
 */
public class OperatorSubstraction implements Operator {

    private OperatorSubstraction() { }

    private static OperatorSubstraction instance;

    public static OperatorSubstraction getInstance() {
        if (instance == null) {
            instance=new OperatorSubstraction();
        }
        return instance;
    }

    @Override
    public double compute(double nb1, double nb2) {
        return nb1-nb2;
    }

}
