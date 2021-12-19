package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachHangbean;
import bean.loaibean;

public class khachHangdao {
	public khachHangbean getkhachhang(String username, String password) throws Exception{
		dungChung dc = new dungChung();
    	dc.ketnoi();
    	String sql = "Select * From khachhang Where tendn=? AND pass=?";
    	PreparedStatement cmd = dc.cn.prepareStatement(sql);
    	cmd.setString(1, username);
    	cmd.setString(2, password);
    	ResultSet rs = cmd.executeQuery();
    	if(rs.next()) {
    		String makh=rs.getString("makh");
    	    String hoten = rs.getString("hoten");
    	    String diachi = rs.getString("diachi");
    	    String matkhau = rs.getString("pass");
    	    dc.cn.close();
    		return new khachHangbean(makh,hoten,diachi,matkhau);
    	}
    	dc.cn.close();
    	return null;
    }
	public khachHangbean register(String username, String password, String name,String sdt, String email,String address) throws Exception{
		dungChung dc = new dungChung();
    	dc.ketnoi();
    	String sql = "INSERT INTO KhachHang(hoten,diachi,sodt,email,tendn,pass) VALUES(?,?,?,?,?,?)";
    	PreparedStatement cmd = dc.cn.prepareStatement(sql);
    	cmd.setString(1, name);
    	cmd.setString(2, address);
    	cmd.setString(3, sdt);
    	cmd.setString(4, email);
    	cmd.setString(5, username);
    	cmd.setString(6, password);
    	if(cmd.executeUpdate()!=0) {
    		sql = "Select max(makh) From KhachHang";
    		PreparedStatement getma = dc.cn.prepareStatement(sql);
    		ResultSet r = getma.executeQuery();
    		r.next();
    		String makh = r.getString(1);
    		System.out.println(makh);
    		return new khachHangbean(makh, name, address, password);
    	}
    	dc.cn.close();
    	return null;
	}
}
