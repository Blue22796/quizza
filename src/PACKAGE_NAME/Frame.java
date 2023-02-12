package PACKAGE_NAME;

import javax.swing.*;
import java.util.Stack;

public class Frame {
	
	private static Frame instance = null;
	private JFrame jFrame;
    Stack <JPanel> stack =  new Stack<JPanel>() ;
    
    private Frame() {
        jFrame = new JFrame() ;
        jFrame.setSize(500,500);
    }
    
    public static Frame getInstance() {
    	if(instance==null)
    		instance = new Frame();
		return instance;
    	
    }
    
    public void add (JPanel jPanel){
       // jFrame.removeAll();
    	jFrame.getContentPane().removeAll();
        stack.push(jPanel) ;
        jFrame.add(jPanel) ;
        jFrame.repaint();
        jFrame.setVisible(true);
    }
    public  void remove (){
        jFrame.getContentPane().removeAll();
        stack.pop() ;
        jFrame.add(stack.peek())  ;
    }
}
