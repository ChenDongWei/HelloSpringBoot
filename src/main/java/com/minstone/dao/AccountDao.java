package com.minstone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minstone.entity.Account;

/**
 *  银行转账dao
 * @author ChenDongWei
 * @date 2018年8月10日下午3:51:35
 */
public interface AccountDao extends JpaRepository<Account, Integer> {
	
}
