
/**
 * Sillas que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Silla extends Mueble
{
    private boolean respaldo;
    
    /**
     * Construye una silla con los atributos indicados.
     */
    public Silla(String color, int altura, boolean respaldo)
    {
        super(color, altura);
        this.respaldo = respaldo;
    }

    /**
     * Devuelve si la silla tiene respaldo
     * @return     True si tiene, false si no
     */
    public boolean hasRespaldo()
    {
        return respaldo;
    }
    
    /**
     * Cambia el tener respaldo en esta silla
     * @param   r  booleano que indica si tendrá respaldo la silla
     */
    public void setRespaldo (boolean r) {
        respaldo = r;
    }
    
    /**
     * Devuelve los atributos de esta mesa en texto
     * @return     Todo lo que tengan las superclases de esta clase y si tiene respaldo, en string.
     */
    public String toString() {
        String respuesta = hasRespaldo() ? "Sí" : "No";                
        return super.toString() + "\n\t\t¿La silla tiene respaldo? " + respuesta + ".";
    }
}
