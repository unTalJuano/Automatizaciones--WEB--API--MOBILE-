#Author: your.email@your.domain.com
@e2e
Feature: Prueba E2E para gestion de usuarios

  
  @CrearUsuario
  Scenario: Permite crear un usuario
    Given el usuario inicia sesion con las credenciales configuradas
    And el usuario verifica que inicio sesion correctamente
    When el usuario ingresa a la opcion para crear un cliente