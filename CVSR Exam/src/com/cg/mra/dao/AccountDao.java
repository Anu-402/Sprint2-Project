package com.cg.mra.dao;

import com.cg.mra.beans.Account;

//import com.cg.mra.service.Account;

public interface AccountDao {
	Account getAccountDetails(String mobileno);
	int rechargeAccount(String mobileno,double rechargeAccount );
}
