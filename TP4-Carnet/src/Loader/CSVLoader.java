package Loader;

import Annuaire.Annuaire;
import Personne.Personne;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVLoader implements Loader {
	private String pathToFile;

	public CSVLoader(String pathToFile){
		this.pathToFile = pathToFile;
	}


	@Override
	public void load(Annuaire annuaire) {
		BufferedReader br = null;
		String line;

		//séparateur du CSV
		String csvSeparator = ",";

		System.out.println("CSV Loader");

		try {
			br = new BufferedReader(new FileReader(pathToFile));
			int i=0;
			//on boucle sur chaque ligne du fichier

			while ((line = br.readLine()) != null) {
				i++;


				// on récupère la ligne que l'on découpe en fonction du séparateur, on
				// obtient un tableau de chaînes de caractères (pour chaque ligne)
				String[] contacts = line.split(csvSeparator);


				//Affichage dans la foulée pour montrer le résultat
				System.out.println("Contact #"+i+" : " + contacts[1] + " " + contacts[0] + " (" + contacts[2]+ ")");

				annuaire.add(new Personne(contacts[0],contacts[1],contacts[2]));
				// on aurait pu stocker les informations dans une autre structure de
				// données un peu plus optimale, bien évidemment (List, Map, etc.)
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done.");
	}
}
