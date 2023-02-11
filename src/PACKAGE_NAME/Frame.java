package PACKAGE_NAME;

import javax.swing.*;
import java.util.Stack;

public class Frame {
   public JFrame jFrame  ;
    Stack <JPanel> stack =  new Stack<JPanel>() ;
    Frame(){
        jFrame = new JFrame() ;
        jFrame.setSize(1600,1000);
        jFrame.setVisible(true);
    }
    public void add (JPanel jPanel){
       // jFrame.removeAll();
        stack.push(jPanel) ;
        this.jFrame.add(jPanel) ;
        this.jFrame.pack();
    }
    public  void remove (){
        jFrame.removeAll();
        stack.pop() ;
        jFrame.add(stack.peek())  ;
        jFrame.pack();
    }
}
