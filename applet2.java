package GUI;

import java.applet.Applet;
import java.awt.Graphics;

public class applet2 extends Applet{
public void paint(Graphics g){
	g.drawString("hehe", 10, 10);
	g.draw3DRect(0, 0, 200, 20, true);
}
}
