package com.fundoo.services;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.models.GenerateOtp;
import com.fundoo.utility.UserToken;
import com.fundoo.utility.Utility;
import com.fundoo.dao.UserDAO;

import com.fundoo.models.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
//	@Override
//	public void save(UserDTO userDTO) {
//		User user = new User(userDTO);
//		userDAO.save(user);
//	}

	@Autowired
	String key;
	
	@Override
	public boolean addUser(User user) {
		
		System.out.println(userDao + " " + key);
		System.out.println("check1"+user.getPassword());
		String encryptedPassword = Utility.encrypt(user.getPassword(), key);
		
		System.out.println("check2");
		System.out.println(key);
		System.out.println("check2");
		System.out.println(encryptedPassword);
		
		user.setPassword(encryptedPassword);
		System.out.println("check3");
		user.setIsActive(1);
		boolean check = userDao.save(user);
		System.out.println("check4");
		return check;
	}

	@Override
	public boolean sendOtpCall(User user) {

		List<User> userList = userDao.getAllUser();
		List<GenerateOtp> generateOtps = userDao.getAllOtp();
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		if (user.getEmail().equals(userList.get(i).getEmail())
				&& generateOtps.get(i).getEmail().equals(user.getEmail())) {
				System.out.println("already exist");
				return false;
			}
		}
		String password = Utility.OTP();
		GenerateOtp userOtp = new GenerateOtp();
		
//		userOtp.setEmail(user.getEmail());
//		userOtp.setOtpPassword(password);
		for (int i = 0; i < generateOtps.size(); i++) {
			System.out.println("aadsads");
			if (user.getEmail().equals(generateOtps.get(i).getEmail())) {
				userOtp = generateOtps.get(i);
				System.out.println(userOtp);
				userOtp.setEmail(user.getEmail());
				userOtp.setOtpPassword(password);
				System.out.println("after generate" + userOtp);
				userDao.updateOtp(userOtp);
				Utility.sendEmail(user, password);
				return true;
			}
		}
		System.out.println("hiiii");
		userOtp.setEmail(user.getEmail());
		userOtp.setOtpPassword(password);
		userDao.saveOtp(userOtp);
		Utility.sendEmail(user, password);

		return true;
	}

	@Override
	public boolean verifyOtp(GenerateOtp userOtp) {
     System.out.println("aman"+userOtp.getOtpPassword());
		List<GenerateOtp> otp = userDao.getAllOtp();
		
		
		System.out.println("hdjsg");
		System.out.println(userOtp.getEmail() + " " + userOtp.getOtpPassword() + " " + otp.size());
		for (int i = 0; i < otp.size(); i++) 
		{
			System.out.println("hihihih");
			System.out.println(otp.get(i).getOtpPassword());
			if (userOtp.getOtpPassword().equals(otp.get(i).getOtpPassword())) {
				//System.out.println("hi");
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateUser(User user, Integer id) {
		User updateUser = userDao.getUser(id);
		updateUser.setName(user.getName());
		updateUser.setEmail(user.getEmail());
		boolean check = userDao.updateUser(updateUser);
		if (check)
			return true;
		return false;
	}

	@Override
	public boolean deleteUser(Integer id) {
		User updateUser = userDao.getUser(id);

		boolean check = userDao.deleteUser(updateUser);
		if (check)
			return true;
		return false;
	}

	@Override
	public String userLogin(User user) {
		System.out.println("sssssssssss"+user.getPassword());
		System.out.println("eeeeeeeeeeeee"+user.getEmail());

		List<User> userList = userDao.getAllUser();
		for (int i = 0; i < userList.size(); i++) {
			System.out.println("test1");
			String encrptedPassword = Utility.encrypt(user.getPassword(), key);
			System.out.println( Utility.encrypt(user.getPassword(), key));
			System.out.println("test2");
			System.out.println(encrptedPassword);
			
			if (user.getEmail().equals(userList.get(i).getEmail())
					&& encrptedPassword.equals(userList.get(i).getPassword())) {

				try {
					return UserToken.generateToken(userList.get(i).getUserId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return "not valid";
	}

	@Override
	public User getUser(Integer id) {
		User user = userDao.getUser(id);
		return user;
	}

	@Override
	public boolean forgetPassword(User user) {
		List<User> userList = userDao.getAllUser();
		List<GenerateOtp> userOtp = userDao.getAllOtp();
		for (int i = 0; i < userList.size(); i++) {
			if (user.getEmail().equals(userList.get(i).getEmail())) {
				// User newUser=userList.get(i);

				String password = Utility.OTP();
				GenerateOtp newUserOtp = new GenerateOtp();

				if (userOtp.get(i).getEmail().equals(user.getEmail())) {
					newUserOtp = userOtp.get(i);
				}
				newUserOtp.setEmail(user.getEmail());
				newUserOtp.setOtpPassword(password);
				boolean check = userDao.updateOtp(newUserOtp);
				if (check) {
					Utility.sendEmail(user, password);
					/*
					 * String encryptedPassword=Utility.encrypt(user.getPassword(), key);
					 * newUser.setPassword(encryptedPassword); boolean
					 * check1=userDao.updateUser(newUser); if(check1)
					 */
					return true;
				}

			}
		}
		return false;
	}

	@Override
	public boolean forgetVerification(GenerateOtp generateOtp, User forgetUser) {
		List<GenerateOtp> userOtp = userDao.getAllOtp();
		List<User> userList = userDao.getAllUser();
		for (int i = 0; i < userOtp.size(); i++) {
			if (generateOtp.getOtpPassword().equals(userOtp.get(i).getOtpPassword())) {
				for (int j = 0; j < userList.size(); j++) {

					if (userList.get(i).getEmail().equals(forgetUser.getEmail())) {
						String encryptedPassword = Utility.encrypt(forgetUser.getPassword(), key);
						User newUser = userList.get(i);
						newUser.setPassword(encryptedPassword);
						boolean check = userDao.updateUser(newUser);
						if (check) {
							return true;
						}
					}
				}
			}
		}
		return false;

	}

}
	



