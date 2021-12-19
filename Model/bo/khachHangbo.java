package bo;

import java.util.ArrayList;

import bean.khachHangbean;
import dao.khachHangdao;

public class khachHangbo {
	private khachHangdao khdao = new khachHangdao();
	public khachHangbean ktdn(String makh,String mk) throws Exception{
		khachHangbean kh =  khdao.getkhachhang(makh, mk);
		return kh;
	}
	public khachHangbean dangky(String name, String address, String sdt, String email, String username, String password) throws Exception{
		return khdao.register(username, password, name, sdt, email, address);
	}
}
