package GUI;

import java.awt.Button;
import java.awt.Event;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;  
public class FileDialogTest extends Frame {   
	TextField filename = new TextField(); 
	TextField directory = new TextField(); 
	Button open = new Button("Open");
	Button save = new Button("Save");  
	public FileDialogTest() {     
		setTitle("File Dialog Test"); 
		Panel p = new Panel();  
		p.setLayout(new FlowLayout());  
		p.add(open);   
		p.add(save);    
		add("South", p);    
		directory.setEditable(false);   
		filename.setEditable(false);  
		p = new Panel(); 
		p.setLayout(new GridLayout(2,1)); 
		p.add(filename);  
		p.add(directory);   
		add("North", p);   
		}   
	public boolean handleEvent(Event evt) {  
		if(evt.id == Event.WINDOW_DESTROY)   
			System.exit(0);    
		else      
			return super.handleEvent(evt);    
		return true;  
		}  
	public boolean action(Event evt, Object arg) {   
		if(evt.target.equals(open)) {   
			// Two arguments, defaults to open file:  
			FileDialog d = new FileDialog(this,     
					"What file do you want to open?");   
			d.setFile("*.java"); // Filename filter    
			d.setDirectory("."); // Current directory   
			d.show();     
			String openFile;  
			if((openFile = d.getFile()) != null) {   
				filename.setText(openFile);    
				directory.setText(d.getDirectory()); 
				} else {      
					filename.setText("You pressed cancel"); 
        directory.setText("");
        }     }    
		else if(evt.target.equals(save)) {    
			FileDialog d = new FileDialog(this, 
					"What file do you want to save?",  
					FileDialog.SAVE);    
			d.setFile("*.java");  
			d.setDirectory(".");    
			d.show();     
			String saveFile;    
			if((saveFile = d.getFile()) != null) {  
				filename.setText(saveFile);   
				directory.setText(d.getDirectory()); 
				} 
			else {    
				filename.setText("You pressed cancel");
				directory.setText("");       }     }    
		else  
			return super.action(evt, arg);   
		return true; 
		} 
	public static void main(String[] args) { 
		Frame f = new FileDialogTest();   
		f.setSize(250,120); 
		f.setVisible(true);  
		}
	}