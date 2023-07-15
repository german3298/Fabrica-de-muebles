
/**
 * Mesas de café que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class MesaCafe extends Mesa
{
    private int numeroBases;            //número de patas que tiene esta mesa
    
    /**
     * Construye una mesa de café con los atributos indicados.
     */
    public MesaCafe(String color, int altura, String forma, int numeroBases)
    {
        super(color,altura,forma);
        this.numeroBases = numeroBases;
    }

    /**
     * Devuelve el número de bases de la mesa
     * @return     un int del número de bases
     */
    public int getNumeroBases()
    {
        return numeroBases;
    }
    
    /**
     * Cambia el número de bases de la mesa
     * @param   nB  int con el nuevo número de bases
     */
    public void setNumeroBases(int nB)
    {
        numeroBases = nB;
    }
    
    /**
     * Devuelve los atributos de esta mesa de café en texto
     * @return     Todo lo que tengan las superclases de esta clase y el número de bases, en string.
     */
    public String toString () {
        return super.toString() + "\n\t\tNúmero de bases que tiene la mesa de café: " + getNumeroBases() + ".";
    }
}
