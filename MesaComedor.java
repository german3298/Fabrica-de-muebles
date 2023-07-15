
/**
 * Mesas de comedor que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class MesaComedor extends Mesa
{
    private boolean extensible;
    /**
     * Construye una mesa de comedor con los atributos indicados.
     */
    public MesaComedor(String color, int altura, String forma, boolean extensible)
    {
        super(color, altura, forma);
        this.extensible = extensible;
    }

    /**
     * Devuelve si la mesa será extensible
     * @return     True si será, false si no
     */
    public boolean isExtensible()
    {
        return extensible;
    }
    
    /**
     * Cambia el que sea extensible la mesa
     * @param    e booleano que indica si será extensible
     */
    public void setExtensible(boolean e)
    {
        extensible = e;
    }
    
    /**
     * Devuelve los atributos de esta mesa de comedor en texto
     * @return     Todo lo que tengan las superclases de esta clase y si es extensible, en string.
     */
    public String toString () {
        String respuesta = isExtensible() ? "Sí" : "No";
        return super.toString() + "\n\t\t¿Es extensible la mesa de comedor? " + respuesta + ".";
    }
}
