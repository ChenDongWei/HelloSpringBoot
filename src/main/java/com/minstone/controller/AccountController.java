package com.minstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minstone.service.AccountService;

@RestController
@RequestMapping("/blank/")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("transfer")
	public String transferAccounts() {
		try {
			accountService.transferAccounts(1, 2, 200);
			return "转账成功";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "转账失败";
	}
}
