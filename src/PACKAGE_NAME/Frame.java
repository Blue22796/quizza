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
    public  void add (JPanel jPanel){

       if (stack.size()>0){
           jFrame.remove(stack.peek());
       }
        jFrame.add(jPanel);
        jFrame.validate();
        jFrame.repaint();
        jFrame.revalidate();
        stack.push(jPanel) ;
    }
    public  void remove (){
        if (stack.size()>0) {
            jFrame.remove(stack.peek());
            stack.pop() ;
            jFrame.add(stack.peek())  ;
            jFrame.validate();
            jFrame.repaint();
            jFrame.revalidate();
        }

        jFrame.pack();
    }
}
