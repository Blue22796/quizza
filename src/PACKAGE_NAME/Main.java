package PACKAGE_NAME;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	static JFrame j = new JFrame();
    public static void main(String[] args) {
    	MainMenu mainMenu = new MainMenu()  ;
		
		j.setSize(600,450);
		j.add(mainMenu.mainMenuPanel);
		j.setVisible(true);
    }
    
    public static void add(JPanel x) {
    	j.removeAll();
    	j.validate();
    	j.repaint();
    	j.revalidate();
    	j.add(x);
    }
}
