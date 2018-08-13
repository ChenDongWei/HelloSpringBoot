package com.minstone.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minstone.dao.AccountDao;
import com.minstone.entity.Account;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	public void transferAccounts(int fromUserId, int toUserId, float account) {
		Account fromUser = accountDao.getOne(fromUserId);
		fromUser.setBalance(fromUser.getBalance() - account);
		accountDao.save(fromUser);
		
		Account toUser = accountDao.getOne(toUserId);
		toUser.setBalance(toUser.getBalance() + account);
		accountDao.save(toUser);
	}
}
