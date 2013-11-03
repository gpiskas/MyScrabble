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

package scrabble.playable;

import java.util.Locale;
import scrabble.Game;
import scrabble.GUI.ScrabbleWindow;


/**
 * Class that represents the Super Scrabble game.
 * 
 * Board Size: 21 cells
 * Players: 2-4
 * Player's rack size: 7 letters
 * Bundles:
 * -scrabble.localization.AlphabetDistributionSuper
 * -scrabble.localization.AlphabetPoints
 * -scrabble.localization.Alphabet
 * Default Rules.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class SuperScrabble extends Game{



	public SuperScrabble(int boardSize, int rackSize, Locale locale, String dstBdlPath, String ptsBdlPath, String albBdlPath) {
		super(boardSize, rackSize, locale, dstBdlPath, ptsBdlPath, albBdlPath);
	}

	
	public static void main(String[] args){
		//Localization and Alphabet Options
		String dstBdlPath=new String("scrabble.localization.AlphabetDistributionSuper");	 //super scrabble
		String ptsBdlPath=new String("scrabble.localization.AlphabetPoints"); 		 //classic scrabble
		String albBdlPath=new String("scrabble.localization.Alphabet"); 			 //classic scrabble
		//Initialization Options
		Locale locale = new Locale(getLocalePopup());
		int boardSize = 21;	//super scrabble
		int rackSize = 7;	//classic scrabble 
		
		SuperScrabble newGame = new SuperScrabble(boardSize, rackSize, locale, dstBdlPath, ptsBdlPath, albBdlPath);
		newGame.play();	
	}


	/**
	 * The method that starts the game and the main frame.
	 * 
	 */
	@Override
	protected void play() {
		ScrabbleWindow game = new ScrabbleWindow(board,player);
		game.setVisible(true);
		game.setTitle("Super Scrabble");
	}
}