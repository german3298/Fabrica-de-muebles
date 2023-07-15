/**
 * Clase que controla el flujo de control del sistema, y permite ir haciendo las elecciones del usuario. 
 * También inicializa y almacena los objetos de los gestores, que gestionan casi todas las tareas del programa.
 * Los métodos de esta clase son todos privados por encapsulación, ya que solo se usan en esta misma clase.
 * 
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class ControlFabrica
{
    GestorEmpleados gestorEmpleados;
    GestorClientes gestorClientes;
    GestorMuebles gestorMuebles;
    GestorPersonal gestorPersonal;
    GestorPedidos gestorPedidos;
    Menu menu;
    Analizador analizador;
    
    public static final int MAXIMO_PIEZAS_FABRICA = 100;
    public int piezasActuales;

    /**
     * Construye un objeto de esta clase, y crea los atributos necesarios, e inicia el número de piezas de la fábrica al máximo posible
     */
    public ControlFabrica()
    {
        analizador = new Analizador();
        gestorEmpleados = new GestorEmpleados();
        gestorClientes = new GestorClientes();
        gestorMuebles = new GestorMuebles(analizador);
        gestorPersonal = new GestorPersonal (gestorEmpleados, gestorClientes, analizador);
        gestorPedidos = new GestorPedidos(gestorMuebles, gestorClientes, gestorEmpleados);
        menu = new Menu();

        piezasActuales = MAXIMO_PIEZAS_FABRICA;
        
        empezar();
    }
    
    /**
     * Empieza el programa, se elije opción en el menú principal
     */
    private void empezar(){
        menu.mostrarMenuInicial();
        int eleccion = analizador.leerOpcion(3);

        switch (eleccion){
            case 0:
                gestionarPersonal();
            break;
            case 1:
                entrarSistema();
            break;
            case 2:
                salir();
            break;
        }
    }

    /**
     * Vuelve al menú principal
     */
    private void volverMenuPrincipal() {
        System.out.println("Volviendo al menú principal.");
        empezar();
    }

    /**
     * Permite elegir dentro del menú de gestión del personal
     */
    private void gestionarPersonal() {
        menu.mostrarMenuGestionDelPersonal();
        int eleccion = analizador.leerOpcion(3);
        switch (eleccion){
            case 0:
                darDeAlta();
            break;
            case 1:
                darDeBaja();
            break;
            case 2:
                modificarDatosPersona();
            break;
        }
    }

    /**
     * Permite elegir el tipo de persona a la que vas a dar de alta
     */
    private void darDeAlta() {
        menu.mostrarMenuDarAlta();
        int eleccion = analizador.leerOpcion(2);

        switch (eleccion){
            case 0:
                darDeAltaEmpleado();
            break;
            case 1:
                darDeAltaCliente();
            break;
        }
    }
    
    /**
     * Permite elegir el tipo de empleado a dar de alta y lo crea, luego vuelve al menú principal
     */
    private void darDeAltaEmpleado() {
        menu.mostrarMenuDarAltaEmpleado();
        int eleccion = analizador.leerOpcion(4);
        TipoPersona tipoNuevaPersona = null;
        switch (eleccion){
            case 0:
                tipoNuevaPersona = TipoPersona.JEFE;//Jefe
            break;
            case 1:
                tipoNuevaPersona = TipoPersona.COMERCIAL;//Comercial
            break;
            case 2:
                tipoNuevaPersona = TipoPersona.ARTESANO_EN_PLANTILLA;//Artesano en plantilla
            break;
            case 3:
                tipoNuevaPersona = TipoPersona.ARTESANO_POR_HORAS;//Artesano por horas
            break;
        }
        gestorPersonal.crearPersona(tipoNuevaPersona);      //Crear persona leyendo los datos
        volverMenuPrincipal();
    }

    /**
     * Permite elegir el tipo de cliente a dar de alta y lo crea, luego vuelve al menú principal
     */
    private void darDeAltaCliente() {
        menu.mostrarMenuDarAltaCliente();
        int eleccion = analizador.leerOpcion(2);
        TipoPersona tipoNuevaPersona = null;
        switch (eleccion){
            case 0:
                tipoNuevaPersona = TipoPersona.CLIENTE_EMPRESA;//Empresa
            break;
            case 1:
                tipoNuevaPersona = TipoPersona.CLIENTE_PARTICULAR;//Particular
            break;
        }
        gestorPersonal.crearPersona(tipoNuevaPersona);
        volverMenuPrincipal();
    }
    
    /**
     * Permite dar de baja una persona del sistema, primero iniciando sesión con esa persona y luego la da de baja, luego vuelve al menú principal. 
     * Si falla el inicio de sesión (por introducir ID no existente), vuelve al menú principal directamente
     */
    private void darDeBaja() {
        String ID = analizador.leerCadenaTexto("Introducir ID de persona del sistema para darla de baja: ");
        if (gestorPersonal.iniciarSesion(ID)) {             //establece la persona conectada
            gestorPersonal.darDeBajaPersonaConectada();     //da de baja la persona conectada
            System.out.println("Persona dada de baja correctamente.");
        }
        volverMenuPrincipal();
    }
    
    /**
     * Permite modificar algunos datos de una persona del sistema, primero iniciando sesión con esa persona y luego modificandolo, luego vuelve al menú principal.
     * Si falla el inicio de sesión (por introducir ID no existente), vuelve al menú principal directamente
     */
    private void modificarDatosPersona() {
        String ID = analizador.leerCadenaTexto("Introducir ID de persona del sistema para modificarla: ");
        if (gestorPersonal.iniciarSesion(ID)) {             //establece la persona conectada
            gestorPersonal.setPersonasConectadas();         //establece el cliente, empleado o artesano conectados
            gestorPersonal.modificarPersonaConectada();     //modifica la persona conectada
            System.out.println("Persona modificada correctamente.");
        }
        volverMenuPrincipal();
    }

    /**
     * Permite entrar en el sistema, primero iniciando sesión con esa persona, y según el tipo de persona conectada, abre su menú correspondiente.
     * Si falla el inicio de sesión (por introducir ID no existente), vuelve al menú principal directamente
     */
    private void entrarSistema() {
        String ID = analizador.leerCadenaTexto("Introducir ID para entrar en el sistema: ");
        if (gestorPersonal.iniciarSesion(ID)) {                                         //establece la persona conectada
            gestorPersonal.menuBienvenida();                                            //saca menú de bienvenida, al entrar en el sistema
            gestorPersonal.setPersonasConectadas();                                     //establece el cliente, empleado o artesano conectados
            TipoPersona tipoPersona = gestorPersonal.tipoPersonaConectada();            //Recibe el tipo de persona que tiene la persona conectada
            switch (tipoPersona){
                case JEFE:
                    opcionesJefeEnSistema();                //Menú de jefes
                break;
                case COMERCIAL:
                    opcionesComercialEnSistema();           //Menú de comerciales
                break;
                case ARTESANO_EN_PLANTILLA:
                case ARTESANO_POR_HORAS:
                    opcionesArtesanoEnSistema();            //Menú de artesanos
                break;
                case CLIENTE_PARTICULAR:
                case CLIENTE_EMPRESA:
                    opcionesClienteEnSistema();             //Menú de clientes
                break;
            }
        } else {
            volverMenuPrincipal();
        }
    }

    /**
     * Permite elegir las opciones del jefe, siendo la última cerrar sesión
     */
    private void opcionesJefeEnSistema () {
        menu.mostrarMenuJefe();
        int eleccion = analizador.leerOpcion(3);
        
        switch (eleccion){
            case 0:
                asignarPedidoArtesano();
            break;
            case 1:
                listarPedidosEnProceso();
            break;
            case 2:
                cerrarSesion();
            break;
        }
    }
   
    /**
     * Permite asignar un pedido a un artesano, primero se elije el pedido (entre los pedidos sin asignar), y luego el artesano al que asignar el pedido.
     * Sino hay artesanos o no hay pedidos por asignar, vuelve al menú del jefe, con el mensaje correspondiente en cada caso
     */
    private void asignarPedidoArtesano() {
        if (gestorEmpleados.getNumeroArtesanos() > 0) {
            if (gestorPedidos.getNumeroPedidosSinAsignar() > 0) {
                System.out.println("Lista de pedidos sin asignar, elija uno: ");
                gestorPedidos.listarPedidosSinAsignar();          //listar los pedidos sin asignar para elegir uno
                int eleccionPedido = analizador.leerOpcion(gestorPedidos.getNumeroPedidosSinAsignar()); //elegir el pedido, y se pasa como límite de opciones el número de pedidos sin asignar
                System.out.println("Pedido elegido correctamente.");
                System.out.println("Lista de artesanos de la fábrica, elija uno para asignarle el pedido: ");
                gestorEmpleados.listarArtesanos();                //listar los artesanos                                   
                int eleccionArtesano = analizador.leerOpcion(gestorEmpleados.getNumeroArtesanos()); //elegir el artesano, y se pasa como límite de opciones el número de artesanos
                gestorPedidos.asignarPedidoArtesano(eleccionPedido, eleccionArtesano);     //se asigna el pedido elegido al artesano elegido, pasando los dos indices
                System.out.println("Pedido asignado correctamente.");
            } else {
                System.out.println("No hay pedidos sin asignar en la fábrica.");
            }
        } else {
            System.out.println("No hay artesanos dados de alta en la fábrica.");
        }
        volverMenuJefe();
    }
    
    /**
     * Lista los pedidos en proceso de la fábrica y luego vuelve al menú de jefe, si no hay ninguno, imprime el mensaje correspondiente y vuelve al menú de jefe
     */
    private void listarPedidosEnProceso() {
        if (gestorPedidos.getNumeroPedidosEnProceso() <= 0) {
            System.out.println("Actualmente no hay pedidos en proceso en la fábrica.");
        } else {
            System.out.println();
            System.out.println("Lista de pedidos en proceso en la fábrica: ");
            System.out.println();
            gestorPedidos.listarPedidosEnProceso();                     //listar pedidos en proceso de la fábrica
        }
        volverMenuJefe();
    }

    /**
     * Permite elegir las opciones del comercial, siendo la última cerrar sesión
     */
    private void opcionesComercialEnSistema () {
        menu.mostrarMenuComercial();
        int eleccion = analizador.leerOpcion(3);

        switch (eleccion){
            case 0:
                enviarPedidoParaConfirmacion();
            break;
            case 1:
                verEmpresas();
            break;
            case 2:
                cerrarSesion();
            break;
            
        }
    }
    
    /**
     * Permite elegir un pedido, que debe estar en estado PENDIENTE_DE_ENVIO, y lo cambia a PENDIENTE_DE_CONFIRMACION (lo envía al cliente), luego vuelve al menú 
     * del comercial. Sino hay pedidos por enviar se imprime un mensaje y vuelve al menú del comercial directamente
     */
    private void enviarPedidoParaConfirmacion(){
        if (gestorPedidos.getNumeroPedidosPorEnviar() <= 0) {
            System.out.println("Actualmente no hay pedidos por enviar en la fábrica.");
        } else {
            System.out.println();
            System.out.println("Lista de pedidos pendientes por enviar de toda la fábrica, elija uno: ");
            System.out.println();
            gestorPedidos.listarPedidosPorEnviar();                                             //listar pedidos por enviar
            int eleccion = analizador.leerOpcion(gestorPedidos.getNumeroPedidosPorEnviar());    //elegir el pedido por enviar, y se pasa como límite de opciones el número pedidos por enviar
            gestorPedidos.enviarPedido(eleccion);                                               //se envía el pedido con el indice elegido
            System.out.println("Pedido enviado para confirmación.");
        }
        volverMenuComercial();
    }
    
    /**
     * Permite ver todas las empresas que hay en toda la fábrica, sacado de la lista de clientes, luego vuelve al menú del comercial.
     * Sino hay ninguna, imprime el mensaje y vuelve al menú del comercial
     */
    private void verEmpresas() {
        if (gestorClientes.getNumeroEmpresas() > 0) {
            gestorClientes.listarEmpresas();
        } else {
            System.out.println("No hay empresas dadas de alta en la fábrica.");
        }
        volverMenuComercial();
    }

    /**
     * Permite elegir las opciones del artesano, siendo la última cerrar sesión
     */
    private void opcionesArtesanoEnSistema () {
        menu.mostrarMenuArtesano();
        int eleccion = analizador.leerOpcion(7);

        switch (eleccion){
            case 0:
                historialPedidosArtesano();
            break;
            case 1:
                establecerPedidoEnCurso();
            break;
            case 2:
                mostrarPedidoEnCurso();
            break;
            case 3:
                cambiarEstadoPedido();
            break;
            case 4:
                cogerPiezas();
            break;
            case 5:
                pedirPiezas();
            break;
            case 6:
                cerrarSesion();
            break;
        }
    }
    
    /**
     * Muestra la lista de pedidos asignados del artesano y vuelve a su menú, sino tiene pedidos asignados lo indica y vuelve al menú 
     */
    private void historialPedidosArtesano() {
        if (gestorEmpleados.getNumeroPedidosArtesano() > 0) {
            gestorPedidos.listarPedidosArtesano(false);         //Listar los pedidos del artesano, se pasa false porque no son opciones para elegir
        } else {
            System.out.println("No tiene ningún pedido.");
        }
        volverMenuArtesano();
    }
    
    /**
     * Muestra la lista de pedidos asginados del artesano para elegir uno y que se convierta en el pedido en curso y vuelve al menú del artesano.
     * Sino tiene pedidos asignados lo indica y vuelve al menú
     */
    private void establecerPedidoEnCurso() {
        if (gestorEmpleados.getNumeroPedidosArtesano() > 0) {
            gestorPedidos.listarPedidosArtesano(true);                           //Listar los pedidos del artesano, se pasa true porque son opciones para elegir
            int eleccion = analizador.leerOpcion(gestorEmpleados.getNumeroPedidosArtesano()); //elegir el pedido, y se pasa como límite de opciones el numero de pedidos asignados de este artesano
            gestorPedidos.establecerPedidoEnCursoArtesano(eleccion);             //se establece el pedido elegido enviado por indice como el pedido en curso               
            System.out.println("Pedido en curso establecido correctamente.");
        } else {
            System.out.println("No tiene ningún pedido.");
        }
        volverMenuArtesano();
    }
    
    /**
     * Muestra los datos del pedido en curso y vuelve al menú del artesano, sino tiene lo indica y vuelve al menú
     */
    private void mostrarPedidoEnCurso() {
        if (gestorEmpleados.hasPedidoEnCurso())
        {
          System.out.println();
          System.out.println ("Pedido en curso: \n\n" + gestorEmpleados.pedidoEnCursoToString());
        } else {
            System.out.println("Actualmente no tiene pedido en curso.");
        }
        volverMenuArtesano();
    }
    
    /**
     * Elije el estado al que cambiar el pedido en curso, lo cambia y vuelve al menú de artesano, sino tiene lo indica y vuelve al menú
     */
    private void cambiarEstadoPedido() {
        if (gestorEmpleados.hasPedidoEnCurso())
        {
          System.out.println();
          System.out.println ("Estado del pedido en curso: " + gestorEmpleados.estadoPedidoEnCursoToString()); //muestra el estado actual del pedido en curso
          menu.mostrarMenuCambiarEstado();                      //muestra los diferentes estados a los que se permite cambiar
          int eleccion = analizador.leerOpcion(4);              //se elige, son 4 estados diferentes a los que se permite cambiar
          gestorEmpleados.cambiarPedidoEnCurso(eleccion);       //se cambia el pedido pasando el indice del estado elegido
          System.out.println("Estado del pedido modificado correctamente.");
        } else {
            System.out.println("Actualmente no tiene pedido en curso.");
        }
        volverMenuArtesano();
    }
    
    /**
     * Pide el número de piezas a coger y las retira, sino hay suficientes se retiran las máximas posibles y se indica cuantas faltaban por coger, y luego vuelve al menú
     */
    private void cogerPiezas(){
        System.out.println("Piezas en la fábrica: " + piezasActuales + ".");
        int piezasCogidas = analizador.leerEnteroTexto("Introduce número de piezas necesarias: ");
        if (piezasCogidas < piezasActuales) {
            piezasActuales -= piezasCogidas;
            System.out.println("Piezas retiradas correctamente.");
        } else {
            if (piezasCogidas >= MAXIMO_PIEZAS_FABRICA) {                           //Comprobar que no se cogen igual o más piezas del número máximo de piezas de la fábrica
                System.out.println("No puede coger tantas piezas de una vez.");
            } else {
                System.out.println("Ha cogido " + piezasActuales + " piezas, faltan " + (piezasCogidas-piezasActuales) + " piezas de los pedidos ya que se han agotado, pida más.");
                piezasActuales = 0;
            }
        }
        volverMenuArtesano();
    }
    
    /**
     * Pide piezas para la fábrica, y se llena el número de piezas actuales al máximo que permite la fábrica
     */
    private void pedirPiezas(){
        piezasActuales = MAXIMO_PIEZAS_FABRICA;
        System.out.println("Piezas pedidas, ahora están al completo.");
        System.out.println("Piezas en la fábrica: " + piezasActuales + ".");
        volverMenuArtesano();
    }

    /**
     * Permite elegir las opciones del cliente, siendo la última cerrar sesión
     */
    private void opcionesClienteEnSistema () {
        menu.mostrarMenuCliente();
        int eleccion = analizador.leerOpcion(5);

        switch (eleccion){
            case 0:
                gestorPedidos.crearNuevoPedidoClienteConectado();           //crea un nuevo pedido con lista de muebles vacía y con los datos del cliente conectado
                hacerPedido();
            break;
            case 1:
                confirmarPedido();
            break;
            case 2:
                modificarMueble();
            break;
            case 3:
                listarPedidosCliente();
                break;
            case 4:
                cerrarSesion();
                break;
        }
    }
    
    /**
     * Permite añadir muebles al pedido que se está creando, o indicar que ya está terminado, si se hace un nuevo mueble se crea y se repite este menú, si se indica que se ha terminado se vuelve
     * al menú principal, siempre que como mínimo se haya añadido un mueble
     */
    private void hacerPedido() {
        menu.mostrarMenuHacerPedido(gestorPedidos.getNumeroMueblesPedidoNuevo());           //Muestra el número de muebles en el pedido que se está realizando y las opciones disponibles
        int eleccion = analizador.leerOpcion(2);
        
        switch (eleccion){
            case 0:
                crearMueble();      //crear nuevo mueble y añadirlo al pedido
                hacerPedido();      //volver a este método
            break;
            case 1:
                //Si tiene 0 o menos pedidos, se vuelve al mismo menú, hasta que haya por lo menos un mueble en el pedido
                if (gestorPedidos.getNumeroMueblesPedidoNuevo() <= 0) {                             
                    System.out.println("Pedido sin muebles, debe añadir un mueble como mínimo");
                    System.out.println();
                    hacerPedido();      //volver a este método
                } else {
                    gestorPedidos.anadirNuevoPedido();          //Se termina el nuevo pedido y se añade en la lista de pedidos de la fábrica 
                    System.out.println("Pedido terminado y enviado a la fábrica, cuando esté listo podrá confirmar su envío desde 'Confirmar pedido'.");
                    volverMenuCliente();
                }
            break;
        }
    }
    
    /**
     * Permite elegir entre crear una mesa o una silla
     */
    private void crearMueble() {
        menu.mostrarMenuCrearMueble();
        int eleccion = analizador.leerOpcion(2);

        switch (eleccion){
            case 0:
                crearMesa();
            break;
            case 1:
                crearSilla();
            break;
        }
    }
    
    /**
     * Permite elegir el tipo de mesa a crear, la crea y envía a la lista de muebles del pedido que se está creando
     */
    private void crearMesa() {
        menu.mostrarMenuCrearMesa();
        int eleccion = analizador.leerOpcion(4);
        TipoMueble tipoMueble = null;
        switch (eleccion){
            case 0:
                tipoMueble = TipoMueble.MESA_CAFE_MADERA;//Mesa cafe madera
            break;
            case 1:
                tipoMueble = TipoMueble.MESA_CAFE_CRISTAL;//Mesa cafe cristal
            break;
            case 2:
                tipoMueble = TipoMueble.MESA_DORMITORIO;//Mesa dormitorio
            break;
            case 3:
                tipoMueble = TipoMueble.MESA_COMEDOR;//Mesa comedor
            break;
        }
        gestorPedidos.getNuevoPedido().anadirMueble(gestorMuebles.crearMueble(tipoMueble));    //Crea un mueble del tipo pedido y lo añade a los muebles del pedido nuevo
    }

    /**
     * Permite elegir el tipo de silla a crear, la crea y envía a la lista de muebles del pedido que se está creando
     */
    private void crearSilla() {
        menu.mostrarMenuCrearSilla();
        int eleccion = analizador.leerOpcion(4);
        TipoMueble tipoMueble = null;
        switch (eleccion){
            case 0:
                tipoMueble = TipoMueble.SILLA_OFICINA_RUEDAS;//Silla de oficina con ruedas
            break;
            case 1:
                tipoMueble = TipoMueble.SILLA_OFICINA_SIN_RUEDAS;//Silla de oficina sin ruedas
            break;
            case 2:
                tipoMueble = TipoMueble.SILLA_COCINA;//Silla cocina
            break;
            case 3:
                tipoMueble = TipoMueble.SILLA_PLEGABLE;//Silla plegable
            break;
        }
        gestorPedidos.getNuevoPedido().anadirMueble(gestorMuebles.crearMueble(tipoMueble));    //Crea un mueble del tipo pedido y lo añade a los muebles del pedido nuevo
    }
    
    /**
     * Permite elegir y confirmar un pedido que esté en estado PENDIENTE_DE_CONFIRMACIÓN, y lo confirma, quedando como ENTREGADO ese pedido, luego vuelve al menú de cliente, sino hay
     * pedidos por confirmar de este cliente, lo indica y vuelve al menú de cliente
     */
    private void confirmarPedido() {
        if (gestorPedidos.getNumeroPedidosPorConfirmarCliente() <= 0) {
            System.out.println("Actualmente no tiene pedidos por confirmar.");
        } else {
            System.out.println();
            System.out.println("Lista de pedidos pendientes por confirmar, elija uno para confirmarlo: ");
            System.out.println();
            gestorPedidos.listarPedidosPorConfirmarCliente();                                               //lista los pedidos por confirmar de este cliente, para elegir uno
            int eleccion = analizador.leerOpcion(gestorPedidos.getNumeroPedidosPorConfirmarCliente());      //se elige el pedido, el límite es el número de pedidos por confirmar del cliente
            gestorPedidos.confirmarPedidoCliente(eleccion);                                                 //se confirma el pedido elegido, pasando el índice del pedido elegido    
            System.out.println("Pedido confirmado.");
        }
        volverMenuCliente();
    }
    
    /**
     * Muestra la lista de los muebles del cliente para elegir uno, luego muestra la lista de atributos para elegir cual modificar, y lo modifica, luego vuelve
     * al menú del cliente. Sino tiene muebles este cliente lo indica y vuelve al menú del cliente
     */
    private void modificarMueble() {
         gestorPedidos.llenarMueblesCliente();           //llena la lista de muebles del cliente conectado
         if (gestorMuebles.getNumeroMueblesCliente() <= 0) {
            System.out.println("Actualmente no tiene ningún mueble, puesto que no ha realizado pedidos.");
         } else {
            System.out.println();
            System.out.println("Lista de muebles de todos los pedidos, elija uno para modificarlo: ");
            System.out.println();
            gestorMuebles.listarMueblesCliente();                                                //muestra la lista de muebles del cliente conectado como opciones para elegir
            int eleccionMueble = analizador.leerOpcion(gestorMuebles.getNumeroMueblesCliente()); //se elige el mueble, el límite es el número de muebles de este cliente
            menu.mostrarMenuElegirAtributo(gestorMuebles.isMesaMuebleCliente(eleccionMueble));   //se muestran los atributos a modificar, y se pasa un booleano para indicar si es una mesa o una silla
            int eleccionAtributo = analizador.leerOpcion(3);                                     //se elige el atributo a modificar
            gestorMuebles.cambiarAtributo(eleccionMueble, eleccionAtributo);                     //se modifica el atributo elegido del mueble elegido
            System.out.println("Mueble modificado correctamente.");
         }
        volverMenuCliente();
    }
    
    /**
     * Muestra los pedidos del cliente conectado y vuelve al menú, sino hay lo indica y vuelve al menú del cliente
     */
    private void listarPedidosCliente () {
        System.out.println();
        if (gestorPedidos.getNumeroPedidosCliente() > 0) {
            System.out.println("Mostrando todos los pedidos realizados hasta el momento: ");
            System.out.println();
            gestorPedidos.listarPedidosCliente();
        } else {
            System.out.println("Todavía no ha realizado ningún pedido.");
        }
        
        volverMenuCliente();
    }
    
    /**
     * Muestra el texto de volver al menú del jefe y vuelve a ese menú
     */
    private void volverMenuJefe() {
        System.out.println();
        System.out.println("Volviendo al menú de jefe...");
        System.out.println();
        opcionesJefeEnSistema();
    }
    
    /**
     * Muestra el texto de volver al menú del comercial y vuelve a ese menú
     */
    private void volverMenuComercial() {
        System.out.println();
        System.out.println("Volviendo al menú de comercial...");
        System.out.println();
        opcionesComercialEnSistema();
    }
    
    /**
     * Muestra el texto de volver al menú del artesano y vuelve a ese menú
     */
    private void volverMenuArtesano() {
        System.out.println();
        System.out.println("Volviendo al menú de artesano...");
        System.out.println();
        opcionesArtesanoEnSistema();
    }
    
    /**
     * Muestra el texto de volver al menú del cliente y vuelve a ese menú
     */
    private void volverMenuCliente() {
        System.out.println();
        System.out.println("Volviendo al menú de cliente...");
        System.out.println();
        opcionesClienteEnSistema();
    }

    /**
     * Muestra el texto de cerrar sesión y vuelve al menú principal
     */
    private void cerrarSesion() {
        System.out.println();
        System.out.println("Cerrando sesión...");
        volverMenuPrincipal();
    }

    /**
     * Muestra el menú de salir y se finaliza el programa
     */
    private void salir(){
        menu.mostrarMenuSalir();
    }

}
