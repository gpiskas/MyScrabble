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
 * Bundle class that holds output text. English version.
 * 
 * Keys are used to represent longer strings and offer localization abilities.<br>
 * In order to create a full localization for the game, you will need to create<br>
 * Localization_**.java, Alphabet_**.java, AlphabetPoints_**.java and AlphabetDistribution_**.java<br>
 * classes, where "**" represents the country language code. <br>
 * Also add the language tag at the Game.ALL_LOCALES field.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class Localization_en extends ListResourceBundle{
			
    private Object[][] text = {
            {"@numberOfPlayers", "Select the number of players"},
            {"@numberOfPlayersTitle", "Number of players"},
            {"@playerName", "Enter name of Player "},
            {"@defaultPlayerName", "Player"},
            {"@playerNameTitle", "Player Name"},
            {"@wordQuest", "Do you approve the word?"}, 
            {"@wordTitle", "Word Approval"}, 
            {"@score", "Score"}, 
            {"@turn", ", it's your turn!"},
            {"@playButton", "Play Letters"},
            {"@playButtonState", "Click Here When Done"},
            {"@changeButton", "Change Letters"},
            {"@changeButtonState", "Choose Letters To Change"},
            {"@passButton", "Play Pass"},
            {"@rack", "Your letters:"},
            {"@ltrMul2", "Double Letter Score"},
            {"@ltrMul3", "Triple Letter Score"},
            {"@ltrMul4", "Quadruple Letter Score"},
            {"@wrdMul2", "Double Word Score"},
            {"@wrdMul3", "Triple Word Score"},
            {"@wrdMul4", "Quadruple Word Score"},
            {"@wrnLtrExist", "There is already a letter here!"},
            {"@wrnLtrExistTitle", "Cell Taken"},
            {"@wrnNotCell", "You must drag and drop the letter in a cell!"},
            {"@wrnNotCellTitle", "Not A Cell"},
            {"@passDialog", "Are you sure?"},
            {"@passDialogTitle", "Play Pass"},
            {"@xtr50Pts", "You used all your lettes! \n You get 50 bonus points!"},
            {"@xtr50PtsTitle", "Bonus Points"},
            {"@turnLost", "The word you entered was not approved! \n You lost your turn."},
            {"@turnLostTitle", "Turn Lost"},
            {"@bagEmpty", "The letter bag is empty! \n No more letters can be given, or changed!"},
            {"@bagEmptyTitle", "Letter Bag Emtpy"},
            {"@orientationV", "Vertical"},
            {"@orientationH", "Horisontal"},
            {"@orientation", "You played only one letter. \n Define the orientation of the word."},
            {"@orientationTitle", "Word Orientation"},
            {"@name", "Name"},
            {"@exit", "Exit"},
            {"@exitDialog", "Are you sure you want to exit? \n The game will end!"},
            {"@exitDialogTitle", "Exit"},
            {"@DnD", "Drag and Drop a letter on a cell"},
            {"@ChL", "Click a letter to select it"},
            {"@endGame0", "The game has ended! \n Noone played for two turns in a row!"},
            {"@endGame1", "The game has ended! \n A player has used all his letters and the bag is empty!"},
            {"@endGameTitle", "Game Over"},
            
        };

	@Override
	protected Object[][] getContents() {
		return text;
	}
	
}
