package com.javatpoint.dao;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import com.javatpoint.beans.*; 
public class UserDao {  
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        //String url = "jdbc:mysql://localhost:3306/";
        String url = "jdbc:mysql://85.10.205.173/w3class";
        String id = "w3class";
        String pw = "boroomdal1!";
        con=DriverManager.getConnection(url,id,pw);  
    }
    catch(Exception e){
    	System.out.println(e);
    }
    return con;  
}  

public static int save(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(
        		"insert into USER(name,password, studentID,email) values(?,?,?,?)");  
        ps.setString(1,u.getName());  
        ps.setString(2,u.getPassword());  
        ps.setString(3,u.getStudentID());  
        ps.setString(4,u.getEmail());  
        status=ps.executeUpdate();  
    }catch(Exception e){
    	System.out.println(e);
    }  
    return status;  
}  

public static int update(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update USER set name=?,password=?, studentID=?, email=? where id=?");  
        ps.setString(1,u.getName());  
        ps.setString(2,u.getPassword());  
        ps.setString(3,u.getStudentID());  
        ps.setString(4,u.getEmail());   
        ps.setInt(5,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int delete(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from USER where id=?");  
        ps.setInt(1,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
// -------------------------------------------------------------------------------------

public static List<Classroom> getAllRecords(){  
    List<Classroom> list=new ArrayList<Classroom>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from CLASSROOM");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            Classroom u=new Classroom();  
            u.setId(rs.getInt("classID"));  
            u.setTitle(rs.getString("classTITLE"));  
            u.setContent(rs.getString("classCONTENT"));  
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  

//-------------------------------------------------------------------------------------

public static User getRecordById(int id){  
    User u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from luke_test where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setStudentID(rs.getString("studentID"));  
            u.setEmail(rs.getString("email"));  
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  

//-------------------------------------------------------------------------------------
	public static User getLoginInfo(String name, String pw) {
		Connection con=getConnection();  
        PreparedStatement ps;
        
        User u=null;
        try {
			ps = con.prepareStatement("select * from USER where name=? AND password=?");
	        ps.setString(1, name);
	        ps.setString(2, pw);
	        ResultSet rs = ps.executeQuery();
	        u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setStudentID(rs.getString("studentID"));
            u.setEmail(rs.getString("email"));  
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
        return u;
	}
}  