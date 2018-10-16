package model;

import model.operator.Operator;

import java.util.Observable;

/**
 * Created by Kleyman on 20/09/2018.
 */
public class CalcModel extends Observable {

    private double nb1;
    private Operator op;
    private double nb2;

    private boolean nb1Append;
    private boolean nb2Set;

    public CalcModel() {
        this.nb1=0;
        this.op=null;
        this.nb2=0;
        this.nb2Set=false;
        this.nb1Append=false;
    }

    public double getNb1() {
        return nb1;
    }

    public Operator getOp() {
        return op;
    }

    public double getNb2() {
        return nb2;
    }

    public boolean isNb1Append() {
        return nb1Append;
    }

    public boolean isNb2Set() {
        return nb2Set;
    }

    public void setOperator(Operator newOp) {
        if (this.op != null && this.nb2Set) {
            compute(newOp);
        } else {
            this.op=newOp;
        }
        this.setChanged();
        this.notifyObservers();
    }

    public void addChiffre(int chiffre, int base) {
        if (this.op == null) {
            if (this.nb1Append == false) {
                this.nb1=0;
            }
            this.nb1=(int)(this.nb1)*base+chiffre+((this.nb1)-(int)(this.nb1));
            this.nb1Append=true;
        } else {
            this.nb2=(int)(this.nb2)*base+chiffre+(((this.nb2)-(int)(this.nb2)));
            this.nb2Set=true;
        }
        this.setChanged();
        this.notifyObservers();
    }

    public void reset() {
        this.nb1=0;
        this.op=null;
        this.nb2=0;

        this.nb1Append=false;
        this.nb2Set=false;

        this.setChanged();
        this.notifyObservers();
    }

    public void compute(Operator newOp){
        if (op != null && nb2Set) {
            this.nb1=op.compute(nb1,nb2);
            this.op=newOp;
            this.nb2=0;
            this.nb2Set=false;
            this.nb1Append=false;

            this.setChanged();
            this.notifyObservers();
        }
    }

}
