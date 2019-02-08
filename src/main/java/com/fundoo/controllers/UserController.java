package com.fundoo.controllers;

import javax.servlet.http.HttpServletResponse;


import com.fundoo.models.Response;
import com.fundoo.models.User;

import javax.servlet.http.HttpServletRequest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo.models.GenerateOtp;

import com.fundoo.services.UserService;




@RestController
//@CrossOrigin(origins = { "http://localhost:4200" }, exposedHeaders = { "jwtTokenxxx" })
@RequestMapping("user/api")
public class UserController {
	
	User tempUser, forgetUser;
	Response response;
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping(method=RequestMethod.POST, consumes = {"application/json"} )
//	public String save(@RequestBody UserDTO userDTO) {
//		userService.save(userDTO);
//		return userDTO.toString();
//		
//	}

	
	
	
	
	
	/*public UserController() 
	{
		
	}
	public UserController(IUserService userService)
	{
		this.userService=userService;
	}
	*/
	
	@RequestMapping("/")
	public String welcome()
	{
		return "welcome";
	}
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST )
	public ResponseEntity<Response> userLogin(@RequestBody User user,HttpServletResponse httpResponse)
	{
		System.out.println(user);
		String token=userService.userLogin(user);
		response=new Response();
		
		if(token.equals("not valid"))
		{
			response.setStatusCode(404);
			response.setStatus("user is not valid");
			return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
		}
		response.setStatusCode(166);
		response.setStatus("login successfully");
		httpResponse.addHeader("jwtTokenxxx", token);
		System.out.println("response="+response);
		System.out.println(token);
		
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/sendOtp", method=RequestMethod.POST)
	public ResponseEntity<Response> sendOtp(@RequestBody User user,HttpServletRequest request)
	{
		System.out.println("aman");
		tempUser=new User();
		tempUser=user;
		System.out.println(user+"         ");
		boolean check=userService.sendOtpCall(user);

		response=new Response();
		
		if(check)
		{
				response.setStatusCode(200);
				response.setStatus("otp send successfull");
				return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
	//	System.out.println("hihi");
		response.setStatusCode(0);
		response.setStatus("Account already exist");
		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
	}
	
	
	
	@RequestMapping(value="/otpVerify", method=RequestMethod.POST)
	public ResponseEntity<Response> veifyOtp(@RequestBody GenerateOtp userOtp)
	{
	//	System.out.println(userOtp.getEmail()+" "+userOtp.getOtpPassword());
		System.out.println(userOtp.getOtpPassword());
		
		boolean check=userService.verifyOtp(userOtp);
		response=new Response();
		if(check)
		{
			
			response.setStatusCode(200);
			response.setStatus("otp is match");
			
			registerUser(forgetUser);
		
			
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
		response.setStatus("otp is wrong");
		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ResponseEntity<Response> registerUser(@RequestBody User tempUser )
	{
	
		System.out.println(tempUser);
		boolean check=userService.addUser(tempUser);
		
		response=new Response();
		if(check)
		{
			response.setStatusCode(200);
			response.setStatus("register successfull");
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
		response.setStatus("register unsuccessfull");
		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
	}
	
	
	
	@RequestMapping("/updateUser/{id}")
	public ResponseEntity<Response> updateUser(@RequestBody User user,@PathVariable Integer id)
	{
		boolean check=userService.updateUser(user,id);
		response=new Response();
		if(check)
		{
			response.setStatus("updated successfully");
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
		response.setStatus("id is not valid");
		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
		
	}
	
	
	@RequestMapping("/deleteUser/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable Integer id)
	{
		boolean check=userService.deleteUser(id);
		response=new Response();
		if(check)
		{
			response.setStatus("delete successfully");
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
		response.setStatus("user is not found");
		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
	}
	
	
	
	@RequestMapping(value="/forgetPassword", method=RequestMethod.POST)
	public ResponseEntity<Response > forgetPassword(@RequestBody User user)
	{
		forgetUser=new User();
		forgetUser=user;
		boolean check=userService.forgetPassword(user);
		response=new Response();
		if(check)
		{
			response.setStatusCode(200);
			response.setStatus("otp send successfully");
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
		response.setStatusCode(404);
		response.setStatus("email id is not valid");
		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
				
	}
	

	@RequestMapping(value="/forgetOtpVerification", method=RequestMethod.POST)
	public ResponseEntity<Response> forgetOtpVerify(@RequestBody GenerateOtp generateOtp)
	{
		boolean check=userService.forgetVerification(generateOtp,forgetUser);
		response=new Response();
		if(check)
		{
			response.setStatusCode(200);
			response.setStatus("reset successfully");
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
		response.setStatusCode(404);
		response.setStatus("otp is wrong");
		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
}	
	

			
