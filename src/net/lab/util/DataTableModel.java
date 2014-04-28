package net.lab.util;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import net.lab.util.DataModel;

public class DataTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private Vector<DataModel> dataarray;
	private int ColumnCount = 10;
	
	private int selectedId=0;
	private int selectedRow=0;
	
	
	public DataTableModel(Vector<DataModel> d){
		dataarray = d;
	}

	@Override
	public String getColumnName(int ColumnIndex){
		switch(ColumnIndex){
		case 0: return "Street";
		case 1: return "Dom";
		case 2: return "Kv";
		case 3: return "Ls";
		case 4: return "Fio";
		case 5: return "Month";
		case 6: return "VxS";
		case 7: return "Nach";
		case 8: return "Opl";
		case 9: return "IsxS";
		
		}
		return null;
	}
	
	@Override
	public int getColumnCount() {
		return ColumnCount;
	}

	@Override
	public int getRowCount() {
		return dataarray.size();
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex){
		 DataModel rdm =  dataarray.get(rowIndex);
		    switch (columnIndex) {
		      case 0: rdm.setStreet((String) aValue);break;
		      case 1: rdm.setDom((String) aValue);break;
		      case 2: rdm.setKv((String) aValue);break;
		      case 3: rdm.setLs((int) aValue);break;
		      case 4: rdm.setFio((String) aValue);break;
		      case 5: rdm.setMonth((String) aValue);break;
		      case 6: rdm.setVx((Double) aValue);break;
		      case 7: rdm.setNach((Double) aValue);break;
		      case 8: rdm.setOpl((Double) aValue);break;
		      case 9: rdm.setIsx((Double) aValue);break;
		    }
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
	 DataModel rdm =  dataarray.get(arg0);
		    switch (arg1) {
		      case 0: return rdm.getStreet();
		      case 1: return rdm.getDom();
		      case 2: return rdm.getKv();
		      case 3: return rdm.getLs();
		      case 4: return rdm.getFio();
		      case 5: return rdm.getMonth();
		      case 6: return rdm.getVx();
		      case 7: return rdm.getNach();
		      case 8: return rdm.getOpl();
		      case 9: return rdm.getIsx();
		    }
    return null;
		
	}
	public int getId(int arg0) {
		 DataModel rdm =  dataarray.get(arg0);
		 return rdm.getId();
	}

	public int getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public DataModel getRow(int num_row){
		DataModel rdm =  dataarray.get(num_row);
		return rdm;
	}

}
