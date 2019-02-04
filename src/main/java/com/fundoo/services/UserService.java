package com.fundoo.services;

import com.fundoo.models.GenerateOtp;
import com.fundoo.models.User;


public interface UserService {

	//void save(UserDTO userDTO);
   boolean addUser(User user);

	
	boolean sendOtpCall(User user);

	
	boolean verifyOtp(GenerateOtp userOtp);


	boolean updateUser(User user, Integer id);

	
	boolean deleteUser(Integer id);

	
	String userLogin(User user);
	
	
	public User getUser(Integer id);

	
	boolean forgetPassword(User user);


	boolean forgetVerification(GenerateOtp generateOtp, User forgetUser);

}
