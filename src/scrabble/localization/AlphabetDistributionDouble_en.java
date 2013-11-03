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
 * Bundle class that holds the amound of each letter in the bag. Greek version. (FOR DOUBLE SCRABBLE)
 * 
 * The capital letter is used as the key and the returned string is the number it in the bag.<br>
 * In order to create a full localization for the game, you will need to create<br>
 * Localization_**.java, Alphabet_**.java, AlphabetPoints_**.java and AlphabetDistribution_**.java<br>
 * classes, where "**" represents the country code.
 *  
 * @author George Piskas
 * @version 1.0
 */
public class AlphabetDistributionDouble_en extends ListResourceBundle{

    private Object[][] distr = {
            {"A", "18"},
            {"B", "4"},
            {"C", "4"},
            {"D", "8"}, 
            {"E", "24"}, 
            {"F", "4"}, 
            {"G", "6"},
            {"H", "4"},
            {"I", "18"},
            {"J", "2"},
            {"K", "2"},
            {"L", "8"},
            {"M", "4"},
            {"N", "12"},
            {"O", "16"},
            {"P", "4"},
            {"Q", "2"},
            {"R", "12"},
            {"S", "8"},
            {"T", "12"},
            {"U", "8"},
            {"V", "4"},
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