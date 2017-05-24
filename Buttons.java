package GUI;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;

public class Buttons extends JPanel{
JButton jb=new JButton("Jbutton");
BasicArrowButton up=new BasicArrowButton(BasicArrowButton.NORTH);
BasicArrowButton down=new BasicArrowButton(BasicArrowButton.SOUTH);
BasicArrowButton right=new BasicArrowButton(BasicArrowButton.EAST);
BasicArrowButton left=new BasicArrowButton(BasicArrowButton.WEST);
public Buttons(){
	add(jb);
	add(new JToggleButton("jt"));
	add(new JCheckBox("jc"));
	add(new JRadioButton("jr"));
	JPanel jp=new JPanel();
	jp.setBorder(new TitledBorder("Direction"));
	jp.add(up);
	jp.add(down);
	jp.add(right);
	jp.add(left);
	add(jp);
}
public static void main(String[] args) {
	show.inFrame(new Buttons(), 500, 300);
}
}
