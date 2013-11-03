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
public class AlphabetDistribution_el extends ListResourceBundle{

    private Object[][] distr = {
            {"�", "12"},
            {"�", "1"},
            {"�", "2"},
            {"�", "2"}, 
            {"�", "8"}, 
            {"�", "1"}, 
            {"�", "7"},
            {"�", "1"},
            {"�", "8"},
            {"�", "4"},
            {"�", "3"},
            {"�", "3"},
            {"�", "6"},
            {"�", "1"},
            {"�", "9"},
            {"�", "4"},
            {"�", "5"},
            {"�", "7"},
            {"�", "8"},
            {"�", "4"},
            {"�", "1"},
            {"�", "1"},
            {"�", "1"},
            {"�", "3"},
            {"*", "2"},
        };

	@Override
	protected Object[][] getContents() {
		return distr;
	}

}