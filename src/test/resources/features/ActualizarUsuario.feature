#author: Estefania Congote Grajales
#language: es

Característica: Actualizar usuario PUT

  Yo como estefania
  Quiero realizar consumos a un servicio
  Para actualizar datos

  Antecedentes:
    Dado "estefania" obtiene la baseurl de la api

  @Successful
  Escenario: Actualiza(put) los datos de un usuario
    Cuando configura la peticion
    Entonces valida los datos consultados fueron actualizados