package Personnes;

import Matieres.Matiere;

public class Professeur extends Enseignant {
    private static final double HEURES_MIN = 200.0;
    private static final double SALAIRE_MIN = 2000.0;

    public Professeur(String nom, String prenom, double heures, Matiere matiere) {
        super(nom, prenom, heures, matiere);
    }

    @Override
    public double getSalaire() {
        double res = SALAIRE_MIN;

        double heure_sup = heures - HEURES_MIN;

        if(heure_sup > 0)
            res += heure_sup * SALAIRE_HORAIRE;

        return res;
    }
}
