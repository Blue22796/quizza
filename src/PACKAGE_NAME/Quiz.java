package PACKAGE_NAME;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Quiz {
ArrayList<problem> currentQuiz ;
     JFrame jFrame =  new JFrame() ;
     JPanel jPanel =  new JPanel() ;
     GridLayout gridLayout  ;
     JLabel label =  new JLabel() ;
    public Quiz(ArrayList<problem> current_Quiz) {
        currentQuiz = current_Quiz;
        buildForm();
    }
    private void buildForm(){
        jPanel.setBounds(0,0,1600, 500);
        gridLayout =  new GridLayout(currentQuiz.size() ,  1)  ;
        jPanel.setLayout(gridLayout);
        for(int i =0 ; i < currentQuiz.size(); i++){
            String Question =  currentQuiz.get(i).getProblemStatement() ;
           label =  new JLabel("ahmed") ;
           jPanel.add(label);
        }
        jFrame.add(jPanel) ;
        jFrame.setSize(1600,1000);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

    }





}
