package com.sheshu.dbh.controller;

import com.sheshu.dbh.bean.Cat;
import com.sheshu.dbh.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 董帮辉 2017-4-16.
 */
@Controller
@RequestMapping("/cat")
public class CatController {

    @Resource
    private CatService catService;

    @RequestMapping("/selectByName")
    @ResponseBody
    public Cat selectByName(String name){
        return catService.selectByName(name);
    }

    /**
     * 返回html模板.
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){
        map.put("hello","from TemplateController.helloHtml");
        return "/hello";
    }


}
