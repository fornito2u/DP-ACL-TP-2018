package MainCarnetAdresse;

import DAO.ConsoleDAO;
import DAO.ContactDAO;
import DAO.CsvDAO;
import Personne.Personne;
import Annuaire.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainCarnetAdresse {
	public static final String ENDLINE = System.getProperty("line.separator");
	//Le \n ne fonctionne pas sur tous les OS, ce line.separator si.

	public static String CURR_DIR = System.getProperty("user.dir");

	public static void main(String[] args) {
		{
			char[] tmp = new char[10];
			char[] target = {'T','P','4','-','C','a','r','n','e','t'};

			CURR_DIR.getChars(CURR_DIR.length()-10, CURR_DIR.length(), tmp, 0);

			for(int i = 0; i < 10; i++){
				if(tmp[i] != target[i]){
					CURR_DIR+="/TP4-Carnet";
					i = 11;
				}
			}

		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean continuer = true;
		Annuaire annuaire = new Annuaire();
		String input;
		String nom, prenom, adresse;

		ArrayList<ContactDAO> daos = new ArrayList<ContactDAO>();

		ConsoleDAO Console = new ConsoleDAO();
		daos.add(Console);
		CsvDAO Csv = new CsvDAO(CURR_DIR + "/src/Aide/addressbook.csv");
		daos.add(Csv);

		while(continuer){
			System.out.println(ENDLINE + ENDLINE + ENDLINE);

			System.out.println("Menu principal, que faire:");
			System.out.println("1) Ajouter un contact");
			System.out.println("2) Afficher la liste");
			System.out.println("3) Enregistrer en CSV");
			System.out.println("4) Enregistrer en BDD");
			System.out.println("5) Charger avec tous les DAO");

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
						Console.save(annuaire);
						break;

					case "3":
						Csv.save(annuaire);
						break;

					case "4":
						System.out.println("PAS ENCORE FONCTIONNEL");
						break;

					case "5":
						for(ContactDAO dao : daos)
							dao.load(annuaire);
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
