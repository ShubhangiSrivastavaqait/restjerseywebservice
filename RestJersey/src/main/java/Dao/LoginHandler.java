package Dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoginHandler {

public String getParticularUser(Connection dbConnect, String username) throws SQLException {
	
String pass;
System.out.println("the-login" +username);
			
PreparedStatement ps = dbConnect.prepareStatement("select password from LoginCredentials where uname='"+username+"';");
  
 System.out.println("before ex");
 ResultSet rs=ps.executeQuery();
			
 System.out.println("after ex");
 rs.next();
 pass = rs.getString(1);
 System.out.println(pass);
  
  return pass;
	
}
    
  	
}

