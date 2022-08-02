package com.javatpoint.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;



import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     

import com.javatpoint.beans.*;    
import com.javatpoint.dao.*;
import com.javatpoint.service.*;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

@Controller
public class ClassroomController {    
	
//    @Autowired    
//    ClassDao dao;//will inject dao from XML file  
    
	@Autowired
	ClassroomService classroomService;
	
    @Inject
   	private SqlSessionFactory sqlFactory;
    
//    @Resource(name = "ClassroomDAO")
//    @Autowired  
//    private ClassroomDAO classroomdao;
//
////    @Resource(name = "LectureDAO")
//    @Autowired  
//    private LectureDAO lecturedao;
//    
////    @Resource(name = "UserDAO")
//    @Autowired  
//    private UserDAO userdao;
    
	@RequestMapping(value = "/")
	public String index() {
		try {

			SqlSession session = sqlFactory.openSession();
			System.out.println("성공 : " + session);
				
		} catch (Exception ex){
			System.out.println("실패..!");
			ex.printStackTrace();
		}
		return "w3main";
	}
    
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */

	
//	// mvc
//   @RequestMapping(value = "/classroomsave", method = RequestMethod.POST)    
//    public String showclassroomform(@ModelAttribute("m") ClassroomVO classroom ){    
//		dao.saveClassroom(classroom);
//        return "allclassroom";   
//    }
    

	
//    @RequestMapping(value = "/lecturesave", method = RequestMethod.POST)    
//    public String showlectureform(@ModelAttribute("m") Lecture lecture){    
//        dao.saveLecture(lecture);
//        return "alllecture";   
//    } 
    
//	// batis
//	@RequestMapping(value = "/loginform")
//	public String toLoginPage(Model m) {
//		m.addAttribute("command", new UserVO());
//		return "loginpage";
//	}
//	// batis
//	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
//	public String loginCheck(@ModelAttribute("user") UserVO user) throws Exception {
//		String path="";
//		int check = userdao.Login(user);
//		if(check == 1) {
//			path = "w3main";
//		}
//		else path = "loginpage";
//		return path;
//	}
		
	
	// batis
	@RequestMapping("/classroomform")    
    public String showclassroomform(Model m){
		m.addAttribute("command", new ClassroomVO());
        return "classroomform";   
    } 
	
//    // batis
//    @RequestMapping(value="/saveClassroom",method = RequestMethod.POST)    
//    public String saveClassroom(@ModelAttribute("classroom") ClassroomVO Classroom){    
//        classroomdao.insertClassroom(Classroom);    
//        return "redirect:viewclassroom";  
//    }  
    // batis
    @RequestMapping(value="/saveClassroom",method = RequestMethod.POST)    
    public String saveClassroom(@ModelAttribute("classroom") ClassroomVO Classroom){    
    	classroomService.insertClassroom(Classroom);    
        return "redirect:viewclassroom";  
    } 
    
//	// batis
//    @RequestMapping("/lectureform")    
//    public String showlectureform(Model m){
//		m.addAttribute("command", new LectureVO());
//        return "lectureform";   
//    } 
	// batis
    @RequestMapping("/lectureform")    
    public String showlectureform(Model m){
		m.addAttribute("command", new LectureVO());
        return "lectureform";   
    } 
    
//    // batis
//    @RequestMapping(value="/saveLecture",method = RequestMethod.POST)    
//    public String saveLecture(@ModelAttribute("lecture") LectureVO Lecture){    
//        lecturedao.insertLecture(Lecture);    
//        return "redirect:viewlecture";   
//    }    
    // batis
    @RequestMapping(value="/saveLecture",method = RequestMethod.POST)    
    public String saveLecture(@ModelAttribute("lecture") LectureVO Lecture){    
    	classroomService.insertLecture(Lecture);    
        return "redirect:viewlecture";   
    }   
    

    
//    // batis
//    @RequestMapping(value = "/viewclassroom")    
//    public String viewclassroom(Model m){    
//        List<ClassroomVO> list = classroomdao.selectAllClassroom();    
//        m.addAttribute("a_clr_list",list);   
//        return "allclassroom";    
//    }  
    // service
//    @RequestMapping(value = "/viewclassroom")    
//    public String viewclassroom(Model m){   
//    	List<ClassroomVO> classroomList = classroomService.selectAllClassroom();
//		m.addAttribute("a_clr_list", classroomList);
//    	return "allclassroom";	  
//    }  
    @RequestMapping(value = "/viewclassroom")    
    public String viewclassroom(Model m){   
    	List<ClassroomVO> classroomList = classroomService.selectAllClassroom();
		m.addAttribute("a_clr_list", classroomList);
    	return "allclassroom";	  
    }  
    
