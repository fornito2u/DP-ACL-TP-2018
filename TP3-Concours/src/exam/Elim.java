package exam;

import java.util.ArrayList;

public class Elim {

    public static int PSYCHOLOGICAL=0;
    public static int PHYSICAL=1;

    private int type; // Elim.PSYCHOLOGICAL or Elim.PHYSICAL
    private ArrayList<String> question;
    private ArrayList<String> expected;

    public Elim(int t, ArrayList<String> question, ArrayList<String> expected) {
        this.type=t;
        this.question = question;
        this.expected = expected;
    }
}
