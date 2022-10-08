package Swingg;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacTest implements ActionListener{
	private static final String Borderlayout = null;
	JFrame frameObj = new JFrame();
	JPanel title = new JPanel();
	JPanel button = new JPanel();
	JPanel Button = new JPanel();
	JLabel txt = new JLabel();
	JButton[] btn = new JButton[81];
	JButton[] Btn = new JButton[9];
	boolean Playerturn = true;
	
	
	TicTacTest() {
		frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameObj.setSize(800, 800);
		frameObj.getContentPane().setBackground(Color.black);
		frameObj.setLayout(new BorderLayout());
		frameObj.setVisible(true);
		txt.setBackground(Color.BLACK);
		txt.setForeground(Color.gray);
		txt.setFont(new Font("Ink Free",Font.BOLD,45));
		txt.setHorizontalAlignment(JLabel.CENTER);
		txt.setText("Blackfyre");
		txt.setOpaque(true);
		title.setLayout(new BorderLayout());
		title.setBounds(0, 0, 800, 100);
		
		button.setLayout(new GridLayout(9,9));
		button.setLayout(new GridLayout(3,3));
		button.setBackground(Color.gray);
		
		for(int i = 0;i<81;i++ ) {
			btn[i] = new JButton();
			button.add(btn[i]);
			btn[i].setFont(new Font("MV Boli",Font.BOLD,70));
			if(i%3==0 || i%3==1 || i%3==2){
				btn[i].setBackground(Color.LIGHT_GRAY);
			}else {
				btn[i].setBackground(Color.gray);
			}
			btn[i].setFocusable(false);
			btn[i].addActionListener(this);
		}
		for(int i = 0;i<9;i++ ) {
			Btn[i] = new JButton();
			Button.add(Btn[i]);
			Btn[i].setFont(new Font("MV Boli",Font.BOLD,140));
			if(i%2==0){
				btn[i].setBackground(Color.LIGHT_GRAY);
			}else {
				btn[i].setBackground(Color.gray);
			}
			Btn[i].setFocusable(false);
			Btn[i].setEnabled(false);
		}
		
		title.add(txt);
		frameObj.add(title,BorderLayout.NORTH);
		frameObj.add(button);
		frameObj.add(Button);
		
	}
	public  void ActionListener(ActionEvent e) {
		
	}
	
	public static String  positionGrid (int i) {
		int x = i % 3;
		int y = (i / 9)%3;
		int [] arr = {x,y};
		return Arrays.toString(arr);
	}
	
	public static String CheckGrid(int i ) {
		int x = (i %9 )/3;
		int y = i /27;
		int arr [] = {x,y};
		return Arrays.toString(arr);
	}
	
	
   
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		txt.setText("X Turn");
		for(int i = 0; i < 81; i++) {
			if(e.getSource() == btn[i]) {
				if (Playerturn) {
					if(btn[i].getText()== "") {		//check if a button has a text on it
						btn[i].setForeground(new Color(255, 0, 0));
						btn[i].setText("X");
						Playerturn = false;
						txt.setText("O Turn");
						
						for(int j = 0; j < 81; j++) {
							btn[j].setEnabled(false);
						}
										
						//hard coded
						for (int a = 0 ; a < 81 ; a++) {
							if( positionGrid(i).equals(CheckGrid(a)) ){
								btn[a].setEnabled(true);
							}
						}
					}			
				}
				else {
					if(btn[i].getText()== "") {		//check if a button has a text on it
						btn[i].setForeground(new Color(0, 0, 255));
						btn[i].setText("O");
						Playerturn = true;
						txt.setText("X Turn");
						for(int j = 0; j < 81; j++) {
							btn[j].setEnabled(false);
						}
						
						//hard coded
						for (int a = 0 ; a < 81 ; a++) {
							if( positionGrid(i).equals(CheckGrid(a)) ){
								btn[a].setEnabled(true);
							}
						}
							
					}		
				}
			}
			
		}
	}
}

