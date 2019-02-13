package com.javatpoint.rest;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Dao.*;
import Dao.DbConnection;

@Path("/CommentService")

public class CommentService {
		
	 @POST
	 @Path("/Submitcomments")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	 public String comment(@FormParam("name") String username,
	 @FormParam("comments") String comments) {
		String flag;
		System.out.println(username);
		System.out.println(comments);
		try {
		String[] datab = {username,comments};
		DbConnection dbConnect = new DbConnection();
		CommentHandler commentHandle = new CommentHandler();
		flag= commentHandle.InsercommentToDatabase(dbConnect.getConnection(), data, username,comments);
		System.out.println(flag);

		} catch(Exception e) { }
		return "success";
		
		}
	
	
	 @GET
	 @Path("/getcomments")
	 @Produces(MediaType.APPLICATION_JSON)
	
	  public String getcomments(@QueryParam("name") String username) {
	   Gson gsonBuilder = new GsonBuilder().create();
		List<String> flag = new ArrayList<String>();
		String jsonFromJavaArrayList = null;
		try {
		String[] data = {username};
		DbConnection dbConnect = new DbConnection();
		CommentHandler commentHandle = new CommentHandler();
		flag= commentHandle.RetrieveComment(dbConnect.getConnection(), data, username);
		jsonFromJavaArrayList = gsonBuilder.toJson(flag);
			
		} 
		
		catch(Exception e) {
			
		System.out.println("Comment Service Error found : "+e.getMessage());
			}
	
		return jsonFromJavaArrayList;
	
	}
	
}

