package PACKAGE_NAME;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Quiz {
	ArrayList<Problem> currentQuiz ;
	JPanel paper =  new JPanel() ;
	GridBagLayout gridLayout;
	JLabel label =  new JLabel() ;
	JButton nextButton = null;
    
     public Quiz(ArrayList<Problem> current_Quiz,JButton nextButton) {
        currentQuiz = current_Quiz;
        this.nextButton=nextButton;
        buildForm();
    }
    
     private void buildForm(){
        paper.setBounds(0,0,1600, 500);
        paper.setBackground(new Color(100,100,100));
        gridLayout =  new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill=c.HORIZONTAL;
        c.gridwidth=2;
        c.gridx=0; c.gridy=0;
        c.weightx=c.weighty=1;
        paper.setLayout(gridLayout);
        
        for(int i =0 ; i < currentQuiz.size(); i++){
        	c.gridy++;
        	String Question =  currentQuiz.get(i).getProblemStatement() ;
        	label =  new JLabel("<html>"+Question+"</html>") ;
        	paper.add(label,c);
        }
        c.fill=c.NONE;
        c.gridy++;
        c.gridwidth=1;
        c.gridx=1;
        paper.add(nextButton,c);
        
        JButton b = new JButton();
        b.setText("Back");
        b.addActionListener(e->{
        	Frame.getInstance().clear();
        	Frame.getInstance().add(new QuizGeneratorForm().panel);
        	});
        c.gridx=0;
        paper.add(b,c);
     }
}
