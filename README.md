# Sistema-gestor-de-papeleria (Analisis y diseño de sistemas)

# StarShop (Ingieneria de Software)


### Modulos

- ([Login](#login)) 
- ([Paginas principales](#paginas-principales))
- ([Administrador](#administrador))
  - ([Administrador Consulta ventas](#Consulta-ventas))
  - ([Administrador usuarios](#Administrar-usuarios))
  - ([Administrador proveedores y almacenes](#Proveedores-Almacen))
- ([Empleado](#empleado))
  - ([Realiza pedido](#Realiza-pedido))
  - ([Realiza venta](#Realiza-venta))

Proyecto analisis y diseño de sistemas e ingenieria de software. Este proyecto consiste en la gestion de productos de una papeleria, manejandolos por almacenes, gestion en usuarios y proveedores. Se planteo la posibilidad de poder registrar y realizar una venta y gestionar pedidos.

Este proyecto se inicio en la clase de analisis y diseño de sistemas (año 2018) en el cual se empezo con el manejo de de documentacion, conceptos de arquitectura, diagramas, etc. Y a la par se realizaba la construcción del sistema con un modelo en cascada. Se presentaron alrededor de 16 casos de uso de los cuales solo se entregaron 4 para esta primera parte de entrega del proyecto.

Posteriormente se le dio continuacion a este proyecto en la clase de Ingenieria de software (año 2020) se siguio con el desarrollo del sistema, siguiendo las practicas de las metodologias agiles como lo es Scrum. Al retomar el proyecto y haciendo un analisis se propusieron 16 historias de usuarios para completar el sistema, el cual se concluyeron 13.

La documentacion y el analisis de casa spring se encuentra en el sigueinte [LINK](https://drive.google.com/open?id=1febzrcD0SFJEr1yOwJBGQYimcWO65FbT)

El lenguaje que se utilizo fue java 8, el entorno de desarrollo fue ecliupse y la base de datos fue y la base de datos fue Derby, cabe recalcar que por el tiempo no se implemento una buena base dae datos

## LOGIN

1) El epmpleado o administrador del negocio podra comprobar sus creedenciales y dependiendo de su funcion en la papeleria se mostrara una ventana principal mostrando las funciones que podra realizar con el sistema.

2) Para poder ingresar tendra que poner su nombre de usuario y contraseña

- ![Imagen Login](https://i.ibb.co/tKCF90x/Login.jpg)

___

## PAGINAS PRINCIPALES

Dependiendo de los permisos que se tengan al momento de registrarse, se mostrara una pagina principal para un administrador y un empleado, el cual cada uno podra hacer tareas especificas

1. Ventana administrador  

![Imagen ventana administrador](https://i.ibb.co/kg6rWQG/VAdmin.jpg)

2. Ventana empleado  
  
![Imagen ventana empleado](https://i.ibb.co/FxRrM2H/VEmple.jpg)

___

## Administrador

### Consulta ventas

El administrador puede ver las ventas totales que se han realizado durante el transcurso del dia con respectiva informacion

![Imagen ventana empleado](https://i.ibb.co/9N0kptd/Consulta-Venta.jpg)


### Administrar usuarios

El administrador puede eliminar, modificar o agregar un nuevo usuario para acceder al sistema y base a este poder hacer ciertas acciones y tareas

![Imagen ventana crud usuario](https://i.ibb.co/MsHsGYY/Crud-Usuario.jpg)

Cada uasuario tendra que tener la siguiente informacion obligatoria:

![Imagen ventana añadir usuario](https://i.ibb.co/W3qTxQh/A-adir-Usuario.jpg)

Cuando un nuevo usuario quiera entrar al sistema, este temdra que acceder con su nombre de usuario y contraseña

### Proveedores-Almacen

En esta seccion el administrador podra gestionar los produtctos y administrar la informacion de sus poroveedores que les llega a surtir ciertos productos 

![Imagen ventana empleado](https://i.ibb.co/8NYzLsR/Proveedor-Almacen.jpg)

#### Proveedores 

Esta seccion es similar a la de usuarios; Se almacena la informacion de los prveedores en la base de datos para tener un catalogo de ellos y asi tener a la mano su informacion en caso de necesitar de ellos. De igual manera el administrador puede agregar, modificad o eliminar un proveedor Cada proveedor cuenta con la siguiente informacion:

![Imagen ventana registra proveedores](https://i.ibb.co/hs1yRrd/Registrar-Prov.jpg)


### Almacenes

En esta parte del sistema, el administrador podra agregar, modificar y eliminar productos de la papeleria. Estos productos estan divididos por difetrentes tipos de almacenes (Stock) ya que para el administrador le es importante separar los productos y administrarlos por importancia en fechas de dias festivos y un almacen general de productos de papeleria.

![Imagen ventana almacenes](https://i.ibb.co/jRL09kZ/Almacenes.jpg)

___

## Empleado

### Realiza venta
En esta parte del sistema el empleado puede registrar una venta concluida con exito, primero se tendra que agregar un producto, lo que hace es buscarte todos los productos y el empleado tendra que seleccionar  el producto que estara registrado en la venta, posteriormente tendra que ingresar la cantidad de este producto y tendra que dar clic en agregar, esto se hara las veces que dese y automaticamente se calculara el total de la venta, tambien se podra aplicar un descuento si asi se decea sobre la venta total. Cuando el empleado haya concluido, tendra que dar clic en el boton "Liquidar venta" para finalizarla y registrarla en la base de datos

![Imagen ventana realiza venta](https://i.ibb.co/nC9nv33/Realiza-Venta.jpg)

### Realiza pedido

En esta parte del sistema es similar al de realiza venta, con la caracteristica de que la venta no es inmediata, si no que se registra un pedido, pusiendo esta ser eliminada o modificada hasta que el cliente acabe de pagar el pedido

  ![Imagen ventana crud pedido](https://i.ibb.co/r4bF8Lr/Crud-Pedido.jpg)

Las caracteristicas que debe de tener un pedido son las siguientes:

  ![Imagen ventana pedido](https://i.ibb.co/xJZPz9V/Ventana-Pedido.jpg)


  gracias