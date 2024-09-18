package com.proyecto.pageObject.steps;

import com.proyecto.pageObject.pageObjects.LoginPage;

import net.serenitybdd.annotations.Step;

public class LoginSteps {
	
	LoginPage loginPage;
	
	@Step
	public void iniciarSesion(String usuario, String pass) 
	{
		loginPage.ingresarCredenciales(usuario, pass);
		loginPage.clickearBoton();
	}

}
