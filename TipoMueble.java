
/**
 * Todos los tipos de mueble que se pueden crear en el sistema, y que se almacenan en él.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public enum TipoMueble
{
        MESA_CAFE_MADERA("Mesa de café con tablero de madera") , MESA_CAFE_CRISTAL("Mesa de café con tablero de madera"), MESA_DORMITORIO ("Mesa de dormitorio"), 
        MESA_COMEDOR ("Mesa de comedor"), SILLA_OFICINA_RUEDAS("Silla de oficina con ruedas"), SILLA_OFICINA_SIN_RUEDAS("Silla de oficina sin ruedas"), 
        SILLA_COCINA("Silla de cocina"), SILLA_PLEGABLE("Silla plegable");
    
        private String tipoMuebleString;

        /**
        * Construye un tipo de mueble, y le asigna el string asociado.
        */
        private TipoMueble (String tipoMuebleString){
            this.tipoMuebleString = tipoMuebleString;
        }
        
        /**
        * Devuelve el string asociado a cada tipo de mueble
        * @return     el tipo de mueble, en una cadena
        */
        public String toString(){
            return tipoMuebleString;
        }
}
