package net.lab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class Dbf {
	private static final String URL = "jdbc:DBF:/C:\\Temp";
	private static final String TABLE = "create table SAMPLE(SM VARCHAR(10), PRIM  VARCHAR(10) )"; 

	private Connection conn=null;	
	
	public Dbf(){
		Properties properties = new Properties();
		properties.setProperty( "charSet", "cp866" );
		properties.setProperty( "CODEPAGEID", "66" );
		
		try{
			
			//Class.forName("com.hxtt.sql.dbf.DBFDriver").newInstance();
			//Connection dbfConn = DriverManager.getConnection( URL, properties );
			//Statement stmt = dbfConn.createStatement();
			//stmt.executeUpdate( TABLE );
			//stmt.close();
			//PreparedStatement ps = dbfConn.prepareStatement( "INSERT INTO SAMPLE (SM, PRIM) VALUES (?,?);"  );
			//ps.setString( 1, "test11" );
			//ps.setString( 2, "test12" );
			//ps.executeUpdate();
			//ps.close();
			//dbfConn.close();
			
		}
		catch(Exception e){
			
		}
	}
	
	
}
