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
					ViewPort vp = new ViewPort();
			}
		});
	}

}
