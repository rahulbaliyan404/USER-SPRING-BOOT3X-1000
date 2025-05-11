package com.home.controller;

import java.util.Base64;

public class JavaDemo {

	public static void main(String[] args) {
		String password = "1";
		String encodePassword = Base64.getEncoder().encodeToString(password.getBytes());
		System.out.println("Encode  ::: "+encodePassword);
		try {
			byte[] bytesPassword = Base64.getDecoder().decode(encodePassword);
			String passwordStr = new String(bytesPassword, "UTF-8");
			System.out.println("Decoded ::: " + passwordStr);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
