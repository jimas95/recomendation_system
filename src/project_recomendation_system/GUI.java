package project_recomendation_system;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;





public class GUI extends JPanel{
	private static final long serialVersionUID = 1L;
	JTextField textField_T;
	JTextField textField_N;
	JTextField textField_X;
	JTextField textField_M;
	JTextField textField_K;
	
	JTextPane textPane;
	
	private JButton btnRun;
	private JRadioButton jaccard;
	private JRadioButton cosine;
	private JRadioButton pearson;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	
	public GUI(){
		setBorder(UIManager.getBorder("RadioButtonMenuItem.border"));
	       
    	init_components();
    	init_events();
	}
	
	   public void init_events(){
	    	
	        btnRun.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent arg0) {
	         		System.out.println("read CONFIGFILE.txt");
//	         		btnNewButton_1.doClick();
	         		
	         		if(pearson.isSelected()){
	         			System.out.println("running " + pearson.getText());
	         		}
	         		else if(jaccard.isSelected()){
	         			System.out.println("running " + jaccard.getText());
	         		}
	         		else if(cosine.isSelected()){
	         			System.out.println("running " + cosine.getText());
	         			recomendation_system.compute_cosine();
	         		}
	         		
	         	}
	         });
	        
	        
	         btnNewButton.addActionListener(new ActionListener() {
		         	public void actionPerformed(ActionEvent arg0) {
		         		recomendation_system.setTxt();
		         	}
		         });
		         btnNewButton_1.addActionListener(new ActionListener() {
		         	public void actionPerformed(ActionEvent arg0) {
		         		recomendation_system.readTXT();
		         		recomendation_system.createMatrix();
	                textField_T.setText(Integer.toString(recomendation_system.T));
	                textField_N.setText(Integer.toString(recomendation_system.N));
	                textField_M.setText(Integer.toString(recomendation_system.M));
	                textField_X.setText(Integer.toString(recomendation_system.X)+"%");
	                textField_K.setText(Integer.toString(recomendation_system.X));

		         		
		         	}
		         });
	    }
	    
	    public void init_components(){
	         
	         JPanel panel_1 = new JPanel();
	         
	         JPanel panel_2 = new JPanel();
	         
	         btnRun = new JButton("run");
	         
	         JScrollPane scrollPane = new JScrollPane();
	         
	         JPanel panel_3 = new JPanel();

	         GroupLayout groupLayout = new GroupLayout(this);
	         groupLayout.setHorizontalGroup(
	         	groupLayout.createParallelGroup(Alignment.LEADING)
	         		.addGroup(groupLayout.createSequentialGroup()
	         			.addContainerGap()
	         			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	         				.addGroup(groupLayout.createSequentialGroup()
	         					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
	         					.addGap(30))
	         				.addGroup(groupLayout.createSequentialGroup()
	         					.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
	         					.addGap(102)))
	         			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	         				.addComponent(btnRun)
	         				.addGroup(groupLayout.createSequentialGroup()
	         					.addGap(8)
	         					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	         					.addPreferredGap(ComponentPlacement.RELATED)
	         					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
	         					.addGap(24)))
	         			.addGap(28))
	         );
	         groupLayout.setVerticalGroup(
	         	groupLayout.createParallelGroup(Alignment.LEADING)
	         		.addGroup(groupLayout.createSequentialGroup()
	         			.addGap(109)
	         			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	         			.addContainerGap(302, Short.MAX_VALUE))
	         		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	         			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	         				.addGroup(groupLayout.createSequentialGroup()
	         					.addContainerGap()
	         					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
	         				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 209, Short.MAX_VALUE))
	         			.addGap(9)
	         			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	         				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	         					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
	         					.addContainerGap())
	         				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	         					.addComponent(btnRun)
	         					.addGap(71))))
	         );
	                  panel_3.setLayout(new GridLayout(0, 1, 0, 0));
	                  
	                  JScrollPane scrollPane_1 = new JScrollPane();
	                  panel_3.add(scrollPane_1);
	                  
	                           textPane = new JTextPane();
	                           scrollPane_1.setViewportView(textPane);
	                           textPane.setBackground(Color.GRAY);
	         panel_2.setLayout(new GridLayout(0, 1, 0, 0));
	         
	         btnNewButton_1 = new JButton("read values");
	         panel_2.add(btnNewButton_1);
	         
	         
	                  
	                  JPanel panel = new JPanel();
	                  panel_2.add(panel);
	                  panel.setLayout(new GridLayout(0, 2, 0, 0));
	                  
	                  JLabel lblInputData = new JLabel("input data");
	                  panel.add(lblInputData);
	                  
	                  JLabel lblNewLabel_1 = new JLabel("New label");
	                  panel.add(lblNewLabel_1);
	                  
	                  JLabel label = new JLabel("T:");
	                  panel.add(label);
	                  
	                  textField_T = new JTextField();
	                  panel.add(textField_T);
	                  textField_T.setColumns(10);
	                  
	                  JLabel lblNewLabel = new JLabel("N:");
	                  panel.add(lblNewLabel);
	                  
	                  textField_N = new JTextField();
	                  panel.add(textField_N);
	                  textField_N.setColumns(10);
	                  
	                  JLabel lblM = new JLabel("M");
	                  panel.add(lblM);
	                  
	                  textField_M = new JTextField();
	                  panel.add(textField_M);
	                  textField_M.setColumns(10);
	                  
	                  JLabel lblX = new JLabel("X:");
	                  panel.add(lblX);
	                  
	                  textField_X = new JTextField();
	                  panel.add(textField_X);
	                  textField_X.setColumns(10);
	                  
	                  JLabel lblK = new JLabel("K:");
	                  panel.add(lblK);
	                  
	                  textField_K = new JTextField();
	                  panel.add(textField_K);
	                  textField_K.setColumns(10);
	         
	         btnNewButton = new JButton("set values");
	         panel_2.add(btnNewButton);

	         panel_1.setLayout(new GridLayout(0, 1, 0, 0));
	         ButtonGroup group = new ButtonGroup();
	         jaccard = new JRadioButton("Jaccard");
	         panel_1.add(jaccard);
	         group.add(jaccard);
	         cosine = new JRadioButton("Cosine");
	         panel_1.add(cosine);
	         group.add(cosine);
	         pearson = new JRadioButton("Pearson");
	         panel_1.add(pearson);
	         group.add(pearson);
	         setLayout(groupLayout);
	    	
	    	
	    	
	    }
	
}