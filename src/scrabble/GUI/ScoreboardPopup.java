/*
*  MyScrabble
*  Copyright (C) 2013  George Piskas
*
*  This program is free software; you can redistribute it and/or modify
*  it under the terms of the GNU General Public License as published by
*  the Free Software Foundation; either version 2 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
*
*  You should have received a copy of the GNU General Public License along
*  with this program; if not, write to the Free Software Foundation, Inc.,
*  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*
*  Contact: geopiskas@gmail.com
*/

package scrabble.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import scrabble.Game;


/**
 * Class that creates the scoreboard popup.
 * 
 * Shows the Scoreboard at the end of the game and ends the application.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class ScoreboardPopup extends JFrame{

	private static final long serialVersionUID = 796421709561661050L;

	private JLabel winner;	
	private JLabel imgL;	
	private JLabel imgR;	
	
	private JPanel winPanel;
	private JPanel gridPanel;
	
	private Border winnerTitle;
	private Border scoreTitle;
	
	private JButton bExit;
	
	
	/**
	 * Scoreboard Constructor.
	 * 
	 * @param thePlayers array of JLabel objects from the main frame
	 */
	public ScoreboardPopup(JLabel[] thePlayers){
		super("ScoreBoard");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(4,4));
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/icon.jpg"));

		int winnerID=0;
		for (int i=0;i<thePlayers.length;i++){
			if(thePlayers[i].getForeground().equals(Color.red)){
				winnerID=i;
				continue;
			}
		}
		winner = new JLabel(thePlayers[winnerID].getName().toUpperCase(), null, JLabel.CENTER);
		winner.setFont(new Font("arial", Font.BOLD, 16));
		
		imgL = new JLabel();
		imgL.setIcon(new ImageIcon("icon/cup.png"));
		imgR = new JLabel();
		imgR.setIcon(new ImageIcon("icon/cup.png"));
		
		winPanel = new JPanel(new BorderLayout(4,4));
		winPanel.add(winner, BorderLayout.CENTER);
		winPanel.add(imgL, BorderLayout.WEST);
		winPanel.add(imgR, BorderLayout.EAST);
		
		winnerTitle = BorderFactory.createRaisedBevelBorder();
		winPanel.setBorder(winnerTitle);
		
		gridPanel = new JPanel(new GridLayout(thePlayers.length+1,2));
		gridPanel.add(new JLabel(Game.getTextBundle().getString("@name")));
		gridPanel.add(new JLabel(Game.getTextBundle().getString("@score")));
		for (int i=0;i<thePlayers.length;i++){
			gridPanel.add(new JLabel(thePlayers[i].getName()));
			gridPanel.add(new JLabel(""+thePlayers[i].getText().substring(thePlayers[i].getName().length()+1)));
		}
		
		scoreTitle = BorderFactory.createEtchedBorder();
		gridPanel.setBorder(scoreTitle);
		
		bExit = new JButton(Game.getTextBundle().getString("@exit"));
		bExit.addActionListener(new ButtonHandler());
		
		add(winPanel, BorderLayout.NORTH);
		add(gridPanel, BorderLayout.CENTER);
		add(bExit ,BorderLayout.SOUTH);
		
		setSize(250,200);
		setResizable(false);
		setVisible(true);
		
	}
	
	/**
	 * A listener class that is used to end the application when the button is pressed.
	 */
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
    }
}
