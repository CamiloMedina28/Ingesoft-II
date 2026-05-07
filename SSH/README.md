# Taller SSH✨👩‍🎤

## Nombre del estudiante
- Camilo Andrés Medina Sánchez
- 🏫 Universidad Nacional De Colombia 🏫
- 💻Ingeniería de sistemas y computación💻

## Fecha de entrega
`2026-05-06`

### NodeJS

NodeJS es un entorno de ejecución de javascript que permite a los desarrolladores la ejecución de código javascript por fuera del navegador,principalmente en el servidor.
Como primera medida en este taller se debe verificar la existencia de la instalación de NODEJS en nuestra máquina, para ello ejecutamos en la terminal de powershell el comando.
```powershell
node --version
```
![Verificación de la versión de Node](./media/1.nodeversion.png)

Como se puede evidenciar en la imagen, existe en la maquina una versión de Node activa, razón por la cual es posible continuar con el desarrollo de la práctica.

### Ejecución del servidor

Para continuar se debe ejecutar el servidor de NodeJS, código que ya ha sido previamente implementado, para esto, se debe ubicar dentro del directorio en donde se encuentra el script del server y ejecutar el comando 
```powershell
node server.js
```
![Ejecución del servidor Node](./media/2.ejecucionservernode.png)

Como se ve en la imagen, se cambia al directorio en donde se encuentran los archivos del servidor y se ejecuta el comando previamente indicado. 

```javascript
server.listen(3000, () => {
  console.log('Servidor corriendo en http://localhost:3000');
  console.log('Endpoints disponibles:');
  console.log('  POST /auth/register');
  console.log('  POST /auth/login');
  console.log('  GET  /tasks          (requiere token)');
  console.log('  POST /tasks          (requiere token)');
  console.log('  PUT  /tasks/:id      (requiere token)');
  console.log('  DELETE /tasks/:id    (requiere token)');
});
```
En las ultimas líneas del script del servidor se indica que se debe sacar por consola la siguiente información de los endpoints que hay disponibles.
Esto se puede confirmar desde la consola luego de ejecutar el script.

### Ejecución de comandos desde otra terminal

#### Register

```powershell
Invoke-RestMethod -Method POST -Uri http://localhost:3000/auth/register -ContentType "application/json" -Body 	'{"username":"ana","email":"ana@test.com","password":"1234"}'

```
Como se puede ver en la solicitud que se está presentando, se busca hacer una solicitud HTTP de tipo Post, en la url localhost en el puerto 3000 (Siendo este en donde se ejecuta el servidor de NodeJS) y se pasa en formato .json los valores de: 
- Nombre de usuario
- Correo electrónico
- 

El código en server para este endpoint es el siguiente
```javascript
// POST /auth/register
if (method === 'POST' && url === '/auth/register') {
    const { username, email, password } = await readBody(req);

    if (!username || !email || !password)
      return send(res, 400, { error: 'Todos los campos son requeridos' });

    const existe = db.users.find(u => u.email === email);
    if (existe)
      return send(res, 409, { error: 'El email ya esta registrado' });

    const user = {
      id: Date.now().toString(),
      username,
      email,
      password
    };
    db.users.push(user);
    return send(res, 201, { message: 'Usuario creado', userId: user.id });
}
```
Como se ve acá, este endpoint tiene que ser tipo post y se establece la url `/auth/register`.
Se indican los parametros que deben ser enviados (Mencionados más arriba), se desarrollan validaciones de si el correo electrónico ya está en la base de datos o si los valores enviados no son suficientes.
Finalmente, se agrega el usuario a la base de datos (que no es una bdd real, solo un objeto que persiste de manera temporal en memoria). Además, la llave primaria de estos registros de usuarios hace referencia a un timestamp convertido en cadena de caracteres.
Si todo el proceso se desarrolla de manera exitosa, se devuelve un código de estado 201. A continuación, se indica con registro fotográfico todo el proceso desarrollado.

![POST register](./media/3.solicitudpostregister.png)

Como se puede ver en la imagen, se desarrolla desde otra consola de powershell la solicitud y se muestra un mensaje del lado del usuario en donde se confirma la creación del usuario.
Ahora bien, permitamonos volver a enviar la solicitud, teniendo en cuenta que el usuario ya existe, para ver el comportamiento del sistema.

![Post Error](./media/4.posterror.png)
En la imagen se muestra el surgimiento de un error por la ya existencia de los datos de usuario ingresados en la "base de datos".

### Propuestas de mejora y retroalimentación

- Login del lado del servidor.