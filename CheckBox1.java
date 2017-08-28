package GUI;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.Event;
import java.awt.TextArea;  
public class CheckBox1 extends Applet {  
	TextArea t = new TextArea(6, 20); 
	Checkbox cb1 = new Checkbox("Check Box 1"); 
	Checkbox cb2 = new Checkbox("Check Box 2");  
	Checkbox cb3 = new Checkbox("Check Box 3"); 
	public void init() {     
		add(t); add(cb1); add(cb2); add(cb3); 
		}   
	public boolean action (Event evt, Object arg) {     
		if(evt.target.equals(cb1))    
			trace("1", cb1.getState());  
		else if(evt.target.equals(cb2))  
			trace("2", cb2.getState());   
		else if(evt.target.equals(cb3))  
			trace("3", cb3.getState());   
		else        
			return super.action(evt, arg);  
		return true;   }  
	void trace(String b, boolean state) { 
		if(state)       
			t.append("Box " + b + " Set\n");     
		else      
			t.append("Box " + b + " Cleared\n");   } } 