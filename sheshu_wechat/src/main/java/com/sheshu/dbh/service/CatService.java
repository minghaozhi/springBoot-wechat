package com.sheshu.dbh.service;

import com.sheshu.dbh.bean.Cat;
import com.sheshu.dbh.dao.CatDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CatService {

    @Resource
    private CatDao catDao;

    public Cat selectByName(String name){
        return catDao.selectByName(name);
    }

}
