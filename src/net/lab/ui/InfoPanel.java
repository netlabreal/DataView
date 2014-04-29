package net.lab.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class InfoPanel extends JPanel{
	
	public JFrame ff1;
	public JTable t;
	private static final long serialVersionUID = 1L;
	public JTextField streetf;
	public JTextField domf;
	public JTextField kvf;
	public JTextField lsf;
	public JTextField ff;
	
	public JTextField mf;
	public JTextField vxf;
	public JTextField nachf;
	public JTextField oplf;
	public JTextField isxf;
	
	
	public InfoPanel(){
		setLayout(new GridBagLayout());
		//*************************************************//
		JLabel streetLabel = new JLabel("Улица: ");
		add(streetLabel,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		streetf = new JTextField(10);
		streetf.setEditable(false);
		add(streetf,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(5, 50, 2, 2),0,0));
		
		JLabel DomLabel = new JLabel("Дом: ");
		add(DomLabel,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		domf = new JTextField(10);
		domf.setEditable(false);
		add(domf,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 50, 2, 2),0,0));
		
		JLabel KvLabel = new JLabel("Кв: ");
		add(KvLabel,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		kvf = new JTextField(10);
		kvf.setEditable(false);		
		add(kvf,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 50, 2, 2),0,0));
		
		JLabel LsLabel = new JLabel("ЛС: ");
		add(LsLabel,new GridBagConstraints(0,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		lsf = new JTextField(10);
		lsf.setEditable(false);		
		add(lsf,new GridBagConstraints(0,3,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 50, 2, 2),0,0));
		
		JLabel FioLabel = new JLabel("ФИО: ");
		add(FioLabel,new GridBagConstraints(0,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		ff = new JTextField(10);
		ff.setEditable(false);		
		add(ff,new GridBagConstraints(0,4,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 50, 2, 2),0,0));

		//*************************************************//
		JLabel MLabel1 = new JLabel("Месяц: ");
		add(MLabel1,new GridBagConstraints(2,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		mf = new JTextField(10);
		mf.setEditable(false);		
		add(mf,new GridBagConstraints(2,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(5, 50, 2, 200),0,0));

		JLabel VxLabel = new JLabel("Входящее сальдо: ");
		add(VxLabel,new GridBagConstraints(2,1,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		vxf = new JTextField(10);
		vxf.setEditable(false);		
		add(vxf,new GridBagConstraints(2,1,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 125, 2, 200),0,0));
		
		JLabel NachLabel = new JLabel("Начислено: ");
		add(NachLabel,new GridBagConstraints(2,2,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		nachf = new JTextField(10);
		nachf.setEditable(false);		
		add(nachf,new GridBagConstraints(2,2,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 125, 2, 200),0,0));
		
		JLabel OplLabel = new JLabel("Оплачено: ");
		add(OplLabel,new GridBagConstraints(2,3,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		oplf = new JTextField(10);
		oplf.setEditable(false);		
		add(oplf,new GridBagConstraints(2,3,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 125, 2, 200),0,0));
		
		JLabel IsxLabel = new JLabel("Исходящее сальдо: ");
		add(IsxLabel,new GridBagConstraints(2,4,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		isxf = new JTextField(10);
		isxf.setEditable(false);		
		add(isxf,new GridBagConstraints(2,4,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 125, 2, 200),0,0));
		
		//JLabel MLabel = new JLabel("");
		//add(MLabel,new GridBagConstraints(3,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		//*************************************************//
		
	}

	public void setData(String s){
		streetf.setText(s);
	}
	
}
