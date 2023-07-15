
/**
 * Sillas plegables que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class SillaPlegable extends Silla
{
    private boolean posavasos;
    
    /**
     * Construye una silla plegable con los atributos indicados.
     */
    public SillaPlegable(String color, int altura, boolean respaldo, boolean posavasos)
    {
        super(color, altura, respaldo);
        this.posavasos = posavasos;
    }

    /**
     * Devuelve si la silla plegable tiene posavasos
     * @return     True si la silla tiene  posavasos y false si no
     */
    public boolean hasPosavasos()
    {
        return posavasos;
    }
    
    /**
     * Cambia el tener posavasos en esta silla
     * @param   p  booleano que indica si tendrá posavasos la silla
     */
    public void setPosavasos(boolean p) {
        posavasos = p;
    }
    
    /**
     * Devuelve los atributos de esta silla plegable en texto
     * @return     Todo lo que tengan las superclases de esta clase y si tiene posavasos, en string.
     */
    public String toString () {
        String respuesta = hasPosavasos() ? "Sí" : "No";
        return super.toString() + "\n\t\t¿Tiene posavasos esta silla plegable? " + respuesta + ".";
    }
    
    
}
