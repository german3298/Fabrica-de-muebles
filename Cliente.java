/**
 * Clientes que tiene la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Cliente extends Persona
{
    private String domicilioEntrega;            //domicilio donde se entregarán los muebles de los pedidos
    
    /**
     * Construye un cliente con los atributos indicados
     */
    public Cliente(String ID, String domicilioEntrega)
    {
        super(ID);
        this.domicilioEntrega = domicilioEntrega;
    }

    /**
     * Devuelve domicilio de este cliente
     * @return     String con la dirección
     */
    public String getDomicilioEntrega() {
        return domicilioEntrega;
    }

    /**
     * Cambiar el domicilio de este cliente
     * @param    dE String con la nueva dirección
     */
    public void setDomicilioEntrega(String dE) {
        domicilioEntrega = dE;
    }
    
    /**
     * Devuelve los atributos de este cliente, en texto
     * @return     Todo lo que tengan las superclases de esta clase y el domicilio de entrega, en string.
     */
    public String toString() {
        return super.toString() + "\n\t\tDomicilio de entrega: " + getDomicilioEntrega() + ".";
    }

}
