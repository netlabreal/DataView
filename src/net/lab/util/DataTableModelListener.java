package net.lab.util;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class DataTableModelListener implements TableModelListener  {
	private JTable table;

	public DataTableModelListener(JTable t){
		table = t;
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		 int firstRow = e.getFirstRow();
		 switch (e.getType()) {
		    case TableModelEvent.INSERT:  System.out.println("INSERT"); break;
		    case TableModelEvent.UPDATE:  System.out.println("UPDATE");break;
		    case TableModelEvent.DELETE:  System.out.println("DELETE");break;
		 }
	}
	
	

}
