package PACKAGE_NAME;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuizGeneratorForm {
    QuizGenerator quizGenerator ;
    JPanel panel = null ;
    JTextField MeanField =null ;
    JTextField SD_Field =null ;
    JTextField NumberOfQuestionField =null ;
    JLabel MeanLabel  ;
    JLabel SDLabel  ;
    JLabel NumberOfQuestionLabel  ;
    JButton generate   ;

    public QuizGeneratorForm() {
        buildForm();
    }
    private void buildForm(){
        panel.setBounds(0,0,1600, 500);
        MeanLabel =  new JLabel("mean") ;
        MeanField =  new JTextField();
        MeanLabel.setBounds(10 ,  50  , 100   , 50 );
        MeanField.setBounds(140 ,  50  , 100   , 50 );
        SDLabel  =  new JLabel("standard deviation") ;
        SD_Field =new JTextField() ;
        MeanLabel.setBounds(10  , 140  ,  100 ,  50);
        MeanLabel.setBounds(140  , 140  ,  100 ,  50);
        NumberOfQuestionLabel = new JLabel( " no.questions") ;
        NumberOfQuestionField =  new JTextField()  ;
        NumberOfQuestionLabel.setBounds(10,  230  , 100 , 50);
        NumberOfQuestionField.setBounds(140  , 230   ,  100 ,  50 );
        generate =  new JButton("generate quiz" );
        generate.setFocusable(false);
        generate.setBounds(800 ,400,  100 ,  25);
        generate.addActionListener( e ->QuizGenerator() );
        panel.add(MeanLabel) ;
        panel.add(MeanField) ;
        panel.add(SD_Field) ;
        panel.add(SDLabel) ;
        panel.add(NumberOfQuestionLabel) ;
        panel.add(NumberOfQuestionField);
        panel.add(generate) ;
    }
    private void QuizGenerator() {
        try {
            float mean =  Float.parseFloat(MeanField.getText()) ;
            float sd =  Float.parseFloat(SD_Field.getText()) ;
           int  NumberOfQuestion = Integer.parseInt(NumberOfQuestionField.getText()) ;
            if(mean <1.0f  ||mean>100.0f   ){
                ErorrMessage.print_message("you entered invalid mean");
            }
            else if ( sd <0 ||sd >Math.min(mean, 100.0-mean)) {
               ErorrMessage.print_message("you entered invalid standard deviation");
            }
            else if (NumberOfQuestion<0 ||NumberOfQuestion>150){
                ErorrMessage.print_message("the number of question is too large or negative");
            }
            else {
                quizGenerator =  new QuizGenerator(mean, sd , NumberOfQuestion) ;
                ArrayList<Problem> quiz  =  quizGenerator.generateQuiz() ;
                Quiz Q1 =  new Quiz(quiz) ;
            }

        }
        catch(NumberFormatException e) {
		 ErorrMessage.print_message("please enter the data correct in the textField  ");

        }

    }


}
