
/**
 * Mesas de dormitorio que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class MesaDormitorio extends Mesa
{
    private boolean cajonIncrustado;
    /**
     * Construye una mesa de dormitorio con los atributos indicados.
     */
    public MesaDormitorio(String color, int altura, String forma, boolean cajonIncrustado)
    {
        super(color, altura, forma);
        this.cajonIncrustado = cajonIncrustado;
    }

    /**
     * Devuelve si la mesa tiene cajón incrustado
     * @return     True si tiene, false si no
     */
    public boolean hasCajonIncrustado()
    {
        return cajonIncrustado;
    }
    
    /**
     * Cambia el tener cajón incrustado en esta mesa
     * @param   cI  booleano que indica si tendrá cajón incrustado
     */
    public void setCajonIncrustado(boolean cI)
    {
        cajonIncrustado = cI;
    }
    
    /**
     * Devuelve los atributos de esta mesa de dormitorio en texto
     * @return     Todo lo que tengan las superclases de esta clase y si tiene cajón incrustado, en string.
     */
    public String toString () {
        String respuesta = hasCajonIncrustado() ? "Sí" : "No";
        return super.toString() + "\n\t\t¿Tiene cajón incrustado la mesa de dormitorio? " + respuesta + ".";
    }
}
