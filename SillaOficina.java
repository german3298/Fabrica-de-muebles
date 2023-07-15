
/**
 * Sillas de oficina que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class SillaOficina extends Silla 
{
    private int alturaReposabrazos;
    
    /**
     * Construye una silla de oficina con los atributos indicados.
     */
    public SillaOficina(String color, int altura, boolean respaldo, int alturaReposabrazos)
    {
        super(color, altura, respaldo);
        this.alturaReposabrazos = alturaReposabrazos;
    }

    /**
     * Devuelve la altura del reposabrazos
     * @return     int con la altura, en cm
     */
    public int getAlturaReposabrazos()
    {
        return alturaReposabrazos;
    }
    
    /**
     * Cambia la altura del reposabrazos
     * @param   aR  int con la nueva altura del reposabrazos, en cm
     */
    public void setAlturaReposabrazos(int aR)
    {
        alturaReposabrazos = aR;
    }
    
    /**
     * Devuelve los atributos de esta silla de oficina en texto
     * @return     Todo lo que tengan las superclases de esta clase y la altura del reposabrazos, en string.
     */
    public String toString () {
        return super.toString() + "\n\t\tAltura del reposabrazos de la silla de oficina: " + getAlturaReposabrazos() + ".";
    }
}
