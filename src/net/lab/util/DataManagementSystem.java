package net.lab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataManagementSystem {
private static DataManagementSystem instance;
private static Connection conn;
private String fullPath;
private Statement stmt = null;
private ResultSet rs = null;

private DataManagementSystem() {
}

public Boolean ConnectToDB(String s){
	Boolean b = false;
	try {
		//fullPath = "C:\\111.accdb";
		fullPath = s;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url = "jdbc:odbc:Driver="
		         + "{Microsoft Access Driver (*.mdb, *.accdb)};"
		         + "DBQ="
		         + fullPath.replace("\\", "/");
		conn = DriverManager.getConnection(url,"","");
		if(conn!=null){b=true;}
	} catch (Exception e) {
	}
	return b;
}

public String getInfo() throws SQLException{
	if(conn!=null){
		String h = "Соединение установлено "+conn.getCatalog();
		conn.close();
		return h;
	}else{
		return "Соединение не установлено!!!";
	}
	
}
public static synchronized DataManagementSystem getInstance() throws Exception{
	if(instance==null){instance = new DataManagementSystem();}
	return instance;
}
	

public List<DataModel> getData(String s) throws SQLException{
	List<DataModel> ldm = new ArrayList<DataModel>();
	try {
		Boolean par = ConnectToDB(s);
		if(par==true){
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * from naim Order by ls");
			  //*************//
			  while (rs.next()) {
				DataModel data = new DataModel();
				data.setStreet(rs.getString(5));
				data.setDom(rs.getString(6));
				data.setKv(rs.getString(7));
				data.setLs(rs.getInt(1));
				String Fio ="";
				String F = rs.getString(2);
				if(F!=null){Fio = F;}
				String I = rs.getString(3);
				if(I!=null){Fio = Fio+" "+I;}
				String O = rs.getString(4);
				if(O!=null){Fio = Fio+" "+O;}
				
				data.setFio(Fio);
				data.setMonth(rs.getString(10));
				data.setVx(rs.getDouble(12));
				data.setNach(rs.getDouble(13));
				data.setIsx(rs.getDouble(14));
				data.setOpl(rs.getDouble(15));
				data.setId(rs.getInt(22));
				
				ldm.add(data);
			  }
			  //*************//
		}
		
	} catch (Exception e) {
	}
	finally{
		if(rs==null){rs.close();}
			conn.close();stmt.close();
		}
	return ldm;
}



}
