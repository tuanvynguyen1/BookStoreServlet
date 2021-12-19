package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception{
    	ArrayList<loaibean> ds= new ArrayList<loaibean>();
//    	ds.add(new loaibean("cntt", "Công nghệ thông tin"));
//    	ds.add(new loaibean("kt", "Kinh tế"));
//    	ds.add(new loaibean("vh", "Văn học"));
//    	ds.add(new loaibean("luat", "Sách luật kinh tế"));
//    	return ds;
    	dungChung dc = new dungChung();
    	dc.ketnoi();
    	String sql = "Select * From Loai";
    	PreparedStatement cmd = dc.cn.prepareStatement(sql);
    	ResultSet rs = cmd.executeQuery();
    	while(rs.next()) {
    		String maloai = rs.getString("maloai");
    		String tenloai = rs.getString("tenloai");
    		ds.add(new loaibean(maloai,tenloai));
    	}
    	dc.cn.close();
    	return ds;
    }
}
