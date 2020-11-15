package com.example.controller;

import com.example.domain.Clas;

import com.example.service.IClasService;

import com.example.service.IDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/clas")
public class ClasController {
    @Autowired
    private IClasService clasService;
    @Autowired
    private IDepartService departService;
    @RequestMapping(value = "/getAll")
    public @ResponseBody
    ModelAndView getAll(@RequestParam(name = "page",defaultValue = "1") int page,
                        @RequestParam(name = "size",defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",clasService.getAll(page,size));
        mv.setViewName("clas_list");
        return mv;
    }

    @RequestMapping(value = "/getById")
    public @ResponseBody
    ModelAndView getById(String clasno){
        ModelAndView mv = new ModelAndView();
        mv.addObject("clas",clasService.getById(clasno));
        mv.setViewName("clas_detail");
        return mv;
    }
    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    public String insert(Clas s){
        clasService.insert(s);
        return "redirect:getAll";
    }
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public String update(Clas s){
        clasService.update(s);
        return "redirect:getAll";
    }

    @RequestMapping(value = "deleteByIds",method = {RequestMethod.POST})
    public  String deleteByIds(String ids[]){
        clasService.deleteByIds(ids);
        return "redirect:getAll";
    }
}
