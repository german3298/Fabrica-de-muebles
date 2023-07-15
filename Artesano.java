import java.util.ArrayList;
/**
 * Artesanos de la fábrica. Cada uno es capaz de fabricar todos los tipos 
 * de mueble y almacena una lista de los pedidos que le ha asignado algún jefe. 
 * También tiene un pedido “en curso”, que es el pedido en el cual está trabajando
 * en ese momento.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Artesano extends Empleado
{
    private ArrayList<Pedido> pedidosAsignados;         //Lista de pedidos asignados al artesano
    private Pedido pedidoEnCurso;                       //Pedido en el que está trabajando actualmente el artesano
    
    /**
     * Construye un artesano con los atributos indicados, y una lista de pedidos asignados vacía, y el pedido en curso vacío
     */
    public Artesano(String ID, int sueldo)
    {
        super(ID, sueldo);
        pedidosAsignados = new ArrayList<Pedido>();
        pedidoEnCurso = null;
    }
    
    /**
     * Devuelve el pedido en curso del artesano
     * @return     El pedido en curso
     */
    public Pedido getPedidoEnCurso() {
        return pedidoEnCurso;
    }
    
     /**
     * Establece el pedido en curso del artesano
     * @param    p El nuevo pedido en curso
     */
    public void setPedidoEnCurso(Pedido p) {
        pedidoEnCurso = p;
    }
    
     /**
     * Devuelve la lista de pedidos asignados al artesano
     * @return     Un ArrayList con los pedidos asignados 
     */
    public ArrayList<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
    }
    
     /**
     * Devuelve el número de pedidos asignados al artesano
     * @return     El número de pedidos
     */
    public int getNumeroPedidosAsignados() {
        return pedidosAsignados.size();
    }
    
     /**
     * Añade el pedido a la lista de pedidos asignados
     * @param    p El pedido que se añade
     */
    public void anadirPedido(Pedido p) {
        pedidosAsignados.add(p);
    }
    
     /**
     * Cambia el estado del pedido en curso mediante un indice
     * @param    indice  indice del nuevo estado del pedido en curso
     */
    public void cambiarEstadoPedidoCurso (int indice) {
        pedidoEnCurso.setEstado(indice);
    }
    
    /**
     * Devuelve si tiene pedido en curso
     * @return     True si tiene, false si no
     */
    public boolean hasPedidoEnCurso () {
        return pedidoEnCurso != null;
    }
    
    /**
     * Devuelve el estado del pedido en curso, en texto
     * @return     Texto del estado del pedido
     */
    public String estadoPedidoEnCursoToString() {
        return pedidoEnCurso.getEstado().toString();
    }
    
    /**
     * Devuelve el pedido en curso, en texto
     * @return     El string con los datos del pedido en curso
     */
    public String pedidoEnCursoToString() {
        return pedidoEnCurso.toString();
    }
    
    /**
     * Devuelve todos los pedidos asignados al artesano, en texto
     * @return     El string con los datos de cada pedido, enumerados. O un texto indicando que no tiene pedidos asignados.
     */
    public String pedidosToString() {
        String listaPedidos = "";
        if (pedidosAsignados.size() <= 0) {
            listaPedidos += "\n\t\tArtesano sin pedidos asignados por el momento." ;
        } else {
            listaPedidos += "\n\t\tLista de pedidos asignados a este artesano: " ;
            for (int i = 0; i < pedidosAsignados.size(); i++) {
                listaPedidos += "\nPedido " + (i+1) + ": \n" + pedidosAsignados.get(i).toString();
            }
        }
        return listaPedidos;
    }
    
}
