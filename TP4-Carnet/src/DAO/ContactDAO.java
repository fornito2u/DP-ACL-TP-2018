package DAO;

import Annuaire.Annuaire;

public interface ContactDAO {

	boolean load(Annuaire annuaire);
	//True si tout c'est bien passe, false si une erreur est arrivee


	boolean save(Annuaire annuaire);//Sauvegarde une liste de personne
	//True si tout c'est bien passe, false si une erreur est arrivee
}
