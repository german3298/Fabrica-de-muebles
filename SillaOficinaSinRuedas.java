
/**
 * Sillas de oficina sin ruedas que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class SillaOficinaSinRuedas extends SillaOficina
{
    private boolean elevador;
    
    /**
     * Construye una silla de oficina sin ruedas, con los atributos indicados.
     */
    public SillaOficinaSinRuedas(String color, int altura, boolean respaldo, int alturaReposabrazos, boolean elevador)
    {
        super(color, altura, respaldo, alturaReposabrazos);
        this.elevador = elevador;
    }

    /**
     * Devuelve si tiene elevador
     * @return     True si la silla tiene elevador, false si no
     */
    public boolean hasElevador()
    {
        return elevador;
    }
    
    /**
     * Cambia el tener elevador de esta silla
     * @param    e booleano que indica si tendrá elevador la silla
     */
    public void setElevador(boolean e)
    {
        elevador = e;
    }
    
    /**
     * Devuelve los atributos de esta silla de oficina sin ruedas en texto
     * @return     Todo lo que tengan las superclases de esta clase y si tiene elevador, en string.
     */
    public String toString () {
        String respuesta = hasElevador() ? "Sí" : "No";
        return super.toString() + "\n\t\t¿Tiene sistema elevador esta silla de oficina sin ruedas?: " + respuesta + ".";
    }
}
