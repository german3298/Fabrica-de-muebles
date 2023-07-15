/**
 * Clase que almacena y muestra menús de la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Menu
{
    /**
     * Construye un objeto de esta clase, sin parámetros
     */
    public Menu()
    {
        
    }
    
    //Menús principales
    
    /**
     * Muestra el menú principal
     */
    public void mostrarMenuInicial() {
        System.out.println();
        System.out.println("********** Menú principal **********");
        System.out.println("0) Gestión del personal.");
        System.out.println("1) Entrar en el sistema.");
        System.out.println("2) Salir.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de salir, justo antes de terminar el programa
     */
    public void mostrarMenuSalir() {
        System.out.println();
        System.out.println("¡Gracias por usar nuestro sistema!");
        System.out.println("Cerrando...");
        System.out.println();
    }
    
    //Menús gestión del personal, creación de personas
    
    /**
     * Muestra el menú de opciones de gestión del personal
     */
    public void mostrarMenuGestionDelPersonal() {
        System.out.println("********** Menú gestión del personal **********");
        System.out.println("0) Dar de alta una persona.");
        System.out.println("1) Dar de baja una persona.");
        System.out.println("2) Modificar datos de una persona.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones de dar de alta una persona
     */
    public void mostrarMenuDarAlta() {
        System.out.println("********** Menú dar de alta persona **********");
        System.out.println("0) Dar de alta empleado.");
        System.out.println("1) Dar de alta cliente.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones de dar de alta un empleado
     */
    public void mostrarMenuDarAltaEmpleado() {
        System.out.println("********** Menú dar de alta empleado **********");
        System.out.println("0) Dar de alta jefe.");
        System.out.println("1) Dar de alta comercial.");
        System.out.println("2) Dar de alta artesano en plantilla.");
        System.out.println("3) Dar de alta artesano por horas.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones de dar de alta un cliente
     */
    public void mostrarMenuDarAltaCliente() {
        System.out.println("********** Menú dar de alta cliente **********");
        System.out.println("0) Dar de alta como cliente a una empresa.");
        System.out.println("1) Dar de alta como cliente a un particular.");
        System.out.println();
    }
    
    //Menús de cada usuario, una vez han iniciado sesión como tal
    
    /**
     * Muestra el menú de opciones de un jefe conectado al sistema
     */
    public void mostrarMenuJefe() {
        System.out.println("**************** Menú de jefe ****************");
        System.out.println("0) Asignar pedido a un artesano.");
        System.out.println("1) Ver pedidos en proceso.");
        System.out.println("2) Cerrar sesión y volver al menú principal.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones de un comercial conectado al sistema
     */
    public void mostrarMenuComercial() {
        System.out.println("******************* Menú de comercial *******************");
        System.out.println("0) Enviar pedido acabado a su cliente para confirmación.");
        System.out.println("1) Ver todas las empresas entre los clientes.");
        System.out.println("2) Cerrar sesión y volver al menú principal.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones de un artesano conectado al sistema
     */
    public void mostrarMenuArtesano() {
        System.out.println("**************** Menú de artesano ****************");
        System.out.println("0) Mis pedidos asignados.");
        System.out.println("1) Establecer pedido en curso.");
        System.out.println("2) Mostrar pedido en curso.");
        System.out.println("3) Cambiar estado de pedido en curso.");
        System.out.println("4) Coger piezas para muebles.");
        System.out.println("5) Pedir piezas.");
        System.out.println("6) Cerrar sesión y volver al menú principal.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones de un cliente conectado al sistema
     */
    public void mostrarMenuCliente() {
        System.out.println("**************** Menú de cliente ****************");
        System.out.println("0) Hacer pedido.");
        System.out.println("1) Confirmar pedido para retirar.");
        System.out.println("2) Modificar mueble de un pedido.");
        System.out.println("3) Ver todos mis pedidos.");
        System.out.println("4) Cerrar sesión y volver al menú principal.");
        System.out.println();
    }
    
    //Menús de opciones del artesano conectado
    
    /**
     * Muestra el menú de opciones para elegir un estado al que cambiar del pedido en curso de el artesano conectado
     */
    public void mostrarMenuCambiarEstado() {
        System.out.println("**************** Cambio de estado ****************");
        System.out.println("Cambiar estado a: ");
        System.out.println("0) Pendiente.");
        System.out.println("1) En proceso.");
        System.out.println("2) Parado por falta de piezas.");
        System.out.println("3) Pendiente de envío.");
        System.out.println();
    }
    
    //Menús del cliente conectado
    
    /**
     * Muestra el menú de opciones cuando un cliente hace un pedido
     * @param numeroMueblesPedido int del número de muebles que lleva ese pedido 
     */
    public void mostrarMenuHacerPedido(int numeroMueblesPedido) {
        System.out.println("*********** Hacer pedido ************");
        System.out.println("Muebles en el pedido: " + numeroMueblesPedido);
        System.out.println("0) Añadir nuevo mueble.");
        System.out.println("1) Terminar pedido.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones cuando un cliente crea un mueble haciendo un pedido
     */
    public void mostrarMenuCrearMueble() {
        System.out.println("********** Menú de crear mueble **********");
        System.out.println("¿Ese mueble será una mesa o una silla?");
        System.out.println("0) Elegir una mesa.");
        System.out.println("1) Elegir una silla.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones cuando un cliente crea una mesa haciendo un pedido
     */
    public void mostrarMenuCrearMesa() {
        System.out.println("********** Menú de crear mesa **********");
        System.out.println("¿Que tipo de mesa desea?");
        System.out.println("0) Mesa de café con tablero de madera.");
        System.out.println("1) Mesa de café con tablero de cristal.");
        System.out.println("2) Mesa de dormitorio.");
        System.out.println("3) Mesa de comedor.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones cuando un cliente crea una silla haciendo un pedido
     */
    public void mostrarMenuCrearSilla() {
        System.out.println("********** Menú de crear silla **********");
        System.out.println("¿Que tipo de silla desea?");
        System.out.println("0) Silla de oficina con ruedas.");
        System.out.println("1) Silla de oficina sin ruedas.");
        System.out.println("2) Silla de cocina.");
        System.out.println("3) Silla plegable.");
        System.out.println();
    }
    
    /**
     * Muestra el menú de opciones cuando un cliente elije un atributo para modificar de un mueble
     * @param isMesa   Si el mueble a modificar es una mesa, se podrá elegir cambiar la forma, si es una silla, se podrá elegir cambiar el respaldo
     */
    public void mostrarMenuElegirAtributo(boolean isMesa) {
        System.out.println("********** Menú de elegir atributo **********");
        System.out.println("¿Qué desea modificar?");
        System.out.println("0) Modificar color.");
        System.out.println("1) Modificar altura.");
        System.out.println(isMesa ? "2) Modificar forma." : "2) Modificar respaldo.");   //Si es una mesa, se modificará la forma, si es una silla, el respaldo
        System.out.println();
    }
}
