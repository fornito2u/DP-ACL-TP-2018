package Client;

import Article.Article;
import Server.Auction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BidderW extends Window {
	private JButton BidButton = new JButton("Bid");
	private JTextField Bid = new JTextField();

	public BidderW(Auction auction) {
		super(auction,"Bidder");

		BidButton.setEnabled(false);
		Bid.setEnabled(false);


		buildFrame();
	}

	protected void buildFrame(){
		super.buildBasicFrame();

		panels[3].setLayout(new FlowLayout(FlowLayout.CENTER));
		panels[3].add(Bid);

		panels[4].setLayout(new FlowLayout(FlowLayout.CENTER));
		panels[4].add(BidButton);
		BidButton.addActionListener(new BidListener());

		Bid.setPreferredSize(new Dimension(50,20));

		super.endBuildBasicFrame();
	}

	public void Start(){
		BidButton.setEnabled(true);
		Bid.setEnabled(true);
	}

	public void Stop(){
		BidButton.setEnabled(false);
		Bid.setEnabled(false);
	}

	@Override
	public void setBid(int bid){
		super.setBid(bid);
		Bid.setText(Integer.toString(bid + 1));
	}

	@Override
	public void setArticle(Article a){
		super.setArticle(a);
		Bid.setText(Integer.toString(a.getBidPrice() + 1));
	}

	class BidListener implements ActionListener {

		public BidListener() {}

		@Override
		public void actionPerformed(ActionEvent e) {
			int theBid = Integer.parseInt(Bid.getText());
			System.out.println("New bid tried " + theBid);

			auction.newBid(theBid);
		}
	}
}
