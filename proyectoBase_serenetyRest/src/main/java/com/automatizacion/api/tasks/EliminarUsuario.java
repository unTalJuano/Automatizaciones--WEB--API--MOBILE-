package com.automatizacion.api.tasks;

import com.automatizacion.api.endpoint.ObtenerEndpoint;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class EliminarUsuario  implements Task {

	int id;
    @Override

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Delete.from((ObtenerEndpoint.obtenerEndpoint("eliminar_usuario"+id)))
                .with(request -> request.header("Content-Type", "application/json")
                ));    
    }

    public static EliminarUsuario eliminar(int id) {
    	return Tasks.instrumented(EliminarUsuario.class);
    }
}
