package com.cg.mra.service;
import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.ui.MainUI;

public class AccountServiceImpl implements AccountService {
	AccountDaoImpl adi = new AccountDaoImpl();
	public Account getAccountDetails(String mobileno) {
		Account a= adi.getAccountDetails(mobileno);
		return a;
		
	}
	
	public int rechargeAccount(String mobileno,double rechargeAccount ) {
		int a=adi.rechargeAccount(mobileno, rechargeAccount);
		return a;
	}

}
