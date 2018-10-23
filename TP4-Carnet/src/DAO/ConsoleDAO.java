package DAO;

import Annuaire.Annuaire;
import Personne.Personne;

public class ConsoleDAO implements ContactDAO {

	@Override
	public boolean load(Annuaire annuaire) {
		return false;
	}

	@Override
	public boolean save(Annuaire annuaire) {
		for(Personne p : annuaire){
			System.out.println(p.parse(","));
		}

		return true;
	}
}
