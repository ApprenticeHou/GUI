package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

class DataTable extends AbstractTableModel{
	Object[][] data = { 
			{"one", "two", "three", "four"},  
			{"five", "six", "seven", "eight"},  
			{"nine", "ten", "eleven", "twelve"},
			};
	DataTable(){
		addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				// TODO 自动生成的方法存根
				for(int x=0;x<data.length;x++){
					for(int y=0;y<data[x].length;y++)
						System.out.print(data[x][y]);
				}
				System.out.println();
			}
		});
	}
	@Override
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		return data[0].length;
	}
	@Override
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return data.length;
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO 自动生成的方法存根
		return data[row][col];
	}
	public void setValueAt(Object o,int row,int col){
		data[row][col]=o;
		fireTableDataChanged();
	}
}
public class Table extends JPanel{

Table(){
	setLayout(new BorderLayout());
	JTable jt=new JTable(new DataTable());
	JScrollPane jp=new JScrollPane(jt);
	add(jp,BorderLayout.CENTER);
	System.out.println(jt.getRowCount());
}
public static void main(String[] args){
	show.inFrame(new Table(), 500, 200);
}
}
