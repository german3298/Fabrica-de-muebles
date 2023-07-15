
/**
 * Clientes particulares de la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Particular extends Cliente
{
    private String apellidos;
    
    /**
     * Construye un cliente particular con los atributos indicados
     */
    public Particular(String ID, String domicilio, String apellidos)
    {
        super(ID, domicilio);
        this.apellidos = apellidos;
    }

    /**
     * Devuelve los apellidos de este cliente particular
     * @return     String con los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }
    
    /**
     * Establece los apellidos de este cliente
     * @param    a String con los nuevos apellidos
     */
    public void setApellidos(String a) {
        apellidos = a;
    }
    
    /**
     * Devuelve los atributos de este cliente particular, en texto
     * @return     Todo lo que tengan las superclases de esta clase y los apellidos del cliente, en string.
     */
    public String toString() {
        return super.toString() + "\n\t\tApellidos del cliente: " + getApellidos() + ".";
    }
}
