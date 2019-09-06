
# Servidor Web (tipo Apache)

Servidor web (tipo Apache) que recibe multiples solicitudes no concurentes, con capacidad de responder paginas html e imagenes tipo Html, adicionala a esto debe proveer un framework IoC para contruir aplicaciones web a partir de POJOS.


### Pre-requisitos

Es necesario tener instalado:


```
*  Maven 3.6 en caso de no tener istalado maven siga el siguiente tutorial dependiendo del sistema operativo que posea https://maven.apache.org/install.html
* Java 1.8 si no tiene instalado java en su dispositivo siga el sigueinte tutorial https://java.com/en/download/help/download_options.xml
* Git tutorial: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
* Heroku 
* Spark 
```

## Instalaciòn y ejecucion del proyecto

### De forma local
Descargue el repositorio lo puede realizar de dos formas descargando el .zip o usando git 

En caso de usar git la linea de comando para clonar el repositiorio es:

```
git clone https://github.com/YohannaToro/Calculator
```
Abrir terminal y dirigirse a la siguiente carpeta:

```
cd ServicioApache
```

Descargar dependencias

```
mvn package
```

Ejecutar aplicaciòn

```
java -cp target/classes:target/dependency/* edu.escuelaing.arem.project.app.Controlador
```
Ejecutar heroku de forma local

```
Heroku local web
```
Ejecutar proyecto
```
Heroku local web
```

### Despliegue en  Heroku

[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://yohanna-framework.herokuapp.com/apps/test)

### Ejecutar pruebas y aplicaciòn

Ejecutra pruebas
```
mvn test
```




### Casos de prueba

![enter image description here](https://lh3.googleusercontent.com/YgF6pFc5Fg6PORbBR6IfjoPx42GVKv9XPC35nauSoUTDsT75vJ8fKWnmZofsIYjvGXKvRorOZVI)


Algunos de los casos probados fueron estos dos devido probamos un grupo de numeros reales tanto enteros como complejos y con las formulas ya mencioandas obtenemos la desviaciòn estandar y la media


### Codigo de pruebas

Para realizar las prubas se probaron dos funciones la desviacion estandar y la media:
en cada una de ellas ejecutamos la aplicacion de un grupo de datos y se realiza la correspondiente comparaciòn entre el valor esperado y el que se obtiene para saber si es correcto o incorrecto


## Built With
* [Maven](https://maven.apache.org/) - Dependency Management


## Autor

* **Yohanna Toro**  - [YohannaToro](https://github.com/YohannaToro)


## Licencia

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details


