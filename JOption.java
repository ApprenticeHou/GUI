package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOption {
JOption(){
	JFrame jr=new JFrame();
	JOptionPane jp=new JOptionPane("jop");
	jp.showMessageDialog(jr, "����һ��");
}
public static void main(String[] args) {
	JOption jo=new JOption();
}
}
