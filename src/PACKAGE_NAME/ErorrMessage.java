package PACKAGE_NAME;

import java.awt.Button;

import javax.swing.*;

public interface ErorrMessage {
    public static void print_message(String message){
        JLabel MessageLabel  =  new JLabel(message) ;
        JPanel prompt = new JPanel();
        prompt.add(MessageLabel);
        JButton b = new JButton();
        b.setText("Back");
        b.addActionListener(e->{
        	Frame.getInstance().clear();
        	Frame.getInstance().add(new QuizGeneratorForm().panel);
        	});
        prompt.add(b);
        MessageLabel.setBounds(200,  200,  250  ,  250);
        Frame.getInstance().add(prompt);
        
    }
}
