
/**
 * Jefes de la fábrica. Pueden mandar pedidos a los artesanos.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Jefe extends Empleado
{
    private int incentivoJefe;              //Mensual, en euros

    /**
     * Construye un jefe con los atributos indicados
     */
    public Jefe(String ID, int sueldo, int incentivoJefe)
    {
        super(ID, sueldo);
        this.incentivoJefe = incentivoJefe;
        //setTipoPersona(TipoPersona.JEFE);
    }

    /**
     * Devuelve el incentivo de este jefe, en euros
     * @return     int del incentivo
     */
    public int getIncentivo()
    {
        return incentivoJefe;
    }
    
    /**
     * Establece el incentivo de este jefe, en euros
     * @param   iP  int del incentivo
     */
    public void setIncentivo(int iP)
    {
       incentivoJefe = iP;
    }
    
    /**
     * Devuelve los atributos de este jefe, en texto
     * @return     Todo lo que tengan las superclases de esta clase y el incentivo, en string.
     */
    public String toString() {
        return super.toString() + "\n\t\tIncentivo del jefe: " + getIncentivo() + "€";
    }
}
