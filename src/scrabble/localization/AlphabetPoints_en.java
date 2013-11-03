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
 * Bundle class that holds the awarded points of each letter. English version.
 * 
 * The capital letter is used as the key and the returned string is the number of points.<br>
 * In order to create a full localization for the game, you will need to create<br>
 * Localization_**.java, Alphabet_**.java, AlphabetPoints_**.java and AlphabetDistribution_**.java<br>
 * classes, where "**" represents the country code. 
 * 
 * @author George Piskas
 * @version 1.0
 */
public class AlphabetPoints_en extends ListResourceBundle{

    private Object[][] points = {
            {"A", "1"},
            {"B", "3"},
            {"C", "3"},
            {"D", "2"}, 
            {"E", "1"}, 
            {"F", "4"}, 
            {"G", "2"},
            {"H", "4"},
            {"I", "1"},
            {"J", "8"},
            {"K", "5"},
            {"L", "1"},
            {"M", "3"},
            {"N", "1"},
            {"O", "1"},
            {"P", "3"},
            {"Q", "10"},
            {"R", "1"},
            {"S", "1"},
            {"T", "1"},
            {"U", "1"},
            {"V", "4"},
            {"W", "4"},
            {"X", "8"},
            {"Y", "4"},
            {"Z", "10"},
            {"*", "0"},
        };

	@Override
	protected Object[][] getContents() {
		return points;
	}

}