package DAO;

import Annuaire.Annuaire;
import Personne.Personne;

import java.io.*;

public class CsvDAO implements ContactDAO {
	private String pathToFile;

	public CsvDAO(String pathToFile){
		config(pathToFile);
	}

	public void config(String pathToFile){
		this.pathToFile = pathToFile;
	}

	@Override
	public boolean save(Annuaire annuaire) {
		try {
			FileWriter writer = new FileWriter(pathToFile);

			String csvSeparator = ",";



			for(Personne p : annuaire){
				writer.append(p.parse(csvSeparator));
				writer.append('\n');
				writer.flush();
			}

			writer.close();
			return true;

		} catch(IOException e) {
		}

		return false;
	}

	@Override
	public boolean load(Annuaire annuaire) {
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
			return true;

		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND CsvDAO.");
		} catch (IOException e) {
			System.out.println("IOException CsvDAO");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {

				}
			}
		}

		return false;
	}
}
