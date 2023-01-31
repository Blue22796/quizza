package PACKAGE_NAME;

import javax.swing.*;

public interface ErorrMessage {
    public static void print_message(String message){
        JFrame jFrame  =  new JFrame() ;
        JLabel MessageLabel  =  new JLabel(message) ;
        MessageLabel.setBounds(200,  200,  250  ,  250);
        jFrame.add(MessageLabel) ;
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1600,1000);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}
