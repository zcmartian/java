
package service;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import domain.Test;


public class LoginService implements LoginFace
{
	private Test t;

	public void setT(Test t) {
		this.t = t;
	}

	public Test combine(String username, String password) {
		// TODO Auto-generated method stub
		t.setUsername(username);
		t.setPassword(password);
		return t;
		
	}


}