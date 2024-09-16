#language: es
Característica: Verificar el CRUD de usuarios desde API
  como usuario deseo validar la funcionalidad del servicio de la API
  Para garantizar que el flujo funciona correctamente

  @CrearUsuario
  Esquema del escenario: Validar la respuesta del servicio para crear usuarios
    Cuando el usuario envia la petición para crear el usuario con los datos:
      | name  | job       |
      | Pedro | Ingeniero |
    Entonces el deberia ver que la respuesta es un codigo <codigo> con el nombre <nombre>

    Ejemplos: 
      | codigo | nombre |
      |    201 | Pedro  |

  @ActualizarUsuario
  Esquema del escenario: Validar la respuesta del servicio para actualizar usuarios
    Dado el usuario desea consumir el servicio single user con el id 1 para verificar que existe
    Cuando el usuario envia la petición para actualizar el usuario 1 con los datos:
      | name    | job       |
      | Juanito | Ingeniero |
    Entonces el usuario deberia ver que la respuesta es un codigo 200
    Y el usuario verifica que los datos de <nombre> y <trabajo> son correctos

    Ejemplos: 
      | nombre  | trabajo   |
      | Juanito | Ingeniero |

  @ListarUsuarios
  Esquema del escenario: Validar la respuesta del servicio para listar los usuarios
    Cuando el usuario envia la petición para listar los usuarios
    Entonces el usuario deberia ver que la respuesta es un codigo 200
    Y el usuario deberia ver que la cantidad es 6

  @EliminarUsuario
  Esquema del escenario: Validar la respuesta del servicio para eliminar usuarios
    Cuando el usuario envia la peticion para eliminar el usuario con id 2
    Entonces el usuario deberia ver que la respuesta es un codigo 204
