package Utility;

import PageObjects.ForgetPwdPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		LoginPage obj = new LoginPage();//1--child class
		 
		// browser launch
		obj.browserLaunch();//Base Class
		Thread.sleep(1000);
		
		// forget password link click
		ForgetPwdPage fp = obj.forgetPwdLink();
		
		//forgetpage heading
		fp.displayHeading();
		
		
	   //Login Func
		HomePage hp = obj.loginWithInValidCred();//Login
		//logout func
		hp.logOut();
		
		
		
//		//login func
//		String username="Admin";
//		String locName="id";
//		String locVal = "txtUsername";
//		
//		String unameElm="id####txtUsername####Admin";
//		//obj.sendData(unameElm);
//		obj.sendData(locName,locVal,username);
//		
//		//pwd field
//		String password="admin123";
//		String plocName="NAME";
//		String plocVal = "txtPassword";
//		obj.sendData(plocName,plocVal,password);
//		
//		//clear fields
//		//elments size get
//		//element present or not
//		//drop down---Select class
//		//unameElm=id####txtUsername####Admin
	}

}
