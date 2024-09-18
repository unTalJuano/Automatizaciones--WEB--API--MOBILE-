package co.com.retoAutomatizacion.modelo;

public class InformacionPaginaPrincipal {
	
	 private final String titulo;

	    public InformacionPaginaPrincipal(String titulo) {
	        this.titulo = titulo;
	    }

	    @Override
	    public String toString() {
	        return String.format("{title='%s'}", titulo);
	    }

}
