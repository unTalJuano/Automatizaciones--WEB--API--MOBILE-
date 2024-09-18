package com.proyecto.pageobject.definitions;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.proyecto.pageObject.steps.LoginSteps;
import com.proyecto.pageObject.steps.PaginaPrincipalSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;


public class ManejoClientesStepsDefinitions {
	
	private String usuario;
    private String pass;
    private String url;
    @Managed
    WebDriver driver;
    
    @Steps
    LoginSteps login;
    @Steps
    PaginaPrincipalSteps paginaSteps;

    @Before
    public void configuracionInicial() {
        Properties properties = new Properties();
        try {
            FileInputStream configStream = new FileInputStream("serenity.properties");
            properties.load(configStream);
            configStream.close(); // Asegurarse de cerrar el stream
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer usuario, contraseña y URL del archivo de configuración
        usuario = properties.getProperty("usuario");
        pass = properties.getProperty("password");
        url = properties.getProperty("url");
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        // Navegar a la URL especificada en el archivo de configuración
        driver.get(url);
        driver.manage().window().maximize();
        ngWebDriver.waitForAngularRequestsToFinish();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12)); // 12 segundos de espera
        WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        wait.until(ExpectedConditions.visibilityOf(userField));
    }

   @After

    public void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
	
	@Given("el usuario inicia sesion con las credenciales configuradas")
	public void el_usuario_inicia_sesion_con_las_credenciales_configuradas() {
	    login.iniciarSesion(usuario, pass);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 10 segundos de espera
        WebElement icono = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[src*='data:image']")));
        wait.until(ExpectedConditions.visibilityOf(icono));
	}

	@Given("el usuario verifica que inicio sesion correctamente")
	public void el_usuario_verifica_que_inicio_sesion_correctamente() {
	    // Realizar la aserción para asegurarse de que el inicio de sesión fue correcto
		boolean ingresoExitoso = paginaSteps.verificarIngreso();
	    assertTrue("El usuario no pudo iniciar sesión correctamente.", ingresoExitoso);
	}
	
	@When("el usuario ingresa a la opcion para crear un cliente")
	public void el_usuario_ingresa_a_la_opcion_para_crear_un_cliente(){
		driver.get("https://qastaging.siigo.com/#/third-party/350?Customer=true");
	}

}
