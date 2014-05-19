package net.lab.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.metal.MetalIconFactory;

import net.lab.util.DataManagementSystem;
import net.lab.util.DataModel;
import net.lab.util.DataTableModel;
import net.lab.util.Pdf;
import net.lab.util.Xml;

public class ViewPort extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel top,bot,b_panel,grid_tab;
	private JButton ex,ok,dbf;
	private JMenuBar mbar;
	private JTabbedPane tab;
	private	DataTableModel dtm =null;
	private JProgressBar progress;
	private InfoPanel info =null;
	public JTable tt;
	public JFrame own;
	private JMenuItem mitem2;
	
	public ViewPort(){
		//**************************************//
		own=this;
		Init();
		InitPanels();
		InitButtons();
		InitMenu();
		InitTab();
		//**************************************//
	}
	
	public void Init(){
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setDefaultLookAndFeelDecorated(true);
	
	setLayout(new BorderLayout());
	setBounds(10,10,800,600);
	setPreferredSize(new Dimension(800, 600));
	setTitle("Преобразование данных");
	setVisible(true);
	
	//Xml x = new Xml();
	//x.InitDoc();
	}
	
	public void InitPanels(){
		top = new JPanel();
		top.setBackground(Color.black);
		top.setFocusable(false);

		bot = new JPanel();
		bot.setLayout(new BorderLayout());
		bot.setFocusable(false);
		
		add(top,BorderLayout.NORTH);
		add(bot,BorderLayout.SOUTH);
	}
	
	public void InitButtons(){
		b_panel = new JPanel();
		JPanel p_panel = new JPanel();
		b_panel.setFocusable(false);
		
		progress = new JProgressBar();
		progress.setVisible(false);
		
		p_panel.add(progress);
		
		ex = new JButton("Выход");
		//********************************//
		ex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//********************************//
		bot.add(ex,BorderLayout.WEST);
		dbf = new JButton("Выгрузить данные в DBF");
		dbf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pdf pdf = new Pdf();
				try {
					Runtime.getRuntime().exec("C:/Program Files/Adobe/Reader 9.0/Reader/AcroRd32.exe "+pdf.FILE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		//********************************//
		ok = new JButton("Выгрузить данные в XML");
		//********************************//
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Thread th = new Thread(){
				//	public void run(){
				//		progress.setVisible(true);
				//		progress.setMinimum(0);
				//		progress.setMaximum(dtm.getRowCount());
				//		try {
				//			for (int i = 0; i < dtm.getRowCount(); i++) {
				//				Thread.currentThread();
				//				Thread.sleep(1);
				//				System.out.println(dtm.getValueAt(i, 0));
				//				progress.setValue(i);
				//			}
				//			progress.setVisible(false);
				//		} catch (InterruptedException e) {
				//			// TODO Auto-generated catch block
				//			e.printStackTrace();
				//		}
				//	}
				//};
				//th.start();
				//progress.setVisible(true);
				//setResizable(false);
				Xml xml = new Xml(tt, progress);
				
				//ThreadSearch ths = new ThreadSearch(tt, progress);
				Thread t1 = new Thread(xml);
				t1.start();
			}
		});
		//********************************//
		b_panel.add(ok);b_panel.add(dbf);b_panel.add(ex);
		ok.setEnabled(false);dbf.setEnabled(false);
		
		bot.add(b_panel,BorderLayout.WEST);
		bot.add(p_panel,BorderLayout.EAST);
	}
	
	public void InitMenu(){
		mbar = new JMenuBar();
		JMenu menu = new JMenu("Данные");
		JMenu menuvid = new JMenu("Вид");
		JMenu menuopt = new JMenu("Настройки");
		JMenu menuhelp = new JMenu("Помощь");
		
		JMenuItem options = new JMenuItem("Прочитать файл настроек");
		JMenuItem help = new JMenuItem("О программе");
			help.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int reply = JOptionPane.showConfirmDialog(null, "Is Hello world?", "Title", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION){
						int x = (getWidth()/2)-150;	int y = (getHeight()/2)-150;
						DialogOptions d = new DialogOptions(x,y,300,300);
						d.setModal(true);d.setVisible(true);
					}					
				}
			});
		
		mitem2 = new JMenuItem("Показывать информационную панель");
		mitem2.setEnabled(false);
		JMenuItem mitem = new JMenuItem("Установить соединение и загрузить данные");
		JMenuItem mitem1 = new JMenuItem("Выход");
		menu.add(mitem);menu.add(mitem1);menuvid.add(mitem2);menuopt.add(options);menuhelp.add(help);
		mbar.add(menu);mbar.add(menuvid);mbar.add(menuopt);mbar.add(menuhelp);
	
		mbar.setFocusable(false);
		setJMenuBar(mbar);
		//******************************************************//
		mitem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(info==null){
					info =new InfoPanel();
					info.ff1 = own;
					grid_tab.add(info,BorderLayout.SOUTH);
					tt.requestFocusInWindow();
					InitInfo();
				}
				else
				{
					grid_tab.remove(info);
					info = null;
				}
			}
		});
		//******************************************************//
		mitem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		//******************************************************//
		mitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(grid_tab==null)
				{
					grid_tab = new JPanel(new BorderLayout());
					grid_tab.setFocusable(false);tab.setFocusable(false);
					tt = new JTable(ReturnData());
					tt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tt.setRowSelectionInterval(1,1);
					mitem2.setEnabled(true);
					JPopupMenu poupmenu = new JPopupMenu();
					 JMenuItem jMenuItem_A = new JMenuItem("Выгрузить данные в XML");
					 JMenuItem jMenuItem_B = new JMenuItem("Выгрузить данные в DBF");
					 poupmenu.add(jMenuItem_A);poupmenu.add(jMenuItem_B);
					 tt.setComponentPopupMenu(poupmenu);
					//***************************************************//
					ListSelectionModel cellSelectionModel = tt.getSelectionModel();
					cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
				        int selectedRow = tt.getSelectedRow();
						InitInfo();
				        
				        dtm.setSelectedId(dtm.getId(selectedRow));
				        System.out.println(dtm.getSelectedId());
					}
				});
				//***************************************************//
				JScrollPane scroll = new JScrollPane(tt);
				grid_tab.add(scroll);
				//---------------------------------------//
				info =new InfoPanel();
				info.ff1 = own;
				grid_tab.add(info,BorderLayout.SOUTH);
				//---------------------------------------//
				JPanel dop = new JPanel(new GridBagLayout());
				dop.setOpaque(false);
				//*--------------------------------//
				JButton btnClose = new JButton(MetalIconFactory.getInternalFrameCloseIcon(16));
				btnClose.setBorder(null);
				btnClose.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						int ind = tab.indexOfTab("Данные о квартиросъемщиках");
						tab.removeTabAt(ind);
						tt=null;
						grid_tab=null;
						mitem2.setEnabled(false);
						ok.setEnabled(false);dbf.setEnabled(false);	
					}
				});	
				//*--------------------------------//
				//******************************************************//
				JLabel lblTitle = new JLabel("Данные о квартиросъемщиках  ");
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.weightx = 1;
				dop.add(lblTitle, gbc);
				gbc.gridx++;
				gbc.weightx = 0;
				
				dop.add(btnClose, gbc);
				tab.addTab("Данные о квартиросъемщиках", grid_tab);
				int index = tab.indexOfTab("Данные о квартиросъемщиках");
				tab.setTabComponentAt(index, dop);
				tt.requestFocusInWindow();
				//******************************************************//
				InitInfo();
				ok.setEnabled(true);dbf.setEnabled(true);
		        System.out.println(dtm.getSelectedId());
			}
			}
		});
		
	}
	
	public void InitInfo(){
		if(info!=null){
        int selectedRow = tt.getSelectedRow();
        
        info.t = tt;
        info.streetf.setText((String) tt.getValueAt(selectedRow, 0));
        info.domf.setText((String) tt.getValueAt(selectedRow, 1));
        info.kvf.setText((String) tt.getValueAt(selectedRow, 2));
        info.lsf.setText((String) tt.getValueAt(selectedRow, 3).toString());
        info.ff.setText((String) tt.getValueAt(selectedRow, 4));
        info.mf.setText((String) tt.getValueAt(selectedRow, 5).toString());
        info.vxf.setText((String) tt.getValueAt(selectedRow, 6).toString());
        info.nachf.setText((String) tt.getValueAt(selectedRow, 7).toString());
        info.oplf.setText((String) tt.getValueAt(selectedRow, 8).toString());
        info.oplf.setText((String) tt.getValueAt(selectedRow, 8).toString());
        info.isxf.setText((String) tt.getValueAt(selectedRow, 9).toString());
        dtm.setSelectedId(dtm.getId(selectedRow));
		}
	}
	
	public void InitTab(){
		tab = new JTabbedPane();
		add(tab,BorderLayout.CENTER);
		tab.setFocusable(false);
	}

	public DataTableModel ReturnData(){
		DataManagementSystem dms;
		Vector<DataModel> vdm;
		try {
			//-----------------------------//
			dms = DataManagementSystem.getInstance();
		    vdm = new Vector<DataModel>(dms.getData("C:\\11.accdb"));
	        dtm = new DataTableModel(vdm);
	        //-----------------------------//
	        dtm.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent arg0) {
					System.out.println(arg0);	
				}
			//-----------------------------//
	        });
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtm;
	}
}
