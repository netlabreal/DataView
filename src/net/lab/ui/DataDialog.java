package net.lab.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.lab.util.DataModel;
import net.lab.util.DataTableModel;

public class DataDialog extends JDialog {
	private static final int D_HEIGHT = 190;  // ������ ����
    private final static int D_WIDTH = 600;   // ������ ����
    private ViewPort owner;
	
    public JTextField streetf=new JTextField();
	public JTextField domf=new JTextField();
	public JTextField kvf=new JTextField();
	public JTextField lsf=new JTextField();
	public JTextField ff=new JTextField();
	
	public JTextField mf=new JTextField();
	public JTextField vxf=new JTextField();
	public JTextField nachf=new JTextField();
	public JTextField oplf=new JTextField();
	public JTextField isxf=new JTextField();
    
    public DataDialog(JFrame f, DataTableModel dm) {
		setTitle("���� ����� ������.");
		int width = f.getWidth()/2-D_WIDTH/2;
		int height = f.getHeight()/2-D_HEIGHT/2;
		setBounds(width, height, D_WIDTH, D_HEIGHT);
		
		Init();
		
		
		
	}
    
    public void Init(){
		setLayout(new BorderLayout());
		JPanel p = new JPanel(new GridBagLayout());
		
		//*************************************************//
		JLabel streetLabel = new JLabel("�����: ");
		p.add(streetLabel,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		streetf = new JTextField(10);
		p.add(streetf,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(5, 50, 2, 2),0,0));
		
		JLabel DomLabel = new JLabel("���: ");
		p.add(DomLabel,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		domf = new JTextField(10);
		p.add(domf,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 50, 2, 2),0,0));
		
		JLabel KvLabel = new JLabel("��: ");
		p.add(KvLabel,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		kvf = new JTextField(10);
		p.add(kvf,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 50, 2, 2),0,0));
		
		JLabel LsLabel = new JLabel("��: ");
		p.add(LsLabel,new GridBagConstraints(0,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		lsf = new JTextField(10);
		p.add(lsf,new GridBagConstraints(0,3,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 50, 2, 2),0,0));
		
		JLabel FioLabel = new JLabel("���: ");
		p.add(FioLabel,new GridBagConstraints(0,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		ff = new JTextField(10);
		p.add(ff,new GridBagConstraints(0,4,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 50, 2, 2),0,0));

		//*************************************************//
		JLabel MLabel1 = new JLabel("�����: ");
		p.add(MLabel1,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		mf = new JTextField(10);
		p.add(mf,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(5, 125, 2, 2),0,0));

		JLabel VxLabel = new JLabel("�������� ������: ");
		p.add(VxLabel,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		vxf = new JTextField(10);
		p.add(vxf,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 125, 2, 2),0,0));
		
		JLabel NachLabel = new JLabel("���������: ");
		p.add(NachLabel,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		nachf = new JTextField(10);
		p.add(nachf,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 125, 2, 2),0,0));
		
		int kj = 1;
		
		JLabel OplLabel = new JLabel("��������: ");
		p.add(OplLabel,new GridBagConstraints(1,3,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		oplf = new JTextField(10);
		p.add(oplf,new GridBagConstraints(1,3,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 125, 2, 2),0,0));
		
		JLabel IsxLabel = new JLabel("��������� ������: ");
		p.add(IsxLabel,new GridBagConstraints(1,4,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		isxf = new JTextField(10);
		p.add(isxf,new GridBagConstraints(1,4,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(2, 125, 2, 2),0,0));
    	
		add(p,BorderLayout.NORTH);
		
		JPanel but_p = new JPanel();
		JButton ok = new JButton("OK");
		JButton ex = new JButton("EXIT");
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		ex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
		});

		but_p.add(ok);
		but_p.add(ex);
		add(but_p,BorderLayout.EAST);
		
    }
    
	
}
