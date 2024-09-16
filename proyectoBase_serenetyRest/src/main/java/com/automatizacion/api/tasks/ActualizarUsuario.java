package com.automatizacion.api.tasks;



import java.util.Map;

import static com.automation.api.exceptions.UserAsertions.DATOS_DE_USUARIOS_NO_SON_CORRECTOS;
import com.automatizacion.api.endpoint.ObtenerEndpoint;
import com.automatizacion.api.utils.ConstruirCuerpo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.IsEqual.equalTo;

public class ActualizarUsuario implements Task{
	
	private Map<String,String> datos;
	private Integer id;

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		String actualizarUsuario = ConstruirCuerpo.conLaPlantilla("src\\test\\resources\\templates\\Usuarios.json")
                .yLosValores(datos);
		actor.attemptsTo(Put.to(ObtenerEndpoint.obtenerEndpoint("buscar_usuarios")+id)
				.with(request -> request
				.header("Content-Type", "application/json")
				.body(actualizarUsuario)
				.relaxedHTTPSValidation("TLS")));
	}

	public static ActualizarUsuario actualizar() {
    	return Tasks.instrumented(ActualizarUsuario.class);
    }
	
	public ActualizarUsuario conLosDatos(Integer id,Map<String, String> datos){
		this.id=id;
		this.datos=datos;
		return this;
    }

}
