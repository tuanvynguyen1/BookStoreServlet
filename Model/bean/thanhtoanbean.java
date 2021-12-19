package bean;

import java.util.ArrayList;

public class thanhtoanbean {
	String mahoadon;
	String datetime;
	String makh;
	ArrayList<giohangbean> gh;
	public thanhtoanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public thanhtoanbean(String mahoadon, String datetime, String makh, ArrayList<giohangbean> gh) {
		super();
		this.mahoadon = mahoadon;
		this.datetime = datetime;
		this.makh = makh;
		this.gh = gh;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public ArrayList<giohangbean> getGh() {
		return gh;
	}
	public void setGh(ArrayList<giohangbean> gh) {
		this.gh = gh;
	}
	
	
}
