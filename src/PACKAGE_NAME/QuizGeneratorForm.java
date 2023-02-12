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
    JButton back;

    public QuizGeneratorForm() {
        buildForm();
    }
    private void buildForm(){

        GridBagConstraints gbc =  new GridBagConstraints() ;
    	panel = new JPanel();
        panel.setLayout(new GridBagLayout());
    	panel.setBackground(new Color(0,0,0));
        MeanLabel =  new JLabel("mean") ;
    	MeanLabel.setForeground(new Color(255, 255, 255, 255));
        MeanLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        MeanLabel.setHorizontalAlignment(JLabel.CENTER);

        gbc.gridx =0 ;
        gbc.gridy =0 ;
        gbc.weightx =  1;
        panel.add(MeanLabel,gbc);
        gbc.insets =  new Insets(10,0,25,120 )  ;



        MeanField =  new JTextField();
        gbc.gridx=  1 ;
        gbc.gridy=  0 ;
        gbc.weightx =1 ;
        gbc.gridwidth= 1  ;
        gbc.fill =  GridBagConstraints.HORIZONTAL ;
        panel.add(MeanField,gbc) ;

        SDLabel  =  new JLabel("standard deviation") ;

        gbc.gridx= 0 ;
        gbc.gridy =  1  ;
    	SDLabel.setForeground(new Color(255, 255, 255));
        SDLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        SDLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(SDLabel,gbc) ;


        SD_Field =new JTextField() ;

        gbc.gridy =1 ;
        gbc.gridx =  1  ;

        panel.add(SD_Field,gbc) ;



        NumberOfQuestionLabel = new JLabel( " no.questions") ;
        NumberOfQuestionLabel.setForeground(new Color(255, 255, 255));
        NumberOfQuestionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        NumberOfQuestionLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx= 0 ;
        gbc.gridy =  2  ;

        panel.add(NumberOfQuestionLabel,gbc) ;

        NumberOfQuestionField =  new JTextField()  ;
        gbc.gridx =  1  ;
        gbc.gridy= 2  ;
        panel.add(NumberOfQuestionField , gbc) ;

        generate =  new JButton("generate quiz" );
        generate.setFocusable(false);
        generate.addActionListener( e ->quizGenerate() );
        gbc.insets =  new Insets(100,30,70,50 )  ;
        gbc.weightx= 0.1 ;

        gbc.gridy  =3  ;
        gbc.gridx   =  0 ;

        panel.add(generate,gbc) ;
        gbc.gridy =  3 ;
        gbc.gridx =   1  ;
        back= new JButton("Back");
        back.addActionListener(e->Frame.getInstance().clear()) ;
        panel.add(back, gbc);


    }
    private void quizGenerate() {
        try {

            float mean =  Float.parseFloat(MeanField.getText()) ;
            float sd =  Float.parseFloat(SD_Field.getText()) ;
           int  NumberOfQuestion = Integer.parseInt(NumberOfQuestionField.getText()) ;
            if(mean <1.0f  ||mean>100.0f   ){
                ErrorMessage.print_message("you entered invalid mean");
            }
            else if ( sd <0 ||sd >Math.min(mean, 100.0-mean)) {
               ErrorMessage.print_message("you entered invalid standard deviation");
            }
            else if (NumberOfQuestion<0 ||NumberOfQuestion>150){
                ErrorMessage.print_message("the number of question is too large or negative");
            }
            else {
                quizGenerator =  new QuizGenerator(mean, sd , NumberOfQuestion) ;
                try {
                	ArrayList<Problem> quiz  =  quizGenerator.generateQuiz() ;
                	JButton next = new JButton("Next");
                	next.setPreferredSize(new Dimension(200,50));
                	next.addActionListener(e->quizGenerate());
                	Quiz Q1 =  new Quiz(quiz,next) ;
                	Frame.getInstance().add(Q1.paper);
                }
                catch(Exception e) {
                	ErrorMessage.print_message("Too many problems X.x");
                }
               
            }

        }
        catch(NumberFormatException e) {
		 ErrorMessage.print_message("please enter the data correct in the textField  ");
        }
    }


}
