package com.fundoo.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GenerateOtp")
public class GenerateOTP {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="otpPassword")
	private String otpPassword;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtpPassword() {
		return otpPassword;
	}
	public void setOtpPassword(String password) {
		this.otpPassword = password;
	}
}

