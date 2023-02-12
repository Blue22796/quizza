package PACKAGE_NAME;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class MainMenu {
    JPanel mainMenuPanel ;
    JButton submissionButton  ;
    JButton generationButton  ;
    JLabel menuLabel;
     MainMenu(){
    	 mainMenuPanel =  new JPanel(new GridBagLayout());
         mainMenuPanel.setBackground(new Color(0,0,0));
         
         submissionButton  = new JButton("submit question") ;
         submissionButton.setPreferredSize(new Dimension(100,50));
         
         generationButton =  new JButton("generate exam") ;
         generationButton.setPreferredSize(new Dimension(100,50));   
         

         menuLabel = new JLabel("QUIZZA",SwingConstants.CENTER);
         menuLabel.setPreferredSize(new Dimension(100,50));
         menuLabel.setFont(new Font("Serif", Font.PLAIN, 60));
         menuLabel.setForeground(new Color(101, 18, 75));
 
         
         
       
         submissionButton.setFocusable(false);
         generationButton.setFocusable(false );
         submissionButton.addActionListener(e -> OpenSubmissionForm());
         generationButton.addActionListener(e->OpenQuizGenerator()); 

         GridBagConstraints c = new GridBagConstraints();
         c.fill=c.BOTH;
         c.weightx= 0.6;c.weighty=0.6;
         c.gridheight=3;
         c.gridwidth=3;
         c.gridy=0;
         mainMenuPanel.add(menuLabel,c);
         
         c.fill=c.HORIZONTAL;
         c.insets= new Insets(1,0,1,10);
         c.gridheight=1;
         c.gridwidth=1;
         c.gridy=4;
         mainMenuPanel.add(submissionButton,c) ;
        
         c.insets= new Insets(1,10,1,0);
         c.gridx=1;
         mainMenuPanel.add(generationButton,c) ;
     }
     void OpenSubmissionForm(){
         Frame.getInstance().add(new ProblemSubmissionForm().form);

     }
     void OpenQuizGenerator(){
    	 Frame.getInstance().add(new QuizGeneratorForm().panel);
     }

}
