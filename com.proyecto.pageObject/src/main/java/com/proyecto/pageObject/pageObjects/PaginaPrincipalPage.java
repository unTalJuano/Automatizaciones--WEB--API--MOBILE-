package com.proyecto.pageObject.pageObjects;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;

public class PaginaPrincipalPage extends PageObject {
	

	public boolean verificarIngreso() {
	    return $(By.cssSelector("img[src*='data:image']")).isVisible();
	}

	
	public void ingresarOpcionClientes() {
		$(By.xpath("//siigo-button-atom//div[contains(@class, 'btn-element size-m')]")).click();
	}

}
