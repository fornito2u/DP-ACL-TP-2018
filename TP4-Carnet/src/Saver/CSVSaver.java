package Saver;

import Personne.*;

import java.io.FileWriter;
import java.io.IOException;

public class CSVSaver implements Saver{
	private String pathToFile;

	public CSVSaver(String pathToFile){
		config(pathToFile);
	}

	public void config(String pathToFile){
		this.pathToFile = pathToFile;
	}

	@Override
	public boolean save(Contact contact) {
		try {
			FileWriter writer = new FileWriter(pathToFile);

			String csvSeparator = ",";

			for(Personne p : contact){
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
