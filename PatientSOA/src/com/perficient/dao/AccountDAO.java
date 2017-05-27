package com.perficient.dao;

import java.math.BigDecimal;
import java.util.List;

import com.perficient.pojo.PftAccountDetails;
import com.perficient.to.ResponseTO;


public interface AccountDAO {

	ResponseTO saveDetails(PftAccountDetails pftAccountDetails );
	ResponseTO updateDetails(PftAccountDetails pftAccountDetails );
	List<PftAccountDetails> getAccountDetails(BigDecimal userId);
	
}
