package PACKAGE_NAME;

<<<<<<< HEAD
import javax.swing.JFrame;
import javax.swing.JPanel;
=======
import javax.swing.*;
import java.awt.*;
>>>>>>> 17cb9a084c9eb8bfdd0b6fac4259544590cf3f11

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
