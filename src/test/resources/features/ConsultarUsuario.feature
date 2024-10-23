#author: Estefania Congote Grajales
#language: es

Característica: Consulta de usuario

  Yo como estefaniade apirest de tipo get
  Quiero realizar consumos a un servicio
  Para  consultar usuario

  Antecedentes:
    Dado "estefania" obtiene la baseurl de la api

  @Successful
  Escenario: Obtener(get) los datos del usuario
    Cuando configura la peticion a consumir
    Entonces valida estado de la peticion