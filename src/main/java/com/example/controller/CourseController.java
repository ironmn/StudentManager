package com.example.controller;

import com.example.domain.Course;

import com.example.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @RequestMapping(value = "/getAll")
    public @ResponseBody
    ModelAndView getAll(@RequestParam(name = "page",defaultValue = "1") int page,
                        @RequestParam(name = "size",defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",courseService.getAll(page,size));
        mv.setViewName("course_list");
        return mv;
    }

    @RequestMapping(value = "/getById")
    public @ResponseBody
    ModelAndView getById(String cno){
        ModelAndView mv = new ModelAndView();
        mv.addObject("course",courseService.getById(cno));
        mv.setViewName("course_detail");
        return mv;
    }
    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    public String insert(Course s){
        courseService.insert(s);
        return "redirect:getAll";
    }
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public String update(Course s){
        courseService.update(s);
        return "redirect:getAll";
    }

    @RequestMapping(value = "deleteByIds",method = {RequestMethod.POST})
    public  String deleteByIds(String ids[]){
        courseService.deleteByIds(ids);
        return "redirect:getAll";
    }
}
