
/**
 * Artesano con contrato fijo, están en la plantilla de la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class ArtesanoEnPlantilla extends Artesano
{
    private int numeroTaller;               //número del taller de la fábrica donde trabaja este artesano en plantilla
    
    /**
     * Construye un artesano en plantilla con los atributos indicados
     */
    public ArtesanoEnPlantilla(String ID, int sueldo, int numeroTaller)
    {
        super(ID, sueldo);
        this.numeroTaller = numeroTaller;
    }
    
    /**
     * Devuelve el número de taller de este empleado
     * @return     int del número de taller
     */
    public int getNumeroTaller(){
        return numeroTaller;
    }
    
    /**
     * Establece el número de taller de este artesano
     * @param   nT int del número de taller
     */
    public void setNumeroTaller(int nT){
        numeroTaller = nT;
    }
    
    /**
     * Devuelve los atributos de este artesano en plantilla, en texto
     * @return     Todo lo que tengan las superclases de esta clase y el número de taller, en string.
     */
    public String toString() {
        return super.toString() + "\n\t\tNúmero de taller asignado de este artesano: " + getNumeroTaller();
    }

    
}
