package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentHandler {
public String InsercommentToDatabase(Connection dbConnect, String[] data, String username , String comments) throws Exception {
String comm;

try {
 System.out.println(data[0]);
PreparedStatement ps = dbConnect.prepareStatement("INSERT INTO usercomments values ( '"+data[0]+"', '"+data[1]+"');");
		
  ps.executeUpdate();
			 
PreparedStatement ds=dbConnect.prepareStatement("select comments from usercomments where username='"+username+"';"); 
ResultSet rs=ds.executeQuery();
		
rs.next();
comm = rs.getString(1);
	
	} 
catch (Exception e) {

 System.out.println("Comment Handler Error found : "+e.getMessage());
 throw e;

}
 return comm;

		
}

	
public List<Map> RetrieveComment(Connection dbConnect, String[] data, String username) throws Exception {

List <Map> obj = new ArrayList();
  
try {

			 
  PreparedStatement ds=dbConnect.prepareStatement("select username,comments from usercomments "
		+ "where username='"+username+"';"); 
     ResultSet rs=ds.executeQuery();
      System.out.println("hello");

		while(rs.next()) {
		
		Map mMap = new HashMap();
		
		mMap.put(rs.getString("username"), rs.getString("comments"));
		
		obj.add(mMap);	
			
		}
		}
			
			catch (Exception e) {
				System.out.println("Handler Error found : "+e.getMessage());
				throw e;
			}
       
		return obj;

		
}


