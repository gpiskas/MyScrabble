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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import scrabble.Board;
import scrabble.Game;
import scrabble.Letter;
import scrabble.Player;

/**
 * Class that creates the main scrabble window.
 * 
 * Creates the scrabble board and the player's choises.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class ScrabbleWindow extends JFrame{

	private static final long serialVersionUID = 7290905517050727170L;

	private JPanel boardPanel;
	private JPanel mainBottomPanel;
	private JPanel scorePanel;
	private JPanel choisePanel;
	private JPanel choiseTopPanel;
	private JPanel choiseBottomPanel;
	
	private TitledBorder scoreTitle;
	private TitledBorder playerNameTitle;
	private TitledBorder lettersTitle;
		
	private JButton[][] bCells;
	private JButton[] bLetters;
	private JButton bPlay;
	private JButton bChange;
	private JButton bPass;
	private JButton bExit;
		
	private JLabel[] lPlayers;
	
	private JScrollPane scrollBar;
	
	private MouseListener dragListener = new DragMouseAdapter();
	private MouseListener chooseListener = new SelectMouseAdapter();

	private boolean togglePlayButton=false;
	private boolean toggleChangeButton=false;
	private boolean messageFlag=false;
	private int idleTurnCounter=0;
	private int playerNumTurn=0;
	private int boardSize;
	private int nPlayers;
	private Player[] thePlayers;
	
	private ArrayList<Letter> usedLetters = new ArrayList<Letter>();
	private ArrayList<Letter> returnLetters = new ArrayList<Letter>();
	private ArrayList<Point> lettersUndo = new ArrayList<Point>();
	
	
	/**
	 * The constructor of the main frame.
	 * 
	 * Use setTitle() method in a "playable" class in order to change the title of the frame.
	 * 
	 * @param theBoard	the board of the game
	 * @param players	the players in an array
	 */
	public ScrabbleWindow(Board theBoard, Player[] players){
		super("Scrabble");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(4,4));
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/icon.jpg"));
		
		boardSize = theBoard.getSize();
		nPlayers = players.length;
		
		thePlayers = new Player[nPlayers];
		for(int i=0;i<nPlayers;i++){
			thePlayers[i]=players[i];
		}
		
		boardPanel =  new JPanel(new GridLayout(boardSize,boardSize, 4, 4));
		
		bCells = new JButton[boardSize][boardSize];
		for (int i=0;i<boardSize;i++){
			for (int j=0;j<boardSize;j++){
				
				bCells[i][j] = new JButton("");
				int ltrMult = theBoard.getCell(i, j).getLetterMult();
				int wordMult = theBoard.getCell(i, j).getWordMult();
				bCells[i][j].setMargin(new java.awt.Insets(0, 0, 0, 0));
				
				if(boardSize==15){
					bCells[i][j].setFont(new Font("arial", Font.BOLD, 14));
				}
				else{
					bCells[i][j].setFont(new Font("arial", Font.BOLD, 9));
				}
				
				if(ltrMult>0){
					if(ltrMult==2){
						bCells[i][j].setToolTipText(Game.getTextBundle().getString("@ltrMul2"));
						bCells[i][j].setBackground(Color.getHSBColor((float)0.5663717,(float)0.46502057,(float)0.9529412));
						bCells[i][j].setName("02");
					}
					else if(ltrMult==3){
						bCells[i][j].setToolTipText(Game.getTextBundle().getString("@ltrMul3"));
						bCells[i][j].setBackground(Color.getHSBColor((float)0.5503003,(float)1.0,(float)0.87058824));
						bCells[i][j].setName("03");
					}
					else if(ltrMult==4){
						bCells[i][j].setToolTipText(Game.getTextBundle().getString("@ltrMul4"));
						bCells[i][j].setBackground(Color.getHSBColor((float)0.6041667,(float)0.8679245,(float)0.83137256));
						bCells[i][j].setName("04");
					}
				}
				
				if(wordMult>0){
					if(wordMult==2){
						bCells[i][j].setToolTipText(Game.getTextBundle().getString("@wrdMul2"));
						bCells[i][j].setBackground(Color.getHSBColor((float)0.034364264,(float)0.39430895,(float)0.9647059));
						bCells[i][j].setName("21");
					}
					else if(wordMult==3){
						bCells[i][j].setToolTipText(Game.getTextBundle().getString("@wrdMul3"));
						bCells[i][j].setBackground(Color.getHSBColor((float)0.9894822,(float)0.87659574,(float)0.92156863));
						bCells[i][j].setName("31");
					}
					else if(wordMult==4){
						bCells[i][j].setToolTipText(Game.getTextBundle().getString("@wrdMul4"));
						bCells[i][j].setBackground(Color.getHSBColor((float)0.9891599,(float)0.9609375,(float)0.5019608));
						bCells[i][j].setName("41");
					}
				}
				
				if(wordMult==0 && ltrMult==0){
					bCells[i][j].setBackground(Color.getHSBColor((float)0.49549547,(float)0.68013246,(float)0.5921569));
					bCells[i][j].setName("01");
				}
				
				boardPanel.add(bCells[i][j]);	
			} 
		}
		add(boardPanel, BorderLayout.CENTER);
				
		mainBottomPanel =  new JPanel(new BorderLayout());
		
		scorePanel = new JPanel(new GridLayout(nPlayers+1,1));
		scoreTitle = BorderFactory.createTitledBorder(Game.getTextBundle().getString("@score"));
		scorePanel.setBorder(scoreTitle);
		
		lPlayers = new JLabel[nPlayers];
		for (int i=0;i<nPlayers;i++){
			lPlayers[i] = new JLabel(thePlayers[i].getName()+": "+String.format("%5d", players[i].getScore()));
			lPlayers[i].setName(thePlayers[i].getName());
			lPlayers[i].setFont(new Font("arial", Font.PLAIN, 13));
			scorePanel.add(lPlayers[i]);
		}
		bExit = new JButton(Game.getTextBundle().getString("@exit"));
		bExit.addActionListener(new ButtonExitHandler());
		scorePanel.add(bExit);
		
		choisePanel =  new JPanel(new BorderLayout(4,4));
		choiseTopPanel =  new JPanel(new GridLayout(1, 3, 10, 10));
		playerNameTitle = BorderFactory.createTitledBorder( thePlayers[0].getName() + Game.getTextBundle().getString("@turn"));
		playerNameTitle.setTitleColor(Color.BLUE);
		playerNameTitle.setTitleFont(new Font("sansserif", Font.BOLD, 15));
		choiseTopPanel.setBorder(playerNameTitle);
		
		ButtonHandler playerActionListener = new ButtonHandler();
		
		bPlay = new JButton(Game.getTextBundle().getString("@playButton"));
		bPlay.setIcon(new ImageIcon("icon/play.png"));
		bPlay.setName("bPlay");
		bPlay.addActionListener(playerActionListener);
		
		bChange = new JButton(Game.getTextBundle().getString("@changeButton"));
		bChange.setIcon(new ImageIcon("icon/change.png"));
		bChange.setName("bChange");	
		if(!Game.getLetterBag().isEmpty()){
			bChange.addActionListener(playerActionListener);
		}
		else{
			bChange.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Toolkit.getDefaultToolkit().beep();
				}	
			});
		}
			
		bPass = new JButton(Game.getTextBundle().getString("@passButton"));
		bPass.setIcon(new ImageIcon("icon/pass.png"));
		bPass.setName("bPass");
		bPass.addActionListener(playerActionListener);
		
		choiseTopPanel.add(bPlay);
		choiseTopPanel.add(bChange);
		choiseTopPanel.add(bPass);
		choiseBottomPanel =  new JPanel(new FlowLayout());
		
		scrollBar = new JScrollPane(choiseBottomPanel);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		lettersTitle = BorderFactory.createTitledBorder(Game.getTextBundle().getString("@rack"));
		choiseBottomPanel.setBorder(lettersTitle);
		
		int tempRackSize = thePlayers[0].getRack().getContainer().size();
		bLetters = new JButton[tempRackSize];
		for(int i=0;i<tempRackSize;i++){
			char theChar = thePlayers[0].getRack().getContainer().get(i).getLetter();
			int thePoints =  thePlayers[0].getRack().getContainer().get(i).getPoints();			
			bLetters[i] = new JButton(theChar+" | "+thePoints);
			bLetters[i].setEnabled(false);
			bLetters[i].addMouseListener(dragListener);
			bLetters[i].setMargin(new java.awt.Insets(0, 0, 0, 0));
			choiseBottomPanel.add(bLetters[i]);
		}
				
		choisePanel.add(choiseTopPanel, BorderLayout.CENTER);
		choisePanel.add(scrollBar, BorderLayout.SOUTH);
		mainBottomPanel.add(scorePanel, BorderLayout.WEST);
		mainBottomPanel.add(choisePanel, BorderLayout.CENTER);
		add(mainBottomPanel, BorderLayout.SOUTH);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		if(dim.height>1000){
			setSize(807,950);
		}
		else{
			setSize(807,750);
		}
		setResizable(true);
	}

	/**
	 * Play Letters action.
	 */
	
	public void setPlayButtonState() {
		if(togglePlayButton==false){
			bPlay.setText(Game.getTextBundle().getString("@playButtonState"));
			bPlay.setEnabled(false);
			bPass.setEnabled(false);
			bChange.setEnabled(false);
			
			for(int i=0;i<bLetters.length;i++){
				bLetters[i].setEnabled(true);
				bLetters[i].setToolTipText(Game.getTextBundle().getString("@DnD"));
			}
			
		}
		else{
			bPlay.setText(Game.getTextBundle().getString("@playButton"));
			bPass.setEnabled(true);
			bChange.setEnabled(true);
			//play process
			int result = thePlayers[playerNumTurn].actPlayLetters(usedLetters); 
			if(Game.getLetterBag().isEmpty()){
				if(!messageFlag){
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(boardPanel, Game.getTextBundle().getString("@bagEmpty"), Game.getTextBundle().getString("@bagEmptyTitle"), JOptionPane.WARNING_MESSAGE);
					bChange.setEnabled(false);
					messageFlag=true;
				}
			}
			if(result==-1){
				for (int i=0;i<lettersUndo.size();i++){
					bCells[lettersUndo.get(i).x][lettersUndo.get(i).y].setText("");					
				}
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(boardPanel, Game.getTextBundle().getString("@turnLost"), Game.getTextBundle().getString("@turnLostTitle"), JOptionPane.WARNING_MESSAGE);
				++idleTurnCounter;
				if(idleTurnCounter==nPlayers*2){
					endGame(0);
				}
			}		
			else{
				idleTurnCounter=0;
				thePlayers[playerNumTurn].addToScore(calculatePoints());
				if(result==1){
					JOptionPane.showMessageDialog(boardPanel, Game.getTextBundle().getString("@xtr50Pts"), Game.getTextBundle().getString("@xtr50PtsTitle"), JOptionPane.INFORMATION_MESSAGE);
				}
			}	
			updateScorePanel();
			usedLetters.clear();
			lettersUndo.clear();
			nextPlayer();
		}		
		togglePlayButton=!togglePlayButton;
	}
	
	/**
	 * Change Letters action.
	 */
	
	public void setChangeButtonState() {
		if(toggleChangeButton==false){
			bChange.setText(Game.getTextBundle().getString("@changeButtonState"));
			bPlay.setEnabled(false);
			bPass.setEnabled(false);
			bChange.setEnabled(false);
			for(int i=0;i<bLetters.length;i++){
				bLetters[i].setEnabled(true);
				bLetters[i].setToolTipText(Game.getTextBundle().getString("@ChL"));
				bLetters[i].removeMouseListener(dragListener);
				bLetters[i].addMouseListener(chooseListener);		//change the listener to choise
			}
		}
		else{
			bChange.setText(Game.getTextBundle().getString("@changeButton"));
			bPlay.setEnabled(true);
			bPass.setEnabled(true);
			thePlayers[playerNumTurn].actChangeLetters(returnLetters);
			returnLetters.clear();
			nextPlayer();
			for(int i=0;i<bLetters.length;i++){
				bLetters[i].setEnabled(false);
				bLetters[i].removeMouseListener(chooseListener);
				bLetters[i].addMouseListener(dragListener);		//change the listener to drag
			}
		}

		toggleChangeButton=!toggleChangeButton;
	}
	
	/**
	 * Pass action.
	 */
	
	public void setPassButtonState() {
		int result=JOptionPane.showConfirmDialog(boardPanel,Game.getTextBundle().getString("@passDialog"), Game.getTextBundle().getString("@passDialogTitle"), JOptionPane.YES_NO_OPTION);
		if(result==0){
			thePlayers[playerNumTurn].actPass(); 
			nextPlayer();
			++idleTurnCounter;
			if(idleTurnCounter==nPlayers*2){
				endGame(0);
			}
		}
	}
	
	/**
	 * Updates the score labels and sets the current winner to red color.
	 * If the game is minimum scrabble, the player with the less points wins (and is red).
	 */
	private void updateScorePanel() {
		//update label text
		for (int i=0;i<nPlayers;i++){
			lPlayers[i].setText((thePlayers[i].getName()+": "+String.format("%5d", thePlayers[i].getScore())));
		}
		
		//findmax, or findmin if minimum scrabble.
		int tempWin=thePlayers[0].getScore();
		int iWin=0;
		if(getTitle().equals("Minimum Scrabble")){
			for (int i=0;i<lPlayers.length;i++){
				if(thePlayers[i].getScore()<tempWin){
					tempWin=thePlayers[i].getScore();
					iWin=i;
				}
			}
			lPlayers[iWin].setForeground(Color.RED);
			lPlayers[iWin].setFont(new Font("arial", Font.BOLD, 13));
		}
		else{
			for (int i=0;i<lPlayers.length;i++){
				if(thePlayers[i].getScore()>tempWin){
					tempWin=thePlayers[i].getScore();
					iWin=i;
				}
			}
			lPlayers[iWin].setForeground(Color.RED);
			lPlayers[iWin].setFont(new Font("arial", Font.BOLD, 13));
		}
		
		//update label font and color
		for (int i=0;i<nPlayers;i++){
			if(i!=iWin){
				lPlayers[i].setFont(new Font("arial", Font.PLAIN, 13));
				lPlayers[i].setForeground(Color.BLACK);
			}
		}
	}

	/**
	 * Calculates the points a player won and returns them.
	 * 
	 * Calculation is done according to the classic scrabble default rules. <br>
	 * Word multiplyers are unique and are counted only once. <br>
	 * Calculates neighbouring words in a smart way using x,y coordinates.
	 * 
	 * @return the points a player won
	 */
	private int calculatePoints() {
		int totalScore=0;
		int wordTotalMult=0;
		//finding all word multiplyers only for newly placed letters
		for (int i=0;i<lettersUndo.size();i++){
			wordTotalMult = wordTotalMult + Character.getNumericValue((bCells[lettersUndo.get(i).x][lettersUndo.get(i).y].getName().charAt(0)));	
		}
		if (wordTotalMult==0){
			wordTotalMult=1;
		}
		
		//finding all letter multiplyers and applying them
		ArrayList<Point> ltrsToEvaluate = new ArrayList<Point>();
		int orientation=getWordOrientation(lettersUndo);
		Point first=getFirstLetterPoint(orientation,lettersUndo);
		Point last=getLastLetterPoint(orientation,lettersUndo);
		ltrsToEvaluate.add(first);
		if(lettersUndo.size()>1){
			ltrsToEvaluate.add(last);
		}
		if(orientation==1){
			int yPos=first.y;
			//adding mid letters
			for(int i=(first.x+1);i<last.x;i++){
				ltrsToEvaluate.add(new Point(i,yPos));
			}
			//check top for more letters
			int tempTopX=(first.x-1);
			while(tempTopX>=0 && !bCells[tempTopX][yPos].getText().equals("")){
				ltrsToEvaluate.add(new Point(tempTopX,yPos));
				tempTopX--;
			}
			//check bot for more letters
			int tempBotX=(last.x+1);
			while(tempBotX<boardSize && !bCells[tempBotX][yPos].getText().equals("")){
				ltrsToEvaluate.add(new Point(tempBotX,yPos));
				tempBotX++;
			}
		}
		else{
			int xPos=first.x;
			//adding mid letters
			for(int i=(first.y+1);i<last.y;i++){
				ltrsToEvaluate.add(new Point(xPos,i));
			}
			//check left for more letters
			int tempLeftY=(first.y-1);
			while(tempLeftY>=0 && !bCells[xPos][tempLeftY].getText().equals("")){
				ltrsToEvaluate.add(new Point(xPos,tempLeftY));
				tempLeftY--;
			}
			//check right for more letters
			int tempRightY=(last.y+1);
			while(tempRightY<boardSize && !bCells[xPos][tempRightY].getText().equals("")){
				ltrsToEvaluate.add(new Point(xPos,tempRightY));
				tempRightY++;
			}
		}
		
		for (int i=0;i<ltrsToEvaluate.size();i++){
			int ltrMult = Character.getNumericValue((bCells[ltrsToEvaluate.get(i).x][ltrsToEvaluate.get(i).y].getName().charAt(1)));
			int ltrPts = Integer.parseInt((bCells[ltrsToEvaluate.get(i).x][ltrsToEvaluate.get(i).y].getText().substring(4))); //4+ is points spot
			totalScore = totalScore + (ltrPts * ltrMult);
		}
		return totalScore*wordTotalMult;
	}

	/**
	 * Finds and returns the first letter position from the word the user played.
	 * 
	 * @param orientation the orientation of the word (0 horisontal, 1 vertical)
	 * @param ltrs the letters that were used to make the word
	 * @return the point where the first letter of the word is placed
	 */
	private Point getFirstLetterPoint(int orientation, ArrayList<Point> ltrs) {
		if(orientation==1){
			double xMin=ltrs.get(0).getX();
			int iXMin=0;
			for(int i=0;i<ltrs.size();i++){
				if(ltrs.get(i).getX()<xMin){
					iXMin=i;
				}
			}
			return ltrs.get(iXMin).getLocation();	
		}
		else{
			double yMin=ltrs.get(0).getY();
			int iYMin=0;
			for(int i=0;i<ltrs.size();i++){
				if(ltrs.get(i).getY()<yMin){
					iYMin=i;
				}
			}
			return ltrs.get(iYMin).getLocation();
		}
	}

	/**
	 * Finds and returns the last letter position from the word the user played.
	 * 
	 * @param orientation the orientation of the word (0 horisontal, 1 vertical)
	 * @param ltrs the letters that were used to make the word
	 * @return the point where the last letter of the word is placed
	 */
	private Point getLastLetterPoint(int orientation, ArrayList<Point> ltrs) {
		if(orientation==1){
			double xMax=ltrs.get(0).getX();
			int iXMax=0;
			for(int i=0;i<ltrs.size();i++){
				if(ltrs.get(i).getX()>xMax){
					iXMax=i;
				}
			}
			return ltrs.get(iXMax).getLocation();	
		}
		else{
			double yMax=ltrs.get(0).getY();
			int iYMax=0;
			for(int i=0;i<ltrs.size();i++){
				if(ltrs.get(i).getY()>yMax){
					iYMax=i;
				}
			}
			return ltrs.get(iYMax).getLocation();
		}
	}
	
	/**
	 * Finds and returns the orientation of the word on the board.
	 * If the word consists of a single letter, there is a popup dialogue which asks the user for the orientation.
	 * 
	 * @param ltrs the letters that were used to make the word
	 * @return 0 for horisontal word, 1 for vertical word
	 */
	private int getWordOrientation(ArrayList<Point> ltrs) {
		if(ltrs.size()>1){
			double x0 = ltrs.get(0).getX();
			double x1 = ltrs.get(1).getX();
			if(x0==x1){
				return 0;	//horisontal word
			}
			else{
				return 1;	//vertical word
			}
		}
		else{
			Object[] selections={Game.getTextBundle().getString("@orientationH"),Game.getTextBundle().getString("@orientationV")};
			String orientation= (String) JOptionPane.showInputDialog(boardPanel, Game.getTextBundle().getString("@orientation"),
					Game.getTextBundle().getString("@orientationTitle"), JOptionPane.QUESTION_MESSAGE, null, selections, selections[0]);
					
			if(orientation.equals(Game.getTextBundle().getString("@orientationH"))){
				return 0; //horisontal word
			}
			else{
				return 1; //vertical word
			}
		}
	}
	
	/**
	 * Does all the necessary changes to set up the GUI for the next player.
	 */
	private void nextPlayer(){

		//number of next player
		if(playerNumTurn==nPlayers-1){
			playerNumTurn=0;
		}
		else{
			playerNumTurn=playerNumTurn+1;
		}
		//titlos for next player
		playerNameTitle = BorderFactory.createTitledBorder( thePlayers[playerNumTurn].getName() + Game.getTextBundle().getString("@turn"));
		playerNameTitle.setTitleColor(Color.BLUE);
		playerNameTitle.setTitleFont(new Font("sansserif", Font.BOLD, 15));
		choiseTopPanel.setBorder(playerNameTitle);
		//his letter rack
		for(int i=0;i<bLetters.length;i++){
			bLetters[i].setVisible(false);
		}
		
		int letterAmount=thePlayers[playerNumTurn].getRack().getLetterAmount();
		if(letterAmount==0){
			endGame(1);
		}
		else{
			for(int i=0;i<letterAmount;i++){			
				char theChar = thePlayers[playerNumTurn].getRack().getContainer().get(i).getLetter();
				int thePoints =  thePlayers[playerNumTurn].getRack().getContainer().get(i).getPoints();			
				bLetters[i].setText(theChar+" | "+thePoints);
				bLetters[i].setVisible(true);
				bLetters[i].setEnabled(false);
				bLetters[i].setToolTipText("");
			}
		}
	}
	
	/**
	 * Ends the game with the specified way.
	 * 
	 * @param param 0 ended by idle players, 1 ended by empty rack AND bag, 2 ended by exit button
	 */
	private void endGame(int param) {
		for (int i=0;i<boardSize;i++){
    		for (int j=0;j<boardSize;j++){   
    			bCells[i][j].setEnabled(false);
    		}
		}
		bChange.setEnabled(false);
		bPlay.setEnabled(false);
		bPass.setEnabled(false);
		bExit.setEnabled(false);
		for(int i=0;i<bLetters.length;i++){
			bLetters[i].setVisible(false);
			bLetters[i].setEnabled(false);
		}
		if(param==0){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(boardPanel, Game.getTextBundle().getString("@endGame0"), Game.getTextBundle().getString("@endGameTitle"), JOptionPane.INFORMATION_MESSAGE);
		}
		else if(param==1){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(boardPanel, Game.getTextBundle().getString("@endGame1"), Game.getTextBundle().getString("@endGameTitle"), JOptionPane.INFORMATION_MESSAGE);
		}
		setEnabled(false);
		new ScoreboardPopup(lPlayers);
	}

	/**
	 * Class that is used to control the drag and drop function of the letters on the board.
	 * It uses x and y coordinates where the mouse was released to define where the letter will be placed.
	 * Creates error popups if the release happened outside a cell, or on an occupied cell.
	 * 
	 */
	private class DragMouseAdapter extends MouseAdapter {
		
		@Override
        public void mouseReleased(MouseEvent e) {
			
            JButton c = (JButton) e.getSource();
            
            if (c.isEnabled()){
            	
            	//Validate cell spot on the board
            	StringBuilder temp = new StringBuilder();
            	boolean isCell = false;
            	int ii=0,jj=0;
            	int xPos=e.getLocationOnScreen().x;
            	int yPos=e.getLocationOnScreen().y;
            	Dimension theDim = bCells[0][0].getSize();
            	int xSize=theDim.height;
            	int ySize=theDim.width;
            	for (int i=0;i<boardSize;i++){
            		for (int j=0;j<boardSize;j++){   
            			int xScrn=bCells[i][j].getLocationOnScreen().x;
            			int yScrn=bCells[i][j].getLocationOnScreen().y;
            			if(((xPos>xScrn+2) && (xPos<xScrn+xSize-2)) && ((yPos>yScrn+2) && (yPos<yScrn+ySize-2))){
            				temp.append(bCells[i][j].getText());
            				ii=i;
            				jj=j;
            				isCell = true;
            				continue;
            			}
            		}
            	}
            	if(temp.toString().equals("") && isCell){
            		bCells[ii][jj].setText(c.getText());
            		bPlay.setEnabled(true);
            		c.setEnabled(false);
            		usedLetters.add(new Letter(c.getText().charAt(0)));
            		lettersUndo.add(new Point(ii,jj));
            	}
            	else if(isCell==false){
            		Toolkit.getDefaultToolkit().beep();
            		JOptionPane.showMessageDialog(boardPanel, Game.getTextBundle().getString("@wrnNotCell"), Game.getTextBundle().getString("@wrnNotCellTitle"), JOptionPane.WARNING_MESSAGE);
            	}
            	else{
            		Toolkit.getDefaultToolkit().beep();
            		JOptionPane.showMessageDialog(boardPanel, Game.getTextBundle().getString("@wrnLtrExist"), Game.getTextBundle().getString("@wrnLtrExistTitle"), JOptionPane.WARNING_MESSAGE);
            	}
            }
        }
    }
	
	/**
	 * Class that is used to control the selection of letters. The player chooses by clicking.
	 */
	private class SelectMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			JButton c = (JButton) e.getSource();
			if(c.isEnabled()){
				bChange.setEnabled(true);
				returnLetters.add(new Letter(c.getText().charAt(0)));
				c.setEnabled(false);
			}
		}
	}
	
	/**
	 * Class that is used to control the actions of the three main function buttons.
	 * Play, Change, Pass.
	 */
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton c = (JButton) e.getSource();
			String cName = c.getName();
			if (cName.equals("bPlay")){ 
				setPlayButtonState();	
			}
			else if (cName.equals("bChange")){
				setChangeButtonState();
				
			}
			else if (cName.equals("bPass")){
				setPassButtonState();
			}	
		}
    }
	
	/**
	 * Class that is used to control the actionof exit button.
	 */
	private class ButtonExitHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Toolkit.getDefaultToolkit().beep();
			int result = JOptionPane.showConfirmDialog(boardPanel,Game.getTextBundle().getString("@exitDialog"), Game.getTextBundle().getString("@exitDialogTitle"), JOptionPane.YES_NO_OPTION);
			if(result==0){
				endGame(2);
			}
		}
    }
	
}