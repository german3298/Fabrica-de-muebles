import java.util.ArrayList;
/**
 * Clase que gestiona todos los clientes de la fábrica, y los almacena en una lista, además de gestionar
 * las operaciones a realizar con el cliente conectado en el sistema
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class GestorClientes
{
    private ArrayList<Cliente> clientes;        //lista de clientes en el sistema
    private Cliente clienteConectado;           //cliente conectado en el sistema
    
    /**
     * Construye un objeto de esta clase con una lista de clientes vacía
     */
    public GestorClientes()
    {
        clientes = new ArrayList<Cliente>();
        clienteConectado = null;
    }
    
    //Crear clientes
    
    /**
     * Crea un cliente particular y lo añade a la lista de clientes
     * @return     el cliente creado con los atributos indicados
     */
    public Persona anadirClienteParticular(String ID, String domicilio, String apellidos)
    {
        Cliente c = new Particular(ID, domicilio, apellidos);
        anadirCliente(c);
        return c;
    }
    
    /**
     * Crea un cliente empresa y lo añade a la lista de clientes
     * @return     el cliente creado con los atributos indicados
     */
    public Persona anadirClienteEmpresa(String ID, String domicilio, String sociedadMercantil)
    {
        Cliente c = new Empresa(ID, domicilio, sociedadMercantil);
        anadirCliente(c);
        return c;
    }
    
    //Cliente conectado
    
    /**
     * Devuelve el cliente conectado en el sistema
     * @return      el establecido como cliente conectado
     */
    public Cliente getClienteConectado() {
        return clienteConectado;
    }
    
    /**
     * Establece el cliente conectado en el sistema
     * @param     p la persona que es el nuevo cliente conectado
     */
    public void setClienteConectado(Persona p) {
        clienteConectado = (Cliente)p;                  //Usamos el casting para que reconozca la persona como cliente
    }
    
    /**
     * Modifica el domicilio del cliente conectado
     * @param     domicilio string de el nuevo domicilio
     */
    public void modificarDomicilioClienteConectado(String domicilio){
        clienteConectado.setDomicilioEntrega(domicilio);
    }

    //Lista de clientes
    
    /**
     * Añade cliente a la lista
     * @param    c el nuevo cliente a añadir
     */
    private void anadirCliente(Cliente c) {
        clientes.add(c);
    }
    
    /**
     * Devuelve el número total de empresas en la lista de clientes
     * @return     int del número de empresas en la lista de clientes
     */
    public int getNumeroEmpresas() {
        return listaEmpresas().size();
    }
    
    /**
     * Muestra una lista de todos los clientes que son empresas (enumerados del 1 al último), sacados de la lista de clientes
     */
    public void listarEmpresas() {
        String listaEmpresas = "Lista de clientes que son empresas: ";
        ArrayList<Empresa> empresas = listaEmpresas();
        for (int i = 0; i < empresas.size(); i++) {
            listaEmpresas += "\n" + (i+1) + " - " + empresas.get(i).toString();
        }
        System.out.println(listaEmpresas);
    }
    
    /**
     * Devuelve una lista con las empresas (y que no estén dadas de baja), sacadas de la lista de clientes totales
     * @return     lista de empresas entre la lista de clientes totales
     */
    private ArrayList<Empresa> listaEmpresas() {
        ArrayList<Empresa> empresas = new ArrayList<Empresa>();
        for (Cliente c : clientes) {
            if (!c.deBaja() && c instanceof Empresa) {
                empresas.add((Empresa)c);
            }
        }
        return empresas;
    }

}
