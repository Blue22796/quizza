package PACKAGE_NAME;

import javax.swing.*;

public class MainMenu {
    JPanel MainMenuPanel ;
    JButton SubmissionButton  ;
    JButton GenerationButton  ;
     MainMenu(){
         MainMenuPanel =  new JPanel() ;
         SubmissionButton  = new JButton("submit question") ;
         GenerationButton =  new JButton("generate exam") ;

        SubmissionButton.setBounds(200 , 400,50 , 50);
        GenerationButton.setBounds(300,400 ,50,50);
        SubmissionButton.setFocusable(false);
        GenerationButton.setFocusable(false );
        SubmissionButton.addActionListener(e -> OpenSubmissionForm());
        GenerationButton.addActionListener(e->OpenQuizGenerator());
        MainMenuPanel.add(SubmissionButton) ;
        MainMenuPanel.add(GenerationButton) ;
     }
     void OpenSubmissionForm(){
         System.out.println("ahahaahahah");
     }
     void OpenQuizGenerator(){

     }

}
