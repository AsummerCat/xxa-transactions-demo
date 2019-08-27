package com.linjingc.jtaatomikosdemo.dao;

import com.linjingc.jtaatomikosdemo.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountMapper {
    @Insert("INSERT INTO account(user_id,money) VALUES(#{userId},#{money})")
    public void insert(Account account);
}