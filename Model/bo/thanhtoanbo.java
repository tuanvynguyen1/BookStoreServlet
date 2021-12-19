package bo;

import java.util.ArrayList;

import bean.giohangbean;
import bean.khachHangbean;
import bean.thanhtoanbean;
import dao.thanhtoandao;

public class thanhtoanbo {
	thanhtoandao tt = new thanhtoandao();
	public ArrayList<thanhtoanbean> getthanhtoan(khachHangbean kh) throws Exception{
		return tt.getDanhSach(kh);
	}
	public boolean taoThanhToan(khachHangbean kh, giohangbo gh) throws Exception{
		return tt.taoDanhSach(kh, gh);
	}
	public boolean hoantat(khachHangbean kh, String mahd) throws Exception{
		return tt.thanhtoan(kh, mahd);
	}
}
