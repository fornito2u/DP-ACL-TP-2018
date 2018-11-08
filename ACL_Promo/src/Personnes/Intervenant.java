package Personnes;

import Matieres.Matiere;

public class Intervenant extends Enseignant {

    public Intervenant(String nom, String prenom, double heures, Matiere matiere) {
        super(nom, prenom, heures, matiere);
    }

    @Override
    public double getSalaire() {
        return heures * SALAIRE_HORAIRE * 2;
    }
}
