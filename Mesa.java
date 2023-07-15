
/**
 * Mesas que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Mesa extends Mueble
{
    private String forma;
    
    /**
     * Construye una mesa con los atributos indicados.
     */
    public Mesa(String color, int altura, String forma)
    {
        super(color,altura);
        this.forma = forma;
    }
    
    /**
     * Devuelve la forma de esta mesa
     * @return     String con la forma de esta mesa
     */
    public String getForma()
    {
        return forma;
    }
    
    /**
     * Cambia la forma de esta mesa
     * @param   f  La nueva forma
     */
    public void setForma(String f)
    {
        forma = f;
    }
    
    /**
     * Devuelve los atributos de esta mesa en texto
     * @return     Todo lo que tengan las superclases de esta clase y la forma, en string.
     */
    public String toString() {
        return super.toString() + "\n\t\tForma de la mesa: " + forma + ".";
    }
}
