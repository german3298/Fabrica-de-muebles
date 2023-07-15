/**
 *  Los diferentes estados en los que puede estar un pedido.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public enum EstadoPedido
{
        PENDIENTE("Pendiente"), EN_PROCESO("En proceso"), PARADO_POR_FALTA_DE_PIEZAS("Parado por falta de piezas"), 
        PENDIENTE_DE_ENVIO("Pendiente de envío"), PENDIENTE_DE_CONFIRMACION("Pendiente de confirmación"), ENTREGADO("Entregado");
        
        private String estadoString;

        /**
        * Construye un estado del pedido, y le asigna el string asociado.
        */
        private EstadoPedido (String estadoString){
            this.estadoString = estadoString;
        }
        
        /**
        * Devuelve el string asociado a cada estado del pedido
        * @return     el estado del pedido, en una cadena
        */
        public String toString(){
            return estadoString;
        }
        
        /**
        * Devuelve el estado del pedido asociado a un int, que hace de indice
        * @param     estadoInt indice del estado del pedido, de 1 a 5, si es 0 o diferente devolverá el estado PENDIENTE
        * @return     el estado del pedido
        */
        public static EstadoPedido estadoInt(int estadoInt) {
            EstadoPedido estado;
            switch (estadoInt) {
                case 1: 
                    estado = EstadoPedido.EN_PROCESO;
                break;
                case 2: 
                    estado = EstadoPedido.PARADO_POR_FALTA_DE_PIEZAS;
                break;
                case 3: 
                    estado = EstadoPedido.PENDIENTE_DE_ENVIO;
                break;
                case 4: 
                    estado = EstadoPedido.PENDIENTE_DE_CONFIRMACION;
                break;
                case 5: 
                    estado = EstadoPedido.ENTREGADO;
                break;
                default: 
                estado = EstadoPedido.PENDIENTE;
            }
            return estado;
        }
}


