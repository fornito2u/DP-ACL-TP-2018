package Saver;

import Annuaire.Annuaire;

public interface Saver {
	boolean save(Annuaire annuaire);//Sauvegarde une liste de personne
	//True si tout c'est bien passe, false si une erreur est arrivee
}
