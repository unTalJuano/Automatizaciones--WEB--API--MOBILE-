package co.com.retoAutomatizacion.questions;

import co.com.retoAutomatizacion.modelo.InformacionPaginaPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class PaginaPrincipal implements Question<String>{
	
   

	public String answeredBy(Actor actor) {
        // Obtiene el título de la página del navegador
        String titulo = BrowseTheWeb.as(actor).getTitle();
        System.out.println("Título de la página: " + titulo);
        return titulo;
    }
    
    // Método estático para crear una instancia de la Question
    public static PaginaPrincipal title(){
        return new PaginaPrincipal();
    }

}
