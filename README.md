# Practica de automatizaciones

En este repositorio puede encontrar un compilado de algunos de las proyectos realizados como practicas de automatización de pruebas

Automatización web

Se realizó el flujo para crear un nuevo clientede la pagina https://qastaging.siigo.com

Automatización API

Se realizó la automatización de los request GET, POST, PUT, DELETE para la API https://reqres.in/

Automatización para dispositivos moviles

Se realizó la automatización de las operaciones básicas para la calculadora (Android 9)


### Pre-requisitos 📋

- Se debe contar con un IDE instalado (Eclipse)
- Maven
- APPIUM
- Emulador de android
- JDK
- NPM


## Ejecutando las pruebas ⚙️

Para ejecutar la automatización web se debe realizar mediante el siguiente script 
mvn verify -Dcucumber.options="--tags @test" -Durl=https://www.demoblaze.com/index.html -Dcategoria=Laptops

Tanto para la automatización de la API como la de dispositivos moviles, se puede ejecutar desde el runner o mediante el comando mvn verify

## Autores ✒️


* **Juan David Ocampo** 
