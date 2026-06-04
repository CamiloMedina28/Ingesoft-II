# Prueba técnica e-commerce simplificado con checkout 📈💰📊

## Nombre del estudiante
- Camilo Andrés Medina Sánchez
- 🏫 Universidad Nacional De Colombia 🏫
- 💻Ingeniería de sistemas y computación💻

## Fecha de entrega
`2026-06-`

## Manual de usuario para el frontend

## Manual de usuario para el backend

## Documentación técnica para el frontend

### Stack tecnológico utilizado

Para el desarrollo del frontend se va a desarrollar una interfaz gráfica de usuario en la web haciendo uso de: 
- Vuejs: Para la lógica en frontend.
- Axios: Para los llamados a la API de backend.
- Tailwind: Para los estilos predefinidos y reducir el código css a escribir.

## Documentación técnica para el backend

### Stack tecnológico utilizado

Para el desarrollo del backend se va a desarrollar una API Rest haciendo uso de: 
- Java 21
- Spring boot
- JWT
- mysql

Es ampliamente sabido que en el desarrollo de backends es bastante usual el uso de ORM's para disminuir el código necesario de interacción con base de datos. No obstante, para este proyecto no se incluirá el gestor Jakarta/JPA con el fin de practicar un poco el proceso de estructuración y manejo de bases de datos. 
A su vez, siendo Java un lenguaje orientado a objetos, es necesario al momento de crear clases las definiciones de:
- Constructores
- Destructores en algunos casos
- Clases con el patrón de diseño Builder
- Setters
- Getters

Springboot y java pueden trabajar con la libreria Lombok para evitar toda esta escritura de código. Sin embargo, porla misma razón indicada anteriormente, no se hará uso de esta ayuda.

### Estructura de archivos

En esta sección se presenta la estructura de archivos, la cual permitirá tener de forma ordenada y estructurada los scripts necesarios.
En cada una de las secciones particulares se va a describir la funcionalidad y la importancia de cada uno de estos.

└── 📁 src/
    ├── 📁 config/
    │   ├── 📄 CorsConfig.java
    │   └── 📄 SecurityConfig.java
    ├── 📁 controller/
    │   ├── 📄 AuthController.java
    │   ├── 📄 CartController.java
    │   ├── 📄 OrderController.java
    │   └── 📄 ProductController.java
    ├── 📁 dao/
    │   ├── 📄 CartDAO.java
    │   ├── 📄 OrderDAO.java
    │   ├── 📄 ProductDAO.java
    │   ├── 📄 UserDAO.java
    │   └── 📁 impl/
    │       ├── 📄 CartDAOImpl.java
    │       ├── 📄 OrderDAOImpl.java
    │       ├── 📄 ProductDAOImpl.java
    │       └── 📄 UserDAOImpl.java
    ├── 📁 dto/
    │   ├── 📁 request/
    │   │   ├── 📄 AddToCartDTO.java
    │   │   ├── 📄 CheckoutDTO.java
    │   │   ├── 📄 LoginRequestDTO.java
    │   │   ├── 📄 ProductCreateDTO.java
    │   │   ├── 📄 ProductUpdateDTO.java
    │   │   └── 📄 RegisterRequestDTO.java
    │   └── 📁 response/
    │       ├── 📄 ApiResponseDTO.java
    │       ├── 📄 AuthResponseDTO.java
    │       ├── 📄 CartResponseDTO.java
    │       ├── 📄 OrderResponseDTO.java
    │       └── 📄 ProductResponseDTO.java
    ├── 📄 EcommerceApiApplication.java
    ├── 📁 entity/
    │   ├── 📄 Cart.java
    │   ├── 📄 CartItem.java
    │   ├── 📄 Order.java
    │   ├── 📄 OrderItem.java
    │   ├── 📄 Product.java
    │   └── 📄 User.java
    ├── 📁 exception/
    │   ├── 📄 GlobalExceptionHandler.java
    │   ├── 📄 ResourceNotFoundException.java
    │   ├── 📄 StockException.java
    │   └── 📄 UnauthorizedException.java
    ├── 📁 mapper/
    │   ├── 📄 CartMapper.java
    │   ├── 📄 OrderMapper.java
    │   └── 📄 ProductMapper.java
    ├── 📁 security/
    │   ├── 📄 CustomUserDetailsService.java
    │   ├── 📄 JwtFilter.java
    │   └── 📄 JwtService.java
    ├── 📁 service/
    │   ├── 📄 AuthService.java
    │   ├── 📄 CartService.java
    │   ├── 📄 OrderService.java
    │   └── 📄 ProductService.java
    └── 📁 util/
        ├── 📄 Constants.java
        └── 📄 PasswordUtil.java



## Desarrollo de pruebas unitarias (opcional)