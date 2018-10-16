package Main;

import Article.*;
import Server.Auction;

import java.util.LinkedList;

public class MainAuction {
	public static void main (String[] args){
		Article DD = new SimpleArticle("Disque Dur", 80);
		Article RAM = new SimpleArticle("RAM x8Go", 120);
		Article CM = new SimpleArticle("Carte mère", 150);
		LotSimple PC = new LotSimple("Ordinateur");
		PC.addComposant(CM);
		PC.addComposant(RAM);
		PC.addComposant(DD);

		LinkedList<Auction> auctions = new LinkedList<>();
		//auctions.add(new Auction(DD));
		//auctions.add(new Auction(RAM));
		//auctions.add(new Auction(CM));
		auctions.add(new Auction(PC));

		for ( Auction a : auctions ) {
			a.getNewAucWindow();
			a.getNewBidWindow();
			a.getNewBidWindow();
		}
	}
}
