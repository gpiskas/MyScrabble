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
 * Bundle class that holds the awarded points of each letter. Greek version.
 * 
 * The capital letter is used as the key and the returned string is the number of points.<br>
 * In order to create a full localization for the game, you will need to create<br>
 * Localization_**.java, Alphabet_**.java, AlphabetPoints_**.java and AlphabetDistribution_**.java<br>
 * classes, where "**" represents the country code. 
 * 
 * @author George Piskas
 * @version 1.0
 */
public class AlphabetPoints_el extends ListResourceBundle{

    private Object[][] points = {
            {"Á", "1"},
            {"Â", "8"},
            {"Ã", "4"},
            {"Ä", "4"}, 
            {"Å", "1"}, 
            {"Æ", "10"}, 
            {"Ç", "1"},
            {"È", "10"},
            {"É", "1"},
            {"Ê", "2"},
            {"Ë", "3"},
            {"Ì", "3"},
            {"Í", "1"},
            {"Î", "10"},
            {"Ï", "1"},
            {"Ð", "2"},
            {"Ñ", "2"},
            {"Ó", "1"},
            {"Ô", "1"},
            {"Õ", "2"},
            {"Ö", "8"},
            {"×", "8"},
            {"Ø", "10"},
            {"Ù", "3"},
            {"*", "0"},
        };

	@Override
	protected Object[][] getContents() {
		return points;
	}

}