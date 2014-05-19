package net.lab.util;

import java.awt.Rectangle;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JViewport;

public class ThreadSearch implements Runnable{
	private JTable table;
	private JProgressBar pbar;
	
	public ThreadSearch(JTable t, JProgressBar pb){
		table = t;pbar = pb;
	}
	
	public void ScrollToCenter(int rowIndex, int vColIndex){
		 if (!(table.getParent() instanceof JViewport)) {
		      return;
		    }
		JViewport viewport = (JViewport) table.getParent();	
		 Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);
		    Rectangle viewRect = viewport.getViewRect();
		    rect.setLocation(rect.x - viewRect.x, rect.y - viewRect.y);

		    int centerX = (viewRect.width - rect.width) / 2;
		    int centerY = (viewRect.height - rect.height) / 2;
		    if (rect.x < centerX) {
		      centerX = -centerX;
		    }
		    if (rect.y < centerY) {
		      centerY = -centerY;
		    }
		    rect.translate(centerX, centerY);
		    viewport.scrollRectToVisible(rect);		
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
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			table.setRowSelectionInterval(0,i);
			System.out.println(i);
		}
		pbar.setVisible(false);
	}
}
