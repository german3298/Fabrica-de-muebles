
/**
 * Sillas de oficina con ruedas que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class SillaOficinaRuedas extends SillaOficina
{
    private int numeroRuedas;

    /**
     * Construye una silla de oficina con ruedas, con los atributos indicados.
     */
    public SillaOficinaRuedas(String color, int altura, boolean respaldo, int alturaReposabrazos, int numeroRuedas)
    {
        super(color, altura, respaldo, alturaReposabrazos);
        this.numeroRuedas = numeroRuedas;
    }

    /**
     * Devuelve el número de ruedas de esta silla
     * @return     int con el número de ruedas en total
     */
    public int getNumeroRuedas()
    {
        return numeroRuedas;
    }
    
    /**
     * Cambia el número de ruedas de esta silla
     * @param    nR int con el nuevo total del número de ruedas de esta silla
     */
    public void setNumeroRuedas(int nR)
    {
        numeroRuedas = nR;
    }
    
    /**
     * Devuelve los atributos de esta silla de oficina con ruedas, en texto
     * @return     Todo lo que tengan las superclases de esta clase y el número de ruedas, en string.
     */
    public String toString () {
        return super.toString() + "\n\t\tNúmero de ruedas de esta silla de oficina: " + getNumeroRuedas() + ".";
    }
}
