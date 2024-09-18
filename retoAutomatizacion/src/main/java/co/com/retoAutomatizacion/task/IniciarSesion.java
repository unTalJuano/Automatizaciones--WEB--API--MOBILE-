package co.com.retoAutomatizacion.task;


import co.com.retoAutomatizacion.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesion implements Task{

	private final String username;
    private final String password;

    public IniciarSesion(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static IniciarSesion withCredentials(String username, String password) {
        return instrumented(IniciarSesion.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
        		Click.on(LoginPage.USUARIO),
                Enter.theValue(username).into(LoginPage.USUARIO),
                Click.on(LoginPage.CONTRASEÑA),
                Enter.theValue(password).into(LoginPage.CONTRASEÑA),
                Click.on(LoginPage.BOTON_INGRESAR)
        );
    }

}
