package com.sheshu.dbh.dao;

import com.sheshu.dbh.bean.Cat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 董帮辉 2017-4-16.
 */
@Repository
public class CatDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 1，定义Sql语句
     * 2，定义一个RowMappper
     * 3,执行查询方法
     */
    public Cat selectByName(String name) {
        String sql = "select * from cat where name=?";
        BeanPropertyRowMapper<Cat> rowMapper = new BeanPropertyRowMapper<>(Cat.class);
        Cat cat = jdbcTemplate.queryForObject(sql, new Object[]{name}, rowMapper);
        return cat;
    }


}