    // batis
//    @RequestMapping(value = "/viewlecture")    
//    public String viewlecture(Model m){    
//        List<LectureVO> list=lecturedao.selectAllLecture();    
//        List<LectureVO> HTML_list = lecturedao.selectAllLectureCate("HTML");
//        List<LectureVO> CSS_list = lecturedao.selectAllLectureCate("CSS");
//        List<LectureVO> JS_list = lecturedao.selectAllLectureCate("JavaScript");
//        m.addAttribute("ALL_list",list);  
//        m.addAttribute("HTML_list",HTML_list);  
//        m.addAttribute("CSS_list",CSS_list);  
//        m.addAttribute("JS_list",JS_list);  
//        return "alllecture";    
//    }  
    @RequestMapping(value = "/viewlecture")    
    public String viewlecture(Model m){    
        List<LectureVO> list=classroomService.selectAllLecture();    
        List<LectureVO> HTML_list = classroomService.selectAllLectureCate("HTML");
        List<LectureVO> CSS_list = classroomService.selectAllLectureCate("CSS");
        List<LectureVO> JS_list = classroomService.selectAllLectureCate("JavaScript");
        m.addAttribute("ALL_list",list);  
        m.addAttribute("HTML_list",HTML_list);  
        m.addAttribute("CSS_list",CSS_list);  
        m.addAttribute("JS_list",JS_list);  
        return "alllecture";    
    }
    
//    @RequestMapping(value = "/viewlecture/{cate}", method=RequestMethod.GET)    
//    public String viewlecture(@PathVariable String cate, Model m){   
//    	List<Lecture> list;
//    	if(cate.equals("ALL")) {
//    		list = dao.getAllLecture();
//    	} else {
//    		list = dao.getAllLectureByCategory(cate);
//    	}
//        m.addAttribute("a_lec_list",list);   
//        return "alllecture";    
//    }  
    
    
//    카테고리 별 Lecture 출력   
    
//    @RequestMapping(value="/LecByCate/{cate}")    
//    public String viewlectureByCate(@PathVariable String cate, Model m){    
//        List<Lecture> list = dao.getAllLectureByCategory(cate);    
//        m.addAttribute("a_lec_list",list);  
//        return "alllecture";    
//    }
    
