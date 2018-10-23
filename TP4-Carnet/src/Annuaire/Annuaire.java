package Annuaire;

import Personne.Personne;

import java.util.ArrayList;
import java.util.Iterator;

public class Annuaire implements Iterable<Personne> {
	
	ArrayList<Personne> personnes = new ArrayList<Personne>();
	
	public Annuaire() {
		
	}

	public void add(Personne p){
		personnes.add(p);
	}

	@Override
	public Iterator<Personne> iterator() {
		return new AnnuaireIterator(this);
	}

}
