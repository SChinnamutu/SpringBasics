package com.perficient.dao;

import java.util.List;

import com.perficient.pojo.PftUserDetails;


public interface LoginDAO {
	
	List<PftUserDetails> validate(String userName,String pswd);
}
