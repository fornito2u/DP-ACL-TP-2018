package Promos;

import Main.Main;

import Personnes.Enseignant;
import Personnes.Etudiant;

import java.util.ArrayList;

public class Promo {
    private int anneeDeb, anneeFin;
    private String niveau;

    private ArrayList<Etudiant> etudiants;
    private ArrayList<Enseignant> enseignants;

    public Promo(String niveau, int anneeDeb, int anneeFin){
        this.niveau = niveau;
        this.anneeDeb = anneeDeb;
        this.anneeFin = anneeFin;

        etudiants = new ArrayList<Etudiant>();
        enseignants = new ArrayList<Enseignant>();
    }

    public void addEtudiant(Etudiant etudiant){
        if(!etudiants.contains(etudiant))
            etudiants.add(etudiant);
        etudiant.appartientA(this);
    }

    public void addEnseignant(Enseignant enseignant){
        if(!enseignants.contains(enseignant))
            enseignants.add(enseignant);
        enseignant.appartientA(this);
    }

    public String describe(){
        String res = toString() + Main.RETURN_LINE;

        res += getAllEtudiants() + Main.RETURN_LINE;

        res += getAllEnseignants() + Main.RETURN_LINE;

        return res;
    }

    private String getAllEtudiants(){
        String res = "Les etudiants :" + Main.RETURN_LINE;

        for (Etudiant etudiant : etudiants) {
            res += "  " + etudiant.toString() + Main.RETURN_LINE;
        }

        return res;
    }

    private String getAllEnseignants(){
        String res = "Les enseignants :" + Main.RETURN_LINE;

        for (Enseignant enseignant : enseignants) {
            res += "  " + enseignant.toString() + Main.RETURN_LINE;
        }

        return res;
    }

    @Override
    public String toString() {
        return "Promo " + niveau + " " + anneeDeb + "-" + anneeFin;
    }
}
