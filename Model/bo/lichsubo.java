package bo;

import java.util.ArrayList;

import bean.khachHangbean;
import bean.thanhtoanbean;
import dao.lichsudao;

public class lichsubo {
	lichsudao ls = new lichsudao();
	public ArrayList<thanhtoanbean> getthanhtoan(khachHangbean kh) throws Exception{
		return ls.getDanhSach(kh);
	}
}
