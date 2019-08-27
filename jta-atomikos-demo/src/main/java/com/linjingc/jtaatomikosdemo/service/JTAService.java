package com.linjingc.jtaatomikosdemo.service;

import com.linjingc.jtaatomikosdemo.dao.AccountMapper;
import com.linjingc.jtaatomikosdemo.dao1.UserMapper;
import com.linjingc.jtaatomikosdemo.entity.Account;
import com.linjingc.jtaatomikosdemo.entity.BasicUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class JTAService {
	//操作db_account库
	@Resource
	private AccountMapper accountMapper;
	//操作db_user库
	@Resource
	private UserMapper userMapper;


	@Transactional
	public void insert() {
		BasicUser user = new BasicUser();
		user.setName("wangxiaoxiao");
		userMapper.insert(user);

		    int i = 1 / 0;//模拟异常，spring回滚后，db_user库中user表中也不会插入记录
		Account account = new Account();
		account.setUserId(user.getId());
		account.setMoney(1111d);
		accountMapper.insert(account);
	}
}