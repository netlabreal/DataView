package net.lab.main;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import net.lab.ui.ViewPort;
import net.lab.util.DataManagementSystem;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
					DataManagementSystem dms=null;
					try {
						dms = DataManagementSystem.getInstance();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						System.out.println(dms.getInfo());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
					ViewPort vp = new ViewPort();
					
			}
		});
	}

}
