package com.automation.api.exceptions;

public class UserAsertions extends AssertionError {


	public static final String DATOS_DE_USUARIOS_NO_SON_CORRECTOS = "Los datos del usuario no son correctos";
	public static final String STATUS_CODE_NO_ES_CORRECTO = "El codigo de respuesta no es correcto";
	public static final String CANTIDAD_DIFERENTE = "La cantidad de usuarios no es correcta";

    public UserAsertions(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }

}