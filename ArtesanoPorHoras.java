
/**
 * Artesano con contrato por horas. Su sueldo va en función de las horas que trabaja a la semana.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class ArtesanoPorHoras extends Artesano
{
    private int horasSemanales;             //Número de horas a la semana que trabaja este artesano contratado por horas

    /**
     * Construye un artesano con contrato por horas, con los atributos indicados
     */
    public ArtesanoPorHoras(String ID, int sueldo, int horasSemanales)
    {
        super(ID, sueldo);
        this.horasSemanales = horasSemanales;
    }
    
    /**
     * Devuelve número de horas semanales
     * @return     int de las horas semanales
     */
    public int getHorasSemanales() {
         return horasSemanales;
    }
    
    /**
     * Cambia el numero de horas semanales que trabaja este artesano,
     *  y para ello establece un nuevo sueldo en base al que tenía, y el número
     *  de horas (teniendo en cuenta que cada sueldo es mensual, y que un mes 
     *  tenga exactamente cuatro semanas).
     * 
     * @param  hS  numero de horas. 
     */
    public void setHorasSemanales(int hS) {
         /*Sacar cuanto cobra por hora el artesano dividiendo el 
         sueldo mensual entre cuatro veces las horas semanales*/
         int sueldoPorHora = getSueldo()/(4*horasSemanales);
         /*Establece el nuevo sueldo en función del nuevo número 
         de horas semanales*/
         setSueldo(sueldoPorHora*hS*4);
         horasSemanales = hS;
    }
    
    /**
     * Devuelve los atributos de este artesano por horas, en texto
     * @return     Todo lo que tengan las superclases de esta clase y el número de horas de trabajo semanal, en string.
     */
    public String toString() {
        return super.toString() + "\n\t\tNúmero de horas de trabajo semanales de este artesano: " + getHorasSemanales();
    }
    
}
