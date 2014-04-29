package net.lab.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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

public class ViewPort extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel top,bot,b_panel,grid_tab;
	private JButton ex,ok;
	
	private JMenuBar mbar;
	
	private JTabbedPane tab;

	private	DataTableModel dtm =null;

	JProgressBar progress;
	
	private InfoPanel info;
	
	public JTable tt;
	public JFrame own;
	
	public ViewPort(){
		own=this;
		Init();
		InitPanels();
		InitButtons();
		InitMenu();
		InitTab();
		
		//**************************************//
		//**************************************//
	}
	
	
	
	public void Init(){
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setDefaultLookAndFeelDecorated(true);
	
	setLayout(new BorderLayout());
	setBounds(10,10,800,600);
	setPreferredSize(new Dimension(800, 600));
	setTitle("Преобразование данных");
	//setExtendedState(MAXIMIZED_BOTH);

	setVisible(true);
	
	}
	
	public void InitPanels(){
		top = new JPanel();
		top.setBackground(Color.black);
		top.setFocusable(false);

		bot = new JPanel();
		//bot.setBackground(Color.BLUE);
		bot.setLayout(new BorderLayout());
		bot.setFocusable(false);
		
		//cent = new JPanel();
		//cent.setBackground(Color.white);
		
		add(top,BorderLayout.NORTH);
		add(bot,BorderLayout.SOUTH);
		//add(cent,BorderLayout.CENTER);
	}
	
	public void InitButtons(){
		b_panel = new JPanel();
		JPanel p_panel = new JPanel();
		b_panel.setFocusable(false);
		
		progress = new JProgressBar();
		//progress.setBorder(null);
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
		ok = new JButton("Выгрузить данные в XML");
		//********************************//
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Thread th = new Thread(){
					public void run(){
						progress.setVisible(true);
						progress.setMinimum(0);
						progress.setMaximum(dtm.getRowCount());
						try {
							for (int i = 0; i < dtm.getRowCount(); i++) {
								Thread.currentThread();
								Thread.sleep(1);
								System.out.println(dtm.getValueAt(i, 0));
								progress.setValue(i);
							}
							progress.setVisible(false);
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				th.start();

			}
		});
		//********************************//
		b_panel.add(ok);b_panel.add(ex);
		
		bot.add(b_panel,BorderLayout.WEST);
		bot.add(p_panel,BorderLayout.EAST);
		//bot.add(progress,BorderLayout.EAST);
	}
	
	public void InitMenu(){
		mbar = new JMenuBar();
		JMenu menu = new JMenu("Данные");
		JMenu menuvid = new JMenu("Вид");
		
		JMenuItem mitem2 = new JMenuItem("Показывать информационную панель");
		
		JMenuItem mitem = new JMenuItem("Установить соединение и загрузить данные");
		JMenuItem mitem1 = new JMenuItem("Выход");
		menu.add(mitem);menu.add(mitem1);menuvid.add(mitem2);
		mbar.add(menu);mbar.add(menuvid);
	
		mbar.setFocusable(false);
		setJMenuBar(mbar);
		//******************************************************//
		mitem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Thread thr = new Thread(new ThreadSearch(tt));
				//thr.start();
				tt.requestFocusInWindow();
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
				//tt.setFocusable(false);

				tt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tt.setRowSelectionInterval(1,1);
				//tt.setFocusable(true);
				//tt.requestFocus();
	
				
				//***************************************************//
				ListSelectionModel cellSelectionModel = tt.getSelectionModel();
				cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						String selectedData = null;

				        int selectedRow = tt.getSelectedRow();
				        info.streetf.setText((String) tt.getValueAt(selectedRow, 0));
				        info.domf.setText((String) tt.getValueAt(selectedRow, 1));
				        info.kvf.setText((String) tt.getValueAt(selectedRow, 2));
				        info.lsf.setText((String) tt.getValueAt(selectedRow, 3).toString());
				        info.ff.setText((String) tt.getValueAt(selectedRow, 4));
				        String dk = " д. "+tt.getValueAt(selectedRow, 1)+" кв. "+tt.getValueAt(selectedRow, 2);
				        String fl = " лс. "+tt.getValueAt(selectedRow, 3)+" фио "+tt.getValueAt(selectedRow, 4);
				        
				        info.mf.setText((String) tt.getValueAt(selectedRow, 5).toString());
				        info.vxf.setText((String) tt.getValueAt(selectedRow, 6).toString());
				        info.nachf.setText((String) tt.getValueAt(selectedRow, 7).toString());
				        info.oplf.setText((String) tt.getValueAt(selectedRow, 8).toString());
				        info.oplf.setText((String) tt.getValueAt(selectedRow, 8).toString());
				        
				        //info.isxf.setText((String) dtm.getId(selectedRow).toString());
				        info.isxf.setText((String) tt.getValueAt(selectedRow, 9).toString());
				        
						info.t = tt;

				        dtm.setSelectedId(dtm.getId(selectedRow));
				        System.out.println(dtm.getSelectedId());
				        selectedData =  tt.getValueAt(selectedRow, 0)+dk+fl;
				        
				        System.out.println(selectedData);
					}
				});
				//***************************************************//
				
				//tt.setValueAt("", 0, 0);
				JScrollPane scroll = new JScrollPane(tt);
			
				//scroll.setPreferredSize(new Dimension(800,800));
				grid_tab.add(scroll);
				//---------------------------------------//
				info =new InfoPanel();
				info.ff1 = own;
				//JPanel info_panel = new JPanel(new BorderLayout());
				//info_panel.setBounds(10,10, 100, 100);
				grid_tab.add(info,BorderLayout.SOUTH);
			
				//info_panel.add(new JTextField("1111222222222222222222"),BorderLayout.NORTH);
				//info_panel.add(new JTextField("1111222222222222222222"),BorderLayout.SOUTH);
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
						grid_tab=null;
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
				
				
				
		        int selectedRow = tt.getSelectedRow();
		        info.streetf.setText((String) tt.getValueAt(selectedRow, 0));
		        info.domf.setText((String) tt.getValueAt(selectedRow, 1));
		        info.kvf.setText((String) tt.getValueAt(selectedRow, 2));
		        info.lsf.setText((String) tt.getValueAt(selectedRow, 3).toString());
		        info.ff.setText((String) tt.getValueAt(selectedRow, 4));
		        //String dk = " д. "+tt.getValueAt(selectedRow, 1)+" кв. "+tt.getValueAt(selectedRow, 2);
		        //String fl = " лс. "+tt.getValueAt(selectedRow, 3)+" фио "+tt.getValueAt(selectedRow, 4);
		        
		        info.mf.setText((String) tt.getValueAt(selectedRow, 5).toString());
		        info.vxf.setText((String) tt.getValueAt(selectedRow, 6).toString());
		        info.nachf.setText((String) tt.getValueAt(selectedRow, 7).toString());
		        info.oplf.setText((String) tt.getValueAt(selectedRow, 8).toString());
		        info.oplf.setText((String) tt.getValueAt(selectedRow, 8).toString());
		        
		        //info.isxf.setText((String) dtm.getId(selectedRow).toString());
		        info.isxf.setText((String) tt.getValueAt(selectedRow, 9).toString());
		        
		        dtm.setSelectedId(dtm.getId(selectedRow));
		        System.out.println(dtm.getSelectedId());
		       
				
				
			}
			}
		});
		
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
			dms = DataManagementSystem.getInstance();
		    vdm = new Vector<DataModel>(dms.getData("C:\\11.accdb"));
	        dtm = new DataTableModel(vdm);
	        
			//-----------------------------//
	        //-----------------------------//
	        dtm.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent arg0) {
					System.out.println(arg0);	
				}
			//-----------------------------//
	        
	        });
	        
//dtm.getRowCount()
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtm;
	}
	
}
