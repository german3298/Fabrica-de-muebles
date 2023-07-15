
/**
 * Personas relacionadas con la fábrica de muebles, 
 * tanto clientes como empleados.
 *
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Persona
{
    private TipoPersona tipoPersona;    //Enum del tipo de persona
    private String ID;                  //Número de identificación que tienen todas las personas de la fábrica, servirá para iniciar sesión, dar de baja y modificar atributos
    private boolean dadoDeBaja;         //Si la persona está dada de baja en el sistema
    
    /**
     * Construye una persona con el ID asignado
     */
    public Persona(String ID)
    {
        this.ID = ID;
        dadoDeBaja = false;             //al crear una persona, se le ha dado de alta, así que no estará de baja
    }

    /**
     * Devuelve el ID.
     * @return     El campo ID de esta persona.
     */
    public String getID()
    {
        return ID;
    }
    
    /**
     * Cambia el ID.
     * @param   id  El campo ID de esta persona.
     */
    public void setID(String id)
    {
        ID = id;
    }
    
    /**
     * Devuelve el tipo de persona
     * @return     El tipo de esta persona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }
    
    /**
     * Establece el tipo de persona
     * @param   tP  El nuevo tipo para esta persona
     */
    public void setTipoPersona (TipoPersona tP) {
        tipoPersona = tP;
    }
    
    /**
     * Devuelve si esta persona está dada de baja
     * @return     True si está dada de baja, false si no
     */
    public boolean deBaja() {
        return dadoDeBaja;
    }
    
    /**
     * Da de baja a esta persona
     */
    public void darDeBaja() {
        dadoDeBaja = true;
    }
    
    /**
     * Devuelve los atributos de esta persona en texto
     * @return     El tipo de persona y su ID en un string
     */
    public String toString() {
        return "\t\t" + getTipoPersona().toString() + ".\n\t\tID: " + getID();
    }
}
