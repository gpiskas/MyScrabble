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
 * Class that represents a rack of letters.
 * 
 * A Rack consists of a number of letters that are available for the player to use.
 * Letters are extracted randomly from the Letter Bag.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class LetterRack implements LetterContainer{

	private ArrayList<Letter> theRack = new ArrayList<Letter>();
	private int maxRackSize;
	
	/**
	 * Letter Rack constructor with custom rack size.
	 * 
	 * Creates a letter rack for a player that holds letters in an array list. 
	 * Rack size is defined.
	 * 
	 * @param bagOfLtrs the bag to extract letters from
	 * @param theRackSize rack size for custom scrabble versions
	 */
	public LetterRack(LetterBag bagOfLtrs, int theRackSize){
		theRack.addAll(bagOfLtrs.newRack(theRackSize));
		maxRackSize=theRackSize;
	}
	
	/**
	 * Letter Rack constructor. Rack size set to 7 (default scrabble rack).
	 * 
	 * Creates a letter rack for a player that holds letters in an array list. 
	 * Rack size is 7, as in the default scrabble version.
	 * 
	 * @param bagOfLtrs the bag to extract letters from
	 */
	public LetterRack(LetterBag bagOfLtrs){
		theRack.addAll(bagOfLtrs.newRack(7));
		maxRackSize=7;
	}
	
	/**
	 * Refreshes the letters a player wants to switch with others.
	 * 
	 * Returns a number of letter back to the bag and the player recieves an equal number
	 * of new randomly picked letters from the bag. The old letters are placed back in the
	 * bag and the new letters are extracted from the bag and placed on the player's rack.
	 * 
	 * @param bagOfLtrs the bag to extract letters from
	 * @param returnedLtrs the letters to return to the bag
	 */
	public void refreshLetters(LetterBag bagOfLtrs, ArrayList<Letter> returnedLtrs){
		for(int i=0;i<returnedLtrs.size();i++){
			theRack.remove(returnedLtrs.get(i));
		}
		theRack.addAll(bagOfLtrs.refreshLetters(returnedLtrs));
	}
	
	/**
	 * When a player chooses to play, letters are placed on the board and removed from the rack.
	 * 
	 * The letters are removed from the rack and the rack is refilled
	 * if there are enough letters in the bag. If there are not enough, he gets all remaining letters.
	 * 
	 * @param bagOfLtrs the bag to extract letters from
	 * @param usedLetters the letters that were played
	 */
	public void playLetters(LetterBag bagOfLtrs, ArrayList<Letter> usedLetters){
		int refillAmount=usedLetters.size();
			for(int i=0;i<refillAmount;i++){
				theRack.remove(usedLetters.get(i));
			}
			ArrayList<Letter> temp = new ArrayList<Letter>();
			temp=bagOfLtrs.refillLetters(refillAmount);
			if(temp!=null){
				theRack.addAll(temp);
			}
	}
	
	/**
	 * Returns the letters left in the rack.
	 * 
	 * @return the number of letters remaining in the rack
	 */
	@Override
	public int getLetterAmount() {
		return theRack.size();
	}

	/**
	 * Returns the letters in the rack.
	 * 
	 * @return the letters in the rack
	 */
	@Override
	public ArrayList<Letter> getContainer() {
		return theRack;
	}
	
	/**
	 * Returns the rack's max size.
	 * 
	 * @return the rack's max size
	 */
	public int getMaxRackSize() {
		return maxRackSize;
	}

	/**
	 * Checks if the rack has been emptied.
	 * 
	 * @return rack is empty
	 */
	@Override
	public boolean isEmpty() {
		return theRack.isEmpty();
	}

	
	/**
	 * Returns rack's information.
	 * 
	 * @return Info returned is the size of the board and the info of each cell
	 */
	@Override
	public String toString() {
		StringBuilder aString= new StringBuilder();
		for (int i=0;i<theRack.size();i++){
			aString.append(theRack.get(i)+" ");
		}
		aString.append("Max Size: "+maxRackSize);
		return aString.toString();
	}

}