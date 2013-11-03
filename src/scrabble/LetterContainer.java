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
 * Class that represents a Letter Container.
 * 
 * Includes methods that every LetterContainer share.
 * 
 * @author George Piskas
 * @version 1.0
 */
public interface LetterContainer {
	
	
	/**
	 * Gets the amound of letters in the container.
	 * 
	 * @return the amount of letters
	 */
	int getLetterAmount();
	
	/**
	 * Gets the letters in the container.
	 * 
	 * @return the letters
	 */
	ArrayList<Letter> getContainer();
		
	/**
	 * Checks if container is empty.
	 * 
	 * @return true if empty
	 */
	boolean isEmpty();

}