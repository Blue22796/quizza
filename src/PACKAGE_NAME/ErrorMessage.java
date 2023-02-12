package PACKAGE_NAME;

import java.awt.*;

import javax.swing.*;

public interface ErrorMessage {
    public static void print_message(String message){
        JLabel MessageLabel  =  new JLabel(message) ;
        GridBagConstraints  gbc = new GridBagConstraints();
        JPanel prompt = new JPanel(new GridBagLayout());
        gbc.gridy= 0 ;
        gbc.gridx= 0 ;
        MessageLabel.setHorizontalAlignment(JLabel.CENTER);
        MessageLabel.setFont(new Font("Arial" ,  0 ,  20));
        MessageLabel.setForeground(new Color(0, 0, 0));
        prompt.add(MessageLabel, gbc);
        JButton b = new JButton();
        b.setText("Back");
        b.addActionListener(e->{
        	Frame.getInstance().clear();

        	});
        gbc.gridy=  1 ;
        gbc.insets =  new Insets(200,0,0, 0 ) ;
        b.setHorizontalAlignment(JButton.CENTER);
        prompt.add(b, gbc);
        MessageLabel.setBounds(200,  200,  250  ,  250);
        Frame.getInstance().add(prompt);
        
    }
}
