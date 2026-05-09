# Taller Patrones de diseño de software ✨👩‍🎤

## Nombre del estudiante
- Camilo Andrés Medina Sánchez
- 🏫 Universidad Nacional De Colombia 🏫
- 💻Ingeniería de sistemas y computación💻

## Fecha de entrega
`2026-05-09`

### Patrones de diseño creacionales

Estos patrones buscan facilitala creación de objetos predefiniendo su lógica y encapsulandola, con el fin de hacer el sistema más flexible y desacoplado. 
Un ejemplo muy general, podria ser en un restaurante cuando se pide un plato y no se conoce el proceso de trás de la **creación del plato** solo se conoce el resultado.

#### Patrón de diseño singleton

El patrón de diseño singleton busca la creación de una clase global y una sola instancia de ella proponienco un punto de acceso global para que esta pueda ser utilizada, este patrón de diseño puede estar muy estrechamente relacionado con el proceso de inyección de dependencias y por tanto, tendrá una relación muy fuerte con el principio de dependency inversion (DIP) de solid.
En esta sección se mostrará la implementación del patrón singleton y a su vez como este puede ser relacionado con el quinto principio solid. 

Un ejemplo de la vida real del patrón singleton es el gobierno de un país, teniendo en cuenta que solo puede existir un gobierno.

Usualmente, este patrón es ampliamente utilizado para definir parámetros de configuración que se deben compartir durante todo el flujo de ejecución, por ejemplo, una conexión a base de datos. Para este ejemplo particular, se va a programar un sistema de logs basado en una lista.

[Clase principal singleton.](./singleton/LoggerSingleton.java)


Notese la arquitectura o diseño inicial de la clase singleton, el constructor está privado. Por tanto, no se pueden hacer llamados a la creación de objetos por fuera de la misma clase. Es decir, esto está prohibido: 
```java
LoggerSingleton log1 = new LoggerSingleton();
LoggerSingleton log2 = new LoggerSingleton();
```
Además que se crea una variable instance dentro de la clase singleton la cual es estática, es decir, se comparte en todas las instancias de la clase (A pesar de que solo se tendrá una).
```java
public static synchronized LoggerSingleton getInstance() {
    if (instance == null) {
        instance = new LoggerSingleton();
    }
    return instance;
}
```
Por otro lado, tengase en cuenta la funcion getInstance, esta es una función crucial.
En primera medida, notese que es una función synchronized, esto teniendo en cuenta que si se hace multithreading en java, mientras se está en un hilo puede ser que la instancia no exista y al pasar a otro se cree la instancia y regresando se cree de nuevo. Resultando con dos instancias (A pesar de que suena confuso).

![Singleton multithreading issues](./media/singletonmultithreading.png)

La imagen describe la situación presentada. 
Comenzando en el segundo hilo se ve que singleton está en null.
Se cambia al hilo 1 y se ve que singleton está en null, entonces, se instancia la clase.
Se cambia de nuevo al hilo 2 y como singleton estaba en null se instancia.
Resultado del proceso, hay dos instancias de la clase singleton.

En terminos generales, la función getInstance, verifica si existe una instancia de la clase, si no hay, la crea. Por el contrario, si ya existe la devuelve. 

La recopilación de estas medidas permiten lo siguiente: 
```java
LoggerSingleton log1 = new LoggerSingleton();
LoggerSingleton log2 = new LoggerSingleton();
System.out.println(log1 == log2); // true
```
Notese que solo es posible la creación de una instancia de clase.

Ahora bien, a continuación se muestra el diagrama UML de como queda la implemenatación que se plantea en esta práctica.
A grosso modo, se pretende generar una clase singleton que maneje los logs dentro de todo el sistema.

![UMLSIngletonImplementation](./media/UMLSingleton.jpg)

Las clases de serivicio de creación de usuarios, productos y ordenes usan la clase singleton Logger. 
Notese que se desarrolla una inyección de dependencias pues los constructores de estas tres clases de servicio reciben como parámetro una instancia de la clase singleton.

#### Patrón de diseño builder

El patrón de diseño builder permite simplificar la creación de objetos complejos.
Por ejemplo, el proceso de creación de una factura puede llegar a tener los siguientes campos hipotéticos.
- número
- cliente
- fecha
- subtotal
- impuestos
- descuento
- observaciones
- método de pago
Teniendo en cuenta esto, el constructor de esta clase se vería de esta forma: 
```java
class Factura{
    public Factura(
        int numero,
        String cliente,
        String fecha,
        int subtotal,
        int impuestos,
        int descuento,
        String observaciones,
        String metodo_pago
    ){
        // ...
    }
}
```
Esto termina siendo un proceso muy tedioso y el constructor se ve muy lleno, este es el principal problema que es resuelto con el patrón builder.

Ahora bien, ¿Cómo se ve la clase luego de aplicar el patrón de diseño?

[Visualización de la clase factura aplicando el método builder](./builder/Factura.java)

Como se ve en el hipervinculo indicado acá arriba. El constructor recibe una instancia de builder.
Se declaran todos los atributos de Factura como atributos privados y se indica en el constructor que estos dependen de builder.
Ahora bien, la clase Builder es una clase que está dentro de la misma clase Factura, esto no es estrictamente necesario, pero suele desarrollarse así porque el builder solo pertenece a esa clase.

el builder tiene una colección tan grande de setters como de atributos de la clase base.


### Combinación del patrón singleton con el patrón

### Uso de patrón creacional, estructural y de comportamiento


### Referencias
- https://refactoring.guru/es/design-patterns/singleton
- https://www.arquitecturajava.com/ejemplo-de-java-singleton-patrones-classloaders/?pdf=5435
- https://lapalejandro.wordpress.com/wp-content/uploads/2010/02/patrones-de-diseno-singleton1.pdf
- https://www.ionos.com/es-us/digitalguide/paginas-web/desarrollo-web/patron-de-diseno-builder/
- https://devexpert.io/blog/builder-patrones-diseno
- https://refactoring.guru/es/design-patterns/builder
