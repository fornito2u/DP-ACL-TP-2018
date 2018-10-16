package Article;

public class SimpleArticle extends Article {
	private int basicPrice;
	private String name;

	public SimpleArticle(String name, int basicPrice){
		this.name = name;
		this.basicPrice = basicPrice;
	}

	@Override
	public String getName() {
		return name;
	}

	public int getBasicPrice(){return basicPrice;}

	@Override
	public int getNbPiece() {
		return 1;
	}
}
