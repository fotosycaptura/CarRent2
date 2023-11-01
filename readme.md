## CarRent 2

Aplicación que da respuesta a una tarea.

## ENUNCIADO DEL CASO

La empresa de arriendo de vehículos “Car-REnt” ha decidido implementar un sistema informático que permita mejorar la gestión de su empresa. Por lo tanto, el gerente lo ha contratado a usted para diseñar y programar una solución que administre y almacene la información asociada a sus automóviles, clientes, arriendos y devoluciones. El requisito fundamental es utilizar la programación orientada a objetos y sus buenas prácticas. La especificación de lo que el gerente requiere se detalla a continuación:

* Un vehículo se caracteriza por su patente (largo 8), marca, modelo, año fabricación (cualquier año desde el 2000 y año actual) y la condición del vehículo. Esta condición puede tomar uno de los siguientes datos: D, A o M, donde D es condición disponible, A es arrendado y M en mantención. Cuando un nuevo vehículo se ingrese al sistema, inicialmente toma la condición D (disponible) y el sistema además debe preocuparse que los valores de la patente, el modelo y marca se reciban con mayúscula.
* Un cliente se caracteriza por su cédula (largo 10 con penúltimo dígito un guion y último dígito valor entre 0 al 9 o una k), nombre y si está vigente o no (true: es vigente, false: no vigente). Cuando un nuevo cliente se ingresa al sistema, su vigencia inicial es true.
* Un arriendo, se caracteriza por un número de arriendo, el vehículo, el cliente que lo arrienda, la fecha de arriendo y el número de días arrendado (mayor que 1 y menor que 10). El monto del arriendo se obtiene a partir del precio que el usuario ingresa en el momento de ingresar el arriendo.

La devolución se caracteriza porque pertenece a un arriendo específico y su fecha de devolución. Esta fecha no puede ser menor a la fecha del arriendo.
* La funcionalidad requerida por el usuario es la siguiente. Usted debe asignar estos comportamientos a la clase que corresponda:
 a) Deshabilitar cliente: Esta operación la ejecuta el gerente del local cuando el estime conveniente y lo único que debe hacer es dejar no vigente al cliente para que no pueda arrendar.
 b) Asignar vehículo en mantención: Esta operación la ejecuta el gerente del local cuando lo estime conveniente y lo único que debe hacer es dejar la condición del vehículo en mantención. Esta condición no es posible asignarla si el vehículo se encuentra actualmente arrendado.
 c) Evaluar arriendo: operación que se ejecuta antes de guardar el arriendo al sistema y valida que el cliente del arriendo esté vigente y que el vehículo de este mismo arriendo tenga condición D (disponible). La función retorna un true (si está ok) o false (si no es posible arrendar).
 d) Ingresar arriendo: Este método evalúa los datos del arriendo instanciado (ejecutando la función c). Si la evaluación fue exitosa, actualiza automáticamente la condición del auto en A y retorna un true, en caso contrario, no guarda el arriendo retornando un false.
 e) Obtener monto a pagar: Este método calcula y entrega el monto del arriendo multiplicando el número de días por el precio diario. Este precio lo entrega el usuario una vez que se ingresa un arriendo al sistema.
 f) Generar ticket de arriendo: método que muestra la información del arriendo ingresado, respetando el formato del siguiente ejemplo. Para mostrar el monto a pagar se invoca al método definido en e).

 g) Ingresar devolución de un vehículo arrendado: este método valida de que todos los datos del vehículo devuelto correspondan a los ingresados en el arriendo respectivo. Si son correctos, esta función dejará el auto devuelto en condición D y retornará un true, en caso contrario, retornará un false.

* Además, se han solicitado otros requerimientos adicionales de programación para cautelar la correcta aplicación de la POO:
 a) Las validaciones de los atributos que se implementan en los mutadores, se deben programar usando métodos públicos en la clase respectiva. Estas validaciones se ejecutan en el momento de actualizar (setear) el objeto, por lo tanto, debe considerar, además, que los datos ingresados por el usuario (en el caso que corresponda) y que son ocupados para instanciar los objetos, podrán ser validados usando estos mismos métodos.
 b) Para que los objetos del sistema entreguen al usuario los diversos mensajes generados por el sistema, programar en cada clase un método que reciba el string con el mensaje y genere la salida. La idea es que los mensajes al usuario se concentren en un único método.

 * Para probar el funcionamiento del sistema, programe el método main en una clase de prueba con lo siguiente:
 a) Crear un cliente asignando los datos directamente (no use entrada por teclado) y pruebe que las validaciones implementadas en los mutadores están funcionando. Muestre el estado del cliente recién creado.
 b) Crear un automóvil asignando los datos directamente (no use entrada por teclado) y pruebe que las validaciones implementadas en los mutadores están funcionando. Muestre el estado del vehículo recién creado.
 c) Deshabilite al cliente creado y muestre su estado para validar sus datos.
 d) Asigne en mantención al vehículo creado y muestre su estado para validar sus datos.
 e) Pruebe el ingreso de un arriendo ejecutando la entrada de datos directa (sin teclado) por agregación o composición según corresponda. Use datos y/o objetos distintos a los que creó en a) y b). Ingrese dos arriendos: uno que se ingrese satisfactoriamente y otro que no. Para ambos casos muestre mensajes al usuario según corresponda. Para el ingreso del arriendo satisfactorio genere el ticket de arriendo. Muestre el estado del vehículo arrendado para ver si sus datos están correctos.
 f) Finalmente, ingrese dos devoluciones: una que se ingrese satisfactoriamente y otra no. Muestre mensajes al usuario según corresponda. Muestre el estado del vehículo devuelto para ver si sus datos están correctos.