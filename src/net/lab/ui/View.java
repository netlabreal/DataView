package net.lab.ui;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.lab.util.DataManagementSystem;
import net.lab.util.DataModel;
import net.lab.util.DataTableModel;

public class View extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	public  JButton btn = new JButton("Выгрузить данные"); 
	private JList list = new JList();
	private JProgressBar progress; 
	private int count;
	private DataTableModel dtm;
	private JTable table;
	private Vector<DataModel> vdm=new Vector<DataModel>();
	JPanel left; 
	
	
	public View(){
		Init();
		InitMenu();
		InitPanel();
	}
	
	public void InitPanel(){
		//******************************************//
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		//top.setLayout(new FlowLayout(FlowLayout.LEFT));
		//******************************************//
		JPanel bot = new JPanel();
        bot.setLayout(new BorderLayout());	
		//******************************************//
       
        btn.setEnabled(false);
        JButton ex = new JButton("Выход");
        ex.addActionListener(this);
        
		bot.add(btn,BorderLayout.NORTH);
		bot.add(ex,BorderLayout.SOUTH);
		//******************************************//
		
		
		//******************************************//
		left = new JPanel();
		left.setLayout(new BorderLayout());
		Vector<String> v = new Vector<String>();
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");
		//JList list = new JList(v);
        list.setListData(v);
        
        //list.setPreferredSize(new Dimension(100,200));
        //JScrollPane scroll = new JScrollPane(table);
        //JScrollPane sj = new JScrollPane(list);
        //sj.setPreferredSize(new Dimension(100,200));
        //sj.add(list);
		//left.add(sj,BorderLayout.CENTER);
		//left.setBorder(new BevelBorder(BevelBorder.LOWERED));
		//******************************************//
		DataManagementSystem dms;
		try {
			dms = DataManagementSystem.getInstance();
			vdm = new Vector<DataModel>(dms.getData("C:\\11.accdb"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        dtm = new DataTableModel(vdm);
        table = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(400,400));
		left.add(scroll,BorderLayout.CENTER);

		
        progress = new JProgressBar();
		top.add(progress,BorderLayout.SOUTH);
		
			
		//top.add(right);
		top.add(left);
		
		
		add(top,BorderLayout.NORTH);
		add(bot,BorderLayout.SOUTH);
		
	}
	public void InitMenu(){
		 JMenuBar menuBar = new JMenuBar();
		 JMenu menu = new JMenu("Данные");
		 JMenuItem menuItem = new JMenuItem("Установить соединение и загрузить данные");
		 JMenuItem menuItem1 = new JMenuItem("Выход");
		 menu.add(menuItem);
		 menu.add(menuItem1);
		 menuBar.add(menu);
		 
		 //-------------------------------------------//	
		 btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Thread th = new Thread(){
					public void run(){
						progress.setMinimum(1);
						progress.setMaximum(count);
						for (int i = 0; i < count; i++) {
							try {
								Thread.currentThread();
								Thread.sleep(1);
								progress.setValue(i);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						System.out.println(i +"  "+Thread.currentThread().getName());	
						list.setSelectedIndex(i);
						}

						progress.setValue(0);
						System.out.println("1111111111111111");
						
					}
					
				};
				th.start();
			}
				//System.out.println(count);
				//for (int i = 0; i < count; i++) {
					//list.setSelectedIndex(i);
					//System.out.println(list.getSelectedValue());
				//}
			//}
		});
		 //-------------------------------------------//	
		 menuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		 //-------------------------------------------//	
		 menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					DataManagementSystem dms=DataManagementSystem.getInstance();
					vdm = new Vector<DataModel>(dms.getData("C:\\11.accdb"));
					
				
					
					dtm.fireTableDataChanged();
					
					//count =vdm.size();
					//list.setListData(vdm);

					btn.setEnabled(true);
					//Boolean bl = dms.ConnectToDB("C:\\11.accdb");
					
					//System.out.println(dms.getInfo()+" "+bl);
					//if(bl==true){btn.setEnabled(true);}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 //-------------------------------------------//	
		 setJMenuBar(menuBar);
	}
	public void Init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10,10,800,600);
		setTitle("DataView");
		setVisible(true);
	
		getContentPane().setLayout(new BorderLayout());
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println(arg0.getSource().toString());
		//JMenuItem senderm = (JMenuItem) arg0.getSource();
		JButton senderb = (JButton) arg0.getSource();
		if(senderb.getText()=="Выход"){System.exit(0);}
	}
	
}
