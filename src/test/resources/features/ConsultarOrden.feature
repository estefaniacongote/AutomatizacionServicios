#author: Estefania Congote Grajales
#language: es

Característica: Consulta de orden

  Yo como estefaniade apirest de tipo get
  Quiero realizar consumos a un servicio
  Para  consultar una orden

  Antecedentes:
    Dado "estefania" obtiene la baseurl de la api

  @Successful
  Escenario: Obtener(get) los datos de una orden
    Cuando configura la peticion a disparar
    Entonces valida estado de la orden