package com.fundoo.dao;

import java.util.List;

import com.fundoo.models.GenerateOTP;
import com.fundoo.models.User;

public interface UserDAO {

//	void save(User user); 

	boolean save(User user);

	List<User> getAllUser();

	void saveOtp(GenerateOTP userOtp);

	List<GenerateOTP> getAllOtp();


	User getUser(Integer id);

	boolean updateUser(User updateUser);

	boolean deleteUser(User updateUser);

	boolean updateOtp(GenerateOTP newUserOtp);
}
