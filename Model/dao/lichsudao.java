package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.giohangbean;
import bean.khachHangbean;
import bean.thanhtoanbean;

public class lichsudao {
	public ArrayList<thanhtoanbean> getDanhSach(khachHangbean kh) throws Exception{
		ArrayList<thanhtoanbean> ds = new ArrayList<thanhtoanbean>();
		dungChung dc = new dungChung();
		dc.ketnoi();
		String sql = "Select * From hoadon where makh = ? and damua=1";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, kh.getMakh());
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			ArrayList<giohangbean> giohang = new ArrayList<giohangbean>();
			sql = "Select * from ChiTietHoaDon as ct left join sach as s on ct.MaSach = s.masach where MaHoaDon=?";
			PreparedStatement getsach = dc.cn.prepareStatement(sql);
			getsach.setString(1, rs.getString("MaHoaDon"));
			ResultSet data = getsach.executeQuery();
			while(data.next()) {
				giohang.add(new giohangbean(data.getString("MaSach"), data.getString("tensach"), data.getString("tacgia"), data.getLong("gia"), data.getString("anh"), data.getLong("soluongmua")));
			}
			ds.add(new thanhtoanbean(rs.getString("MaHoaDon"),rs.getString("NgayMua"), rs.getString("makh"),giohang));
			System.out.println(rs.getString("MaHoaDon"));
		}
		dc.cn.close();
		return ds;
	}
}
