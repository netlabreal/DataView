package net.lab.main;

import javax.swing.SwingUtilities;

import net.lab.ui.ViewPort;

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
