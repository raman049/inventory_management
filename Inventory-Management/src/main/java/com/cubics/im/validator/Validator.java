package com.cubics.im.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validator {

	public boolean email(String email) {
		String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(email);
		return m.matches();
	}
	
	public boolean validName(String name) {
		String pattern = "^[a-zA-Z0-9\\s]{3,20}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(name);
		return m.matches();
	}
	
	public boolean validCode(String code) {
		String pattern = "[A-Z0-9]{4,4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(code);
		return m.matches();
	}

}
