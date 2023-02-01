package PACKAGE_NAME;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Quiz {
	ArrayList<Problem> currentQuiz ;
     JFrame jFrame =  new JFrame() ;
     JPanel jPanel =  new JPanel() ;
     GridBagLayout gridLayout;
     JLabel label =  new JLabel() ;
     JButton nextButton = null;
    
     public Quiz(ArrayList<Problem> current_Quiz,JButton nextButton) {
        currentQuiz = current_Quiz;
        this.nextButton=nextButton;
        buildForm();
    }
    
     private void buildForm(){
        jPanel.setBounds(0,0,1600, 500);
        gridLayout =  new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill=c.HORIZONTAL;
        c.gridx=1; c.gridy=0;
        c.weightx=c.weighty=1;
        jPanel.setLayout(gridLayout);
        
        for(int i =0 ; i < currentQuiz.size(); i++){
        	c.gridy++;
        	String Question =  currentQuiz.get(i).getProblemStatement() ;
        	label =  new JLabel("<html>"+Question+"</html>") ;
        	jPanel.add(label,c);
        }
        c.fill=c.NONE;
        c.gridy++;
        jPanel.add(nextButton,c);
        
        jFrame.add(jPanel) ;
        jFrame.setSize(1600,1000);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

    }


}
