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

package scrabble.localization;

import java.util.ListResourceBundle;

/**
 * Bundle class that holds the amound of each letter in the bag. English version.
 * 
 * The capital letter is used as the key and the returned string is the number it in the bag.<br>
 * In order to create a full localization for the game, you will need to create<br>
 * Localization_**.java, Alphabet_**.java, AlphabetPoints_**.java and AlphabetDistribution_**.java<br>
 * classes, where "**" represents the country code.
 *  
 * @author George Piskas
 * @version 1.0
 */
public class Alphabet_en extends ListResourceBundle{

    private Object[][] letters = {
            {"0", "A"},
            {"1", "B"},
            {"2", "C"},
            {"3", "D"}, 
            {"4", "E"}, 
            {"5", "F"}, 
            {"6", "G"},
            {"7", "H"},
            {"8", "I"},
            {"9", "J"},
            {"10", "K"},
            {"11", "L"},
            {"12", "M"},
            {"13", "N"},
            {"14", "O"},
            {"15", "P"},
            {"16", "Q"},
            {"17", "R"},
            {"18", "S"},
            {"19", "T"},
            {"20", "U"},
            {"21", "V"},
            {"22", "W"},
            {"23", "X"},
            {"24", "Y"},
            {"25", "Z"},
            {"26", "*"},
        };

	@Override
	protected Object[][] getContents() {
		return letters;
	}
	
}