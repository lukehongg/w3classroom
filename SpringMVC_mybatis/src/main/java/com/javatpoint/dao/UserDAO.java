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
public class UserDAO {
//	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
//	JdbcTemplate template;    
//    
//	public void setTemplate(JdbcTemplate template) {    
//	    this.template = template;    
//	}
	

	// SELECT
		public ClassroomVO selectUser(int id) {

			ClassroomVO classroom = session.selectOne("classroomDB.selectClassroom", id);
			return classroom;
		}
		
		// 여러 개 select
		public List<ClassroomVO> selectAllUser() {
			
			List<ClassroomVO> classroomList = session.selectList("classroomDB.selectAllClassroom");
			return classroomList;		
		}
		public int Login(UserVO user) throws Exception {
	        return session.selectOne("classroomDB.Login", user);
	    }
		
		
	
	// INSERT
		
		
		
	// UPDATE		
		
		
		
	// DELETE	
	
	
	
	
	
	
}
