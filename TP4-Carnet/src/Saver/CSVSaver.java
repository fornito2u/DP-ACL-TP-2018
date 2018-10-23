package Saver;

import Annuaire.Annuaire;

import java.io.FileWriter;
import java.io.IOException;

import Personne.Personne;

public class CSVSaver implements Saver{
	private String pathToFile;

	public CSVSaver(String pathToFile){
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

		} catch(IOException e) {
			return false;
		}

		return true;
	}
}
