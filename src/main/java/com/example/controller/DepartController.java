package com.example.controller;

import com.example.domain.Depart;
import com.example.service.IDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/depart")
public class DepartController {
    @Autowired
    private IDepartService departService;
    @RequestMapping(value = "/getAll")
    public @ResponseBody
    ModelAndView getAll(@RequestParam(name = "page",defaultValue = "1") int page,
                        @RequestParam(name = "size",defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",departService.getAll(page,size));
        mv.setViewName("depart_list");
        return mv;
    }

    @RequestMapping(value = "/getById")
    public @ResponseBody
    ModelAndView getById(String departno){
        ModelAndView mv = new ModelAndView();
        mv.addObject("depart",departService.getById(departno));
        mv.setViewName("depart_detail");
        return mv;
    }
    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    public String insert(Depart s){
        departService.insert(s);
        return "redirect:getAll";
    }
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public String update(Depart s){
        departService.update(s);
        return "redirect:getAll";
    }

    @RequestMapping(value = "deleteByIds",method = {RequestMethod.POST})
    public  String deleteByIds(String ids[]){
        departService.deleteByIds(ids);
        return "redirect:getAll";
    }
}
