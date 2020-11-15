package com.example.controller;

import com.example.domain.Score;

import com.example.service.ICourseService;
import com.example.service.IScoreService;

import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private IScoreService scoreService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICourseService courseService;
    @RequestMapping(value = "/getAll")
    public @ResponseBody
    ModelAndView getAll(@RequestParam(name = "page",defaultValue = "1") int page,
                        @RequestParam(name = "size",defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",scoreService.getAll(page,size));
        mv.setViewName("score_list");
        return mv;
    }

    @RequestMapping(value = "/getById")
    public @ResponseBody
    ModelAndView getById(Score s){
        ModelAndView mv = new ModelAndView();
        mv.addObject("score",scoreService.getById(s));
        mv.addObject("studentlist",studentService.getAll(1,Integer.MAX_VALUE).getList());
        mv.addObject("courselist",scoreService.getAll(1,Integer.MAX_VALUE).getList());
        mv.setViewName("score_detail");
        return mv;
    }
    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    public String insert(Score s){
        scoreService.insert(s);
        return "redirect:getAll";
    }
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public String update(Score s){
        scoreService.update(s);
        return "redirect:getAll";
    }

    @RequestMapping(value = "deleteByIds",method = {RequestMethod.POST})
    public  String deleteByIds(String ids){
        Score s = new Score();
        String[] arr  = ids.split("&");
        s.setSno(arr[0]);
        s.setCno(arr[1]);
        scoreService.deleteById(s);
        return "redirect:getAll";
    }
    @RequestMapping(value = "/addScore")
    public @ResponseBody
    ModelAndView getAll(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("studentlist",studentService.getAll(1,Integer.MAX_VALUE).getList());
        mv.addObject("courselist",courseService.getAll(1,Integer.MAX_VALUE).getList());
        mv.setViewName("score_add");
        return mv;
    }
}
