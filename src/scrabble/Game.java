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

package scrabble;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import scrabble.GUI.LocalizationPopup;

/**
 * Class that represents a game of scrabble.
 * 
 * This abstract class is meant to be extended in order to create variations of scrabble games.
 * 
 * @author George Piskas
 * @version 1.0
 */
public abstract class Game {
	//all locales avaliable. Add locale names here if you created new localizations.
	public static final String[] ALL_LOCALES={"en","el"};
	
	private static ResourceBundle textBundle;
	private static Locale myLocale;
	private static String dstBdl;
	private static String ptsBdl;
	private static String albBdl;
	
	protected static LetterBag bag;
	protected static Player[] player;
	protected static int numOfplayers;
	protected static Board board;
	

	/**
	 * The constructor of a scrabble Game. 
	 * 
	 * @param boardSize the size of the board
	 * @param rackSize the size of a player's rack. If 0, then letters are distributed evenly to all players till bag empty
	 * @param locale the language selection
	 * @param dstBdlPath path for the AlphabetDistribution bundle
	 * @param ptsBdlPath path for the AlphabetPoints bundle
	 * @param albBdlPath path for the Alphabet bundle
	 */
	public Game(int boardSize,int rackSize, Locale locale, String dstBdlPath,String ptsBdlPath,String albBdlPath) {
		textBundle = ResourceBundle.getBundle("scrabble.localization.Localization", locale);
		myLocale = new Locale(locale.getLanguage());
		
		dstBdl = new String(dstBdlPath);
		ptsBdl = new String(ptsBdlPath);
		albBdl = new String(albBdlPath);
			
		bag = new LetterBag();
		board = new Board(boardSize); 
		
		playerNumberPopup();
		player = new Player[numOfplayers];
		
		if(rackSize==0){
			rackSize = bag.getLetterAmount() / numOfplayers;
		}
		playerNamesPopup(numOfplayers, rackSize);
	}
	
	/**
	 * The abstract method that starts the game and the main frame if properly overrided.
	 * 
	 */
	protected abstract void play();

	/**
	 * Generates a popup dialogue, where the user must choose a language from the give choises.
	 * 
	 * @return the two character code of the language selected
	 */
	public static String getLocalePopup(){
		LocalizationPopup popup = new LocalizationPopup();
		return popup.getSelection();		
	}
	
	/**
	 * Generates a popup that asks for the number of players. Valid numbers are 2,3 or 4 players. 
	 */
	private void playerNumberPopup(){
		Object[] selections={2,3,4};
		numOfplayers=(Integer) (JOptionPane.showInputDialog(null, textBundle.getString("@numberOfPlayers"), textBundle.getString("@numberOfPlayersTitle"), JOptionPane.QUESTION_MESSAGE, null, selections, 2));
	}
	
	/**
	 * Generates a popup that asks for the player names and creates the player objects with the given rackSize.
	 * 
	 * @param numOfPlayers the number of players
	 * @param rackSize the size of a player's rack
	 */
	private void playerNamesPopup(int numOfPlayers, int rackSize){
		for (int i=0;i<numOfPlayers;i++){
			player[i]= new Player(JOptionPane.showInputDialog(null,textBundle.getString("@playerName")+ (i+1) +":", textBundle.getString("@playerNameTitle"), JOptionPane.QUESTION_MESSAGE),rackSize);
			if(player[i].getName().equals("")){
				player[i].setName(textBundle.getString("@defaultPlayerName")+(i+1));
			}
		}
	}
	
	/**
	 * Generates a popup that asks the user if he approves the word the previous player played on the board.
	 * 
	 * @return 0 if the word is approved, 1 if not.
	 */
	public static int wordApprovalPopup() {
		int rtrn = JOptionPane.showConfirmDialog(null, textBundle.getString("@wordQuest"), textBundle.getString("@wordTitle"), JOptionPane.YES_NO_OPTION);
		return rtrn; 
	}
	
	/**
	 * Returns the locale the user set in the beggining.
	 * 
	 * @return the locale of the game
	 */
	public static Locale getLocale(){
		return myLocale;
	}
	
	/**
	 * Returns the path of the AlphabetDistribution Bundle.
	 * 
	 * @return the path of the AlphabetDistribution Bundle
	 */
	public static String getAlphabetDistributionBundle(){
		return dstBdl;
	}
	
	/**
	 * Returns the path of the AlphabetPoints Bundle.
	 * 
	 * @return the path of the AlphabetPoints Bundle
	 */
	public static String getAlphabetPointsBundle(){
		return ptsBdl;
	}
	
	/**
	 * Returns the path of the Alphabet Bundle.
	 * 
	 * @return the path of the Alphabet Bundle
	 */
	public static String getAlphabetBundle(){
		return albBdl;
	}
	
	/**
	 * Returns the text bundle.
	 * 
	 * @return the text bundle
	 */
	public static ResourceBundle getTextBundle(){
		return textBundle;
	}
	
	/**
	 * Returns the letter bag of the current game.
	 * 
	 * @return the letter bag of the current game
	 */
	public static LetterBag getLetterBag(){
		return bag;
	}
}
