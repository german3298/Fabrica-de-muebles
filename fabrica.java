
/**
 * Clase principal que abre la aplicación, sólo contiene el método main y un campo de tipo ControlFabrica para iniciar el programa. 
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class fabrica
{
    
    /**
     * Construye un objeto de esta clase, pero el programa empieza llamando al método main
     */
    public fabrica()
    {
        
    }
    
    /**
     * Método main que crea objeto de tipo ControlFabrica para iniciar el programa
    */
    public static void main(String[] args) {
        ControlFabrica control = new ControlFabrica();
    }
    
}
