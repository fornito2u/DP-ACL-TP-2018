package Annuaire;

import Personne.Personne;

import java.util.Iterator;

public class AnnuaireIterator implements Iterator<Personne> {
	private Annuaire ann;
	private int i = -1;

	public AnnuaireIterator(Annuaire annuaire){
		ann = annuaire;
	}


	@Override
	public boolean hasNext() {
		return ann.personnes.size() > i;
		//On verifie s'il y as un suivant
	}

	@Override
	public Personne next() {
		return ann.personnes.get(++i);
		//On incremente AVANT (++i et pas i++) pour prendre le suivant
	}
}
