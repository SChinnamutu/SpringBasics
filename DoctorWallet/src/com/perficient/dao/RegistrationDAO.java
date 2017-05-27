package com.perficient.dao;

import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;


public interface RegistrationDAO {

	ResponseTO saveDetails(PftUserDetails pftUserDetails);	
}
