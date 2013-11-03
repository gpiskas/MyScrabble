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

import java.util.ArrayList;

/**
 * Class that represents a player.
 * 
 * A Player has a name, a score and a rack of letters to play with.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class Player {
	
	private int score;
	private String name;
	private LetterRack rack;
	
	
	/**
	 * Creates a player with the given name.
	 * 
	 * Also, score is set to 0 and a default rack is created.
	 * 
	 * @param playerName name of the player
	 */
	public Player(String playerName) {
		score = 0;
		name = new String(playerName);
		rack = new LetterRack(Game.getLetterBag());
	}
	
	/**
	 * Creates a player with the given name.
	 * 
	 * Also, score is set to 0 and a custom sized rack is created.
	 * 
	 * @param playerName name of the player
	 * @param rackSize size of player's rack
	 */
	public Player(String playerName, int rackSize) {
		score = 0;
		name = new String(playerName);
		rack = new LetterRack(Game.getLetterBag(), rackSize);
	}
		
	/**
	 * Returns the player's rack.
	 * 
	 * @return the player's rack
	 */
	public LetterRack getRack(){
		return rack;
	}
	
	
	/**
	 * Returns the player's name.
	 * 
	 * @return the player's name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets the player's name.
	 * 
	 */
	public void setName(String theName){
		name=theName;
	}
	
	/**
	 * Adds the given points to the current score.
	 * 
	 * @param points points to add to player's score
	 */
	public void addToScore(int points){
		score=score+points;
	}

	/**
	 * Returns the player's score.
	 * 
	 * @return the player's score
	 */
	public int getScore(){
		return score;
	}
	
	/**
	 * Player does nothing.
	 */
	public void actPass(){
		
	}
	
	/**
	 * PLayer requests to exchange a list of letters with others from the letter bag.
	 * 
	 * @param returnedLtrs an ArrayList of letters the player returns to the bag
	 */
	public void actChangeLetters(ArrayList<Letter> returnedLtrs){
		rack.refreshLetters(Game.getLetterBag(), returnedLtrs);
	}
	
	
	/**
	 * Player requests to play a list of letter from his rack on the board. The player then gets new letters, if avaliable in the bag.
	 * 
	 * @param usedLetters an ArrayList of letters the player places on the board
	 * @return -1: did not play | 0: play | 1: play +50 extra points
	 */
	public int actPlayLetters(ArrayList<Letter> usedLetters){
		int rVal=0;
		if(Game.wordApprovalPopup()==0){
			if (usedLetters.size()==rack.getLetterAmount()){
				addToScore(50);
				++rVal;
			}
			rack.playLetters(Game.getLetterBag(), usedLetters);
			return rVal;
		}
		else return -1; //-1 did not play | 0 play | 1 play +50 extra points
	}
	
	
}
