import java.util.ArrayList;
/**
 * Clase que gestiona todos los empleados de la fábrica, y los almacena en una lista, además de gestionar
 * las operaciones a realizar con el empleado conectado en el sistema, y con el artesano conectado
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class GestorEmpleados
{
    private ArrayList<Empleado> empleados;          //lista de empleados de la fábrica
    private Empleado empleadoConectado;             //empleado conectado en el sistema
    private Artesano artesanoConectado;             //si el empleado conectado en el sistema es un artesano
    
    /**
     * Construye un objeto de esta clase con una lista de empleados vacía
     */
    public GestorEmpleados()
    {
        empleados = new ArrayList<Empleado>();
        empleadoConectado = null;
        artesanoConectado = null;
    }
        
    //Crear empleados

    /**
     * Crea un jefe y lo añade a la lista de empleados
     * @return     el empleado creado con los atributos indicados
     */
    public Persona anadirJefe(String ID, int sueldo,int incentivoJefe)
    {
        Empleado e = new Jefe(ID, sueldo, incentivoJefe);
        anadirEmpleado(e);
        return e;
    }

    /**
     * Crea un comercial y lo añade a la lista de empleados
     * @return     el empleado creado con los atributos indicados
     */
    public Persona anadirComercial(String ID, int sueldo, boolean cocheEmpresa)
    {
        Empleado e = new Comercial(ID, sueldo, cocheEmpresa);
        anadirEmpleado(e);
        return e;
    }

    /**
     * Crea un artesano en plantilla y lo añade a la lista de empleados
     * @return     el empleado creado con los atributos indicados
     */
    public Persona anadirArtesanoEnPlantilla(String ID, int sueldo, int numeroTaller)
    {
        Empleado e = new ArtesanoEnPlantilla(ID, sueldo, numeroTaller);
        anadirEmpleado(e);
        return e;
    }

    /**
     * Crea un artesano por horas y lo añade a la lista de empleados
     * @return     el empleado creado con los atributos indicados
     */
    public Persona anadirArtesanoPorHoras(String ID, int sueldo, int horasSemanales)
    {
        Empleado e = new ArtesanoPorHoras(ID, sueldo, horasSemanales);
        anadirEmpleado(e);
        return e;
    }
    
    //Lista de empleados
    
    /**
     * Añade un empleado a la lista total de empleados
     * @param e  el empleado a añadir
     */
    private void anadirEmpleado(Empleado e) {
        empleados.add(e);
    }
    
    //Empleado conectado
    
    /**
     * Devuelve el empleado conectado en el sistema
     * @return      el establecido como empleado conectado
     */
    public Empleado getEmpleadoConectado() {
        return empleadoConectado;
    }
    
    /**
     * Establece el empleado conectado en el sistema
     * @param     p la persona que es el nuevo empleado conectado
     */
    public void setEmpleadoConectado(Persona p) {
        empleadoConectado = (Empleado)p;                //Usamos el casting para que reconozca la persona como empleado
    }
    
    /**
     * Modifica el sueldo del empleado conectado
     * @param     sueldo int de el nuevo sueldo
     */
    public void modificarSueldoEmpleadoConectado(int sueldo) {
        empleadoConectado.setSueldo(sueldo);
    }
    
    //Artesano conectado
    
    /**
     * Devuelve el artesano conectado en el sistema
     * @return      el establecido como artesano conectado
     */
    public Artesano getArtesanoConectado() {
        return artesanoConectado;
    }
    
    /**
     * Establece el artesano conectado en el sistema
     * @param     p la persona que es el nuevo artesano conectado
     */
    public void setArtesanoConectado(Persona p) {
        artesanoConectado = (Artesano)p;                 //Usamos el casting para que reconozca la persona como artesano
    }
    
    /**
     * Devuelve el número total de pedidos del artesano conectado
     * @return     int del número de pedidos del artesano conectado
     */
    public int getNumeroPedidosArtesano() {
        return artesanoConectado.getNumeroPedidosAsignados();
    }
    
    /**
     * Devuelve si el artesano conectado tiene pedido en curso
     * @return     True si tiene alguno, false si es null
     */
    public boolean hasPedidoEnCurso() {
        return artesanoConectado.hasPedidoEnCurso();
    }
    
    /**
     * Cambia el pedido en curso del artesano conectado
     * @param    indice int que indica el indice de cual es el estado al que se quiere cambiar (ver lista en la clase enum EstadoPedido)
     */
    public void cambiarPedidoEnCurso (int indice) {
        artesanoConectado.cambiarEstadoPedidoCurso(indice);
    }
    
    /**
     * Devuelve en texto el estado del pedido en curso del artesano conectado
     * @return     El estado del pedido en texto
     */
    public String estadoPedidoEnCursoToString () {
        return artesanoConectado.estadoPedidoEnCursoToString();
    }
    
    /**
     * Devuelve en texto los datos de el pedido en curso del artesano conectado
     * @return     Un string con los datos del pedido
     */
    public String pedidoEnCursoToString () {
        return artesanoConectado.pedidoEnCursoToString();
    }
    
    //Lista de artesanos
    
    /**
     * Devuelve el número de artesanos total en la lista de empleados
     * @return     Un string con los datos del pedido
     */
    public int getNumeroArtesanos() {
        return listaArtesanos().size();
    }
    
    /**
     * Muestra una lista de todos los artesanos de la fábrica, mostrando sus datos y la lista de pedidos de cada uno, enumerados del 0 al último, para elegir uno posteriormente
     */
    public void listarArtesanos() {
        ArrayList<Artesano> artesanos = listaArtesanos();
        String listaArtesanos = "";
        for (int i = 0; i < artesanos.size(); i++) {
            listaArtesanos += i + ") " + artesanos.get(i).toString();
            listaArtesanos += artesanos.get(i).pedidosToString() + "\n";
        }
        System.out.println(listaArtesanos);
    }
    
    /**
     * Devuelve el artesano indicado con el índice de la lista de artesanos, sacada de la lista de empleados
     * @param    indice indice del artesano elegido en la lista de artesanos
     * @return     el artesano elegido por indice
     */
    public Artesano getArtesanoIndice(int indice) {
        return listaArtesanos().get(indice);
    }
    
    /**
     * Devuelve la lista de artesanos que hay en la lista de empleados, y que no están de baja
     * @return     Lista de artesanos 
     */
    private ArrayList<Artesano> listaArtesanos() {
        ArrayList<Artesano> artesanos = new ArrayList<Artesano>();
        for (Empleado e : empleados) {
            if (!e.deBaja() && e instanceof Artesano) {
                artesanos.add((Artesano)e);
            }
        }
        return artesanos;
    }
}
