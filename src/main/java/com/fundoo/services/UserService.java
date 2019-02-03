package com.fundoo.services;

import com.fundoo.models.GenerateOTP;
import com.fundoo.models.User;


public interface UserService {

	//void save(UserDTO userDTO);
   boolean addUser(User user);

	
	boolean sendOtpCall(User user);

	
	boolean verifyOtp(GenerateOTP userOtp);


	boolean updateUser(User user, Integer id);

	
	boolean deleteUser(Integer id);

	
	String userLogin(User user);
	
	
	public User getUser(Integer id);

	
	boolean forgetPassword(User user);


	boolean forgetVerification(GenerateOTP generateOtp, User forgetUser);

}
