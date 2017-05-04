package com.sheshu.heat.controller;

import com.sheshu.dbh.bean.Cat;
import com.sheshu.heat.service.Cat2Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 董帮辉 on 2017-4-22.
 */
@Controller
@RequestMapping("demo")
public class DemoController {

    @Resource
    private Cat2Service cat2Service;

    @RequestMapping(value = "insertCat",method = RequestMethod.POST)
    @ResponseBody
    public String insertCat(Cat cat){
        Integer count = this.cat2Service.insertCat(cat);
        if(count>0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

}
