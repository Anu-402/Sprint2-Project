package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {
	static public Map<String,Account> accountEntry;
	 
	public AccountDaoImpl() {
			accountEntry = new HashMap<>();
	
			accountEntry.put("9010210131",new Account("Prepaid", "Vaishali",200));
			accountEntry.put("9823920123",new Account("Prepaid", "Megha",453));
			accountEntry.put("9932012345",new Account("Prepaid", "Vikas",631));
			accountEntry.put("9010210131",new Account("Prepaid", "Anju",700));
			accountEntry.put("9010210131",new Account("Prepaid", "Tushar",632));
			
		}
	public Account getAccountDetails(String mobileno) {
		if(accountEntry.containsKey(mobileno)) {
			Account a;
			a=accountEntry.get(mobileno);
			//System.out.println("Account Balence : "+a.getAccountBalance());
			return a;
			
		}
		else
			
			return null;
	}
	public int rechargeAccount(String mobileno,double rechargeAccount ) {
		if(accountEntry.containsKey(mobileno)) {
			Account a=accountEntry.get(mobileno);
			
			double nb=a.getAccountBalance()+rechargeAccount;
			a.setAccountBalance(nb);
			accountEntry.replace(mobileno, a);
			
			return (int)nb;
		}
		else {
		return 0;
		}
	}
	
}
