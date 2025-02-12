package tech.nk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tech.nk.model.ServiceModulePojo;

public class ServiceDaoImpl implements ServiceDao {

	public String result;
	@Override
	public String saveService(String iconname, String title, String description, String datetime) {
		Connection connection=null;
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="insert into service(iconname,title,description,datetime) values(?,?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, iconname);
			pstmt.setString(2, title);
			pstmt.setString(3, description);
			pstmt.setString(4, datetime);
			
			int executeUpdate=pstmt.executeUpdate();
			if(executeUpdate==1)
			{
				result="SERVICE ADDED SUCCESSFULLY";
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
	public ArrayList<ServiceModulePojo> readAllServices() {
		Connection connection=null;
        ArrayList<ServiceModulePojo> arrayList=new ArrayList<ServiceModulePojo>();
		
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="select * from service";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			if(!rs.next())
			{
				arrayList.add(new ServiceModulePojo(0, "ne", "ne", "ne", "ne"));
			}
			else
			{
			do
			{
				ServiceModulePojo serviceModulePojo=new ServiceModulePojo(rs.getInt("sn"),rs.getString("iconname"),rs.getString("title"),rs.getString("description"),rs.getString("datetime"));
			    arrayList.add(serviceModulePojo);
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
	public ArrayList<ServiceModulePojo> readFourServices() {
		Connection connection=null;
        ArrayList<ServiceModulePojo> arrayList=new ArrayList<ServiceModulePojo>();
		
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="select * from service LIMIT 4";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			if(!rs.next())
			{
				arrayList.add(new ServiceModulePojo(0, "ne", "ne", "ne", "ne"));
			}
			else
			{
			do
			{
				ServiceModulePojo serviceModulePojo=new ServiceModulePojo(rs.getInt("sn"),rs.getString("iconname"),rs.getString("title"),rs.getString("description"),rs.getString("datetime"));
			    arrayList.add(serviceModulePojo);
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
	public String deleteService(int sn) {
		Connection connection=null;
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="delete from service where sn=?";
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
