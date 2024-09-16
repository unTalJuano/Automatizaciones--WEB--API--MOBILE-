package com.automatizacion.api.tasks;

import com.automatizacion.api.endpoint.ObtenerEndpoint;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ServicioBuscarUsuario implements Task{
	
	Integer id;

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Get.resource(ObtenerEndpoint.obtenerEndpoint("buscar_usuarios"+id))
                .with(request -> request
                .header("Content-Type", "application/json")
				.relaxedHTTPSValidation("TLS")));
		

	}
	
	 public static ServicioBuscarUsuario llamarServicio() {
	    	return Tasks.instrumented(ServicioBuscarUsuario.class);
	    }
	    
	   public ServicioBuscarUsuario buscar(Integer id) 
	    {
	    	this.id=id;
	    	return this;
	    }

}
