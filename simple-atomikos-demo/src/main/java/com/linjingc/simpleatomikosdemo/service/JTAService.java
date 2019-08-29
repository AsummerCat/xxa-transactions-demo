package com.linjingc.simpleatomikosdemo.service;

import com.linjingc.simpleatomikosdemo.dao.AccountMapper;
import com.linjingc.simpleatomikosdemo.dao1.UserMapper;
import com.linjingc.simpleatomikosdemo.entity.Account;
import com.linjingc.simpleatomikosdemo.entity.BasicUser;
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
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				BasicUser user = new BasicUser();
				user.setName("wangxiaoxiao");
				userMapper.insert(user);

//		int i = 1 / 0;//模拟异常，spring回滚后，db_user库中user表中也不会插入记录
				Account account = new Account();
				account.setUserId(user.getId());
				account.setMoney(1111d);
				accountMapper.insert(account);
			}).run();
		}
//		int i = 1 / 0;

	}
}