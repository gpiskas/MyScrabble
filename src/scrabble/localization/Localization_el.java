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
 * Bundle class that holds output text. Greek version.
 * 
 * Keys are used to represent longer strings and offer localization abilities.<br>
 * In order to create a full localization for the game, you will need to create<br>
 * Localization_**.java, Alphabet_**.java, AlphabetPoints_**.java and AlphabetDistribution_**.java<br>
 * classes, where "**" represents the country language code. 
 * 
 * @author George Piskas
 * @version 1.0
 */
public class Localization_el extends ListResourceBundle{
			
    private Object[][] text = {
            {"@numberOfPlayers", "������� ��� ������ ��� �������"},
            {"@numberOfPlayersTitle", "������� �������"},
            {"@playerName", "���� �� ����� ��� ������ "},
            {"@defaultPlayerName", "�������"},
            {"@playerNameTitle", "����� ������"},
            {"@wordQuest", "��������� �� ����;"}, 
            {"@wordTitle", "������� �����"}, 
            {"@score", "����"}, 
            {"@turn", ", ����� � ����� ���!"},
            {"@playButton", "����� ��������"},
            {"@playButtonState", "���� ���� ����������"},
            {"@changeButton", "������ ��������"},
            {"@changeButtonState", "������� �� ��������"},
            {"@passButton", "����� ����"},
            {"@rack", "�� �������� ���:"},
            {"@ltrMul2", "������ ������ �����"},
            {"@ltrMul3", "������ ������� �����"},
            {"@ltrMul4", "������ ��������� �����"},
            {"@wrdMul2", "���� ������ �����"},
            {"@wrdMul3", "���� ������� �����"},
            {"@wrdMul4", "���� ��������� �����"},
            {"@wrnLtrExist", "������� ��� ������ ���!"},
            {"@wrnLtrExistTitle", "�������� ����"},
            {"@wrnNotCell", "������ �� ������ �� ������ �� ����!"},
            {"@wrnNotCellTitle", "��� ����� ����"},
            {"@passDialog", "����� ��������;"},
            {"@passDialogTitle", "����� ����"},
            {"@xtr50Pts", "�������������� ��� �� �������� ���! \n �������� 50 �������� �������!"},
            {"@xtr50PtsTitle", "�������� ������"},
            {"@turnLost", "� ���� ��� ������ ��� ���������! \n ������ �� ����� ���."},
            {"@turnLostTitle", "������� �����"},
            {"@bagEmpty", "� ������� �� �� �������� �������! \n ��� �������� �� ������ ��������� � �� �������� ��������!"},
            {"@bagEmptyTitle", "����� ������� ���������"},
            {"@orientationV", "������"},
            {"@orientationH", "���������"},
            {"@orientation", "������� ���� ��� ������. \n ����� ��� �������������� ��� �����."},
            {"@orientationTitle", "��������������� �����"},
            {"@name", "�����"},
            {"@exit", "������"},
            {"@exitDialog", "����� �������� ��� ��� �� �����; \n �� �������� �� ���������!"},
            {"@exitDialogTitle", "������"},
            {"@DnD", "���� ��� ������ �� ��� ����"},
            {"@ChL", "���� ���� �� ��� ������ ��� �� �� ���������"},
            {"@endGame0", "�� �������� ��������! \n ������� ������� ��� ������ ��� 2 ������������ ������!"},
            {"@endGame1", "�� �������� ��������! \n �� �������� ���� ������ ��������� ��� � ������� ����� �����!"},
            {"@endGameTitle", "����� ����������"},
            
        };

	@Override
	protected Object[][] getContents() {
		return text;
	}
	
}
