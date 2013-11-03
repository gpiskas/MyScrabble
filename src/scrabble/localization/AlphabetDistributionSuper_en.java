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
 * Bundle class that holds the amound of each letter in the bag. Greek version. (FOR SUPER SCRABBLE)
 * 
 * The capital letter is used as the key and the returned string is the number it in the bag.<br>
 * In order to create a full localization for the game, you will need to create<br>
 * Localization_**.java, Alphabet_**.java, AlphabetPoints_**.java and AlphabetDistribution_**.java<br>
 * classes, where "**" represents the country code.
 *  
 * @author George Piskas
 * @version 1.0
 */
public class AlphabetDistributionSuper_en extends ListResourceBundle{

    private Object[][] distr = {
            {"A", "16"},
            {"B", "4"},
            {"C", "6"},
            {"D", "8"}, 
            {"E", "24"}, 
            {"F", "4"}, 
            {"G", "5"},
            {"H", "5"},
            {"I", "13"},
            {"J", "2"},
            {"K", "2"},
            {"L", "7"},
            {"M", "6"},
            {"N", "13"},
            {"O", "15"},
            {"P", "4"},
            {"Q", "2"},
            {"R", "13"},
            {"S", "10"},
            {"T", "15"},
            {"U", "7"},
            {"V", "3"},
            {"W", "4"},
            {"X", "2"},
            {"Y", "4"},
            {"Z", "2"},
            {"*", "4"},
        };

	@Override
	protected Object[][] getContents() {
		return distr;
	}

}