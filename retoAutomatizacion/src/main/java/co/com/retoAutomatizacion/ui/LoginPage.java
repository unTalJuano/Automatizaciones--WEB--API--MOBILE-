package co.com.retoAutomatizacion.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
	

    public static final Target USUARIO = Target.the("nombre_usuario")
            .located(By.name("username-input"));

    public static final Target CONTRASEÑA = Target.the("contraseña")
            .located(By.name("password-input"));
    
    public static final Target BOTON_INGRESAR = Target.the("boton_ingresar")
            .located(By.id("login-submit"));

}
