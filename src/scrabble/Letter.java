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

import java.util.ResourceBundle;


/**
 * Class that represents a single Letter.
 * 
 * A Letter consists of a character and the rewarded points.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class Letter  {
	private char ltr;
	private int points;
	private ResourceBundle pointsBundle = ResourceBundle.getBundle(Game.getAlphabetPointsBundle(), Game.getLocale());
	
	
	/**
	 * Letter "default" constructor.
	 * 
	 * Sets character to ' ' and points to 0.
	 */
	public Letter() {
		ltr = ' ';
		points = 0;
	}

	/**
	 * Letter constructor that sets charachter and points.
	 * 
	 * Sets the character to the given one and extracts the points from pointsBundle Bundle.
	 * 
	 * @param aChar Character to set
	 */
	public Letter(char aChar) {
		ltr = aChar;
		points = Integer.parseInt(pointsBundle.getString(Character.toString(aChar)));
	}

	/**
	 * Sets given character and to letter.
	 * 
	 * @param aChar Character to set
	 */
	public void setLetter(char aChar) {
		ltr = aChar;
		points = Integer.parseInt(pointsBundle.getString(Character.toString(aChar)));
	}
	
	/**
	 * Returns the character of the letter
	 * 
	 * @return the char of letter
	 */
	public char getLetter() {
		return ltr;
	}
	
	/**
	 * Returns the points of the letter
	 * 
	 * @return the points of letter
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Returns all letter's information.
	 * 
	 * @return Info returned in the following form:<br>
	 * character|points
	 */
	@Override
	public String toString() {
		return ltr+"|"+points;
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
}
