package com.javatpoint.dao;
import java.sql.*;  
import java.util.*;
import com.javatpoint.beans.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;


@Repository
public class ClassroomDAO {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
//	JdbcTemplate template;    
//    
//	public void setTemplate(JdbcTemplate template) {    
//	    this.template = template;    
//	}
	
	// SELECT
		public ClassroomVO selectClassroom(int id) {

			ClassroomVO classroom = session.selectOne("classroomDB.selectClassroom", id);
			return classroom;
		}
		
		// 여러 개 select
		public List<ClassroomVO> selectAllClassroom() {
			List<ClassroomVO> classroomList = session.selectList("classroomDB.selectAllClassroom");
			return classroomList;		
		}
		
	
	// INSERT
		public void insertClassroom(ClassroomVO classroom) {
			session.insert("classroomDB.insertClassroom", classroom);
		}
		
		
	// UPDATE		
		public void updateClassroom(ClassroomVO classroom) {
			session.update("updateClassroom", classroom);
		}
		
		
	// DELETE	
		public void deleteClassroom(int id) {
			session.delete("classroomDB.deleteClassroom", id);
		}
		
}




//  
//
//public class ClassDao {
//	JdbcTemplate template;
//	
//	public void setTemplate(JdbcTemplate template) {    
//	    this.template = template;    
//	} 
//	
//	// mvc
//	public int saveClassroom(Classroom u){  
//	    String sql = "insert into CLASSROOM(classTITLE,classCONTENT) values('"
//	    		+ u.getTitle() +"', '"+u.getContent()+"')";
//	    return template.update(sql);  
//	}
//	// mvc
//		public int saveLecture(Lecture u){  
//		    String sql = "insert into LECTURE(category,title,content,link) values('"
//		    		+ u.getCategory() +"', '"+u.getTitle()+"', '"+u.getContent()+"', '"+u.getLink()+"')";
//		    return template.update(sql);  
//		}
//
//	// mvc
//	public int update(Classroom u){    
//	    String sql="update CLASSROOM set classTITLE='"+u.getTitle()+"', classCONTENT='"+u.getContent()+"' where classID="+u.getId()+"";    
//	    return template.update(sql);    
//	}    
//	// mvc
//	public int updateLecture(Lecture u){    
//		String sql="update LECTURE set"
//				+ " category = '"+u.getCategory()+"',"
//				+ " title = '"+u.getTitle()+"',"
//				+ " content = '"+u.getContent()+"',"
//			    + " link = '"+u.getLink()+"'"
//				+ " where lectureID="+u.getId()+"";    
//		return template.update(sql);    
//	}  
//
//	
////	//mvc
////	public int delete(int id){    
////	    String sql="delete from CLASSROOM where classID="+id+"";    
////	    return template.update(sql);    
////	}    
//	
//	//mvc
//		public int deleteClassroom(int id){    
//		    String sql="delete from CLASSROOM where classID="+id+"";    
//		    return template.update(sql);    
//		}    
//		//mvc
//		public int deleteClassroom2(int id){    
//		    String sql="delete from CURRICULUM where classroomID="+id+"";    
//		    return template.update(sql);    
//		}		
//		//mvc
//		public int deleteLecture(int id){    
//			String sql="delete from LECTURE where lectureID="+id+"";    
//			return template.update(sql);    
//		}
//		//mvc
//		public int deleteLecture2(int id){    
//		    String sql="delete from CURRICULUM where lectureID="+id+"";    
//			return template.update(sql);    
//		}	
//		
//	//mvc
//	public Integer delLecInCurri(int cid, int lid){
//		String sql = "delete from CURRICULUM WHERE classroomID = " + cid +" AND lectureID = " + lid +"";
//		return template.update(sql);
//	}
//	//mvc
//	public Integer addLecInCurri(int cid, int lid){
//		String sql = "insert into CURRICULUM(classroomID,lectureID) values("
//	    		+ cid +", "+ lid +");";
//		return template.update(sql);
//	}
//	
//	//mvc
//	public List<Classroom> getAllClassroom(){    
//	    return template.query("select * from CLASSROOM",new RowMapper<Classroom>(){    
//	        public Classroom mapRow(ResultSet rs, int row) throws SQLException {    
//	            Classroom e=new Classroom();    
//	            e.setId(rs.getInt(1));    
//	            e.setTitle(rs.getString(2));    
//	            e.setContent(rs.getString(3));      
//	            return e;    
//	        }    
//	    });
//	} 
//	
//	//mvc
//	public List<Lecture> getAllLecture(){    
//	    return template.query("select * from LECTURE",new RowMapper<Lecture>(){    
//	        public Lecture mapRow(ResultSet rs, int row) throws SQLException {    
//	        	Lecture e=new Lecture();    
//	            e.setId(rs.getInt(1));
//	            e.setCategory(rs.getNString(2));
//	            e.setTitle(rs.getString(3));    
//	            e.setContent(rs.getString(4));  
//	            e.setLink(rs.getString(5));      
//	            return e;    
//	        }    
//	    });
//	} 
//
//	
//	// mvc
//	public Classroom getRecordById(int id){    
//	    String sql="select * from CLASSROOM where classID=?";    
//	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Classroom>(Classroom.class));    
//	}  
//	
//	// mvc
//	public Lecture getLectureById(int id){    
//	    String sql="select * from LECTURE where lectureID=?";    
//	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Lecture>(Lecture.class));    
//	}   
//	
//
//	
//	//mvc
//		public List<Lecture> getLectureByClassroom(int cid){ 
//			String sql = "select L.lectureID, category, title, content, link from LECTURE L INNER JOIN CURRICULUM C"
//		    		+ " ON L.lectureID = C.lectureID WHERE C.classroomID = "
//		    		+ cid +" order by lectureINDEX";		    
//			return template.query(sql,new RowMapper<Lecture>(){    
//		        public Lecture mapRow(ResultSet rs, int row) throws SQLException {    
//		        	Lecture e=new Lecture();    
//		            e.setId(rs.getInt(1));
//		            e.setCategory(rs.getNString(2));
//		            e.setTitle(rs.getString(3));    
//		            e.setContent(rs.getString(4));  
//		            e.setLink(rs.getString(5));      
//		            return e;    
//		        }    
//		    });
//		} 
//		
//		//mvc
//		public List<String> getCategories (){ 
//			String sql = "select DISTINCT(category) from LECTURE";		    
//			return template.query(sql,new RowMapper<String>(){    
//			public String mapRow(ResultSet rs, int row) throws SQLException {    
//				    return rs.getString(1); 
//				}    
//			});
//		} 
//				
//		
//		
//		//mvc
//		public List<Lecture> getAllLectureByCategory(String cate){
//			String sql="";
//			if(cate.equals("ALL")) sql += "select * from LECTURE";
//			else sql += "select * from LECTURE WHERE category = '" + cate +"'";
//			return template.query(sql,new RowMapper<Lecture>(){    
//		    	public Lecture mapRow(ResultSet rs, int row) throws SQLException {    
//				    Lecture e=new Lecture();    
//					e.setId(rs.getInt(1));
//					e.setCategory(rs.getString(2));
//					e.setTitle(rs.getString(3));    
//					e.setContent(rs.getString(4));  
//					e.setLink(rs.getString(5));      
//					return e;    
//				}    
//		    });
//		} 	
//		
////	public static int getClassroomId(String ctitle) {
////		int cid = 0;
////	    try{  
////	        Connection con=getConnection();  
////	        PreparedStatement ps=con.prepareStatement("select classID from CLASSROOM where classTITLE=?");  
////	        ps.setString(1,ctitle);  
////	        ResultSet rs=ps.executeQuery();  
////	        rs.next();
////	        cid = rs.getInt("classID");
////	    }catch(Exception e){System.out.println(e);}  
////	    return cid; 
////	}
//	
//	//mvc
//	public Integer getClassroomId(String ctitle){
//		String sql = "select classID from CLASSROOM WHERE classTITLE = '" + ctitle +"'";
//		return template.queryForObject(sql, new Object[]{ctitle},new BeanPropertyRowMapper<Integer>(Integer.class));    
//	}
//			 
////	public List<Lecture> getLectureClass(Classroom u){
////		String sql = "select L.lectureID, category, title, content, link from CURRICULUM C INNER JOIN LECTURE L"
////	    		+ " ON C.lectureID = L.lectureID WHERE C.classroomID = "
////	    		+u.getId() +" order by lectureINDEX";
////		List<Lecture> list = template.query(sql, new BeanPropertyRowMapper(Lecture.class));
////		return list;
////	}
//	
//	
//	
//}
