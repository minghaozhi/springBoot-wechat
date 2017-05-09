package com.sheshu.heat.service;

import com.sheshu.dbh.bean.Cat;
import com.sheshu.heat.mapper.CatMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Cat2Service {

    @Resource
    private CatMapper catMapper;

    public Integer insertCat(Cat cat) {
        int count = catMapper.insert(cat);
        return count;
    }
}
