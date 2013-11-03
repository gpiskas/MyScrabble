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
            {"@numberOfPlayers", "Διάλεξε τον αριθμό των παικτών"},
            {"@numberOfPlayersTitle", "Αριθμός παικτών"},
            {"@playerName", "Δώσε το όνομα του Παίκτη "},
            {"@defaultPlayerName", "Παίκτης"},
            {"@playerNameTitle", "Όνομα Παίκτη"},
            {"@wordQuest", "Εγγρίνεις τη λέξη;"}, 
            {"@wordTitle", "Έγγριση λέξης"}, 
            {"@score", "Σκόρ"}, 
            {"@turn", ", είναι η σειρά σου!"},
            {"@playButton", "Παίξε Γράμματα"},
            {"@playButtonState", "Πάτα Όταν Τελειώσεις"},
            {"@changeButton", "Άλλαξε Γράμματα"},
            {"@changeButtonState", "Διάλεξε Τα Γράμματα"},
            {"@passButton", "Παίξε Πάσο"},
            {"@rack", "Τα γράμματά σου:"},
            {"@ltrMul2", "Γράμμα Διπλής Αξίας"},
            {"@ltrMul3", "Γράμμα Τριπλής Αξίας"},
            {"@ltrMul4", "Γράμμα Τετραπλής Αξίας"},
            {"@wrdMul2", "Λέξη Διπλής Αξίας"},
            {"@wrdMul3", "Λέξη Τριπλής Αξίας"},
            {"@wrdMul4", "Λέξη Τετραπλής Αξίας"},
            {"@wrnLtrExist", "Υπάρχει ήδη γράμμα εδώ!"},
            {"@wrnLtrExistTitle", "Πιασμένο Κελί"},
            {"@wrnNotCell", "Πρέπει να σύρεις το γράμμα σε κελί!"},
            {"@wrnNotCellTitle", "Δέν Είναι Κελί"},
            {"@passDialog", "Είσαι σίγουρος;"},
            {"@passDialogTitle", "Παίξε Πάσο"},
            {"@xtr50Pts", "Χρησιμοποίησες όλα τα γράμματά σου! \n Παίρνεις 50 επιπλέον πόντους!"},
            {"@xtr50PtsTitle", "Επιπλέον Πόντοι"},
            {"@turnLost", "Η λέξη που έβαλες δεν εγγρίθηκε! \n Έχασες τη σειρά σου."},
            {"@turnLostTitle", "Χαμένος Γύρος"},
            {"@bagEmpty", "Η σακούλα με τα γράμματα άδειασε! \n Δέν μπορείτε να πάρετε καινούρια ή να αλλάξετε γράμματα!"},
            {"@bagEmptyTitle", "Άδεια Σακούλα Γραμμάτων"},
            {"@orientationV", "Κάθετα"},
            {"@orientationH", "Οριζόντια"},
            {"@orientation", "Έπαιξες μόνο ένα γράμμα. \n Όρισε τον προσανατολισμό της λέξης."},
            {"@orientationTitle", "Προσανατολισμός Λέξης"},
            {"@name", "Όνομα"},
            {"@exit", "Έξοδος"},
            {"@exitDialog", "Έισαι σίγουρος πως θές να βγείς; \n Το παιχνίδι θα τελειώσει!"},
            {"@exitDialogTitle", "Έξοδος"},
            {"@DnD", "Σύρε ενα γράμμα σε ένα κελί"},
            {"@ChL", "Κάνε κλίκ σε ενα γράμμα για να το επιλέξεις"},
            {"@endGame0", "Το παιχνίδι τελείωσε! \n Κανένας παίκτης δέν έπαιξε για 2 συνεχόμενους γύρους!"},
            {"@endGame1", "Το παιχνίδι τελείωσε! \n Τα γράμματα ενός παίκτη τελέιωσαν και η σακούλα είναι άδεια!"},
            {"@endGameTitle", "Τέλος Παιχνιδιού"},
            
        };

	@Override
	protected Object[][] getContents() {
		return text;
	}
	
}
