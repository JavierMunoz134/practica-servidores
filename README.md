# practica-servidores
 
Aplicación 1:
El cliente envía una petición al servidor (“time”) y espera a que el servidor le envíe un mensaje con una cadena de texto con la hora.
El servidor está en un bucle a la espera de peticiones. Cada vez que recibe un mensaje con el contenido “time”, devuelve la hora actual en formato texto: “23:55”.

Aplicación 2:
El cliente lee por consola texto del usuario (podría ser de cualquier tamaño). Y envía el texto al servidor. Para enviarlo el cliente hace lo siguiente:
- Escribe primero un carácter de delimitación de mensaje #.
- Después el texto codificado en base64.
- Después escribe un último carácter # para delimitar el mensaje.