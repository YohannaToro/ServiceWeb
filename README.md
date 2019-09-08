# PATRON CLIENTE SERVIDOR.

1. Escriba un programa en el cual usted cree un objeto URL e imprima en
pantalla cada uno de los datos que retornan los 8 m´etodos de la secci´on anterior.

2. Escriba una aplicaci´on browser que pregunte una direcci´on URL al usuario
y que lea datos de esa direcci´on y que los almacene en un archivo con el nombre
resultado.html.
Luego intente ver este archivo en el navegad
3. Escriba un servidor que reciba un n´umero y responda el cuadrado de este numero.
4. Escriba un servidor web que soporte m´ultiples solicitudes seguidas (no concurrentes). El servidor debe retornar todos los archivos solicitados, incluyendo paginas html e imagenes.
5.Utilizando Datagramas escriba un programa que se conecte a un servidor que responde la hora actual en el servidor. El programa debe actualizar la hora cada 5 segundos seg´un los datos del servidor. Si una hora no es recibida debe mantener la hora que tenıa. Para la prueba se apagara el servidor y despu´es de unos segundos se reactivar´a. El cliente debe seguir funcionando y actualizarse
cuando el servidor este nuevamente funcionando.


### Pre-requisitos

Es necesario tener instalado:


```
*  Maven 3.6 en caso de no tener istalado maven siga el siguiente tutorial dependiendo del sistema operativo que posea https://maven.apache.org/install.html
* Java 1.8 si no tiene instalado java en su dispositivo siga el sigueinte tutorial https://java.com/en/download/help/download_options.xml
* Git tutorial: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
```

## Instalaciòn y ejecucion del proyecto

### De forma local
Descargue el repositorio lo puede realizar de dos formas descargando el .zip o usando git 

En caso de usar git la linea de comando para clonar el repositiorio es:

```
git clone https://github.com/YohannaToro/lab3-.git
```
Abrir terminal y dirigirse a la siguiente carpeta:

```
cd Lab3-
```

Descargar dependencias

```
mvn compile
```


### Ejecutar pruebas y aplicaciòn

Ejecutra pruebas
```
mvn test
```


## Built With
* [Maven](https://maven.apache.org/) - Dependency Management


## Autor

* **Yohanna Toro**  - [YohannaToro](https://github.com/YohannaToro)


## Licencia

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
