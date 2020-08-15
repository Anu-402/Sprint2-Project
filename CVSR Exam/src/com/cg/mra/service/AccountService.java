package com.cg.mra.service;

import com.cg.mra.beans.Account;

public interface AccountService {
	Account getAccountDetails(String mobileno);
	int rechargeAccount(String mobileno,double rechargeAccount );
	
}
