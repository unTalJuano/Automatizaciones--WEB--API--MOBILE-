package com.proyecto.pageObject.pageObjects;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject{

		
	public void ingresarCredenciales(String usuario,String pass) 
	{
		$(By.name("username-input")).click();
		$(By.name("username-input")).sendKeys(usuario);
		$(By.name("password-input")).click();
        $(By.name("password-input")).sendKeys(pass);
	}
	
	public void clickearBoton() 
	{
		$(By.id("login-submit")).click();;
	}

}
