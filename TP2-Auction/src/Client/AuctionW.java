package Client;

import Server.Auction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuctionW extends Window {
	private JButton StartButton = new JButton("Start");
	private JButton StopButton = new JButton("Stop");


	public AuctionW(Auction auction) {
		super(auction,"Auction");

		StartButton.setEnabled(true);
		StopButton.setEnabled(false);

		buildFrame();
	}

	protected void buildFrame(){
		super.buildBasicFrame();

		panels[3].setLayout(new FlowLayout(FlowLayout.CENTER));
		panels[3].add(StartButton);
		StartButton.addActionListener(new StartListener());

		panels[4].setLayout(new FlowLayout(FlowLayout.CENTER));
		panels[4].add(StopButton);
		StopButton.addActionListener(new StopListener());

		super.endBuildBasicFrame();
	}

	public void Start(){
		StartButton.setEnabled(false);
		StopButton.setEnabled(true);
	}

	public void Stop(){
		StartButton.setEnabled(true);
		StopButton.setEnabled(false);
	}

	class StartListener implements ActionListener {

		public StartListener() {}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Auction Started");

			auction.StartPushed();
		}
	}

	class StopListener implements ActionListener {

		public StopListener() {}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Auction Stopped");

			auction.StopPushed();
		}
	}
}
