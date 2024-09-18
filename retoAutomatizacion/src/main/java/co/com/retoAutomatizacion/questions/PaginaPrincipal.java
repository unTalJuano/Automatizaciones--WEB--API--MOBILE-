package co.com.retoAutomatizacion.questions;

import co.com.retoAutomatizacion.modelo.InformacionPaginaPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class PaginaPrincipal implements Question<String>{
	
   

	public String answeredBy(Actor actor) {
        // Obtiene el t�tulo de la p�gina del navegador
        String titulo = BrowseTheWeb.as(actor).getTitle();
        System.out.println("T�tulo de la p�gina: " + titulo);
        return titulo;
    }
    
    // M�todo est�tico para crear una instancia de la Question
    public static PaginaPrincipal title(){
        return new PaginaPrincipal();
    }

}
