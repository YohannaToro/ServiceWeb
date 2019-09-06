
# Calculadora desviaciòn estandar y media
Es una programa que se encarga de calcular la desviacion estandar y la media de un cojunto de numeros reales. 
Adicional a esto se usa como estructura de datos una Linked List para almacenar los datos y usaremos Spark framework la cual nos permite el desarrollo de aplicaciones web.
Una linked list tiene comunmente dos componentes que son:
* lista cabeceras
* lista nodos
![enter image description here](https://lh3.googleusercontent.com/KYit6g8u3yn18HBMOmpCNcBz4W1vuxpyL2zaARLeQ1oP8P3FvjGrVLJVEvLOVTLrqeljY-brWks)

Operaciones que tiene y complejidades:


![enter image description here](https://lh3.googleusercontent.com/9t2Nvez_WibFOXO53eRPDKCTmNs3SLhDPSK2X0dkxYp7s97azAw0FRbxfL2u0asK6IEORLU78G8)
## Definiciòn y formulas:
**Media**: es obtener el promedio de un cojunto de datos 

**Desviación estándar**:es una medida de la propagación o dispersión de un conjunto de datos.


![enter image description here](https://lh3.googleusercontent.com/xtXwfC4G6t-pe8tMi8WYozD8LtUlxoioX8Zl32d4VI-Ji_BzXTMHa-kxaCp7v5mYTabVuo-FWLE)


## Diseño

![enter image description here](https://lh3.googleusercontent.com/npRotIXFjAJ66LYLfo7dbI9ncrqkrkhLNXWF9rJBXj-U0049TJ-5jHxgF9mU_XHtvsGWNr9wLyc)
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

Descargar dependencias

```
mvn package
```
Compilar proyecto

```
mvn compile
```
instalar dependencias

```
mvn clean install
```
Compilar proyecto

```
mvn clean install
```
Ejecutar proyecto
```
Heroku local web
```
Url
```
localhost:5000/inputdata
```
### Heroku
```
https://morning-cove-97366.herokuapp.com/inputdata
```
### Ejecutar pruebas y aplicaciòn

Ejecutra pruebas
```
mvn test
```
Ejecutar aplicaciòn

```
java -cp target\calculator-1.0-SNAPSHOT.jar edu.escuelaing.arep.Calculator
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


