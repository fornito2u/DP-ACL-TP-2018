package Saver;
import Annuaire.Annuaire;

import Personne.Personne;

public class ConsoleParser implements Saver{

		@Override
		public boolean save(Annuaire annuaire) {
			for(Personne p : annuaire){
				System.out.println(p.parse(","));
			}

			return true;
		}

}
