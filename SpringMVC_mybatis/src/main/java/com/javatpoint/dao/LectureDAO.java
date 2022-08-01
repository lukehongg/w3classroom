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
public class LectureDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
//	JdbcTemplate template;    
//    
//	public void setTemplate(JdbcTemplate template) {    
//	    this.template = template;    
//	}

	// SELECT
		public LectureVO selectLecture(int id) {
			LectureVO classroom = session.selectOne("classroomDB.selectLecture", id);
			return classroom;
		}
		
		public List<LectureVO> selectAllLecture() {
			List<LectureVO> classroomList = session.selectList("classroomDB.selectAllLecture");
			return classroomList;		
		}
		
		public List<LectureVO> selectAllLectureCate(String cate) {
			List<LectureVO> classroomList = session.selectList("classroomDB.selectAllLectureCate", cate);
			return classroomList;
		}
		public List<LectureVO> selectAllLectureClass(int id) {
			List<LectureVO> classroomList = session.selectList("classroomDB.selectAllLectureClass", id);
			return classroomList;
		}
		
	
	// INSERT
		public void insertLecture(LectureVO lec) {
			session.insert("classroomDB.insertLecture", lec);
		}
		public void insertLecInCurri(Integer cid, Integer lid) {
			HashMap<String, Integer> mapper = new HashMap<String,Integer>();
			mapper.put("cid", cid);
			mapper.put("lid", lid);
			session.insert("classroomDB.insertLecInCurri", mapper);
		}
		
	// UPDATE		
		public void updateLecture(LectureVO lec) {
			session.update("updateLecture", lec);
		}
		
		
	// DELETE	
		public void deleteLecture(int id) {
			session.delete("classroomDB.deleteLecture", id);
		}
		public void deleteCurriculumLec(int id) {
			session.delete("classroomDB.deleteCurriculumLec", id);
		}
		public void deleteCurriculum(int id) {
			session.delete("classroomDB.deleteCurriculum", id);
		}
		public void deleteLecInCurri(Integer cid, Integer lid) {
			HashMap<String, Integer> mapper = new HashMap<String,Integer>();
			mapper.put("cid", cid);
			mapper.put("lid", lid);
			session.insert("classroomDB.deleteLecInCurri", mapper);
		}
	
	
	
	
	
	
	
	
}
