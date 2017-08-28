package GUI;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class moreEvent extends Frame{
	int i=0;
public moreEvent(){
	setLayout(new FlowLayout());
	ArrayList al=new ArrayList<>();
	Button b1=new Button("button1");
	Button b2=new Button("button2");
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("BUtton 1 press");
		}
	});
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("Button b1 press");
			ActionListener a=new CountListener(i++);
			al.add(a);
			b1.addActionListener(a);
}
	});
	b2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("BUtton 2 press");
		}
	});
	b2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("BUtton b2 press");
			int end=al.size()-1;
			if(end>=0)
			{
				b1.removeActionListener((ActionListener)al.remove(end));
				System.out.println("end"+end);
				i=end;
			}
		}
	});
	add(b1);
	add(b2);
}
class CountListener implements ActionListener{
	int index;
	public CountListener(int i)
	{
		index=i;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("Countlistener "+index);
	}
}
public static void main(String[] args) {
	moreEvent me=new moreEvent();
	me.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	});
	me.setBounds(400, 200, 300, 350);
me.setVisible(true);
}

}