package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.DriverManager;

import com.google.dao.bean.ProductBean;
import com.google.dao.exp.DataSourceException;

public class ProductDAO {

	public ProductBean getProductById(Integer productId) throws DataSourceException
	{
		ProductBean product = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try
			{
		Class.forName("oracle.jdbc.OracleDriver");				
	            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
	            ps = con.prepareStatement("Select PID , PNAME , PRICE From PRODUCT Where PID = ?");
		ps.setInt(1, productId);
		rs = ps.executeQuery();
				
				
				if(rs.next())
				{
					product = new ProductBean();
					product.setProductId(rs.getInt("PID"));
					product.setProductName(rs.getString("PNAME"));
					product.setProductPrice(rs.getFloat("PRICE"));
				}
			}catch(SQLException exp)
			{
				exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}finally
			{
				if(rs != null)
				{
					try {
						rs.close();
					} catch (SQLException exp) {
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
				
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException exp) {
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
				
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException exp) {
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
			}
		
		return product;
	}


public boolean save(ProductBean product) throws DataSourceException
	{
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
				
			try
			{
		Class.forName("oracle.jdbc.OracleDriver");				
	            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
	            ps = con.prepareStatement("Insert into Product(PID , PNAME , PRICE)  Values( ?,?,?)");
		ps.setInt(1, product.getProductId());
		ps.setString(2,product.getProductName());
		ps.setFloat(3,product.getProductPrice());
		int  count  = ps.executeUpdate();
				
			if(count > 0)
			{
			flag = true;
			}	
				
			}catch(SQLException exp)
			{
				exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}finally
			{
				
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException exp) {
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
				
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException exp) {
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
			}
		
		return flag;
	}
	
public boolean deleteProductById(Integer productId) throws DataSourceException
	{
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		
			try
			{
		Class.forName("oracle.jdbc.OracleDriver");				
	            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
	            ps = con.prepareStatement("Delete From PRODUCT Where PID = ?");
		ps.setInt(1, productId);
		int count = ps.executeUpdate();
		if(count > 0)
		{
		flag = true;
		}
		
			}catch(SQLException exp)
			{
				exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}finally
			{
				
				
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException exp) {
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
				
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException exp) {
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
			}
		
		return flag;
	}
	
}
