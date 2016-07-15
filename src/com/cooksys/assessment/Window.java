package com.cooksys.assessment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import net.miginfocom.swing.MigLayout;

import java.awt.Panel;

import javax.swing.JDesktopPane;

import java.awt.Choice;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JList;

public class Window {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application. The main method is the entry point to a Java application. 
	 * For this assessment, you shouldn't have to add anything to this.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. This is the constructor for this Window class.
	 * All of the code here will be executed as soon as a Window object is made.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. This is where Window Builder
	 * will generate its code.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 169, 256);
		frame.getContentPane().add(panel);
		
		//Line 79 creates an array of the computer parts
		
		final DefaultListModel computerParts = new DefaultListModel();
		
		String parts[]= {"Case", "Motherboard", "CPU", "GPU", "PSU", "RAM", "HDD"};
		for (String part : parts){
			computerParts.addElement(part);
		}
		panel.setLayout(null);
		
		// Line 83-85 creates the optionsList and adds the array of computer parts to display
		final JList optionsList = new JList(computerParts);
		optionsList.setBounds(6, 6, 77, 119);
		panel.add(optionsList);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(281, 0, 169, 256);
		frame.getContentPane().add(panel_1);
		
		//Line 93 creates an empty array of strings to hold the selected items
		final DefaultListModel selectedParts = new DefaultListModel();
		String parts2[]= {"Test"};
		selectedParts.addElement(parts);
		
		panel_1.setLayout(null);
		
		final JList selectedList = new JList(selectedParts);
		selectedList.setBounds(84,5,0,0);
		panel_1.add(selectedList);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(167, 0, 112, 256);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = optionsList.getSelectedIndex();
				Object selected = optionsList.getSelectedValue();
				computerParts.remove(i);
				selectedParts.addElement(selected);
			}
		});
		
		button.setBounds(37, 106, 51, 29);
		panel_2.add(button);
		
		JButton button_1 = new JButton("<<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_1.setBounds(37, 136, 51, 29);
		panel_2.add(button_1);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		// adds a File sub-menu item to the JMenuBar where drop-down items will be listed
		JMenu mnFile = new JMenu("File");
		mnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnFile);
		
		// adds the following MenuItems below the File in the menu to appear on hover.  As a JMenuItem, they do not have sub-menus. 
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Needs to load the ????
			}
		});
		mnFile.add(mntmLoad);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Needs to save the record
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code below exits the program without saving. 
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
			
	}
}