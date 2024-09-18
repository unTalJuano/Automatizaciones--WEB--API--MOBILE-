package co.com.retoAutomatizacion.stepsdefinitons;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.com.retoAutomatizacion.task.IniciarSesion;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class GestionUsuarioStepsDefinition {

    private String usuario;
    private String pass;
    private String url;
    WebDriver driver;

    @Before
    public void configuracionInicial() {
        // Inicializamos el "escenario" (stage) para los actores de Screenplay
        setTheStage(new OnlineCast());
        Properties properties = new Properties();
        try {
            FileInputStream configStream = new FileInputStream("config.properties");
            properties.load(configStream);
            configStream.close(); // Asegurarse de cerrar el stream
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer usuario, contraseña y URL del archivo de configuración
        usuario = properties.getProperty("usuario");
        pass = properties.getProperty("password");
        url = properties.getProperty("url");

        // Configuración de ChromeDriver
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        // Navegar a la URL especificada en el archivo de configuración
        driver.get(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); // 40 segundos de espera
        WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        wait.until(ExpectedConditions.visibilityOf(userField));
        theActorCalled(usuario);
    }

   @After
    public void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("el usuario inicia sesion con las credenciales configuradas")
    public void el_usuario_inicia_sesion_con_las_credenciales_configuradas() {
        theActorInTheSpotlight()
            .attemptsTo(IniciarSesion.withCredentials(usuario, pass));
    }

    @Given("el usuario verifica que inicio sesion correctamente")
    public void el_usuario_verifica_que_inicio_sesion_correctamente() {
       // theActorInTheSpotlight()
         //   .should(seeThat(PaginaPrincipal.title(), equalTo("My account"))); // Asegúrate de comparar con el título correcto
    }
}
