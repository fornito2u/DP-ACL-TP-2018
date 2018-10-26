package Personnes;

import Matieres.Matiere;

import java.util.ArrayList;

public abstract class Enseignant extends Personne {
    protected static final double SALAIRE_HORAIRE = 30.0;
    protected double heures;
    private Matiere matiere;

    public Enseignant(String nom, String prenom, double heures, Matiere matiere) {
        super(nom, prenom);
        this.heures = heures;
        this.matiere = matiere;
        matiere.enseignePar(this);
    }

    public abstract double getSalaire();

    @Override
    public String toString() {
        return super.toString() + " en " + matiere.toString() + " , salaire = " + getSalaire();
    }
}
