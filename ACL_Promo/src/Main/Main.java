package Main;

import Matieres.Matiere;
import Personnes.Etudiant;
import Personnes.Intervenant;
import Personnes.Professeur;
import Promos.Promo;

import java.util.ArrayList;

public class Main{
    public static final String RETURN_LINE = System.getProperty("line.separator");

    public static void main (String[] args){
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        ArrayList<Intervenant> intervenants = new ArrayList<Intervenant>();
        ArrayList<Professeur> professeurs = new ArrayList<Professeur>();

        ArrayList<Promo> promos = new ArrayList<Promo>();
        ArrayList<Matiere> matieres = new ArrayList<Matiere>();

        //Creation des matieres / promos / personnes
        {matieres.add(new Matiere("Math"));//0
            matieres.add(new Matiere("Info"));//1
            /*matieres.add(new Matiere("Complexite"));//2
            matieres.add(new Matiere("Aglorithmie"));//3
            matieres.add(new Matiere("Anglais"));//4
            matieres.add(new Matiere("Reseau"));//5
            matieres.add(new Matiere("Optimisation"));//6
            matieres.add(new Matiere("Conception"));//7//*/


            promos.add(new Promo("Master 1", 2012, 2013));
            /*promos.add(new Promo("Master 2", 2012, 2013));
            promos.add(new Promo("Master 1", 2013, 2014));
            promos.add(new Promo("Master 2", 2013, 2014));
            promos.add(new Promo("Master 1", 2014, 2015));
            promos.add(new Promo("Master 2", 2014, 2015));
            promos.add(new Promo("Master 1", 2015, 2016));
            promos.add(new Promo("Master 2", 2015, 2016));
            promos.add(new Promo("Master 1", 2016, 2017));
            promos.add(new Promo("Master 2", 2016, 2017));//*/

            etudiants.add(new Etudiant("DUBOIS", "Thierry", 23));
            etudiants.add(new Etudiant("MARTIN", "Claire", 25));
            /*etudiants.add(new Etudiant("SCHWAB", "Lucas", 22));
            etudiants.add(new Etudiant("LANUEL", "Charlotte", 24));
            etudiants.add(new Etudiant("COUDERC", "Arnaud", 21));
            etudiants.add(new Etudiant("BRANDSTETT", "Tim", 21));
            etudiants.add(new Etudiant("DAVIS", "Liam", 20));
            etudiants.add(new Etudiant("ROMEO", "Florian", 21));
            etudiants.add(new Etudiant("LAFILLE", "Julien", 22));//*/

            intervenants.add(new Intervenant("LEVY", "Jean", 400, matieres.get(1)));
            intervenants.add(new Intervenant("BEDOS", "Martine", 101.25, matieres.get(0)));
            //intervenants.add(new Intervenant("BLANCHET", "Jsaispas", 200, matieres.get(3)));

            //professeurs.add(new Professeur("", "", , matieres.get()));
        }
        //Attributions des personnes aux promos
        {
            for(int i = 0; i < 2; i++){
                promos.get(0).addEtudiant(etudiants.get(i));
            }
            for(int i = 0; i < 2; i++){
                promos.get(0).addEnseignant(intervenants.get(i));
            }
        }
        //Quelques affichages
        {
            System.out.println(promos.get(0).describe());

            System.out.println(matieres.get(0).describe());
            System.out.println(matieres.get(1).describe());
        }
    }
}