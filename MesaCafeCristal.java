 
/**
 * Mesas de café de cristal que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class MesaCafeCristal extends MesaCafe
{
    private boolean cristalTemplado;

    /**
     * Construye una mesa de café de cristal con los atributos indicados.
     */
    public MesaCafeCristal(String color, int altura, String forma, int numeroBases, boolean cristalTemplado)
    {
        super(color, altura, forma, numeroBases);
        this.cristalTemplado = cristalTemplado;
    }

    /**
     * Devuelve si el cristal de la mesa será templado
     * @return     True si lo será, false si no
     */
    public boolean hasCristalTemplado()
    {
        return cristalTemplado;
    }
    
    /**
     * Cambia el que el cristal sea templado
     * @param   cT  booleano que indica si será templado el cristal
     */
    public void setCristalTemplado(boolean cT)
    {
        cristalTemplado = cT;
    }
    
    /**
     * Devuelve los atributos de esta mesa de café de cristal en texto
     * @return     Todo lo que tengan las superclases de esta clase y si el cristal es templado, en string.
     */
    public String toString () {
        String respuesta = hasCristalTemplado() ? "Sí" : "No";
        return super.toString() + "\n\t\t¿El cristal de esta mesa de café es templado?: " + respuesta + ".";
    }
}
