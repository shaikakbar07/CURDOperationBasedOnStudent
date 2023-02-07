package com.palle;

import java.sql.*;

public class Employee 
{
	Connection con=null;
	Statement s=null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	
	public static String url="jdbc:mysql://localhost:3306/jdbc";
	public static String username="root";
	public static String password="admin";
	
	public void creating() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username,password);
			
			s=con.createStatement();
			s.executeUpdate("create table employee2(eno int primary key,ename varchar(60),esal varchar(65))");
		}
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		finally
		{
			try 
			{
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}
				
			} 
			 catch (SQLException e) 
			   {
			
				e.printStackTrace();
			    }
		}   
	
	
	}

	public void inserting(int eno,String ename,int esal) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			String qry="insert into employee2(eno,ename,esal)values(?,?,?)";
			ps=con.prepareStatement(qry);
			ps.setInt(1, eno);
			ps.setString(2,ename);
			ps.setInt(3, esal);
			ps.executeUpdate();
		    } 
	
		catch (ClassNotFoundException e) 
		{	
			e.printStackTrace();
		} catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		
		finally
		{
          try
          {
        	  if(ps!=null)
        	  {
        		ps.close();  
        	  }
        	  if(con!=null) 
        	  {
        		 con.close(); 
        	  }
	     	}
          catch (SQLException e)
          {
			
			e.printStackTrace();
		   }
	}
		
		
	}
	
	
	public void update(int eno, String ename, int esal)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
			String qry="update employee2 set ename=?,esal=? where eno=?";
			
			ps=con.prepareStatement(qry);
			ps.setString(1,ename);
			ps.setInt(2,esal);
			ps.setInt(3, eno); 
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(ps!=null)
				try 
			    {
					ps.close();
				}
			catch (SQLException e) 
			     {	
					e.printStackTrace();
				}
			if(con!=null)
				try 
			     {
					con.close();
				} 
			catch (SQLException e)
			    {
					e.printStackTrace();
				}
		  }
		
	}
	public void delete(int eno)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
			String qry="delete from employee2 where eno=?";
			ps=con.prepareStatement(qry);
			ps.setInt(1, eno);
			
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		  {
			
			e.printStackTrace();
		  }
		catch (SQLException e)
		  {
			e.printStackTrace();
		  }
		finally 
		{
			if(ps!=null)
				try
			    {
					ps.close();
				} 
			    catch (SQLException e)
			     {
					
					e.printStackTrace();
				}
			if(con!=null)
				try 
			    {
					con.close();
				}
			    catch (SQLException e)
			     {
					
					e.printStackTrace();
				 }
		}			
								
   }
	public void exit()
	{
		System.out.println("PROGRAM IS EXIT");
	}

}
		
