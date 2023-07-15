
/**
 * Empresa que encarga pedidos de la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Empresa extends Cliente
{
    private String sociedadMercantil;              

    /**
     * Construye un cliente (empresa) con los atributos indicados
     */
    public Empresa(String ID, String domicilio, String sociedadMercantil)
    {
        super(ID,domicilio);
        this.sociedadMercantil = sociedadMercantil;
    }
    
    /**
     * Devuelve la sociedad mercantil de esta empresa
     * @return     String con la sociedad mercantil
     */
    public String getSociedadMercantil() {
        return sociedadMercantil;
    }
    
    /**
     * Establece la sociedad mercantil de esta empresa
     * @param    sM String con la nueva sociedad mercantil
     */
    public void setSociedadMercantil(String sM) {
        sociedadMercantil = sM;
    }
    
    /**
     * Devuelve los atributos de este cliente (empresa), en texto
     * @return     Todo lo que tengan las superclases de esta clase y la sociedad mercantil, en string.
     */
    public String toString() {
        return super.toString() + "\n\t\tSociedad mercantil de la empresa: " + getSociedadMercantil() + ".";
    }
    
}
