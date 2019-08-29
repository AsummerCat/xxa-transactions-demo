package com.linjingc.simpleatomikosdemo.dao;

import com.linjingc.simpleatomikosdemo.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountMapper {
	@Insert("INSERT INTO account(user_id,money) VALUES(#{userId},#{money})")
	public void insert(Account account);
}