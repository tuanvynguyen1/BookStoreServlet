package bo;
import java.util.ArrayList;


import bean.giohangbean;
import bean.sachbean;
public class giohangbo {
	ArrayList<giohangbean> ds= new ArrayList<giohangbean>();
	public void Them(String masach, String tensach, String tacgia, String anhSach, Long gia, Long slmua) {
		//Kiem tra xem sach nay da co chua, neu co thi tang soluong
		for(giohangbean g: ds)
			  if(g.getMasach().equals(masach)) {
				  g.setSlmua(g.getSlmua()+slmua);
				  return;
			  }
		ds.add(new giohangbean(masach, tensach, tacgia, gia, anhSach, slmua));
	}
	public String update(String masach, Long slmua) {
		for(giohangbean g: ds)
			  if(g.getMasach().equals(masach)) {
				  g.setSlmua(slmua);
				  return "OK";
			  }
		return "not";
	}
	public void delete(String masach) {
		for(giohangbean g: ds)
			  if(g.getMasach().equals(masach)) {
				  ds.remove(g);
				  return;
			  }
	}
	public ArrayList<giohangbean> getDS(){
		return ds;
	}
			public void xoa(String masach) {
				for(giohangbean g: ds)
					  if(g.getMasach().equals(masach)) {
						  ds.remove(g);break;
					  }
			}
			public Long TongTien() {
				long s=(long)0;
				for(giohangbean g: ds)
					s+=g.getThanhtien();
				return s;
			}
			public long soluong() {
				return ds.size();
			}
}

