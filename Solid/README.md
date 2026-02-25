# Taller Principios SOLID ✨👩‍🎤

## Nombre del estudiante
- Camilo Andrés Medina Sánchez
- 🏫 Universidad Nacional De Colombia 🏫
- 💻Ingeniería de sistemas y computación💻

## Fecha de entrega
`2026-02-25`

### Historia y beneficios de los principios SOLID.



### Single responsability principle (**S**RP)

En términos generales, se define que el principio de la responsabilidad única indica que

> A class should have one and only one reason to change, meaning that a class should have only one job.

o en español, 

> Una clase debe tener una y solo una razón para cambiar, lo que quiere decir que, una clase sólo debe tener una tarea o trabajo.

![Imagen alusiva al principio SRP](./media/SRP.png)

En la imagen, se indica lo que **NO** debe hacerse en programación. Al indicar que, a pesar de tener la capacidad de hacer las cosas no es necesario hacerlas todas.

Ahora bien, para ver la implementación desde el lenguaje de programación, vease la siguiente definición de la clase, esta es una abreviación, para ver el código completo dirigase [acá.](./SRP/WrongImplementation/Factura.Java)
```java
class Factura{
    private double[] productos;

    public Factura(double[] productos){
        // ...
    }

    public double calcularTotal(){
        // ...
    }

    public void guardarEnBaseDeDatos(){
        // ...
    }

    public void enviarCorreo() {
        // ...
    }
}

```

En esta clase Factura se ven la definición de varios métodos
- Método constructor
- Método para el cálculo del total
- Método para el guardado en la base de datos
- Método para el envío de notificaciones por correo electrónico

Es decir, la clase factura tiene multiples responsabilidades. Ahora bien, se muestra una implementación de la clase factura de forma correcta.

```java
class Factura {

    private double[] productos;

    public Factura(double[] productos) {
        // ...
    }

    public double calcularTotal() {
        // ...
    }
}
```
El segmento de código mostrado anteriormente muestra una implementación correcta de la clase Factura, en donde se define un constructor que recibe un arreglo con los productos y una función que calcula el total del valor. El código completo de la implementación se encuentra [acá.](./SRP/CorrectImplementation/Factura.java)
```java
class FacturaRepository {
    public Connection conectar(){
        // ...
    }

    public void close(Coneection conexion) throws SQLException{
        // ...
    }

    public void guardar(Factura factura) {
        // ...
    }
}
```
El segmento de código anterior indica el proceso de persistencia en la base de datos, el código completo se encuentra [acá.](./SRP/CorrectImplementation/FacturaRepository.java)
```java
class EmailService {

    public void enviarFactura(Factura factura) {
        // ...
    }
}
```
El bloque de código previo indica el proceso de envío de facturas haciendo uso de un servicio de correo electrónico, el código completo referenciado se encuentra [acá.](./SRP/CorrectImplementation/EmailService.java)
```java
public class Main {
    public static void main(String[] args) {

        Factura factura = new Factura(new double[]{100, 200, 300});

        FacturaRepository repository = new FacturaRepository();
        EmailService emailService = new EmailService();

        double total = factura.calcularTotal();
        System.out.println("Total: " + total);

        repository.guardar(factura);
        emailService.enviarFactura(factura);
    }
}
```
Finalmente, el método principal que permite el desarrollo de las funcionalidades asociadas al desarrollo de la factura.

De esta forma se puede ver como se segmenta una clase que tenia muchas tareas en cuatro clases distintas en donde cada una tiene una tarea puntual. A continuación se listan las ventajas que existen cuando una división apropiada de responsabilidades 

- **Mayor mantenibilidad**: El código es más fácil de entender, los cambios son más localizados y se reduce el riesgo de romper otras funcionalidades al desarrollar cambios.
- **Mejor testeo**: Como las clases son más pequeñas y enfocadas, son más fáciles de probar con pruebas unitarias más fáciles.
- **Código más limpio y organizado**: El sistema está estructurado por responsabilidades, de modo que se tiene una cohesión y un orden apropiado.



### Open Closed principle (**O**CP)

En términos generales, se define que el principio de la responsabilidad única indica que

> A module should be opened for extension but closed for modification

o en español, 

> Un módulo debe estar abierto para extensión pero cerrado para modificación.

![Open-closed principle](./media/OCP.png)

La imagen anterior permite ver como hay una interfaz que define los métodos que pueden existir y que hay tres clases que *implementan* la interfaz, siendo estas:
- Drawer (Cajón)
- Door (Puerta)
- Refrigerator (Refrigerador)

Notese que en la notación UML (Unified Modeling language) se establece que la interfaz no se hereda. En cambio, una interfaz debe ser implementada.
Ahora bien, una interfaz se puede entender como un contrato, ya que: 
1. Establece "Derechos y obligaciones":
Todos los métodos de una interfaz deben ser implementados, para el caso particular de la imagen, las clases Drawer, Door y Refrigerator no van a poder ser compiladas hasta que todos los métodos sean implementados. 
2. Separa el qué del cómo
En estos casos, se indica que el objeto biens ea una puerta un cajón o un refrigerador deben poderse abrir, cerrar y verificar si la puerta está abierta o cerrada, la interfaz indica la obligación de esto. No obstante, no indica la forma en que estas acciones deben ser desarrolladas. 
3. Generación de estándares
Las interfaces permiten generar acuerdos de estandarización con el fin de mantener ciertos principios o estándares en el sistema. 

Ahora bien, una nota importante acerca de un atributo que comparte cada una de las clases que son implementadas a partir de la interfaz. Notese, que todas estas tienen un atributo privado de tipo de dato booleano, que indica si la puerta está abierta o cerrada. Además, como en la definición uml está definido con un '-'. Entonces, ese atributo es privado y no se puede acceder a el haciendo uso de la notación estándar punto(.) y debe ser accedido por medio de un getter.

Notese también que el principio OCP es también una puerta de acceso al desarrollo del polimorfismo, uno de los pilares fundamentales de la programación orientada a objetos.

Para continuar, se debe analizar 


### Liskov substitution principle (**L**SP)
### Interface Segregation principle (**I**SP)
### Dependency inversion principle (**D**IP)

### Referencias
- https://corecppil.github.io/Meetups/2020-05-26_CoreCpp_Worldwide!/The_SOLID_Principles.pdf
- https://ivanderevianko.com/wp-content/uploads/2013/10/Agile-Principles-Patterns-and-Practices-in-C.pdf : Chapter 8 - Chapter 12
- https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design#single-responsibility-principle
- https://www.geeksforgeeks.org/system-design/solid-principle-in-programming-understand-with-real-life-examples/