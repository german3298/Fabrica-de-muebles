
/**
 * Todos los tipos de persona que pueden tener cuenta en el sistema, y que se almacenan en él.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public enum TipoPersona
{
        JEFE("Jefe"), COMERCIAL("Comercial"), ARTESANO_EN_PLANTILLA("Artesano en plantilla"), 
        ARTESANO_POR_HORAS("Artesano por horas"), CLIENTE_PARTICULAR("Cliente (particular)"), CLIENTE_EMPRESA("Cliente (empresa)");
    
        private String tipoPersonaString;   
        
        /**
        * Construye un tipo de persona, y le asigna el string asociado.
        */
        private TipoPersona (String tipoPersonaString){
            this.tipoPersonaString = tipoPersonaString;
        }
        
        /**
        * Devuelve el string asociado a cada tipo de persona
        * @return     el tipo de persona, en una cadena
        */
        public String toString(){
            return tipoPersonaString;
        }
}
