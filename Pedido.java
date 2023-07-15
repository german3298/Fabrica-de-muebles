import java.util.ArrayList;
/**
 * Pedido hecho por un cliente a la fábrica. Almacena una lista de muebles, un estado actual del pedido, 
 * el cliente que ha realizado este pedido, un código de pedido y si ha sido asignado. Tiene dos métodos 
 * diferenciados para mostrar los datos por String, uno sin los datos del cliente, y otro sólo de los 
 * datos del cliente.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Pedido
{
    private Cliente cliente;                //Cliente que ha encargado este pedido
    private ArrayList<Mueble> muebles;      //Lista de muebles encargados en este pedido
    private EstadoPedido estado;            //Estado del pedido
    private int codigoPedido;               //Código del pedido
    private boolean asignado;               //Si el pedido ha sido asignado a un artesano para ser fabricado
    
    /**
     * Construye un objeto Pedido, con el cliente indicado, el código indicado, la lista de muebles vacía, el estado en PENDIENTE, y asignado en false
     */
    public Pedido(Cliente cliente, int codigoPedido)
    {
        this.cliente = cliente;
        this.codigoPedido = codigoPedido;
        muebles = new ArrayList<Mueble>();
        estado = EstadoPedido.PENDIENTE;
        asignado = false;
    }
    
    /**
     * Devuelve el código de este pedido
     * @return     un int con el atributo códigoPedido
     */
    public int getCodigoPedido() {
        return codigoPedido;
    }
    
    /**
     * Devuelve el número de muebles que tiene este pedido en la lista
     * @return     un int con el número de muebles, siempre 0 o mayor
     */
    public int getNumeroMuebles() {
        return muebles.size();
    }
    
    /**
     * Devuelve el estado de este pedido
     * @return     un enum, del tipo EstadoPedido, con el estado de este pedido
     */
    public EstadoPedido getEstado() {
        return estado;
    }
    
    /**
     * Cambia el estado de este pedido
     * @param    estadoActual un enum, del tipo EstadoPedido, con el nuevo estado de este pedido
     */
    public void setEstado(EstadoPedido estadoActual) {
        estado = estadoActual;
    }
    
    /**
     * Cambia el estado de este pedido, en base a un indice que indica un estado 
     * @param   indice un int, entre 1 y 5 (si es 0 o mayor se pondrá en estado PENDIENTE) que indica cada uno de los posibles estados de un pedido (ver lista en la clase enum EstadoPedido)
     */
    public void setEstado (int indice) {
        setEstado(EstadoPedido.estadoInt(indice));          //Llama al método estático estadoInt
    }
    
    /**
     * Devuelve la lista de muebles de este pedido
     * @return     un ArrayList<Mueble> con los muebles de este pedido
     */
    public ArrayList<Mueble> getListaMuebles() {
        return muebles;
    }
    
    /**
     * Añade un mueble a la lista
     * @param m mueble a añadir
     */
    public void anadirMueble(Mueble m) {
        muebles.add(m);
    }
    
    /**
     * Devuelve si este pedido está asignado a un artesano
     * @return     true si está asignado, false si no
     */
    public boolean isAsignado() {
        return asignado;
    }
    
    /**
     * Cambia este pedido a estar asignado
     */
    public void asignarPedido () {
        asignado = true;
    }
    
    /**
     * Envía el pedido al cliente, y se queda pendiente de confirmar por el cliente
     */
    public void enviar()
    {
        setEstado(EstadoPedido.PENDIENTE_DE_CONFIRMACION);
    }
    
    /**
     * Confirma el pedido por el cliente, y se entrega al cliente 
     */
    public void confirmar()
    {
        setEstado(EstadoPedido.ENTREGADO);
    }
    
    /**
     * Comprueba si el estado pasado es igual al estado de este pedido
     * @param    e estado a comparar con el de este pedido
     * @return     true si es el mismo, false si no
     */
    public boolean isMismoEstado(EstadoPedido e) {
            return estado == e;
    }
    
    /**
     * Comprueba si el objeto cliente pasado es igual al objeto cliente de este pedido
     * @param    c cliente a comparar con el de este pedido
     * @return     true si es el mismo, false si no
     */
    public boolean isMismoCliente(Cliente c) {
            return cliente == c;
    }
    
    /**
     * Devuelve los datos del cliente de este pedido en texto
     * @return     Un string con los datos del cliente que ha hecho este pedido
     */
    public String clienteToString() {
        return "\nDatos del cliente: \n" + cliente.toString();
    }
    
    /**
     * Devuelve la lista de muebles en texto, númerados del 1 hasta el final
     * @return     Un string con la lista de muebles
     */
    private String listaMueblesToString(){
        String listaMuebles = "";
        for (int i = 0; i < muebles.size(); i++) {
            listaMuebles += "\n\tMueble " + (i+1) + ": " + muebles.get(i).toString();
        }
        return listaMuebles;
    }
    
    /**
     * Devuelve los atributos de este pedido en texto, excepto los datos de el cliente
     * @return     Un string con el código del pedido en formato "00X", el estado del pedido en minúsculas, si está asignado, y la lista de muebles
     */
    public String toString () {
        String codigoPedido = String.format("%03d" , getCodigoPedido());
        String estadoPedido = estado.toString().toLowerCase() + ".";
        String asignado = isAsignado() ? "Sí." : "No.";
        return "Código pedido: " + codigoPedido + "\nEstado pedido: " +
        estadoPedido + "\n¿Está asignado ya este pedido? " + asignado + "\nLista de muebles: " + listaMueblesToString();
    }
}
