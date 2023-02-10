package PACKAGE_NAME;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
    	MainMenu mainMenu = new MainMenu()  ;
		JFrame j = new JFrame();
		j.setSize(600,450);
		j.add(mainMenu.mainMenuPanel);
		j.setVisible(true);
    }
}
