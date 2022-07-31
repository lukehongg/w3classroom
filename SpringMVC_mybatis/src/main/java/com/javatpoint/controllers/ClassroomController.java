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

@Controller    
public class ClassroomController {    
    @Autowired    
    ClassDao dao;//will inject dao from XML file    
    
	@RequestMapping(value = "/")
	public String index() {
		return "w3main";
	}
    
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */
	
	@RequestMapping("/classroomform")    
    public String showclassroomform(Model m){
		m.addAttribute("command", new Classroom());
        return "classroomform";   
    } 
	
	// mvc
   @RequestMapping(value = "/classroomsave", method = RequestMethod.POST)    
    public String showclassroomform(@ModelAttribute("m") Classroom classroom ){    
		dao.saveClassroom(classroom);
        return "allclassroom";   
    }
    
	@RequestMapping("/lectureform")    
    public String showlectureform(Model m){
		m.addAttribute("command", new Lecture());
        return "lectureform";   
    } 
	
    @RequestMapping(value = "/lecturesave", method = RequestMethod.POST)    
    public String showlectureform(@ModelAttribute("m") Lecture lecture){    
        dao.saveLecture(lecture);
        return "alllecture";   
    } 
    
    /*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/    
    @RequestMapping(value="/saveClassroom",method = RequestMethod.POST)    
    public String saveClassroom(@ModelAttribute("classroom") Classroom Classroom){    
        dao.saveClassroom(Classroom);    
        return "allclassroom";//will redirect to viewemp request mapping    
    }    
    
    @RequestMapping(value="/saveLecture",method = RequestMethod.POST)    
    public String saveLecture(@ModelAttribute("lecture") Lecture Lecture){    
        dao.saveLecture(Lecture);    
        return "alllecture";//will redirect to viewemp request mapping    
    }    
    
    /* It provides list of employees in model object */    
    @RequestMapping("/viewclassroom")    
    public String viewclassroom(Model m){    
        List<Classroom> list=dao.getAllClassroom();    
        m.addAttribute("a_clr_list",list);   
        return "allclassroom";    
    }   
    
    @RequestMapping("/viewlecture")    
    public String viewlecture(Model m){    
        List<Lecture> list=dao.getAllLecture();    
        List<Lecture> HTML_list = dao.getAllLectureByCategory("HTML");
        List<Lecture> CSS_list = dao.getAllLectureByCategory("CSS");
        List<Lecture> JS_list = dao.getAllLectureByCategory("JavaScript");
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
    
    @RequestMapping(value="/LecByCate/{cate}")    
    public String viewlectureByCate(@PathVariable String cate, Model m){    
        List<Lecture> list = dao.getAllLectureByCategory(cate);    
        m.addAttribute("a_lec_list",list);  
        return "alllecture";    
    }
 
//	클라스 별 Lecture 출력
    @RequestMapping(value="/lecbyclassroom/{id}", method=RequestMethod.GET)    
    public String viewbyclass(@PathVariable int id, Model m){    
    	 List<Lecture> list = dao.getLectureByClassroom(id);       
        m.addAttribute("lec_by_class",list);
        m.addAttribute("classID", id);
        return "viewlecbyclassroom";    
    }
    
    
    
   

    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    @RequestMapping(value="/editclassroom/{id}")    
    public String editClassroom(@PathVariable int id, Model m){    
        Classroom classroom = dao.getRecordById(id);    
        List<Lecture> list = dao.getLectureByClassroom(id);
        List<Lecture> ALL_list =dao.getAllLecture();    
        List<Lecture> HTML_list = dao.getAllLectureByCategory("HTML");
        List<Lecture> CSS_list = dao.getAllLectureByCategory("CSS");
        List<Lecture> JS_list = dao.getAllLectureByCategory("JavaScript");
        m.addAttribute("classID",id);  
        m.addAttribute("command", classroom);
        m.addAttribute("lec_by_class",list);
        
        m.addAttribute("ALL_list", ALL_list);  
        m.addAttribute("HTML_list",HTML_list);  
        m.addAttribute("CSS_list",CSS_list);  
        m.addAttribute("JS_list",JS_list); 
        
        return "classroomeditform";    
    }
    
    @RequestMapping(value="/editclassroom/deleteLecInCurri/{cid}/{lid}", method=RequestMethod.GET)    
    public String deleteLecInClass(@PathVariable int cid,@PathVariable int lid, Model m){    
    	dao.delLecInCurri(cid, lid);     
        return "redirect:/editclassroom/"+cid;    
    }
    
    @RequestMapping(value="/editclassroom/addLecInCurri/{cid}/{lid}", method=RequestMethod.GET)    
    public String addLecInClass(@PathVariable int cid,@PathVariable int lid, Model m){    
    	dao.addLecInCurri(cid, lid);     
        return "redirect:/editclassroom/"+cid;    
    }
    
    /* It updates model object. */    
    @RequestMapping(value="/editclassroom/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("classroom") Classroom classroom){    
        dao.update(classroom);    
        return "redirect:/viewclassroom";    
    }
    
    @RequestMapping(value="/editlecture/{id}")    
    public String editLecture(@PathVariable int id, Model m){    
        Lecture lecture = dao.getLectureById(id);    
        m.addAttribute("command", lecture);
        m.addAttribute("lid", id);
        return "lectureeditform";    
    }
    @RequestMapping(value="/editlecture/lectureeditsave",method = RequestMethod.POST)    
    public String editlecturesave(@ModelAttribute("lecture") Lecture lecture){    
        dao.updateLecture(lecture);    
        return "redirect:/viewlecture";    
    }
    
    
    
    /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deleteclassroom/{id}",method = RequestMethod.GET)    
    public String deleteClassroom(@PathVariable int id){    
        dao.deleteClassroom(id);
        dao.deleteClassroom2(id);
        return "redirect:/viewclassroom";    
    }
    /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deleteLecture/{id}",method = RequestMethod.GET)    
    public String deleteLecture(@PathVariable int id){    
        dao.deleteLecture(id);
        dao.deleteLecture2(id);
        return "redirect:/viewlecture";    
    }
    
    
    
}