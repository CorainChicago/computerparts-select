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
import javax.swing.ListSelectionModel;

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
import java.io.File;
import java.lang.reflect.Array;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Window {

	private JFrame frame;
	 // Creates two DefaultListModels, computerParts and selectedParts
	private DefaultListModel computerParts;
	private DefaultListModel selectedParts;
	
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
	 * @param <E>
	 */
	public <E> void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.WHITE);
		panelLeft.setBounds(0, 0, 169, 256);
		frame.getContentPane().add(panelLeft);
		panelLeft.setLayout(null);
		
		computerParts = new DefaultListModel();
		setComputerParts();
	
		//Creates the optionsList and adds the array of computerParts to display
		// Adds the list to the panel on the left
		final JList optionsList = new JList<>(computerParts);
		optionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		optionsList.setBounds(6, 6, 77, 119);
		panelLeft.add(optionsList);
		
		//creates a panel on the right, sets the background to white, size, and location
		//adds the panel to the frame
		//sets the layout to null (absolute)
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.WHITE);
		panelRight.setBounds(281, 0, 169, 256);
		frame.getContentPane().add(panelRight);
		
		//creates an empty array of strings to hold the selected items
		selectedParts = new DefaultListModel();
		panelRight.setLayout(null);
		final JList selectedList = new JList(selectedParts);
		selectedList.setBounds(84, 5, 77, 119);
		panelRight.add(selectedList);
		
		//creates a panel in the center, sets the background to white, size, and location
		//adds the panel to the frame
		//sets the layout to null (absolute)
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.LIGHT_GRAY);
		panelCenter.setBounds(167, 0, 112, 256);
		frame.getContentPane().add(panelCenter);
		panelCenter.setLayout(null);
		
		
		/*
		 * Creates an button with a listener
		 * The button adds a selected item from the optionsList 
		 * to the selectedParts list and removes it from the options list
		 * The button's size and location are set and it is added to the panelCenter
		 */
		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = optionsList.getSelectedValue();
				int i = optionsList.getSelectedIndex();
				selectedParts.addElement(selected);
				computerParts.remove(i);
			}
		});
		button.setBounds(37, 106, 51, 29);
		panelCenter.add(button);
		
		/*
		 * Creates an button with a listener
		 * The button removes a selected item from the selectedParts list
		 * and adds it to the computerParts list
		 * The button's size and location are set and it is added to the panelCenter
		 */
		
		JButton button_1 = new JButton("<<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = selectedList.getSelectedValue();
				int i = selectedList.getSelectedIndex();
				computerParts.addElement(selected);
				selectedParts.remove(i);
			}
		});
		button_1.setBounds(37, 136, 51, 29);
		panelCenter.add(button_1);
		
		// creates a menu bar where the menu items will be located
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		// adds a File sub-menu item to the JMenuBar where drop-down items will be listed
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		// adds the following MenuItems below the File in the menu to appear on hover.  As a JMenuItem, they do not have sub-menus. 
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\file.xml");
					JAXBContext jaxbContext = JAXBContext.newInstance(ComputerListSelected.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					ComputerListSelected list = (ComputerListSelected) jaxbUnmarshaller.unmarshal(file);
					System.out.println(list.getList());
					selectedParts.removeAllElements();
					setComputerParts();
					for (String item : list.getList()){
						selectedParts.addElement(item);
						computerParts.removeElement(item);
					}
				  } catch (JAXBException e3) {
					e3.printStackTrace();
				  }
			}
		});
		mnFile.add(mntmLoad);
		
		/* Adds Save to the menu with a listener
		 * When the save menu item is selected, it creates a ComputerListSelected object
		 * The SelectedParts items are added to the ComputerListSelected object
		 * A new file and new JAXBContext instance with the ComputerListSelected object are created
		 * The jaxb library is used to select the properties and save them in the file
		 * If there is an issue creating the jaxbContext instance or marshalling the item,
		 * an stackTrace is printed
		*/
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComputerListSelected list = new ComputerListSelected();
				for ( int i= 0; i < selectedParts.size(); i++ ){
					list.getList().add((String) selectedParts.getElementAt(i));
				}
				try {

					File file = new File("C:\\file.xml");
					JAXBContext jaxbContext = JAXBContext.newInstance(ComputerListSelected.class);
					Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

					// output pretty printed
					jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

					jaxbMarshaller.marshal(list, file);
					jaxbMarshaller.marshal(list, System.out);

				      } catch (JAXBException e2) {
					e2.printStackTrace();
				      }

			}
		});
		mnFile.add(mntmSave);
		
		/*
		 * Creates an Exit menuItem, adds a listener, and exits the program when selected
		 */
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
			
	}
	/*
	 * Function clears the computerParts 
	 * and adds a complete array of them to the computerParts DefaultListModule
	 */
	public void setComputerParts(){
		computerParts.removeAllElements();
		String parts[]= {"Case", "Motherboard", "CPU", "GPU", "PSU", "RAM", "HDD"};
		for (String part : parts){
			computerParts.addElement(part);
		}
		
		
	}
}
 	