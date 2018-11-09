package Personnes;

import Promos.Promo;

import java.util.ArrayList;

public abstract class Personne {
    private String nom, prenom;

    private ArrayList<Promo> promos;

    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;

        promos = new ArrayList<Promo>();
    }

    public void appartientA(Promo promo){
        if(!promos.contains(promo))
            promos.add(promo);
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
}
