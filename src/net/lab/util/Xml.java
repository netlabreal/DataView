package net.lab.util;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JProgressBar;
import javax.swing.JTable;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Xml implements Runnable {
	private Element rootel=null;
	private JTable table;
	private JProgressBar pbar=null;

	
	public Xml(JTable t, JProgressBar pb) {
		rootel = new Element("DATA");
		table = t;
		pbar = pb;
	}
	
	public void SaveDoc(){
		Document doc = new Document(rootel);
		try{
			 XMLOutputter out = new XMLOutputter();
			 out.setFormat(Format.getPrettyFormat());
			 OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream("C:\\output.xml"), "UTF-8");
			 out.output(doc, wr);
			 wr.close();
		}
		catch (Exception ex){
			 System.out.println(ex.getMessage());
		}
	}
	
	public void InsertData(int j){
		Element ls = new Element("ls");
		ls.setAttribute("nomer",table.getValueAt(j,3).toString());
		ls.setAttribute("fio",table.getValueAt(j, 4).toString());
		ls.setAttribute("street",table.getValueAt(j, 0).toString());
		ls.setAttribute("dom",table.getValueAt(j, 1).toString());
		ls.setAttribute("kv",table.getValueAt(j, 2).toString());
		rootel.addContent(ls);
		
		Element Nach = new Element("nach");
		Nach.setAttribute("Month",table.getValueAt(j, 5).toString());
		Nach.setAttribute("VxS",table.getValueAt(j, 6).toString());
		Nach.setAttribute("Nach",table.getValueAt(j, 7).toString());
		Nach.setAttribute("Opl",table.getValueAt(j, 8).toString());
		Nach.setAttribute("IsxS",table.getValueAt(j, 9).toString());
		ls.addContent(Nach);
	}
	

	@Override
	public void run() {
		pbar.setVisible(true);
		int count = table.getRowCount();
		pbar.setMinimum(0);pbar.setMaximum(count);
		for (int i = 0; i < count; i++) {
			try {
				Thread.sleep(1);
				pbar.setValue(i);
				InsertData(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			table.setRowSelectionInterval(0,i);
			System.out.println(i);
		}
		SaveDoc();
		pbar.setVisible(false);
	}

}
