package tech.nk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tech.nk.model.ContactPojo;

public class ContactDaoImpl implements ContactDao {

	private String result;
	
	@Override
	public String saveContact(String name, String email, String subject, String message,String datetime) 
	{
		Connection connection=null;
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="insert into contact(name,email,subject,message,datetime) values(?,?,?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, subject);
			pstmt.setString(4,message);
			pstmt.setString(5, datetime);
			
			int executeUpdate=pstmt.executeUpdate();
			if(executeUpdate==1)
			{
				result="MESSAGE SENT SUCCESSFULLY";
			}
			else
			{
				result="SOMETHING WENT WRONG";
			}
		
		} 
		catch (Exception e) 
		{
			result="SOMETHING WENT WRONG";
			e.printStackTrace();
			
		}
		finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<ContactPojo> readContact() {
		Connection connection=null;
        ArrayList<ContactPojo> arrayList=new ArrayList<ContactPojo>();
		
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="select * from contact";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			if(!rs.next())
			{
				arrayList.add(new ContactPojo(0,"ne","ne","ne","ne","ne"));
			}
			else
			{
				do {
					arrayList.add(new ContactPojo(rs.getInt("sn"),rs.getString("name"),rs.getString("email"),rs.getString("subject"),rs.getString("message"),rs.getString("datetime")));
				}while(rs.next());
				
				
			}
			
			
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			arrayList.clear();
			
		}
		finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return arrayList;
	}

	@Override
	public String deleteContact(int sn) {
		Connection connection=null;
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="delete from contact where sn=?";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, sn);
			
			
			int executeUpdate=pstmt.executeUpdate();
			if(executeUpdate==1)
			{
				result="MESSAGE DELETED SUCCESSFULLY";
			}
			else
			{
				result="SOMETHING WENT WRONG";
			}
		
		} 
		catch (Exception e) 
		{
			result="SOMETHING WENT WRONG";
			e.printStackTrace();
			
		}
		finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}

}
