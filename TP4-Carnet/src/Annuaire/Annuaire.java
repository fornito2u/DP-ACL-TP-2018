package Annuaire;

import Personne.Personne;

import java.util.ArrayList;
import java.util.Iterator;

public class Annuaire implements Iterable<Personne> {
	
	ArrayList<Personne> personnes;
	
	public Annuaire() {
		
	}

	@Override
	public Iterator<Personne> iterator() {
		return new AnnuaireIterator(this);
	}

}
