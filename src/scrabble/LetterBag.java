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
import java.util.ResourceBundle;
import java.util.Collections;

/**
 * Class that represents a letter bag.
 * 
 * A Bag consists of a number of letters with a predefined distribution.
 * This is extracted from a bundle and it is used to fill the bag in the begining of the game.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class LetterBag implements LetterContainer{


	private ArrayList<Letter> bagOfLtrs = new ArrayList<Letter>();
	private ResourceBundle distrBundle = ResourceBundle.getBundle(Game.getAlphabetDistributionBundle(),Game.getLocale());
	private ResourceBundle alphabetBundle = ResourceBundle.getBundle(Game.getAlphabetBundle(), Game.getLocale());
	
	/**
	 * LetterBag constructor.
	 * 
	 * Uses localization bundles to fill the bag with letters in the right language and distribution.<br>
	 * We finally have a shuffled Letter Bag ArrayList.
	 */
	public LetterBag(){
		
		int alphSize=alphabetBundle.keySet().size();
		int distSize=0;
		char chr=' ';
		for(int i=0;i<alphSize;i++){									//gia kathe key
			
			String key=Integer.toString(i);								//key se string
			chr=alphabetBundle.getString(key).charAt(0);			    //vriskei to char
			
			key=Character.toString(chr);								//neo key gia distrBundle
			distSize=Integer.parseInt( distrBundle.getString(key) );    //vriskei distrib
			
			for(int j=0;j<distSize;j++){								//dhmiourgei ta letters
				bagOfLtrs.add(new Letter(chr));							//prosthete sto ArrayList
			}	
		}
		shuffleLetters();
	}
	
	/**
	 * Refreshes letter by player request.
	 * 
	 * If a player wants to refresh his letters from his rack, the function returns the old ones
	 * to the bag and extracts new, randomly generated letters.
	 * 
	 * @param returnedLtrs the letters the player returned to the bag
	 * @return the letter the player will recieve
	 */
	public ArrayList<Letter> refreshLetters(ArrayList<Letter> returnedLtrs){
		if (bagOfLtrs.isEmpty()) return null;
		shuffleLetters();
		int amount=returnedLtrs.size();
		ArrayList<Letter> newLetters = new ArrayList<Letter>();
		if (bagOfLtrs.size()>=amount){
			for (int i=0;i<amount;i++){
				newLetters.add(bagOfLtrs.get(0));						//add to the new list
				bagOfLtrs.remove(0);									//remove from the bag
			}
			bagOfLtrs.addAll(returnedLtrs);
			return newLetters;
		}
		else{
			return returnedLtrs;
		}
	}
	
	/**
	 * Refills a player's rack after he used letters from his rack.
	 * 
	 * Refills the given amount of letters and removes them from the bag. If the bag is emptied during
	 * letter extraction, player recieves all the letters left.
	 * 
	 * @param refillAmount number letters to return
	 * @return	the new letters
	 */
	public ArrayList<Letter> refillLetters(int refillAmount){
		if (bagOfLtrs.isEmpty()) return null;
		shuffleLetters();
		ArrayList<Letter> newLetters = new ArrayList<Letter>();
			for (int i=0;i<refillAmount;i++){
				if (bagOfLtrs.isEmpty()) continue;
				newLetters.add(bagOfLtrs.get(0));						
				bagOfLtrs.remove(0);									
			}
			return newLetters;
	}
	
	/**
	 * Creates an ArrayList of letters to fill the new player's rack.
	 * 
	 * Used only in the beggining of the game, when players join the game.
	 * 
	 * @param rackSize size of the new rack
	 * @return the letters to fill the new rack
	 */
	public ArrayList<Letter> newRack(int rackSize){
		shuffleLetters();
		ArrayList<Letter> newLetters = new ArrayList<Letter>();
		for (int i=0;i<rackSize;i++){
			newLetters.add(bagOfLtrs.get(0));						//add to the new list
			bagOfLtrs.remove(0);									//remove from the bag
		}
		return newLetters;
	}
	
	
	/**
	 * Shuffles the letters within the bag.
	 */
	private void shuffleLetters(){
		Collections.shuffle(bagOfLtrs);
	}
	
	/**
	 * Returns the letters left in the bag.
	 * 
	 * @return the number of letters remaining in the bag
	 */
	@Override
	public int getLetterAmount() {
		return bagOfLtrs.size();
	}

	/**
	 * Returns the letters in the bag.
	 * 
	 * @return the letters in the bag
	 */
	@Override
	public ArrayList<Letter> getContainer() {	
		return bagOfLtrs;
	}

	/**
	 * Checks if the bag has been emptied.
	 * 
	 * @return bag is empty
	 */
	@Override
	public boolean isEmpty() {
		return bagOfLtrs.isEmpty();
	}
}
