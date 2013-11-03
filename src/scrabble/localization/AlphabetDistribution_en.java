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
public class AlphabetDistribution_en extends ListResourceBundle{

    private Object[][] distr = {
            {"A", "9"},
            {"B", "2"},
            {"C", "2"},
            {"D", "4"}, 
            {"E", "12"}, 
            {"F", "2"}, 
            {"G", "3"},
            {"H", "2"},
            {"I", "9"},
            {"J", "1"},
            {"K", "1"},
            {"L", "4"},
            {"M", "2"},
            {"N", "6"},
            {"O", "8"},
            {"P", "2"},
            {"Q", "1"},
            {"R", "6"},
            {"S", "4"},
            {"T", "6"},
            {"U", "4"},
            {"V", "2"},
            {"W", "2"},
            {"X", "1"},
            {"Y", "2"},
            {"Z", "1"},
            {"*", "2"},
        };

	@Override
	protected Object[][] getContents() {
		return distr;
	}

}