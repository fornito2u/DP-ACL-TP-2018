package Server;

import Article.Article;
import Client.AuctionW;
import Client.BidderW;
import Client.Window;

import java.util.LinkedList;
import java.util.List;

public class Auction {
	Article article;
	List<Window> windows = new LinkedList<Window>();

	public Auction(Article article){
		this.article = article;
	}

	public void StartPushed(){
		for (Window w : windows) {
			w.Start();
		}
	}

	public void StopPushed(){
		for (Window w : windows) {
			w.Stop();
		}
	}

	public void newBid(int bid){
		if(bid > article.getBidPrice()){
			article.setBidPrice(bid);
			for (Window w : windows) {
				w.setBid(bid);
			}
		}
	}

	public void setNewArticle(Article a){
		StopPushed();
		this.article = a;
		for (Window w : windows){
			w.setArticle(a);
		}
	}

	public BidderW getNewBidWindow(){
		BidderW res = new BidderW(this);
		windows.add(res);
		res.setArticle(article);
		return res;
	}

	public AuctionW getNewAucWindow(){
		AuctionW res = new AuctionW(this);
		windows.add(res);
		res.setArticle(article);
		return res;
	}
}
