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
 * Bundle class that holds the amound of each letter in the bag. Greek version.
 * 
 * The capital letter is used as the key and the returned string is the number it in the bag.<br>
 * In order to create a full localization for the game, you will need to create<br>
 * Localization_**.java, Alphabet_**.java, AlphabetPoints_**.java and AlphabetDistribution_**.java<br>
 * classes, where "**" represents the country code.
 *  
 * @author George Piskas
 * @version 1.0
 */
public class Alphabet_el extends ListResourceBundle{

    private Object[][] letters = {
            {"0", "Á"},
            {"1", "Â"},
            {"2", "Ã"},
            {"3", "Ä"}, 
            {"4", "Å"}, 
            {"5", "Æ"}, 
            {"6", "Ç"},
            {"7", "È"},
            {"8", "É"},
            {"9", "Ê"},
            {"10", "Ë"},
            {"11", "Ì"},
            {"12", "Í"},
            {"13", "Î"},
            {"14", "Ï"},
            {"15", "Ð"},
            {"16", "Ñ"},
            {"17", "Ó"},
            {"18", "Ô"},
            {"19", "Õ"},
            {"20", "Ö"},
            {"21", "×"},
            {"22", "Ø"},
            {"23", "Ù"},
            {"24", "*"},
        };

	@Override
	protected Object[][] getContents() {
		return letters;
	}
	
}