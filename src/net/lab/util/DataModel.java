package net.lab.util;

public class DataModel {
	private int id;
	private String street;
	private String dom;
	private String kv;
	private String fio;
	private int ls;
	private String month;
	private Double vx;
	private Double nach;
	private Double opl;
	private Double isx;
	
//****************************************//	
		public DataModel(){
			
		}
//****************************************//	
	public String getFio() {return fio;	}
	public void setFio(String fio) {this.fio = fio;	}
	public int getLs() {return ls;	}
	public void setLs(int ls) {	this.ls = ls;	}
	public String getMonth() {return month;}
	public void setMonth(String month) {this.month = month;}
	public Double getVx() {return vx;}
	public void setVx(Double vx) {this.vx = vx;}
	public Double getNach() {return nach;}
	public void setNach(Double nach) {this.nach = nach;}
	public Double getOpl() {return opl;}
	public void setOpl(Double opl) {this.opl = opl;}
	public Double getIsx() {return isx;}
	public void setIsx(Double isx) {this.isx = isx;}
	public String getStreet() {return street;}
	public void setStreet(String street) {this.street = street;}
	public String getDom() {return dom;}
	public void setDom(String dom) {this.dom = dom;}
	public String getKv() {return kv;}
	public void setKv(String kv) {this.kv = kv;}
	public int getId() {return id;}	
	public void setId(int id) {	this.id = id;
	}
}

