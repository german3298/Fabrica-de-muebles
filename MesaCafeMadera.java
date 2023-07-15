
/**
 * Mesas de café de madera que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class MesaCafeMadera extends MesaCafe
{
    private boolean maderaBarnizada;

    /**
     * Construye una mesa de café de madera con los atributos indicados.
     */
    public MesaCafeMadera(String color, int altura, String forma, int numeroBases, boolean maderaBarnizada)
    {
        super(color, altura, forma, numeroBases);
        this.maderaBarnizada = maderaBarnizada;
    }

    /**
     * Devuelve si la madera de la mesa estará barnizada
     * @return      True si lo estará, false si no
     */
    public boolean hasMaderaBarnizada()
    {
        return maderaBarnizada;
    }
    
    /**
     * Cambia el que la madera de la mesa esté barnizada
     * @param   mB  booleano que indica si estará barnizada
     */
    public void setMaderaBarnizada(boolean mB)
    {
        maderaBarnizada = mB;
    }
    
    /**
     * Devuelve los atributos de esta mesa de café de madera en texto
     * @return     Todo lo que tengan las superclases de esta clase y si tiene la madera barnizada, en string.
     */
    public String toString () {
        String respuesta = hasMaderaBarnizada() ? "Sí" : "No";
        return super.toString() + "\n\t\t¿La madera de esta mesa de café estará barnizada?: " + respuesta + ".";
    }
}
