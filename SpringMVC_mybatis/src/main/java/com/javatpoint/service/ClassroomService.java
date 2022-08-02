package com.javatpoint.service;

import java.sql.*;  
import java.util.*;
import com.javatpoint.beans.*;
import com.javatpoint.dao.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	
	
	public ClassroomVO selectClassroom(int id) {

		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		ClassroomVO classroom = mapper.selectClassroom(id);
		return classroom;
	}
	
	// 여러 개 select
	public List<ClassroomVO> selectAllClassroom() {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		List<ClassroomVO> classroomList = mapper.selectAllClassroom();
		return classroomList;		
	}
	

	// INSERT
	public void insertClassroom(ClassroomVO classroom) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		mapper.insertClassroom(classroom);
	}
	
	
	// UPDATE		
	public void updateClassroom(ClassroomVO classroom) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		mapper.updateClassroom(classroom);
	}
	
	
	// DELETE	
	public void deleteClassroom(int id) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		mapper.deleteClassroom(id);
	}
	
	
	
	public LectureVO selectLecture(int id) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		LectureVO classroom = mapper.selectLecture(id);
		return classroom;
	}
	
	public List<LectureVO> selectAllLecture() {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		List<LectureVO> classroomList = mapper.selectAllLecture();
		return classroomList;		
	}
	
	public List<LectureVO> selectAllLectureCate(String cate) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		List<LectureVO> classroomList = mapper.selectAllLectureCate(cate);
		return classroomList;
	}
	public List<LectureVO> selectAllLectureClass(int id) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		List<LectureVO> classroomList = mapper.selectAllLectureClass(id);
		return classroomList;
	}
	

// INSERT
	public void insertLecture(LectureVO lec) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		mapper.insertLecture(lec);
	}
	public void insertLecInCurri(Integer cid, Integer lid) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("cid", cid);
		map.put("lid", lid);
		mapper.insertLecInCurri(map);
	}
	
// UPDATE		
	public void updateLecture(LectureVO lec) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		mapper.updateLecture(lec);
	}
	
	
// DELETE	
	public void deleteLecture(int id) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		mapper.deleteLecture(id);
	}
	public void deleteCurriculumLec(int id) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		mapper.deleteCurriculumLec(id);
	}
	
	public void deleteCurriculum(int id) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		mapper.deleteCurriculum(id);
	}
	
	public void deleteLecInCurri(Integer cid, Integer lid) {
		ClassroomServiceITF mapper = session.getMapper(ClassroomServiceITF.class);
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("cid", cid);
		map.put("lid", lid);
		mapper.deleteLecInCurri(map);
	}
	
}
