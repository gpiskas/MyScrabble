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

package scrabble;

/**
 * Class that represents a scrabble board.
 * 
 * A board consists of cells in a square (n*n) grid. A board also contains multipliers.
 * Words are formed on the board by assining
 * letters to those cells. Score is defined by the letters and the multipliers on the board.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class Board {

	private BoardCell[][] cell;
	private int size;
	
	/**
	 * Board Constructor with custom size. (>=15)
	 * 
	 * Creates a board of cells and extends the classic 15x15 scrabble board. Also, it adds both the default and extra multiplyers.
	 * For custom sizes difrent than 21, you must override the addDefaultMultipliers() function.
	 * 
	 * @param sz The size of the Board, must be >=15.
	 */
	public Board(int sz){
		size=sz-1;
		cell = new BoardCell[size+1][size+1];
		for (int i=0;i<=size;i++){
			for (int j=0;j<=size;j++){
				cell[i][j]= new BoardCell(i, j);	//x,y | x katheta, y orizodia			
			}
		}
		addDefaultMultipliers();
		if (size!=14){
			addExtraMultipliers();
		}
	}
	
	/**
	 * Default Board Constructor.
	 * 
	 * Creates a 15x15 board of cells.
	 */
	public Board(){
		size=14;
		cell = new BoardCell[size+1][size+1];
		for (int i=0;i<=size;i++){
			for (int j=0;j<=size;j++){
				cell[i][j]= new BoardCell(i, j);	//x,y | x katheta, y orizodia			
			}
		}
		addDefaultMultipliers();
	}
	
	/**
	 * Sets the default scrabble multiplyers on the board.
	 */
	private void addDefaultMultipliers(){

		int cp=size/2;	//center Position
		
		//WORD * 3
		cell[cp-7][cp-7].setWordMult(3);
		cell[cp-7][cp].setWordMult(3);
		cell[cp-7][cp+7].setWordMult(3);
		cell[cp][cp-7].setWordMult(3);
		cell[cp][cp+7].setWordMult(3);
		cell[cp+7][cp-7].setWordMult(3);
		cell[cp+7][cp].setWordMult(3);
		cell[cp+7][cp+7].setWordMult(3);
		
		//WORD * 2
		//center
		cell[cp][cp].setWordMult(2);
		//top left q
		cell[cp-6][cp-6].setWordMult(2);
		cell[cp-5][cp-5].setWordMult(2);
		cell[cp-4][cp-4].setWordMult(2);
		cell[cp-3][cp-3].setWordMult(2);
		//top right q
		cell[cp-6][cp+6].setWordMult(2);
		cell[cp-5][cp+5].setWordMult(2);
		cell[cp-4][cp+4].setWordMult(2);
		cell[cp-3][cp+3].setWordMult(2);
		//bot left q
		cell[cp+6][cp-6].setWordMult(2);
		cell[cp+5][cp-5].setWordMult(2);
		cell[cp+4][cp-4].setWordMult(2);
		cell[cp+3][cp-3].setWordMult(2);
		//bor right q
		cell[cp+6][cp+6].setWordMult(2);
		cell[cp+5][cp+5].setWordMult(2);
		cell[cp+4][cp+4].setWordMult(2);
		cell[cp+3][cp+3].setWordMult(2);
		
		//LETTER * 3
		//top left q
		cell[cp-6][cp-2].setLetterMult(3);
		cell[cp-2][cp-2].setLetterMult(3);
		cell[cp-2][cp-6].setLetterMult(3);
		//top right q
		cell[cp-6][cp+2].setLetterMult(3);
		cell[cp-2][cp+2].setLetterMult(3);
		cell[cp-2][cp+6].setLetterMult(3);
		//bot left q
		cell[cp+6][cp-2].setLetterMult(3);
		cell[cp+2][cp-2].setLetterMult(3);
		cell[cp+2][cp-6].setLetterMult(3);
		//bor right q
		cell[cp+6][cp+2].setLetterMult(3);
		cell[cp+2][cp+2].setLetterMult(3);
		cell[cp+2][cp+6].setLetterMult(3);
		
		//LETTER * 2
		//on center axis
		cell[cp-4][cp].setLetterMult(2);
		cell[cp][cp-4].setLetterMult(2);
		cell[cp+4][cp].setLetterMult(2);
		cell[cp][cp+4].setLetterMult(2);
		//top left q
		cell[cp-7][cp-4].setLetterMult(2);
		cell[cp-4][cp-7].setLetterMult(2);
		cell[cp-5][cp-1].setLetterMult(2);
		cell[cp-1][cp-5].setLetterMult(2);
		cell[cp-1][cp-1].setLetterMult(2);
		//top right q
		cell[cp-7][cp+4].setLetterMult(2);
		cell[cp-4][cp+7].setLetterMult(2);
		cell[cp-5][cp+1].setLetterMult(2);
		cell[cp-1][cp+5].setLetterMult(2);
		cell[cp-1][cp+1].setLetterMult(2);
		//bot left q
		cell[cp+7][cp-4].setLetterMult(2);
		cell[cp+4][cp-7].setLetterMult(2);
		cell[cp+5][cp-1].setLetterMult(2);
		cell[cp+1][cp-5].setLetterMult(2);
		cell[cp+1][cp-1].setLetterMult(2);
		//bot right q
		cell[cp+7][cp+4].setLetterMult(2);
		cell[cp+4][cp+7].setLetterMult(2);
		cell[cp+5][cp+1].setLetterMult(2);
		cell[cp+1][cp+5].setLetterMult(2);
		cell[cp+1][cp+1].setLetterMult(2);
	}
	
	/**
	 * Sets the extra scrabble multiplyers on the board, outside the central 15x15 region. (made for 21x21 - Override it for difrent sizes.)
	 */
	protected void addExtraMultipliers(){

		int cp=size/2;	//center Position

		//on the diagonal "X"
		//tleft
		cell[cp-8][cp-8].setWordMult(2);
		cell[cp-9][cp-9].setWordMult(2);	
		cell[cp-10][cp-10].setWordMult(4);
		//tright
		cell[cp-8][cp+8].setWordMult(2);
		cell[cp-9][cp+9].setWordMult(2);	
		cell[cp-10][cp+10].setWordMult(4);
		//bleft
		cell[cp+8][cp-8].setWordMult(2);
		cell[cp+9][cp-9].setWordMult(2);	
		cell[cp+10][cp-10].setWordMult(4);
		//bright
		cell[cp+8][cp+8].setWordMult(2);
		cell[cp+9][cp+9].setWordMult(2);	
		cell[cp+10][cp+10].setWordMult(4);
		
		//WORD * 3
		cell[cp-10][cp-3].setWordMult(3);
		cell[cp-10][cp+3].setWordMult(3);
		cell[cp+10][cp-3].setWordMult(3);
		cell[cp+10][cp+3].setWordMult(3);
		cell[cp-3][cp+10].setWordMult(3);
		cell[cp+3][cp+10].setWordMult(3);
		cell[cp-3][cp-10].setWordMult(3);
		cell[cp+3][cp-10].setWordMult(3);
		
		//WORD * 2
		cell[cp-9][cp-2].setWordMult(2);
		cell[cp-8][cp-1].setWordMult(2);
		cell[cp-9][cp+2].setWordMult(2);
		cell[cp-8][cp+1].setWordMult(2);
		cell[cp+9][cp-2].setWordMult(2);
		cell[cp+8][cp-1].setWordMult(2);
		cell[cp+9][cp+2].setWordMult(2);
		cell[cp+8][cp+1].setWordMult(2);		
		cell[cp-2][cp-9].setWordMult(2);
		cell[cp-1][cp-8].setWordMult(2);
		cell[cp+2][cp-9].setWordMult(2);
		cell[cp+1][cp-8].setWordMult(2);
		cell[cp-2][cp+9].setWordMult(2);
		cell[cp-1][cp+8].setWordMult(2);
		cell[cp+2][cp+9].setWordMult(2);
		cell[cp+1][cp+8].setWordMult(2);
		
		//LETTER * 4
		cell[cp-8][cp-5].setLetterMult(4);
		cell[cp-8][cp+5].setLetterMult(4);
		cell[cp+8][cp-5].setLetterMult(4);
		cell[cp+8][cp+5].setLetterMult(4);
		cell[cp-5][cp-8].setLetterMult(4);
		cell[cp+5][cp-8].setLetterMult(4);
		cell[cp-5][cp+8].setLetterMult(4);
		cell[cp+5][cp+8].setLetterMult(4);
		
		//LETTER * 3
		cell[cp-9][cp-6].setLetterMult(3);
		cell[cp-9][cp+6].setLetterMult(3);
		cell[cp+9][cp-6].setLetterMult(3);
		cell[cp+9][cp+6].setLetterMult(3);
		cell[cp-6][cp-9].setLetterMult(3);
		cell[cp+6][cp-9].setLetterMult(3);
		cell[cp-6][cp+9].setLetterMult(3);
		cell[cp+6][cp+9].setLetterMult(3);
		
		//LETTER * 2
		//on center axis
		cell[cp-10][cp].setLetterMult(2);
		cell[cp][cp-10].setLetterMult(2);
		cell[cp+10][cp].setLetterMult(2);
		cell[cp][cp+10].setLetterMult(2);
		//\\//\\//\\//\\//\\//\\//\\//\\
		cell[cp-10][cp-7].setLetterMult(3);
		cell[cp-10][cp+7].setLetterMult(3);
		cell[cp+10][cp-7].setLetterMult(3);
		cell[cp+10][cp+7].setLetterMult(3);
		cell[cp-7][cp-10].setLetterMult(3);
		cell[cp+7][cp-10].setLetterMult(3);
		cell[cp-7][cp+10].setLetterMult(3);
		cell[cp+7][cp+10].setLetterMult(3);
	}
	
	
	
	/**
	 * Returns a cell with the given coordinates. Warning: x and y start from 0, not 1.
	 * 
	 * @param x vertical position
	 * @param y horisontal position
	 * @return cell of the given positon
	 */
	public BoardCell getCell(int x, int y){
		return cell[x][y];		
	}
	
	/**
	 * Returns board's size.
	 * 
	 * @return size of the board
	 */
	public int getSize(){
		return size+1;	
	}
	 
	/**
	 * Returns board's information.
	 * 
	 * @return Info returned is the size of the board and the info of each cell
	 */
	@Override
	public String toString() {
		StringBuilder returnMe = new StringBuilder();
		returnMe.append("Board size = "+ (size+1) +"\n\n");
		for(int i=0;i<=size;i++){
			for(int j=0;j<=size;j++){
			returnMe.append(cell[i][j].toString()+"\n\n");
			}
		}
		String rtn= new String(returnMe);
		return rtn;
	}
	
}