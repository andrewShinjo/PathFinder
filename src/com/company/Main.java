package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
	    JFrame f = new JFrame("Path Finder");
	    f.setLayout(new BorderLayout());

	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(1,0));
	    JButton DFSButton = new JButton("DFS");
	    JButton BFSButton = new JButton("BFS");
	    JButton AStarButton = new JButton("A*");
	    JButton setStartButton = new JButton("Set Start Location");
	    JButton setFinishButton = new JButton("Set Finish Location");
	    JButton addWallButton = new JButton("Add Wall");

	    buttonPanel.add(DFSButton);
	    buttonPanel.add(BFSButton);
	    buttonPanel.add(AStarButton);
	    buttonPanel.add(setStartButton);
	    buttonPanel.add(setFinishButton);
	    buttonPanel.add(addWallButton);
	    Board panel = new Board();

		DFSButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setState(State.DFS);
			}
		});
		BFSButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setState(State.BFS);
			}
		});
		AStarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setState(State.ASTAR);
			}
		});
		setStartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setState(State.SET_START);
			}
		});
		setFinishButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setState(State.SET_FINISH);
			}
		});
		addWallButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setState(State.ADD_WALL);
			}
		});

	    f.add(panel, BorderLayout.CENTER);
	    f.add(buttonPanel, BorderLayout.SOUTH);



	    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
    }
}
