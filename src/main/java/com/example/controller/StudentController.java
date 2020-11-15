package com.example.controller;

import com.example.domain.Student;
import com.example.service.IClasService;
import com.example.service.IStudentService;
import com.example.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClasService clasService;
    @RequestMapping(value = "/getAll")
    public @ResponseBody
    ModelAndView getAll(@RequestParam(name = "page",defaultValue = "1") int page,
                        @RequestParam(name = "size",defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",studentService.getAll(page,size));
        mv.setViewName("student_list");
        return mv;
    }

    @RequestMapping(value = "/getById")
    public @ResponseBody
    ModelAndView getById(String sno){
        ModelAndView mv = new ModelAndView();
        mv.addObject("student",studentService.getById(sno));
        mv.addObject("claslist",clasService.getAll(1,Integer.MAX_VALUE).getList());
        mv.setViewName("student_detail");
        return mv;
    }
    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    public String insert(Student s){
        studentService.insert(s);
        return "redirect:getAll";
    }
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public String update(Student s){
        studentService.update(s);
        return "redirect:getAll";
    }

    @RequestMapping(value = "deleteByIds",method = {RequestMethod.POST})
    public  String deleteByIds(String ids[]){
        studentService.deleteByIds(ids);
        return "redirect:getAll";
    }
    @RequestMapping(value = "/addStudent")
    public @ResponseBody
    ModelAndView addStudent(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("claslist",clasService.getAll(1,Integer.MAX_VALUE).getList());
        mv.setViewName("student_add");
        return mv;
    }

}
