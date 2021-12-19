package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

import bean.giohangbean;
import bean.khachHangbean;
import bean.thanhtoanbean;
import bo.giohangbo;

public class thanhtoandao {
	public ArrayList<thanhtoanbean> getDanhSach(khachHangbean kh) throws Exception{
		ArrayList<thanhtoanbean> ds = new ArrayList<thanhtoanbean>();
		dungChung dc = new dungChung();
		dc.ketnoi();
		String sql = "Select * From hoadon where makh = ? and damua=0";
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
	public boolean bohangvao(String mahd, giohangbo gh) throws Exception{
		dungChung dc = new dungChung();
		dc.ketnoi();
		String sql = "INSERT INTO chitiethoadon(MaSach,SoLuongMua,MaHoaDon) VALUES(?,?,?)";
		for (giohangbean giohang : gh.getDS()) {
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, giohang.getMasach());
			cmd.setLong(2, giohang.getSlmua());
			cmd.setString(3, mahd);
			cmd.executeUpdate();
		}
		
		dc.cn.close();
		return true;
	}
	public boolean taoDanhSach(khachHangbean kh, giohangbo gh) throws Exception {
		dungChung dc = new dungChung();
		dc.ketnoi();
		Date date =  Calendar.getInstance().getTime();
		java.sql.Time current = new java.sql.Time(date.getTime());
		String sql = "INSERT INTO hoadon(makh,ngaymua,damua) VALUES(?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, kh.getMakh());
		cmd.setString(2, current.toString());
		cmd.setString(3, "0");
		if(cmd.executeUpdate()!=0) {
			sql = "Select Max(MaHoaDon) From hoadon Where makh = ?";
			PreparedStatement cmd2 = dc.cn.prepareStatement(sql);
			cmd2.setString(1, kh.getMakh());
			ResultSet data = cmd2.executeQuery();
			if(data.next()) {
				bohangvao(data.getString(1), gh);
			}
		}
		dc.cn.close();
		return true;
	}
	public boolean thanhtoan(khachHangbean kh,String mahd) throws Exception{
		dungChung dc = new dungChung();
		dc.ketnoi();
		String sql = "UPDATE hoadon SET damua=1 WHERE makh=? AND MaHoaDon=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, kh.getMakh());
		cmd.setString(2, mahd);
		if(cmd.executeUpdate()!=0) {
			
			dc.cn.close();
			return true;
		}
		dc.cn.close();
		return false;
	}
}
