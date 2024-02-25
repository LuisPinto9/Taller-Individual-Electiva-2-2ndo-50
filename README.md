## Instrucciones de Ejecución de la API REST

Para la ejecución adecuada de los endpoints, es necesario seguir el siguiente orden de generación de registros:

1. **Agregar pacientes o médicos:** Dependiendo de qué entidad se haya creado primero, se pueden agregar pacientes o médicos a la base de datos.

2. **Asignar pacientes al médico:** Utilizando el método PUT, se deben asignar los pacientes correspondientes a cada médico. Esta asignación es crucial para el correcto funcionamiento de la aplicación.

3. **Crear especializaciones y oficinas:** Una vez que los médicos estén registrados y tengan sus pacientes asignados, se pueden crear especializaciones y oficinas para añadirlas a los médicos registrados.

Es importante tener en cuenta que solo se puede crear una oficina por cada médico, ya que existe una relación de uno a uno entre ellos.
