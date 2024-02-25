# Taller indivual de Srping Boot
Para la realizacion del taller se utilizó como conetxto un hospital. En este hospital, hay médicos que tienen su propia oficina (relación uno a uno), poseen diversas especializaciones (relación uno a muchos) y atienden a varios pacientes, mientras que estos últimos son atendidos por varios médicos (relación muchos a muchos).

## Instrucciones de Uso
Para la ejecución adecuada de los endpoints, es necesario seguir ciertas pautas y consideraciones. A continuación, se detallan los pasos necesarios para trabajar con el sistema:

## Orden de Generación de Registros
Es crucial seguir el orden correcto al agregar registros al sistema. A continuación se presenta el orden recomendado:

**1. Pacientes y Médicos:** Se pueden agregar pacientes y médicos en cualquier orden. Sin embargo, es importante tener en cuenta que si se crean primero los pacientes, se debe establecer la relación de muchos a muchos entre médicos y pacientes:

 - Si se crean primero los pacientes, se puede establecer la relación de muchos a muchos entre médicos y pacientes al momento de crear un médico. Es necesario rellenar el arreglo de pacientes durante la creación del médico.
 - Si se crean primero los médicos, la relación de muchos a muchos se puede establecer actualizando el médico mediante el método PUT. Deberá rellenar el arreglo de pacientes para establecer esta relación.
Especializaciones y Oficinas:

**2. Especializaciones:** Se pueden crear especializaciones después de haber registrado un médico, ya que se requiere el ID del médico para asociarle especializaciones. Esta relación es de uno a muchos, lo que significa que un médico puede tener varias especializaciones.

**3. Oficinas:** Se permite crear una única oficina por cada médico, ya que la relación es de uno a uno entre médicos y oficinas.

### Autor
Luis Enrique Jr. Pinto Fuentes - 2020100243
