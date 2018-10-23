package MainCarnetAdresse;

import Personne.Personne;
import Saver.*;
import Annuaire.*;
import Loader.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainCarnetAdresse {
	public static final String ENDLINE = System.getProperty("line.separator");
	//Le \n ne fonctionne pas sur tous les OS, ce line.separator si.

	public static final String CURR_DIR = System.getProperty("user.dir");

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean continuer = true;
		Annuaire annuaire = new Annuaire();
		String input;
		String nom, prenom, adresse;


		ConsoleParser consP = new ConsoleParser();

		CSVSaver csvS = new CSVSaver(CURR_DIR + "/src/Aide/addressbookPERSO.csv");


		ArrayList<Loader> loaders = new ArrayList<Loader>();
		loaders.add(new CSVLoader(CURR_DIR + "/src/Aide/addressbook.csv"));

		for(Loader l : loaders)
			l.load(annuaire);

		while(continuer){
			System.out.println(ENDLINE + ENDLINE + ENDLINE);

			System.out.println("Menu principal, que faire:");
			System.out.println("1) Ajouter un contact");
			System.out.println("2) Afficher la liste");
			System.out.println("3) Enregistrer en CSV");
			System.out.println("4) Enregistrer en BDD");

			try {
				input = br.readLine();

				switch (input) {
					case "1":
						try{
							System.out.println("Nom: ");
							nom = br.readLine();

							System.out.println("Prenom:");
							prenom = br.readLine();

							System.out.println("Adresse:");
							adresse = br.readLine();

							annuaire.add(new Personne(nom, prenom, adresse));


						}catch (IOException e){
							System.out.println("ERREUR D'ENTREE");
						}

						break;

					case "2":
						consP.save(annuaire);
						break;

					case "3":
						csvS.save(annuaire);
						break;

					case "4":
						System.out.println("PAS ENCORE FONCTIONNEL");
						break;

					default:
						continuer = false;
				}
			}catch (IOException e){
				System.out.println("ERREUR D'ENTREE");
			}
		}
	}
}
