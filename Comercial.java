
/**
 * Comerciales de la fábrica. 
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Comercial extends Empleado
{
    private boolean cocheEmpresa;

    /**
     * Construye un comercial con los atributos indicados
     */
    public Comercial(String ID, int sueldo, boolean cocheEmpresa)
    {
        super(ID, sueldo);
        this.cocheEmpresa = cocheEmpresa;
    }
    
    /**
     * Devuelve si este comercial tiene coche de empresa
     * @return     True si tiene, false si no
     */
    public boolean hasCocheEmpresa() {
        return cocheEmpresa;   
    }
    
    /**
     * Devuelve los atributos de este comercial, en texto
     * @return     Todo lo que tengan las superclases de esta clase y si dispone de coche de empresa, en string.
     */
    public String toString() {
        String respuesta = hasCocheEmpresa() ? "Sí" : "No";
        return super.toString() + "\n\t\t¿Dispone este comercial de coche de empresa? " + respuesta + ".";
    }
    
}
