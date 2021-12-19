package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dungChung {
	public Connection cn;
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		cn= DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BR912HR:1433;databaseName=QlSach;user=sa; password=1502;encrypt=true;trustServerCertificate=true");

	}
}
