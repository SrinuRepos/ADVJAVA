package com.google.ex;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Driver;
import oracle.jdbc.OracleDriver;
import java.sql.Statement;

public class RegisterProductApp
	{
public static void main(String args[]) throws Exception
{
	//Step 1 : Loads the Driver Class
	Class.forName("oracle.jdbc.OracleDriver");
	
	//Step 2 : Register Driver Class with Driver Manager Here the OracleDriver static block has this logic so after loading OracleDriver static block will be executed so we no need to write it explicitly.
	

	//Step 3 : Get the Connection Object .
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");

	//Step4 Create a Statement Object

	Statement st = con.createStatement();
String sql = "Insert Into Product(Pid,Pname,Price) Values 				(222,'MINote5',25000)";

	//Step5 Submit the Non Select Query using executeUpdate() method
int count = st.executeUpdate(sql);
	System.out.println(count+ "Records inserted ");
st.close();
con.close();

}
	}







