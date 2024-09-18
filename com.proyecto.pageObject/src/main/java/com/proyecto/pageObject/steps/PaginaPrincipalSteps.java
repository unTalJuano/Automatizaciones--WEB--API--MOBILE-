package com.proyecto.pageObject.steps;

import com.proyecto.pageObject.pageObjects.PaginaPrincipalPage;

import net.serenitybdd.annotations.Step;

public class PaginaPrincipalSteps {
	
	PaginaPrincipalPage paginaPrincipalPage;
	
	@Step
	public boolean verificarIngreso() {
		return paginaPrincipalPage.verificarIngreso();
	}

}
