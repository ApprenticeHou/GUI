package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;  
public class ToeTestNew extends Frame {
	TextField rows = new TextField("3");  
	TextField cols = new TextField("3");
	public ToeTestNew() {    
		setTitle("Toe Test");    
		Panel p = new Panel();  
		p.setLayout(new GridLayout(2,2));   
		p.add(new Label("Rows", Label.CENTER));  
		p.add(rows);    
		p.add(new Label("Columns", Label.CENTER));
		p.add(cols); 
		add(p, BorderLayout.NORTH); 
		Button b = new Button("go");   
		b.addActionListener(new BL());  
		add(b, BorderLayout.SOUTH); 
		}  
	static final int BLANK = 0; 
	static final int XX = 1;  
	static final int OO = 2;
	class ToeDialog extends Dialog { 
		// w = number of cells wide     // h = number of cells high   
		int turn = XX; // Start with x's turn    
		public ToeDialog(int w, int h) {   
			super(ToeTestNew.this,         
					"The game itself", false);
			setLayout(new GridLayout(w, h));    
			for(int i = 0; i < w * h; i++)       
				add(new ToeButton());      
			setSize(w * 50, h * 50);     
			addWindowListener(new WindowAdapter() {   
				public void windowClosing(WindowEvent e){     
					dispose();      
					}     
			});    
			}  
		class ToeButton extends Canvas {
			int state = BLANK;   
			ToeButton() {      
				addMouseListener(new ML());     
				}      
			public void paint(Graphics  g) {      
					int x1 = 0; 
					int y1 = 0;    
					int x2 = getSize().width - 1;  
					int y2 = getSize().height - 1;
					g.drawRect(x1, y1, x2, y2);    
					x1 = x2/4;       
					y1 = y2/4;  
					int wide = x2/2; 
       int high = y2/2;    
       if(state == XX) {      
    	   g.drawLine(x1, y1,      
    			   x1 + wide, y1 + high); 
    	   g.drawLine(x1, y1 + high,     
    			   x1 + wide, y1);    
    	   }         
       if(state == OO) {        
    	   g.drawOval(x1, y1,         
    			   x1 + wide/2, y1 + high/2); 
    	   }     
       }      
			class ML extends MouseAdapter {
				public void mousePressed(MouseEvent e) {
					if(state == BLANK) {        
						state = turn;        
						turn = (turn == XX ? OO : XX);  
						}         
					else       
						state = (state == XX ? OO : XX);   
					repaint();      
					}       
				}    
			}   } 
	class BL implements ActionListener {   
		public void actionPerformed(ActionEvent e) {  
			Dialog d = new ToeDialog(     
					Integer.parseInt(rows.getText()), 
					Integer.parseInt(cols.getText()));  
			d.setVisible(true);;    
			}   
		} 
 public static void main(String[] args) {  
	 Frame f = new ToeTestNew();   
	 f.addWindowListener(    
			 new WindowAdapter() {  
				 public void windowClosing(WindowEvent e) {   
					 System.exit(0);    
					 }       });  
	 f.setSize(200,100);    
	 f.setVisible(true);  
	 }
 }