    // batis
//    @RequestMapping(value="/LecByCate/{cate}")    
//    public String viewlectureByCate(@PathVariable String cate, Model m){    
//        List<LectureVO> list = lecturedao.selectAllLectureCate(cate);    
//        m.addAttribute("a_lec_list",list);  
//        return "alllecture";    
//    }
    @RequestMapping(value="/LecByCate/{cate}")    
    public String viewlectureByCate(@PathVariable String cate, Model m){    
        List<LectureVO> list = classroomService.selectAllLectureCate(cate);    
        m.addAttribute("a_lec_list",list);  
        return "alllecture";    
    }
 
//	클라스 별 Lecture 출력
    // batis
//    @RequestMapping(value="/lecbyclassroom/{id}", method=RequestMethod.GET)    
//    public String viewbyclass(@PathVariable int id, Model m){    
//    	 List<LectureVO> list = lecturedao.selectAllLectureClass(id);       
//        m.addAttribute("lec_by_class",list);
//        m.addAttribute("classID", id);
//        return "viewlecbyclassroom";    
//    }
    @RequestMapping(value="/lecbyclassroom/{id}", method=RequestMethod.GET)    
    public String viewbyclass(@PathVariable int id, Model m){    
    	 List<LectureVO> list = classroomService.selectAllLectureClass(id);       
        m.addAttribute("lec_by_class",list);
        m.addAttribute("classID", id);
        return "viewlecbyclassroom";    
    }
    
    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    
    // batis
//    @RequestMapping(value="/editclassroom/{id}")    
//    public String editClassroom(@PathVariable int id, Model m){    
//        ClassroomVO classroom = classroomdao.selectClassroom(id);    
//        List<LectureVO> list = lecturedao.selectAllLectureClass(id);
//        List<LectureVO> ALL_list =lecturedao.selectAllLecture();    
//        List<LectureVO> HTML_list = lecturedao.selectAllLectureCate("HTML");
//        List<LectureVO> CSS_list = lecturedao.selectAllLectureCate("CSS");
//        List<LectureVO> JS_list = lecturedao.selectAllLectureCate("JavaScript");
//        m.addAttribute("classID",id);  
//        m.addAttribute("command", classroom);
//        m.addAttribute("lec_by_class",list);
//        m.addAttribute("ALL_list", ALL_list);  
//        m.addAttribute("HTML_list",HTML_list);  
//        m.addAttribute("CSS_list",CSS_list);  
//        m.addAttribute("JS_list",JS_list);  
//        return "classroomeditform";    
//    }
    @RequestMapping(value="/editclassroom/{id}")    
    public String editClassroom(@PathVariable int id, Model m){    
        ClassroomVO classroom = classroomService.selectClassroom(id);    
        List<LectureVO> list = classroomService.selectAllLectureClass(id);
        List<LectureVO> ALL_list =classroomService.selectAllLecture();    
        List<LectureVO> HTML_list = classroomService.selectAllLectureCate("HTML");
        List<LectureVO> CSS_list = classroomService.selectAllLectureCate("CSS");
        List<LectureVO> JS_list = classroomService.selectAllLectureCate("JavaScript");
        m.addAttribute("classID",id);  
        m.addAttribute("command", classroom);
        m.addAttribute("lec_by_class",list);
        m.addAttribute("ALL_list", ALL_list);  
        m.addAttribute("HTML_list",HTML_list);  
        m.addAttribute("CSS_list",CSS_list);  
        m.addAttribute("JS_list",JS_list);  
        return "classroomeditform";    
    }
   

    
    /* It updates model object. */    
//    @RequestMapping(value="/editclassroom/editsave",method = RequestMethod.POST)    
//    public String editsave(@ModelAttribute("classroom") ClassroomVO classroom){    
//        classroomdao.updateClassroom(classroom);    
//        return "redirect:/viewclassroom";    
//    }
    @RequestMapping(value="/editclassroom/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("classroom") ClassroomVO classroom){    
    	classroomService.updateClassroom(classroom);    
        return "redirect:/viewclassroom";    
    }

    @RequestMapping(value="/editclassroom/viewclassroom")    
    public String toAllClassroom(){        
        return "redirect:/viewclassroom";    
    } 
    @RequestMapping(value="/editclassroom/viewlecture")    
    public String toAllLecture(){        
        return "redirect:/viewlecture";    
    } 
    @RequestMapping(value="/editclassroom/classroomform")    
    public String toAllClassroomForm(){        
        return "redirect:/classroomform";    
    } 
    @RequestMapping(value="/editclassroom/lectureform")    
    public String toAllLectureForm(){        
        return "redirect:/lectureform";    
    } 
    
//    @RequestMapping(value="/editlecture/{id}")    
//    public String editLecture(@PathVariable int id, Model m){    
//        LectureVO lecture = lecturedao.selectLecture(id);    
//        m.addAttribute("command", lecture);
//        m.addAttribute("lid", id);
//        return "lectureeditform";    
//    }
    @RequestMapping(value="/editlecture/{id}")    
    public String editLecture(@PathVariable int id, Model m){    
        LectureVO lecture = classroomService.selectLecture(id);    
        m.addAttribute("command", lecture);
        m.addAttribute("lid", id);
        return "lectureeditform";    
    }
    
//    @RequestMapping(value="/editlecture/lectureeditsave",method = RequestMethod.POST)    
//    public String editlecturesave(@ModelAttribute("lecture") LectureVO lecture){    
//        lecturedao.updateLecture(lecture);    
//        return "redirect:/viewlecture";    
//    }
    @RequestMapping(value="/editlecture/lectureeditsave",method = RequestMethod.POST)    
    public String editlecturesave(@ModelAttribute("lecture") LectureVO lecture){    
    	classroomService.updateLecture(lecture);    
        return "redirect:/viewlecture";    
    }
    @RequestMapping(value="/editlecture/viewclassroom")    
    public String EditLectoAllClassroom(){        
        return "redirect:/viewclassroom";    
    } 
    @RequestMapping(value="/editlecture/viewlecture")    
    public String EditLectoAllLecture(){        
        return "redirect:/viewlecture";    
    } 
    @RequestMapping(value="/editlecture/classroomform")    
    public String EditLectoAllClassroomForm(){        
        return "redirect:/classroomform";    
    } 
    @RequestMapping(value="/editlecture/lectureform")    
    public String EditLectoAllLectureForm(){        
        return "redirect:/lectureform";    
    } 
    
