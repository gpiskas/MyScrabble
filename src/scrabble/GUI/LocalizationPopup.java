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

package scrabble.GUI;

import java.awt.Dialog;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import scrabble.Game;


/**
 * Class that creates the language selection popup.
 * 
 * In order to add new languages, go to localization package and create the requested classes.
 * In order to add the new language pack you created, add the language tag at the Game.ALL_LOCALES field.
 * 
 * @author George Piskas
 * @version 1.0
 */
public class LocalizationPopup extends JDialog{

	private static final long serialVersionUID = 8193905773890552500L;
	
	private JButton okButton = new JButton("OK");
	private ButtonHandler handler = new ButtonHandler();
	private String selection = Game.ALL_LOCALES[0];
	private final JComboBox cBox;
	private final JLabel welcome;
	
	
	/**
	 * The constructor of the language selection popup.
	 */
	public LocalizationPopup(){
		super(null, "Choose A Language", Dialog.DEFAULT_MODALITY_TYPE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/icon.jpg"));
		setModal(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(8,8));
		cBox = new JComboBox(getFullLocaleNames(Game.ALL_LOCALES));
		cBox.setMaximumRowCount(3);
		cBox.addItemListener(new ItemListener(){
		
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange()== ItemEvent.SELECTED){
					selection=Game.ALL_LOCALES[cBox.getSelectedIndex()];
				}			
			}
		});
		
		welcome = new JLabel("Welcome to Scrabble!");
		welcome.setHorizontalAlignment(JLabel.CENTER);
		add(welcome,BorderLayout.NORTH);
		add(cBox,BorderLayout.CENTER);
		add(okButton,BorderLayout.EAST);
		okButton.addActionListener(handler);
		
		setSize(200, 100);
		setVisible(true);
	}
		
	/**
	 * Returns the two character language tag of the selected language.
	 * 
	 * @return the two character language tag 
	 */
	public String getSelection(){ 
		return selection;
	}

	/**
	 * Converts the given 2char language tags to full language names.
	 * 
	 * @param locales an array of 2 char language tag strings
	 * @return a string array of the full language names in their localization
	 */
	private String[] getFullLocaleNames(String[] locales){
		int size=locales.length;
		String[] rtrn = new String[size];
		for(int i=0;i<size;i++){
			Locale temp = new Locale(locales[i]);
			rtrn[i]=temp.getDisplayLanguage(temp);
		}
		return rtrn;	
	}
	
	/**
	 * A listener class that is used to close the frame when the OK button is pressed.
	 */
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}		
	}
}
