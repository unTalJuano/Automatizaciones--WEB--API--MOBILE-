package com.automatizacion.api.stepdefinitions;


import static com.automation.api.exceptions.UserAsertions.DATOS_DE_USUARIOS_NO_SON_CORRECTOS;
import static com.automation.api.exceptions.UserAsertions.STATUS_CODE_NO_ES_CORRECTO;
import static com.automation.api.exceptions.UserAsertions.CANTIDAD_DIFERENTE;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;
import java.util.Map;

import com.automation.api.exceptions.UserAsertions;
import com.automatizacion.api.tasks.ActualizarUsuario;
import com.automatizacion.api.tasks.CrearUsuario;
import com.automatizacion.api.tasks.EliminarUsuario;
import com.automatizacion.api.tasks.ListarUsuarios;
import com.automatizacion.api.tasks.ServicioBuscarUsuario;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class ManejarUsuariosStepDefinitions {

    private EnvironmentVariables envVars;

    @Before
    public void preparacionDelEscenario() throws IllegalAccessException{
    	String baseUrl = envVars.optionalProperty("restapi.baseurl").orElseThrow(IllegalAccessException::new);
        setTheStage(new OnlineCast());
        SerenityRest.setDefaultParser(Parser.JSON);
        theActorCalled("El usuario").whoCan(CallAnApi.at(baseUrl));
    }
    
    @Cuando("el usuario envia la petición para listar los usuarios")
    public void elUsuarioEnviaLaPeticionParaListarUsuarios() {
    	theActorInTheSpotlight().attemptsTo(ListarUsuarios.listar());
    }
    
    @Entonces("el usuario deberia ver que la cantidad es (.*)")
    public void verificarCantidadDeUsuarios(int cant) {
    	 theActorInTheSpotlight().should(
    			 seeThatResponse("La cantidad de usuarios es correcta",
                         response -> response
                                 .body("per_page", equalTo(cant)))
                         .orComplainWith(UserAsertions.class, CANTIDAD_DIFERENTE)
         );
    }
    
    @Cuando("el usuario envia la petición para crear el usuario con los datos:")
    public void elUsuarioEnviaLaPeticiónParaCrearElUsuarioConLosDatos(List<Map<String ,String>> datos) {
        theActorInTheSpotlight().attemptsTo(CrearUsuario.crear().conLosDatos(datos.get(0)));
    }

    @Entonces("el deberia ver que la respuesta es un codigo (.*) con el nombre (.*)")
    public void elDeberiaVerQueLaRespuestaEsUnCodigoConElNombre(Integer codigo, String nombre) {
    	theActorInTheSpotlight().should(seeThatResponse(lastresponse -> lastresponse.statusCode(codigo)
                .body("name", comparesEqualTo(nombre))));
    }
    
    @Dado("el usuario desea consumir el servicio single user con el id (.*) para verificar que existe")
    public void elUsuarioDeseaConsumirElServicioSingleUserConElIdParaVerificarQueExiste(Integer id) {
    	theActorInTheSpotlight().attemptsTo(ServicioBuscarUsuario.llamarServicio().buscar(id));
    }

    @Cuando("el usuario envia la petición para actualizar el usuario (.*) con los datos:")
    public void elUsuarioEnviaLaPeticiónParaActualizarElUsuarioConLosDatos(Integer id,List<Map<String ,String>> datos) {
    	theActorInTheSpotlight().attemptsTo(ActualizarUsuario.actualizar().conLosDatos(id,datos.get(0)));
    }
    
    @Entonces("el usuario verifica que los datos de (.*) y (.*) son correctos")
    public void elUsuarioVerificaQueLosDatosDeYSonCorrectos(String nombre, String trabajo) {
    	 theActorInTheSpotlight().should(
                 seeThatResponse("Los datos del usuario son correctos",
                         response -> response
                                 .body("name", equalTo(nombre))
                                 .body("job", equalTo(trabajo)))
                         .orComplainWith(UserAsertions.class, DATOS_DE_USUARIOS_NO_SON_CORRECTOS)
         );
    }
    
    @Cuando("el usuario envia la peticion para eliminar el usuario con id (.*)")
    public void elUsuarioEnviaLaPeticiónParaEliminar(int id) {
    	theActorInTheSpotlight().attemptsTo(EliminarUsuario.eliminar(id));
    }
    
    @Entonces("el usuario deberia ver que la respuesta es un codigo (.*)")
    public void verificarStatusCodeCorrecto(int status) {
        theActorInTheSpotlight().should(
                seeThatResponse("Status code should be correct",
                        response -> response.statusCode(status))
                        .orComplainWith(UserAsertions.class, STATUS_CODE_NO_ES_CORRECTO)
        );
    }
    
}