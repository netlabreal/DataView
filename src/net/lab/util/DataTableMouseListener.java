package net.lab.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class DataTableMouseListener implements MouseListener{
	private JTable table;

	public DataTableMouseListener(JTable t) {
		table = t;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int ii = table.getSelectedRow();
		//String val = (String) table.getValueAt(ii, 0);
		//table.getModel().setValueAt(val+"1111", ii, 0);
		DataTableModel drm = (DataTableModel) table.getModel();
		drm.setSelectedRow(ii);
		//drm.fireTableCellUpdated(ii, 0);
		int y =1;
		y =y+3;

		System.out.println("CLICKED");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	
}
