package bo;

import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao sd = new sachdao();
	public ArrayList<sachbean> getSach() throws Exception{
		return sd.getsach();
	}
	
	public ArrayList<sachbean> timTheoLoai(ArrayList<sachbean> ds, String key){
		ArrayList<sachbean> temp = new ArrayList<sachbean>();
		for (sachbean sach : ds) {
			if(sach.getMaLoai().contains(key)) {
				temp.add(sach);
			}
		}
		return temp;
	}
	public ArrayList<sachbean> timTheoTen(ArrayList<sachbean> ds, String key){
		ArrayList<sachbean> temp = new ArrayList<sachbean>();
		for (sachbean sach : ds) {
			if(sach.getTenSach().toLowerCase().contains(key.toLowerCase()) || 
					sach.getTacGia().toLowerCase().contains(key.toLowerCase())) {
				temp.add(sach);
			}
		}
		return temp;
	}
	
	public int count(ArrayList<sachbean> ds, String key) {
		ArrayList<sachbean> temp = timTheoLoai(ds, key);
		return temp.size();
	}
}