    @RequestMapping(value="/lecbyclassroom/viewclassroom")    
    public String VBCtoAllClassroom(){        
        return "redirect:/viewclassroom";    
    } 
    @RequestMapping(value="/lecbyclassroom/viewlecture")    
    public String VBCtoAllLecture(){        
        return "redirect:/viewlecture";    
    } 
    @RequestMapping(value="/lecbyclassroom/classroomform")    
    public String VBCtoAllClassroomForm(){        
        return "redirect:/classroomform";    
    } 
    @RequestMapping(value="/lecbyclassroom/lectureform")    
    public String VBCtoAllLectureForm(){        
        return "redirect:/lectureform";    
    } 
    

//    // batis
//    @RequestMapping(value="/editclassroom/addLecInCurri/{cid}/{lid}", method=RequestMethod.GET)    
//    public String addLecInClass(@PathVariable Integer cid,@PathVariable Integer lid, Model m){    
//    	lecturedao.insertLecInCurri(cid, lid);     
//        return "redirect:/editclassroom/"+cid;    
//    }
    // batis
    @RequestMapping(value="/editclassroom/addLecInCurri/{cid}/{lid}", method=RequestMethod.GET)    
    public String addLecInClass(@PathVariable Integer cid,@PathVariable Integer lid, Model m){    
    	classroomService.insertLecInCurri(cid, lid);     
        return "redirect:/editclassroom/"+cid;    
    }

//    // batis
//    @RequestMapping(value="/editclassroom/deleteLecInCurri/{cid}/{lid}", method=RequestMethod.GET)    
//    public String deleteLecInClass(@PathVariable Integer cid,@PathVariable Integer lid, Model m){    
//    	lecturedao.deleteLecInCurri(cid, lid);     
//        return "redirect:/editclassroom/"+cid;    
//    }
    // batis
    @RequestMapping(value="/editclassroom/deleteLecInCurri/{cid}/{lid}", method=RequestMethod.GET)    
    public String deleteLecInClass(@PathVariable Integer cid,@PathVariable Integer lid, Model m){    
    	classroomService.deleteLecInCurri(cid, lid);     
        return "redirect:/editclassroom/"+cid;    
    }
    
//    // batis
//    @RequestMapping(value="/deleteclassroom/{id}",method = RequestMethod.GET)    
//    public String deleteClassroom(@PathVariable int id){    
//        classroomdao.deleteClassroom(id);
//        lecturedao.deleteCurriculum(id);
//        
//        return "redirect:/viewclassroom";    
//    }
    // batis
    @RequestMapping(value="/deleteclassroom/{id}",method = RequestMethod.GET)    
    public String deleteClassroom(@PathVariable int id){    
    	classroomService.deleteClassroom(id);
    	classroomService.deleteCurriculum(id);
        
        return "redirect:/viewclassroom";    
    }
//    // batis
//    @RequestMapping(value="/deleteLecture/{id}",method = RequestMethod.GET)    
//    public String deleteLecture(@PathVariable int id){    
//        lecturedao.deleteLecture(id);
//        lecturedao.deleteCurriculumLec(id);
//        
//        return "redirect:/viewlecture";    
//    }
    // batis
    @RequestMapping(value="/deleteLecture/{id}",method = RequestMethod.GET)    
    public String deleteLecture(@PathVariable int id){    
    	classroomService.deleteLecture(id);
    	classroomService.deleteCurriculumLec(id);
        
        return "redirect:/viewlecture";    
    }
    
    
    
}