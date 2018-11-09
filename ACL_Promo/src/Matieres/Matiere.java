package Matieres;

import Main.Main;

import Personnes.Enseignant;

import java.util.ArrayList;

public class Matiere {
    private String intitule;

    private ArrayList<Enseignant> enseignants;

    public Matiere(String intitule){
        this.intitule = intitule;

        enseignants = new ArrayList<Enseignant>();
    }

    public void enseignePar(Enseignant enseignant){
        if(!enseignants.contains(enseignant))
            enseignants.add(enseignant);
    }

    public String describe(){
        String res = getAllEnseignant();

        return res;
    }

    private String getAllEnseignant(){
        String res = "Les enseignants en " + toString() + " :\n";

        for (Enseignant enseignant : enseignants) {
            res += "  " + enseignant.toString() + Main.RETURN_LINE;
        }

        return res;
    }

    @Override
    public String toString() {
        return intitule;
    }
}
