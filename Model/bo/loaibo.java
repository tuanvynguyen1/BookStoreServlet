package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ld = new loaidao();
	public ArrayList<loaibean> getLoai() throws Exception{
		try {
			return ld.getloai();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ld.getloai();
		}
	}
}
