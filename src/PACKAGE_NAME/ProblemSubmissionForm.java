package PACKAGE_NAME;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProblemSubmissionForm {
	JPanel form = null;
	Problem submission= new Problem();
	JTextField rateField=null;
	JTextField problemStatement=null;
	JButton submitButton;
	
	protected ProblemSubmissionForm() {
		//Instantiating variables and creating labels
		form = new JPanel(new GridBagLayout());
		
		rateField = new JTextField();
		rateField.setPreferredSize(new Dimension(330,25));
		JLabel rateLabel = new JLabel("Rate");
		rateLabel.setPreferredSize(new Dimension(80,20));
		rateLabel.setForeground(new Color(255,255,255));
		
		problemStatement= new JTextField();
		problemStatement.setPreferredSize(new Dimension(330,25));
		JLabel stmtLabel = new JLabel("Problem Statement");
		stmtLabel.setPreferredSize(new Dimension(120,20));
		stmtLabel.setForeground(new Color(255,255,255));
		
		
		//Instantiating button and adding functionality
		submitButton = new JButton("Submit");
		submitButton.setPreferredSize(new Dimension(150,30));
		submitButton.addActionListener(e->submitProblem());
		
		//Managing layout...Adding components
		GridBagConstraints c = new GridBagConstraints();
		c.weightx=c.weighty=1;
		c.gridheight=1;
		c.gridwidth=2;
		c.gridx=0;
		c.gridy=0;
		form.add(rateLabel,c);
		
		c.gridy=1;
		form.add(rateField,c);
		
		c.gridy=2;
		form.add(stmtLabel,c);
		
		c.gridy=3;
		form.add(problemStatement,c);
		
		c.gridx=1;
		c.gridy=4;
		c.gridwidth=1;
		form.add(submitButton,c);
		
		form.setBackground(new Color(0,0,0));
	}
	
	private void submitProblem() {
		try {
			//Retrieve and validate data, throw exception if invalid
			//Submit otherwise
			Frame.getInstance().remove();
			submission.setRate(Float.parseFloat(rateField.getText()));
			submission.setProblemStatement(problemStatement.getText());
			if(submission.getRate()>=0&&submission.getRate()<=100)
				PDBC.getInstance().insertProblem(submission);
			else throw new Exception();
			Frame.getInstance().remove();
		}
		catch(SQLException e) {
			//SQLException first to differentiate from invalid input
			e.printStackTrace();
		}
		catch(Exception e) {
			/*To be added
			Warn user if input is invalid*/
		}
		
		
	}
	
	
	
}
