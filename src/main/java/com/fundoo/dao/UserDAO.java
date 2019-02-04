package com.fundoo.dao;

import java.util.List;

import com.fundoo.models.GenerateOtp;
import com.fundoo.models.User;

public interface UserDAO {

//	void save(User user); 

	boolean save(User user);

	List<User> getAllUser();

	void saveOtp(GenerateOtp userOtp);

	List<GenerateOtp> getAllOtp();


	User getUser(Integer id);

	boolean updateUser(User updateUser);

	boolean deleteUser(User updateUser);

	boolean updateOtp(GenerateOtp newUserOtp);
}
