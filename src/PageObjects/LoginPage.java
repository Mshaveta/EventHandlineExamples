package PageObjects;

import java.io.IOException;

import Utility.BasePage;

public class LoginPage extends BasePage {
	HomePage hp;
	public LoginPage() throws IOException {
		super();
	}
 
	
	
	public HomePage loginWithInValidCred() throws IOException {
		/*username field*/
		String userNameElm= prop.getProperty("userNameElm"); 
		String pwdElm= prop.getProperty("passElm");
		String loginBtnElm= prop.getProperty("loginBtnElm");
		
		sendData(userNameElm);//id###txtUsername###Admin
		sendData(pwdElm);
		clickElement(loginBtnElm);
		
		hp = new HomePage();
		return hp;
		
	}
	
	public ForgetPwdPage forgetPwdLink() throws IOException   {
		String forgetPwdElm= prop.getProperty("forgetPwdElm");
		clickElement(forgetPwdElm);
		return new ForgetPwdPage();
	}
 

 

	 

 

}
