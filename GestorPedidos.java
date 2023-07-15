import java.util.ArrayList;
/**
 * Clase que almacena y gestiona todos los pedidos realizados a la fábrica. 
 * También las diferentes listas y búsquedas sobre los pedidos.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class GestorPedidos
{
    private ArrayList<Pedido> pedidos;              //lista de todos los pedidos de la fábrica
    private GestorMuebles gestorMuebles;
    private GestorClientes gestorClientes;
    private GestorEmpleados gestorEmpleados;
    private Pedido nuevoPedido;                     //lista de todos los pedidos de la fábrica
    private int contadorPedidos = 0;                //se usará para contar los pedidos que se van creando y añadirles el correspondiente código de pedido
    
    /**
     * Construye un gestor de pedidos con los tres atributos asignados, la lista de pedidos vacía y el contador de pedidos a 0
     */
    public GestorPedidos(GestorMuebles gM, GestorClientes gC, GestorEmpleados gE)
    {
        pedidos = new ArrayList<Pedido>();
        nuevoPedido = null;
        setGestorMuebles(gM);
        setGestorClientes(gC);
        setGestorEmpleados(gE);
    }
    
    /**
     * Establece el atributo gestorMuebles con el enviado por parámetro
     * @param     gM gestor muebles nuevo
     */
    private void setGestorMuebles(GestorMuebles gM){
        gestorMuebles = gM;
    }
    
    /**
     * Establece el atributo gestorClientes con el enviado por parámetro
     * @param     gC gestor clientes nuevo
     */
    private void setGestorClientes(GestorClientes gC){
        gestorClientes = gC;
    }
    
    /**
     * Establece el atributo gestorEmpleados con el enviado por parámetro
     * @param     gE gestor empleados nuevo
     */
    private void setGestorEmpleados(GestorEmpleados gE){
        gestorEmpleados = gE;
    }

    //Pedido nuevo
    
    /**
     * Añadir pedido a la lista total de pedidos
     */
    public void anadirNuevoPedido()
    {
        pedidos.add(nuevoPedido);
    }
    
    /**
     * Devuelve el objeto en nuevoPedido
     * @return      el pedido que se está creando
     */
    public Pedido getNuevoPedido() {
        return nuevoPedido;
    }
    
    /**
     * Crea un nuevo pedido y lo pone en el campo nuevoPedido, con el cliente pasado por parámetro
     * @param     c cliente que hace el pedido
     */
    public void crearNuevoPedido(Cliente c){
        nuevoPedido = new Pedido(c, contadorPedidos);
        contadorPedidos++;                              //añade uno al contador de pedidos
    }
    
    /**
     * Crea un nuevo pedido con el cliente conectado del gestorClientes como cliente
     */
    public void crearNuevoPedidoClienteConectado() {
        crearNuevoPedido(gestorClientes.getClienteConectado());
    }
    
    /**
     * Devuelve el numero de muebles que tiene el pedido nuevoPedido
     * @return      int con el número de muebles de nuevoPedido
     */
    public int getNumeroMueblesPedidoNuevo() {
        return nuevoPedido.getNumeroMuebles();
    }
    
    /**
     * Imprime el estado del pedido en curso, pasado por parámetro
     * @param     p pedido del cual leer el estado
     */
    public void estadoPedidoEnCurso(Pedido p) {
        System.out.println("Estado actual de su pedido en curso: " + p.getEstado().toString());
    }
    
    /**
     * Llena la lista de muebles del cliente (en gestorMuebles), enviando todos los muebles de todos los pedidos del cliente conectado
     */
    public void llenarMueblesCliente() {
        ArrayList<Pedido> pedidosCliente = pedidosCliente();        //pedidos del cliente conectado
        for (Pedido p : pedidosCliente) {
            gestorMuebles.setMueblesCliente(p.getListaMuebles());   //llena la lista de muebles del cliente enviando la lista de muebles de cada pedido
        }
    }
    
    // Pedidos del cliente conectado
        
    /**
     * Devuelve una lista de los pedidos del cliente conectado
     * @return ArrayList de pedidos sin asignar
     */
    private ArrayList<Pedido> pedidosCliente() {
        ArrayList<Pedido> pedidosClienteConectado = new ArrayList<Pedido>();
        for (Pedido p : pedidos) {
            if (p.isMismoCliente(gestorClientes.getClienteConectado())){
                pedidosClienteConectado.add(p);
            }
        }
        return pedidosClienteConectado;
    }
    
    /**
     * Devuelve el número de pedidos del cliente conectado
     * @return int de pedidos del cliente conectado
     */
    public int getNumeroPedidosCliente(){
        return pedidosCliente().size();
    }
    
    /**
     * Muestra la lista de pedidos del cliente conectado para informar, no como opciones (al conocerse el cliente, no se muestran los datos del cliente en cada pedido)
     */
    public void listarPedidosCliente() {
        mostrarListaPedidos(pedidosCliente(), false, false);
    }

    // Pedidos por confirmar del cliente conectado
    
    /**
     * Devuelve una lista de los pedidos por confirmar (en estado PENDIENTE_DE_CONFIRMACION) del cliente conectado
     * @return ArrayList de pedidos por confirmar del cliente conectado
     */
    private ArrayList<Pedido> pedidosPorConfirmarCliente() {
       return listaPedidosEstado(pedidosCliente(), EstadoPedido.PENDIENTE_DE_CONFIRMACION);
    }
    
    /**
     * Devuelve el número de pedidos por confirmar (en estado PENDIENTE_DE_CONFIRMACION) del cliente conectado
     * @return int con el número de pedidos por confirmar del cliente conectado
     */
    public int getNumeroPedidosPorConfirmarCliente(){
        return pedidosPorConfirmarCliente().size();
    }
    
    /**
     * Muestra la lista de pedidos del cliente conectado y por confirmar (en estado PENDIENTE_DE_CONFIRMACION), como opciones para elegir 
     * (al conocerse el cliente, no se muestran los datos del cliente en cada pedido)
     */
    public void listarPedidosPorConfirmarCliente() {
        mostrarListaPedidos(pedidosPorConfirmarCliente(), true, false);
    }
    
    /**
     * Confirma el pedido anteriormente elegido con el indice, de la lista de pedidos por confirmar del cliente conectado
     * @param indice indice del pedido elegido en la lista mencionada anteriormente
     */
    public void confirmarPedidoCliente(int indice) {
        pedidosPorConfirmarCliente().get(indice).confirmar();
    }
    
    // Pedidos por enviar en la fábrica
    
    /**
     * Devuelve una lista de los pedidos por enviar (en estado PENDIENTE_DE_ENVIO) de la lista de pedidos de la fábrica
     * @return ArrayList de pedidos por enviar
     */
    private ArrayList<Pedido> pedidosPorEnviar() {
       return listaPedidosEstado(pedidos, EstadoPedido.PENDIENTE_DE_ENVIO);
    }
    
    /**
     * Devuelve el número de pedidos por enviar (en estado PENDIENTE_DE_ENVIO) de la lista de pedidos de la fábrica
     * @return int con el número de pedidos por enviar 
     */
    public int getNumeroPedidosPorEnviar(){
        return pedidosPorEnviar().size();
    }
    
    /**
     * Muestra la lista de pedidos por enviar (en estado PENDIENTE_DE_ENVIO), como opciones para elegir 
     * (al no conocerse el cliente, sí se muestran los datos del cliente en cada pedido)
     */
    public void listarPedidosPorEnviar() {
        mostrarListaPedidos(pedidosPorEnviar(), true, true);
    }
    
    /**
     * Envía el pedido anteriormente elegido con el indice, de la lista de pedidos por enviar
     * @param indice indice del pedido elegido en la lista mencionada anteriormente
     */
    public void enviarPedido(int indice) {
        pedidosPorEnviar().get(indice).enviar();
    }
    
    //Pedidos en proceso en la fábrica
    
    /**
     * Devuelve una lista de los pedidos en proceso (en estado EN_PROCESO) de la lista de pedidos de la fábrica
     * @return ArrayList de pedidos en proceso
     */
    private ArrayList<Pedido> pedidosEnProceso() {
       return listaPedidosEstado(pedidos, EstadoPedido.EN_PROCESO);
    }
    
    /**
     * Devuelve el número de pedidos en proceso (en estado EN_PROCESO) de la lista de pedidos de la fábrica
     * @return int con el número de pedidos en proceso
     */
    public int getNumeroPedidosEnProceso(){
        return pedidosEnProceso().size();
    }
    
    /**
     * Muestra la lista de pedidos en proceso (en estado EN_PROCESO) para informar, no como opciones
     * (al no conocerse el cliente, sí se muestran los datos del cliente en cada pedido)
     */
    public void listarPedidosEnProceso() {
        mostrarListaPedidos(pedidosEnProceso(), false, true);
    }
    
    // Pedidos del artesano conectado
    
    /**
     * Devuelve una lista de los pedidos del artesano conectado
     * @return ArrayList de pedidos del artesano
     */
    private ArrayList<Pedido> pedidosArtesano() {
       return gestorEmpleados.getArtesanoConectado().getPedidosAsignados();
    }
    
    /**
     * Muestra la lista de pedidos del artesano
     * (al no conocerse el cliente, sí se muestran los datos del cliente en cada pedido)
     * @param sonOpciones si es true, se mostrará como opciones para ser elegido por teclado, si es false se mostrará solo para informar
     */
    public void listarPedidosArtesano(boolean sonOpciones) {
        mostrarListaPedidos(pedidosArtesano(), sonOpciones, true);
    }
    
    /**
     * Establece como pedido en curso del artesano conectado, el pedido que tiene el índice pasado como parámetro, elegido en la lista de pedidos del artesano conectado
     * @param indice indice del pedido elegido en la lista mencionada anteriormente
     */
    public void establecerPedidoEnCursoArtesano(int indice) {
        gestorEmpleados.getArtesanoConectado().setPedidoEnCurso(pedidosArtesano().get(indice));
    }
    
    // Pedidos sin asignar
    
    /**
     * Devuelve una lista de los pedidos sin asignar a ningún artesano
     * @return ArrayList de pedidos sin asignar
     */
    private ArrayList<Pedido> pedidosSinAsignar() {
        ArrayList<Pedido> pedidosSinAsignar = new ArrayList<Pedido>();
        for (Pedido p : pedidos) {
            if (!p.isAsignado()){           //si el pedido no está asignado
                pedidosSinAsignar.add(p);   //se añade a la lista
            }
        }
        return pedidosSinAsignar;
    }
    
    /**
     * Devuelve el número de pedidos sin asignar de la lista de pedidos de la fábrica
     * @return int con el número de pedidos sin asignar
     */
    public int getNumeroPedidosSinAsignar() {
        return pedidosSinAsignar().size();
    }
    
    /**
     * Muestra la lista de pedidos sin asignar como opciones
     * (al no conocerse el cliente, sí se muestran los datos del cliente en cada pedido)
     */
    public void listarPedidosSinAsignar() {
        mostrarListaPedidos(pedidosSinAsignar(), true, true);
    }
    
    /**
     * Asigna el pedido sin asignar, con indice del primer parámetro (extraído de la lista de pedidos sin asignar) 
     * al artesano elegido con índice en el segundo parámetro, elegido de la lista de artesanos en la fábrica
     * @param indicePedido índice del pedido sin asignar elegido en la lista de pedidos sin asignar
     * @param indiceArtesano índice del artesano elegido en la lista de artesanos de la fábrica
     */
    public void asignarPedidoArtesano(int indicePedido, int indiceArtesano) {
        Pedido p = pedidosSinAsignar().get(indicePedido);                   //el pedido sin asignar elegido
        p.asignarPedido();                                                  //se marca como pedido ya asignado
        gestorEmpleados.getArtesanoIndice(indiceArtesano).anadirPedido(p);  //se añade el pedido a la lista de pedidos asignados del artesano
    }

    //Lista de pedidos por estado
    
    /**
     * Devuelve una lista de pedidos donde, de la lista de pedidos del primer parámetro, ha añadido solo los del estado pasado por segundo parámetro 
     * @param   pedidos lista de pedidos donde realizar la búsqueda
     * @param   estado estado en el que están los pedidos de la lista a devolver
     * @return ArrayList de pedidos en el estado del segundo parámetro, sacados de la lista del primer parámetro
     */
    private ArrayList<Pedido> listaPedidosEstado (ArrayList<Pedido> pedidos, EstadoPedido estado) {
        ArrayList<Pedido> pedidosEstado = new ArrayList<Pedido>();
        for (Pedido p : pedidos) {
                if (p.isMismoEstado(estado)){
                    pedidosEstado.add(p);
                }
        }
        return pedidosEstado;
    }
    
    //Listar pedidos
    
    /**
     * Imprime una lista de pedidos pasada por el primer parámetro
     * @param   pedidos lista de pedidos a imprimir
     * @param   sonOpciones si es true, se imprimirá empezando por 0 hasta el último número y con ")", 
     * para mostrar que son opciones, si es false será solo para visualizar, y empezará por el 1 hasta el último número, y con "-"
     * @param   mostrarCliente si es true, se imprimirán también los datos del cliente de cada pedido, si es false no
     */
    private void mostrarListaPedidos(ArrayList<Pedido> pedidos, boolean sonOpciones, boolean mostrarCliente) {
        for (int i = 0; i < pedidos.size(); i++) {
            String pedido = sonOpciones ? i + ") " + pedidos.get(i).toString() : (i+1) + " - " + pedidos.get(i).toString();
            if (mostrarCliente) {
                pedido += pedidos.get(i).clienteToString();
            }
            System.out.println(pedido);
            System.out.println();
        }
    }
}
