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


/**
 * Class that represents a single Cell of the Scrabble 2D Board.
 * 
 * A Cell consists of it's position on the 2D board, a letter and point multipliers.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class BoardCell{
	
	private int x,y;
	private Letter letter;
	private int wordMult, letterMult;

	/**
	 * Cell constructor, sets position.
	 * 
	 * Sets the location of the cell, multipliers to 0 and letter to ' '.
	 * 
	 * @param x X position on the board
	 * @param y Y position on the board
	 */
	public BoardCell(int x,int y){
		this.x=x;
		this.y=y;
		letter= new Letter();
		wordMult=0;
		letterMult=0;
	}
	
	/**
	 * Cell constructor, sets position and multipliers.
	 * 
	 * Sets the location of the cell, multipliers to given values and letter to ' '.
	 * 
	 * @param x X position on the board
	 * @param y Y position on the board
	 * @param wordMltp Word point multiplier
	 * @param letterMltp Letter point multiplier
	 */
	public BoardCell(int x,int y, int wordMltp, int letterMltp){
		this.x=x;
		this.y=y;
		letter= new Letter();
		wordMult=wordMltp;
		letterMult=letterMltp;
	}
	
	/**
	 * Sets a letter to the cell.
	 * 
	 * @param aChar The letter to set to the cell
	 */
	public void setLetter(char aChar){
		letter.setLetter(aChar);
	}
	
	/**
	 * Returns cell letter.
	 * 
	 * @return the character within letter
	 */
	public char getLetter(){
		return letter.getLetter();
	}

	/**
	 * Sets both multiplier values to the cell.
	 * 
	 * @param wm Word multiplier to set
	 * @param lm Letter multiplier to set
	 */
	public void setCellMult(int wm,int lm){
		wordMult=wm;
		letterMult=lm;
	}
	
	/**
	 * Sets word multiplier only.
	 * 
	 * @param val Word multiplier value
	 */
	public void setWordMult(int val){
		wordMult=val;
	}
	
	/**
	 * Sets letter multiplier only.
	 * 
	 * @param val Letter multiplier value
	 */
	public void setLetterMult(int val){
		letterMult=val;
	}

	/**
	 * Returns cell's word multiplier.
	 * 
	 * @return the word multiplier
	 */
	public int getWordMult(){
		return wordMult;
	}
	
	/**
	 * Returns cell's letter multiplier.
	 * 
	 * @return the letter multiplier
	 */
	public int getLetterMult(){
		return letterMult;
	}

	
	/**
	 * Returns cell's X position.
	 * 
	 * @return x position of cell
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Returns cell's Y position.
	 * 
	 * @return y position of cell
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Returns all cell's information.
	 * 
	 * @return Info returned in the following form:<br>
	 * Position: (x,y) <br>
	 * Word Multiplier: *<br>
	 * Letter Multiplier: *<br>
	 * Letter: *<br>
	 */
	@Override
	public String toString() {
		String cellData="Position: ("+x+","+y+")"
				+"\nWord Multiplier: "+wordMult
				+"\nLetter Multiplier: "+letterMult
				+"\nLetter: "+letter;
		return cellData;
	}
	
}