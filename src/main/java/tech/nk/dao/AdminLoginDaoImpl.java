package tech.nk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDaoImpl implements AdminLoginDao {

	private String result;
	@Override
	public String checkAdminLoginData(String username, String password) {
		try 
		{
			Connection connection=ConnectionFactory.getConnection();
			String sql="select * from adminlogin where username=? and password=?";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				result="EXIST";
			}
			else
			{
				result="NOTEXIST";
			}
			
		
		} 
		catch (Exception e) 
		{
			result="FAILED";
			e.printStackTrace();
			
		}
		return result;
	}

}
