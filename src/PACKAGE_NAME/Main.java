package PACKAGE_NAME;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;


public class Main {
	public static  Frame frame =  new Frame() ;
    public static void main(String[] args) {
		MainMenu mainMenu =  new MainMenu() ;
		frame.add(mainMenu.mainMenuPanel);
    }
    

}
