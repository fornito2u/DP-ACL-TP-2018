package Article;

public abstract class Article {
	private int bidPrice = 0;

	public abstract String getName();

	public abstract int getBasicPrice();

	public abstract int getNbPiece();

	public int getBidPrice(){return bidPrice;}

	public void setBidPrice(int n){bidPrice = n;}

	public String toString(){
		int nb = getNbPiece();
		return getName() + " : " + nb + (nb > 1 ? " pièces" : " pièce");
	}
}
