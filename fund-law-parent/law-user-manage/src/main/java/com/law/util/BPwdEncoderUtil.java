package com.law.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BPwdEncoderUtil {
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public static String BCryptPassword(String password) {
		return encoder.encode(password);
	}
	
	
	public static boolean matches(CharSequence rawPassword,String password) {
		return encoder.matches(rawPassword, password);
	}
}
