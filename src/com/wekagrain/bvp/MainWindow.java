//sg
/*
    "Copyright 2011 CSE DEPTT. BVCOE  <http://bvcoend.ac.in/Deptt_CSE.asp>"
    
     This file is part of Weka Grain.

    Weka Grain is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Weka Grain is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Weka Grain.  If not, see <http://www.gnu.org/licenses/>.*/

package com.wekagrain.bvp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import com.wekagrain.*;
public class MainWindow {

	private JFrame frame;
	 JFileChooser fc;
	 ImageIcon ic;
	 /*add the name of the datatype you add to this list
	 follow -> 
	 \n<number>.<space> name_of_data_type : Short Description
	 */
	 //____________________________________________________
	 private static final String dataTypeList=
		"Data Types Available" +
		"\n1.   name : Name" +
		"\n2.   int_id : Integer ID"+
		"\n3.   dept: Department" +
		"\n4.   yn : Yes /No" +
		"\n5.   tf : True / False" +
		"\n6.   gender : Gender" +
		"\n7.   ph : Mobile Phone Number" +
		"\n8.   clang : Computer Language" +
		"\n9.   grocery : Grocery Item" +
		"\n10. state : Indian State and UT" +
		"\n11. weather:Weather Conditions" +
		"\n12. marks : Marks (out of 100)" +
		"\n13. publisher : Name of a Publisher ";
	 //_______________________________________________________
	 private static final  String aboutWekaGrainMessage=
		 "Weka Grain (c) generates (random) data " +
		"and can be used for studying data analysers \nlike weka or for generating large databases for practising queries. " +
		"\ncurrent Version 1.1\nDEPT OF CSE ,BVCOE, NEW DELHI";
	 //_______________________________________________________
	 private static final  String helpMessage="\nThe format is \"attribute name:datatype\" with attribute names seperated " +
		"by a semicolon (;)\n\neg   \"emp_id:int_id;emp_name:name;emp_ph:ph;emp_mgr:yn\"\nWill generate an simple employee record having attributes like id,phone number etc." +
		"\n\nPlease note that there should not be any space in the attribute name\nIn case the csv file generated is incorrect,check your grain string and try again";

	 private String helpFileName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		helpFileName="https://github.com/madaan/Weka-Grain/wiki";
		 fc = new JFileChooser();
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("ToolTip.backgroundInactive"));
		frame.setBounds(150, 150, 671, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextArea grainStringInputArea = new JTextArea();
		grainStringInputArea.setForeground(SystemColor.textHighlight);
		grainStringInputArea.setToolTipText("ATTRIBUTE_NAME:DATATYPE");
		grainStringInputArea.setBackground(Color.WHITE);
		grainStringInputArea.setFont(new Font("SansSerif", Font.BOLD, 15));
		grainStringInputArea.setLineWrap(true);
		grainStringInputArea.setBounds(27, 108, 240, 150);
		JScrollPane jspForInput=new JScrollPane(grainStringInputArea);
		jspForInput.setBounds(new Rectangle(27, 108, 240, 150));
		frame.getContentPane().add(jspForInput);
		
		JLabel lblEnterYourGrain = new JLabel("Enter Your Grain String");
		lblEnterYourGrain.setBounds(50, 81, 175, 15);
		frame.getContentPane().add(lblEnterYourGrain);
		JTextPane txtpnDataTypeList = new JTextPane();
		txtpnDataTypeList.setEditable(false);
		txtpnDataTypeList.setBackground(UIManager.getColor("Tree.line"));
		txtpnDataTypeList.setText(dataTypeList);
		txtpnDataTypeList.setBounds(402, 81, 240, 239);
		java.net.URL imgURL = getClass().getResource("grain.png");
		 ic=new ImageIcon(imgURL,"LOTS OF GRAIN!");
		
		JLabel lblWekaGrainfoodFor = new JLabel("WEKA GRAIN:FOOD FOR WEKA",ic,JLabel.CENTER);
		lblWekaGrainfoodFor.setForeground(new Color(105, 105, 105));
		lblWekaGrainfoodFor.setFont(new Font("PakType Tehreer", Font.BOLD, 14));
		lblWekaGrainfoodFor.setBounds(174, 12, 340, 40);
		frame.getContentPane().add(lblWekaGrainfoodFor);
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(174, 268, 93, 20);
		spinner.setValue((Integer)3);
		frame.getContentPane().add(spinner);
		
		JLabel lblSelectNumberOf = new JLabel("Number Of Records");
		lblSelectNumberOf.setBounds(27, 270, 143, 15);
		frame.getContentPane().add(lblSelectNumberOf);
		JButton btnGetCsv = new JButton("Generate Data");
		btnGetCsv.setBounds(291, 352, 152, 25);
		frame.getContentPane().add(btnGetCsv);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(291, 63, -11, 145);
		frame.getContentPane().add(separator);
		
		JLabel lblTypeOfRecord = new JLabel("Output File Format");
		lblTypeOfRecord.setBounds(27, 304, 143, 20);
		frame.getContentPane().add(lblTypeOfRecord);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"arff", "csv"}));
		comboBox.setBounds(174, 302, 93, 24);
		frame.getContentPane().add(comboBox);
		JScrollPane jsp=new JScrollPane(txtpnDataTypeList);
		jsp.setBounds(new Rectangle(402, 81, 240, 239));
		frame.getContentPane().add(jsp);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAboutWekaGrain = new JMenuItem("About Weka Grain");
		mntmAboutWekaGrain.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(frame,aboutWekaGrainMessage,"About Weka Grain",JOptionPane.INFORMATION_MESSAGE,ic );
				
			}
			
			
		});
		mnFile.add(mntmAboutWekaGrain);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmSampleGrainStrings = new JMenuItem("Sample Grain Strings");
		mnHelp.add(mntmSampleGrainStrings);
		mntmSampleGrainStrings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
			openBrowserWindow();
			}
		});
		JMenuItem mntmWritingTheGrain = new JMenuItem("Writing the grain string");
		mnHelp.add(mntmWritingTheGrain);
		mntmWritingTheGrain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				JOptionPane.showMessageDialog(frame,helpMessage ,"Writing the Grain String", JOptionPane.INFORMATION_MESSAGE,ic);
			}
		});
		btnGetCsv.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent ae)
		{
			String grain=grainStringInputArea.getText();
			if(grain.length()==0)
			{
				JOptionPane.showMessageDialog(frame,"No Grain String Entered !","Are You Testing Me?",JOptionPane.INFORMATION_MESSAGE,ic );
			}
			else
			{
				int typeOfFile=comboBox.getSelectedIndex();
			fc.showSaveDialog(frame);
			File f=fc.getSelectedFile();
			int numRec=(Integer)spinner.getValue();
			new GrainStringParser(grain,numRec,typeOfFile,f);
			}
			}
		});
		
	}
	 public  void openBrowserWindow() {

	        if( !java.awt.Desktop.isDesktopSupported() ) {

	            System.err.println( "Desktop is not supported (fatal)" );
	            System.exit( 1 );
	        }

	
	        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

	        if( !desktop.isSupported( java.awt.Desktop.Action.BROWSE ) ) {

	            System.err.println( "Desktop doesn't support the browse action (fatal)" );
	            System.exit( 1 );
	        }
	        	try {

	                java.net.URI uri = new java.net.URI(helpFileName);
	                desktop.browse( uri );
	            }
	            catch ( Exception e ) {

	                System.err.println( e.getMessage() );
	            }
	        
	    }
}

