package MainCarnetAdresse;

import Personne.Personne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainCarnetAdresse {
	public static final String ENDLINE = System.getProperty("line.separator");

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean continuer = true;
		ArrayList<Personne> carnet = new ArrayList<Personne>();
		String input = "";


		while(continuer){
			System.out.println(ENDLINE + ENDLINE + ENDLINE);

			System.out.println("Menu principal, que faire:");
			System.out.println("1) option 1");
			System.out.println("2) option 2");
			System.out.println("3) option 3");
			System.out.println("4) La reponse D");

			try {
				input = br.readLine();

				switch (input) {
					case "a":
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
