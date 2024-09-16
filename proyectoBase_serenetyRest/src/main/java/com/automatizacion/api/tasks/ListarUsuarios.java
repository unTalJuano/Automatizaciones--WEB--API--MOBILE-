package com.automatizacion.api.tasks;

import com.automatizacion.api.endpoint.ObtenerEndpoint;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ListarUsuarios  implements Task {

    @Override

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Get.resource(ObtenerEndpoint.obtenerEndpoint("listar_usuario"))
                .with(request -> request.header("Content-Type", "application/json")
                        .relaxedHTTPSValidation("TLS"))
                );
        

    }

    public static ListarUsuarios listar() {
    	return Tasks.instrumented(ListarUsuarios.class);
    }
}
