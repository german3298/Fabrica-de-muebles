
/**
 * Empleados de la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Empleado extends Persona
{
    private int sueldo;             //Sueldo mensual en euros
    
    /**
     * Construye un empleado con los atributos indicados
     */
    public Empleado(String ID, int sueldo)
    {
        super(ID);
        this.sueldo = sueldo;
    }
    
    /**
     * Devuelve el sueldo de este empleado, en euros
     * @return     int del sueldo
     */
    public int getSueldo()
    {
        return sueldo;
    }
    
    /**
     * Cambiar el sueldo de este empleado
     * @param   s  int con el nuevo sueldo del empleado
     */
    public void setSueldo(int s)
    {
        sueldo = s;
    }
    
    /**
     * Devuelve los atributos de este empleado en texto
     * @return     Todo lo que tengan las superclases de esta clase y el sueldo, en string.
     */
    public String toString(){
        return super.toString() + "\n\t\tSueldo: " + getSueldo() + "€";
    }
}
