package PACKAGE_NAME;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
    	ProblemSubmissionForm psf = new ProblemSubmissionForm();
		JFrame j = new JFrame();
		j.setSize(600,450);
		j.add(psf.form);
		j.setVisible(true);
    }
}
