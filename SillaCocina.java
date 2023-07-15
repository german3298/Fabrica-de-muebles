
/**
 * Sillas de cocina que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class SillaCocina extends Silla
{
    private boolean estilizada;
    
    /**
     * Construye una silla de cocina con los atributos indicados.
     */
    public SillaCocina(String color, int altura, boolean respaldo, boolean estilizada)
    {
        super(color, altura, respaldo);
        this.estilizada = estilizada;
    }

    /**
     * Devuelve si la silla es estilizada
     * @return     True si es estilizada, y false si no
     */
    public boolean isEstilizada()
    {
        return estilizada;
    }
    
    /**
     * Cambia el que sea estilizada esta silla
     * @param   e  booleano que indica si será estilizada la silla
     */
    public void setEstilizada(boolean e){
        estilizada = e;
    }
    
    /**
     * Devuelve los atributos de esta silla de cocina en texto
     * @return     Todo lo que tengan las superclases de esta clase y si es estilizada, en string.
     */
    public String toString () {
        String respuesta = isEstilizada() ? "Sí" : "No";
        return super.toString() + "\n\t\t¿Es estilizada esta silla de cocina? " + respuesta + ".";
    }
}
