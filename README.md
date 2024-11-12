##Descripción

Este es un proyecto backend desarrollado en Spring Boot que permite la publicación y el consumo de mensajes a través de JMS (Java Message Service). Los mensajes se procesan y almacenan en una base de datos usando Java Persistence API (JPA).

##Características

####Publicación de mensajes en una cola JMS.

####Consumo de mensajes desde una cola JMS.
####Persistencia de datos en una base de datos relacional utilizando JPA e Hibernate.
####API REST para enviar y consultar mensajes procesados.
#####Arquitectura hexagonal y de fácil escalabilidad.

##Tecnologías
####Spring Boot - Marco de desarrollo principal.
####Spring JMS - Para la publicación y consumo de mensajes.
####JPA (Java Persistence API) - Para el acceso y la gestión de datos en la base de datos.
####H2 - Base de datos en memoria.
####ActiveMQ - Proveedor de JMS.
####Spring Data JPA - Simplifica el acceso a los datos.

##Requisitos Previos
####Java 17 o superior.
####Gradle para la gestión de dependencias.
####ActiveMQ o cualquier otro proveedor de mensajería compatible con JMS.

##Configuración del Proyecto
####Configuración de la Base de Datos. configura la conexión a la base de datos en el archivo application.properties
##Configuración de ActiveMQ
####También debes configurar el proveedor de mensajes JMS en el archivo application.properties

##Ejecución del Proyecto
Instala y configura ActiveMQ o el proveedor de mensajes que prefieras (por defecto, se espera que ActiveMQ esté en localhost:61616).

Crea la base de datos especificada en el archivo de configuración y asegúrate de que las credenciales de acceso sean correctas.
Clona el proyecto y abrelo con tu IDE de preferencia para su posterior ejecucion.

##Estructura del proyecto
####Controller: Contiene los controladores REST para manejar las solicitudes HTTP.
####UseCases: Contiene la lógica de negocio para el manejo de los mensajes y la interacción con la base de datos.
####Repository: Interfaces de JPA para el acceso a la base de datos.
####Listener: Configura y maneja los mensajes entrantes desde la cola JMS.
####Config: Contiene la configuración de JMS y de los casos de uso.



