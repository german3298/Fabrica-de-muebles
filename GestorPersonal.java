import java.util.HashMap;
/**
 * Clase que crea cualquier persona de la fábrica, leyendo todos los datos necesarios. 
 * También se usa para iniciar sesión según el ID de la persona que entre al sistema.
 * 
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class GestorPersonal
{
    private HashMap<String,Persona> personal;    //lista de todas las personas de la fábrica, el string será la "contraseña" de cada persona para entrar, que es el campo ID de la persona
    
    private Persona personaConectada;            //persona conectada en el sistema
    
    private Analizador analizador;
    private GestorEmpleados gestorEmpleados;
    private GestorClientes gestorClientes;
    
    /**
     * Construye un gestor de personal con los tres atributos asignados y la lista de personas vacía
     */
    public GestorPersonal(GestorEmpleados gE, GestorClientes gC, Analizador a)
    {
        personal = new HashMap<String,Persona>();     
        personaConectada = null;
        setGestorEmpleados (gE);
        setGestorClientes(gC);
        setAnalizador(a);
    }
    
    /**
     * Establece el atributo gestorEmpleados con el enviado por parámetro
     * @param     gE gestor empleados nuevo
     */
    private void setGestorEmpleados(GestorEmpleados gE){
        gestorEmpleados = gE;
    }
    
    /**
     * Establece el atributo gestorClientes con el enviado por parámetro
     * @param     gC gestor clientes nuevo
     */
    private void setGestorClientes(GestorClientes gC){
        gestorClientes = gC;
    }
    
    /**
     * Establece el atributo analizador con el enviado por parámetro
     * @param     a analizador nuevo
     */
    private void setAnalizador(Analizador a) {
        analizador = a;
    }
    
    /**
     * Comprueba si el ID pasado por parámetro existe como clave en el hashmap de personas
     * @param     ID String que comprueba si existe en el hashmap
     * @return    true si existe, false si no
     */
    private boolean existeID (String ID) {
         return personal.containsKey(ID);
    }
    
    /**
     * Comprueba si el ID pasado por String existe en el hashmap y luego si esa persona está de baja, 
     * y sino lo está, inicia la sesión, asignando la persona correcta dando el ID como clave al hashmap
     * @param     ID String para intentar iniciar sesión
     * @return    true si ha podido iniciar sesión, false si no
     */
    public boolean iniciarSesion (String ID){
        if (existeID(ID)) {
            if (!personal.get(ID).deBaja()) {
                personaConectada = personal.get(ID);
                return true;
            } else {
                System.out.println("ID perteneciente a una persona que actualmente está de baja del sistema.");
            }
        } else {
            System.out.println("ID introducido no existente en el sistema.");
        }
        return false;
    }
        
    /**
     * Menú de bienvenida cuando se inicia sesión, que muestra el tipo de persona que es y sus datos personales
     */
    public void menuBienvenida() {
        String tipoPersonaString = personaConectada.getTipoPersona().toString().toLowerCase();
        System.out.println("Bienvenido, ha entrado usted al sistema como " + tipoPersonaString + ".");
        System.out.println("Datos personales: ");
        System.out.println(personaConectada.toString());
        System.out.println();
    }
    
    /**
     * Da de baja a la persona conectada
     */
    public void darDeBajaPersonaConectada() {
        personaConectada.darDeBaja();
    }  
    
    /**
     *  Establece, si es necesario según el tipo de persona, el artesano conectado, el empleado conectado o el cliente conectado
     *  En caso de ser el artesano, también se establece el empleado, puesto que un artesano es un empleado
     */
    public void setPersonasConectadas() {
        switch (personaConectada.getTipoPersona()) {
            case ARTESANO_EN_PLANTILLA:
            case ARTESANO_POR_HORAS:
                gestorEmpleados.setArtesanoConectado(personaConectada);
            case JEFE:
            case COMERCIAL:
                gestorEmpleados.setEmpleadoConectado(personaConectada);
                break;
            case CLIENTE_PARTICULAR:
            case CLIENTE_EMPRESA:
                gestorClientes.setClienteConectado(personaConectada);
                break;
        }
    }
    
    /**
     * Devuelve el tipo de persona de la persona conectada
     * @return    el tipo de persona, del enum TipoPersona
     */
    public TipoPersona tipoPersonaConectada () {
        return personaConectada.getTipoPersona();
    }
    
    /**
     * Modifica la persona conectada, si es un empleado modifica el sueldo, y si es un cliente modifica su domicilio
     */
    public void modificarPersonaConectada () {
        if (isEmpleado(tipoPersonaConectada())) {
            System.out.println("Procediendo a modificar el sueldo de este empleado...");
            gestorEmpleados.modificarSueldoEmpleadoConectado(leerSueldo());
        } else {
            System.out.println("Procediendo a modificar el domicilio de este cliente...");
            gestorClientes.modificarDomicilioClienteConectado(leerDomicilio());
        }
    }
    
    /**
     * Comprueba si el tipoPersona indicado es un empleado o un cliente
     * @param     tipoPersona del enum tipoPersona
     * @return    true si es un empleado, false si no
     */
    public boolean isEmpleado(TipoPersona tipoPersona) {
        switch (tipoPersona){
                case CLIENTE_PARTICULAR:
                case CLIENTE_EMPRESA:
                    return false;
                default:
                    return true;
        }
    }
    
    /**
     * Añade una persona indicada por parámetro al hashmap de personal, poniendo su ID como clave
     * @param  p  persona a añadir en el hashmap
     */
    public void anadirPersona(Persona p) {
        personal.put(p.getID(),p);
    }
    
    //Crear cada tipo de empleado, en cada tipo creamos una persona del tipo pedido con sus atributos, luego le añadimos su tipo, y devolvemos esa persona
    
    /**
     * Crea un jefe, devuelto del gestorEmpleados
     * @return     la persona creada con los atributos indicados
     */
    public Persona crearJefe(String ID, int sueldo, int incentivoJefe)
    {
        Persona p = gestorEmpleados.anadirJefe(ID, sueldo, incentivoJefe);      
        p.setTipoPersona(TipoPersona.JEFE);
        return p;
    }

    /**
     * Crea un comercial, devuelto del gestorEmpleados
     * @return     la persona creada con los atributos indicados
     */
    public Persona crearComercial(String ID, int sueldo, boolean cocheEmpresa)
    {
        Persona p = gestorEmpleados.anadirComercial(ID, sueldo, cocheEmpresa);      
        p.setTipoPersona(TipoPersona.COMERCIAL);
        return p;
    }

    /**
     * Crea un artesano en plantilla, devuelto del gestorEmpleados
     * @return     la persona creada con los atributos indicados
     */
    public Persona crearArtesanoEnPlantilla(String ID, int sueldo, int numeroTaller)
    {
        Persona p = gestorEmpleados.anadirArtesanoEnPlantilla(ID, sueldo, numeroTaller);     
        p.setTipoPersona(TipoPersona.ARTESANO_EN_PLANTILLA);
        return p;
    }

    /**
     * Crea un artesano por horas, devuelto del gestorEmpleados
     * @return     la persona creada con los atributos indicados
     */
    public Persona crearArtesanoPorHoras(String ID, int sueldo, int horasSemanales)
    {
        Persona p = gestorEmpleados.anadirArtesanoPorHoras(ID, sueldo, horasSemanales);    
        p.setTipoPersona(TipoPersona.ARTESANO_POR_HORAS);
        return p;
    }
    
     //Crear cada tipo de cliente, en cada tipo creamos una persona del tipo pedido con sus atributos, luego le añadimos su tipo, y devolvemos esa persona
    
    /**
     * Crea un cliente particular, devuelto del gestorClientes
     * @return     la persona creada con los atributos indicados
     */
    public Persona crearClienteParticular(String ID, String domicilio, String apellidos)
    {
        Persona p = gestorClientes.anadirClienteParticular(ID, domicilio, apellidos);     
        p.setTipoPersona(TipoPersona.CLIENTE_PARTICULAR);
        return p;
    }
    
    /**
     * Crea un cliente empresa, devuelto del gestorClientes
     * @return     la persona creada con los atributos indicados
     */
    public Persona crearClienteEmpresa(String ID, String domicilio, String sociedadMercantil)
    {
        Persona p = gestorClientes.anadirClienteEmpresa(ID, domicilio, sociedadMercantil);     
        p.setTipoPersona(TipoPersona.CLIENTE_EMPRESA);
        return p;
    }
        
    //Leer los datos y crear una persona
    
    /**
     * Crea una persona (dependiendo del tipo indicado), leyendo del teclado todos los datos,
     * que va pidiendo uno a uno, y si el ID introducido ya existe, para el proceso. Al final añade esta persona a la lista
     * @param    tipoPersonaCreada Tipo de la persona a crear
     */
    public void crearPersona (TipoPersona tipoPersonaCreada) {
        Persona p = null;
        String ID = analizador.leerCadenaTexto("ID para la persona: ");
        
        if (existeID(ID)){                             //Si el ID introducido ya existe, se para el proceso
            System.out.println("No se puede continuar, ID ya existente.");              
            return;
        }
        
        switch (tipoPersonaCreada) {
            case JEFE:
                p = crearJefe(ID, leerSueldo(), leerIncentivoJefe());
                break;
            case COMERCIAL:
                p = crearComercial(ID, leerSueldo(), leerCocheEmpresa());
                break;
            case ARTESANO_EN_PLANTILLA:
                p = crearArtesanoEnPlantilla(ID, leerSueldo(), leerNumeroTaller());
                break;
            case ARTESANO_POR_HORAS:
                p = crearArtesanoPorHoras(ID, leerSueldo(), leerNumeroHoras());
                break;
            case CLIENTE_PARTICULAR:
                p = crearClienteParticular(ID, leerDomicilio(), leerApellidos());
                break;
            case CLIENTE_EMPRESA:
                p = crearClienteEmpresa(ID, leerDomicilio(), leerSociedadMercantil());
                break;
            default:
            System.out.println("Tipo de persona incorrecto, fallo creando persona.");  //Error.
            return;
        }
        System.out.println(tipoPersonaCreada.toString() + " creado.");
        anadirPersona(p);
    }
    
    //Leer datos sobre las personas, son métodos privados porque solo se usan en esta misma clase
    
    private int leerSueldo() {
        return analizador.leerEnteroTexto("Sueldo mensual del empleado(en euros): ");
    }
    
    private String leerDomicilio() {
        return analizador.leerCadenaTexto("Domicilio de entrega del cliente: ");
    }
    
    private int leerIncentivoJefe() {
        return analizador.leerEnteroTexto("Incentivo del jefe(mensual, en euros): ");
    }
    
    private boolean leerCocheEmpresa() {
        return analizador.leerBooleanoTexto("¿El comercial va a disponer de coche de empresa?");
    }
    
    private int leerNumeroTaller() {
        return analizador.leerEnteroTexto("Número de taller asignado en la fábrica para este artesano: ");
    }
    
    private int leerNumeroHoras() {
        return analizador.leerEnteroTexto("Número de horas semanales que va a trabajar este artesano: ");
    }
    
    private String leerApellidos() {
        return analizador.leerCadenaTexto("Apellidos: ");
    }
    
    private String leerSociedadMercantil() {
        return analizador.leerCadenaTexto("Tipo de sociedad mercantil: ");
    }
}
