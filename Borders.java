package GUI;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class Borders extends JPanel{
static JPanel showBorder(Border b){
	JPanel j=new JPanel();
	j.setLayout(new BorderLayout());
	String m=b.getClass().toString();
	m=m.substring(m.indexOf(".")+1);
	j.add(new JLabel(m,JLabel.CENTER),BorderLayout.CENTER);
	j.setBorder(b);
	return j;
}
public Borders(){
	 setLayout(new GridLayout(2,4));
	 add(showBorder(new TitledBorder("Title")));
	 add(showBorder(new EtchedBorder()));
	 add(showBorder(new LineBorder(Color.RED)));
	 add(showBorder(new MatteBorder(5,5,10,10,Color.BLUE)));
	 add(showBorder(new BevelBorder(BevelBorder.RAISED)));
	 add(showBorder(new SoftBevelBorder(BevelBorder.LOWERED)));
	 add(showBorder(new CompoundBorder(new EtchedBorder(), new LineBorder(Color.GREEN))));
}
public static void main(String[] args) {
	show.inFrame(new Borders(), 500, 300);
}
}
