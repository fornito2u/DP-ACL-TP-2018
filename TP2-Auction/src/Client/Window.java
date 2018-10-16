package Client;

import Article.Article;
import Server.Auction;

import javax.swing.*;
import java.awt.*;

public abstract class Window {
	private JFrame frame;
	protected JPanel[] panels = new JPanel[5];
	private JLabel[] txt = new JLabel[3];

	JPanel contentPane;

	Auction auction;

	public Window(Auction auction, String nom){
		this.auction = auction;
		frame = new JFrame(nom);

		for(int i = 0; i < panels.length; i++)
			panels[i] = new JPanel();

		txt[0] = new JLabel("Wrong");
		txt[1] = new JLabel("Create using");
		txt[2] = new JLabel("Auction.newWindow");

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = (JPanel) frame.getContentPane();
	}

	protected abstract void buildFrame();

	protected void buildBasicFrame(){
		panels[0].setLayout(new FlowLayout(FlowLayout.CENTER));
		panels[0].add(txt[0]);

		panels[1].setLayout(new FlowLayout(FlowLayout.CENTER));
		panels[1].add(txt[1]);

		panels[2].setLayout(new FlowLayout(FlowLayout.CENTER));
		panels[2].add(txt[2]);
	}

	protected void endBuildBasicFrame(){
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		for (JPanel jPanel : panels) {
			contentPane.add(jPanel);
		}

		frame.pack();
		frame.setVisible(true);

		frame.setSize(300,200);
	}

	public void setArticle(Article a){
		txt[0].setText("Article: " + a.getName());
		txt[1].setText("Price: " + Integer.toString(a.getBasicPrice()));
		txt[2].setText("Last Bid: " + Integer.toString(a.getBidPrice()));

		int max = 300;
		for(int i = 0; i < 3; i++){
			max = (max > txt[i].getWidth() ? max : txt[i].getWidth());
		}
		frame.setSize(max,200);
	}

	public void setBid(int bid){
		txt[2].setText("Last Bid: " + Integer.toString(bid));
	}

	public abstract void Start();
	public abstract void Stop();
}
