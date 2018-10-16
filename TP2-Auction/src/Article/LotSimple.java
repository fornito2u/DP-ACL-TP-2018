package Article;

import java.util.LinkedList;

public class LotSimple extends Article {
	private String name;
	private LinkedList<Article> composants = new LinkedList<Article>();

	public LotSimple(String name){
		this.name = name;
	}

	public void addComposant(Article c){
		composants.add(c);
	}

	@Override
	public String getName() {
		/*String res = name + " ( ";
		for(Article a : composants)
			res += a.getName();
		res += " ) ";
		return res;//*/

		String res = name;

		if(composants.size() > 0){
			res += "( " + composants.get(0);

			for(int i = 1; i < composants.size(); i++)
				res += ", " + composants.get(1);

			res += " )";
		}

		return res;

	}

	public int getBasicPrice(){
		int res = 0;

		for(Article a : composants)
			res += a.getBasicPrice();

		return res;
	}

	@Override
	public int getNbPiece() {
		int res = 1;

		for(Article a : composants)
			res += a.getNbPiece();

		return res;
	}
}
