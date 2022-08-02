package com.javatpoint.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.javatpoint.beans.ClassroomVO;
import com.javatpoint.beans.LectureVO;


public interface ClassroomServiceITF {
	public ClassroomVO selectClassroom(int id);
	
	// 여러 개 select
	public List<ClassroomVO> selectAllClassroom();
	
	// INSERT
	public void insertClassroom(ClassroomVO classroom);
	
	// UPDATE		
	public void updateClassroom(ClassroomVO classroom);
	
	
// DELETE	
	public void deleteClassroom(int id);
	
	public LectureVO selectLecture(int id);
	
	public List<LectureVO> selectAllLecture();
	
	
	public List<LectureVO> selectAllLectureCate(String cate);
	public List<LectureVO> selectAllLectureClass(int id);
	

// INSERT
	public void insertLecture(LectureVO lec);
	public void insertLecInCurri(HashMap<String, Integer> map);
	
// UPDATE		
	public void updateLecture(LectureVO lec);
	
	
// DELETE	
	public void deleteLecture(int id);
	public void deleteCurriculumLec(int id);
	public void deleteCurriculum(int id);
	public void deleteLecInCurri(HashMap<String, Integer> map);
	
	
	
//	public ClassroomVO selectUser(int id) {
//
//		ClassroomVO classroom = session.selectOne("classroomDB.selectUser", id);
//		return classroom;
//	}
//	
//	// 여러 개 select
//	public List<ClassroomVO> selectAllUser() {
//		
//		List<ClassroomVO> classroomList = session.selectList("classroomDB.selectAllClassroom");
//		return classroomList;		
//	}
}
