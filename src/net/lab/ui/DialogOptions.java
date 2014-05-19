package net.lab.ui;

import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.lab.util.Dbf;

public class DialogOptions extends JDialog {

	private static final long serialVersionUID = 1L;

	public DialogOptions() {
		Init(10,10,300,300);
	}
	public DialogOptions(int x,int y, int w, int z) {
		Init(x,y,w,z);
	}
	
	public void Init(int x,int y, int w, int z){
		
		
		setTitle("Настройки");
		setBounds(x, y, w, z);

		Dbf dbf = new Dbf();
		//*************************************************//
		setLayout(new GridBagLayout());
		JLabel PathMdb = new JLabel("Путь к БД (.mdb) : ");FileDialog fd = new FileDialog(this,"Выберите БД");
		fd.setVisible(true);
		add(PathMdb,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		//add(PassLabel,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2, 2, 2, 2),0,0));
		
		JTextField login = new JTextField(15);
		add(login,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,new Insets(0, 0, 0, 0),0,0));
		//*************************************************//
		
		
		//JButton okButton = new JButton("OK");
		//add(okButton);
	}
}
