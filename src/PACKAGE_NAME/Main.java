package PACKAGE_NAME;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
    	QuizGeneratorForm psf = new QuizGeneratorForm();
		JFrame j = new JFrame();
		j.setSize(600,450);
		j.add(psf.panel);
		j.setVisible(true);
    }
}
