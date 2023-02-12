package PACKAGE_NAME;

import javax.swing.*;
import java.awt.*;

public class Main {
	static Frame j = Frame.getInstance();
    public static void main(String[] args) {
    	MainMenu mainMenu = new MainMenu();
		j.add(mainMenu.mainMenuPanel);
    }
}
