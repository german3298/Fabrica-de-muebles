import java.util.ArrayList;
/**
 * Clase que gestiona los muebles relacionado con la fábrica y permite
 * crear cada tipo de mueble, y modificar algunos datos, además de elegir
 * el atributo a modificar.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class GestorMuebles
{
    private ArrayList<Mueble> mueblesCliente;                   //Muebles totales que ha pedido el cliente conectado al sistema
    private Analizador analizador;                              //Para leer datos
    
    /**
     * Construye un objeto de esta clase, con el analizador recibido
     */
    public GestorMuebles(Analizador a)
    {
        mueblesCliente =  new ArrayList<Mueble>();
        setAnalizador(a);
    }
    
    /**
     * Establece el atributo analizador con el enviado por parámetro
     * @param     a analizador nuevo
     */
    private void setAnalizador(Analizador a) {
        analizador = a;
    }
    
    //Modificar un atributo concreto de un mueble concreto de todos los muebles del cliente conectado
    
    /**
     * Añade muebles a la lista de muebles del cliente conectado
     * @param   muebles  lista de muebles a añadir a la lista de muebles del cliente conectado
     */
    public void setMueblesCliente(ArrayList<Mueble> muebles) {
        for (Mueble m : muebles) {
            mueblesCliente.add(m);
        }
    }
    
     /**
     * Devuelve el número de muebles del cliente conectado
     * @return     int con el número de muebles, siempre 0 o positivo
     */
    public int getNumeroMueblesCliente(){
        return mueblesCliente.size();
    }
    
    /**
     * Muestra cada uno de los muebles del cliente conectado, listados de 0 al último, para poder elegir uno
     */
    public void listarMueblesCliente(){
        for (int i = 0; i < mueblesCliente.size(); i++) {
           System.out.println(i + ") " + mueblesCliente.get(i).toString());
           System.out.println();
        }
    }
    
    /**
     * Cambia un atributo (elegido con un indice) de un mueble (elegido entre los muebles del cliente con otro indice)
     * @param   indiceMueble  int indice del mueble de la lista de muebles del cliente conectado
     * @param   indiceAtributo  int indice del atributo elegido para modificar
     */
    public void cambiarAtributo(int indiceMueble, int indiceAtributo){
        Mueble m = mueblesCliente.get(indiceMueble);                //Selecciona el mueble en el que se va a modificar el atributo
        switch (indiceAtributo) {
            case 0:
            m.setColor(leerColor());
            break;
            case 1:
            m.setAltura(leerAltura());
            break;
            case 2:
            if (isMesa(m)){
                //El mueble elegido es una mesa
                Mesa mesa = (Mesa)m;
                mesa.setForma(leerForma());
            } else {
                //El mueble elegido es una silla
                Silla silla = (Silla)m;
                silla.setRespaldo(leerRespaldo());
            }
            break;
        }
        mueblesCliente.clear();
    }
    
    /**
     * Devuelve si es una mesa el mueble de los de la lista de muebles del cliente, marcado con un indice
     * @param     indice indice de la lista de muebles del cliente, a comprobar si es una mesa
     * @return     true si es una mesa, false si no
     */
    public boolean isMesaMuebleCliente (int indice) {
        return isMesa(mueblesCliente.get(indice));
    }
    
    /**
     * Devuelve si el mueble es una mesa
     * @param     m mueble a comprobar si es una mesa
     * @return     true si es una mesa, false si no
     */
    private boolean isMesa (Mueble m) {
        return m instanceof Mesa;
    }
    
    //Crear cada tipo de mesa, en cada tipo creamos un mueble del tipo pedido con sus atributos, luego le añadimos su tipo, y devolvemos ese mueble
    
    /**
     * Crea una mesa de café de madera
     * @return     el mueble creado con los atributos indicados
     */
    public Mueble crearMesaCafeMadera(String color, int altura, String forma, int numeroBases, boolean maderaBarnizada){
        Mueble m = new MesaCafeMadera(color, altura, forma, numeroBases, maderaBarnizada);
        m.setTipoMueble(TipoMueble.MESA_CAFE_MADERA);
        return m;
    }
    
    /**
     * Crea una mesa de café de cristal
     * @return     el mueble creado con los atributos indicados
     */
    public Mueble crearMesaCafeCristal(String color, int altura, String forma, int numeroBases, boolean cristalTemplado){
        Mueble m = new MesaCafeCristal(color, altura, forma, numeroBases, cristalTemplado);
        m.setTipoMueble(TipoMueble.MESA_CAFE_CRISTAL);
        return m;
    }
    
    /**
     * Crea una mesa de dormitorio
     * @return     el mueble creado con los atributos indicados
     */
    public Mueble crearMesaDormitorio(String color, int altura, String forma, boolean cajonIncrustado){
        Mueble m = new MesaDormitorio(color, altura, forma, cajonIncrustado);
        m.setTipoMueble(TipoMueble.MESA_DORMITORIO);
        return m;
    }
    
    /**
     * Crea una mesa de comedor
     * @return     el mueble creado con los atributos indicados
     */
    public Mueble crearMesaComedor(String color, int altura, String forma, boolean extensible){
        Mueble m = new MesaComedor(color, altura, forma, extensible);
        m.setTipoMueble(TipoMueble.MESA_COMEDOR);
        return m;
    }
    
    //Crear cada tipo de silla, en cada tipo creamos un mueble del tipo pedido con sus atributos, luego le añadimos su tipo, y devolvemos ese mueble
    
    /**
     * Crea una silla de oficina con ruedas
     * @return     el mueble creado con los atributos indicados
     */
    public Mueble crearSillaOficinaRuedas(String color, int altura, boolean respaldo, int alturaReposabrazos, int numeroRuedas){
        Mueble m = new SillaOficinaRuedas(color, altura, respaldo, alturaReposabrazos, numeroRuedas);
        m.setTipoMueble(TipoMueble.SILLA_OFICINA_RUEDAS);
        return m;
    }
    
    /**
     * Crea una silla de oficina sin ruedas
     * @return     el mueble creado con los atributos indicados
     */
    public Mueble crearSillaOficinaSinRuedas(String color, int altura, boolean respaldo, int alturaReposabrazos, boolean elevador){
        Mueble m = new SillaOficinaSinRuedas(color, altura, respaldo, alturaReposabrazos, elevador);
        m.setTipoMueble(TipoMueble.SILLA_OFICINA_SIN_RUEDAS);
        return m;
    }
    
    /**
     * Crea una silla de cocina
     * @return     el mueble creado con los atributos indicados
     */
    public Mueble crearSillaCocina(String color, int altura, boolean respaldo, boolean estilizada){
        Mueble m = new SillaCocina(color, altura, respaldo, estilizada);
        m.setTipoMueble(TipoMueble.SILLA_COCINA);
        return m;
    }
    
    /**
     * Crea una silla plegable
     * @return     el mueble creado con los atributos indicados
     */
    public Mueble crearSillaPlegable(String color, int altura, boolean respaldo, boolean posavasos){
        Mueble m = new SillaPlegable(color, altura, respaldo, posavasos);
        m.setTipoMueble(TipoMueble.SILLA_PLEGABLE);
        return m;
    }
    
    // Crear un nuevo Mueble leyendo los datos
    
    /**
     * Crea un mueble (dependiendo del tipo indicado), leyendo del teclado todos los datos, que va pidiendo uno a uno, y devuelve este mueble
     * @param    tipoMuebleCreado Tipo del mueble a crear
     * @return   nuevo mueble creado, del tipo indicado en el parámetro, será null si el tipo es incorrecto
     */
    public Mueble crearMueble (TipoMueble tipoMuebleCreado) {
        Mueble m = null;
        switch (tipoMuebleCreado) {
            case MESA_CAFE_MADERA:
                m = crearMesaCafeMadera(leerColor(), leerAltura(), leerForma(), leerNumeroBases(), leerMaderaBarnizada());
                break;
            case MESA_CAFE_CRISTAL:
                m = crearMesaCafeCristal(leerColor(), leerAltura(), leerForma(), leerNumeroBases(), leerCristalTemplado());
                break;
            case MESA_DORMITORIO:
                m = crearMesaDormitorio(leerColor(), leerAltura(), leerForma(), leerCajonIncrustado());
                break;
            case MESA_COMEDOR:
                m = crearMesaComedor(leerColor(), leerAltura(), leerForma(), leerExtensible());
                break;
            case SILLA_OFICINA_RUEDAS:
                m = crearSillaOficinaRuedas(leerColor(), leerAltura(), leerRespaldo(), leerAlturaReposabrazos(), leerNumeroRuedas());
                break;
            case SILLA_OFICINA_SIN_RUEDAS:
                m = crearSillaOficinaSinRuedas(leerColor(), leerAltura(), leerRespaldo(), leerAlturaReposabrazos(), leerElevador());
                break;
            case SILLA_COCINA:
                m = crearSillaCocina(leerColor(), leerAltura(), leerRespaldo(), leerEstilizada());
                break;
            case SILLA_PLEGABLE:
                m = crearSillaPlegable(leerColor(), leerAltura(), leerRespaldo(), leerPosavasos());
                break;
            default:
            System.out.println("Tipo de mueble incorrecto, fallo creando persona.");  //Error.
            return m;
        }
        System.out.println(tipoMuebleCreado.toString() + " añadida.");      //indicamos el mueble que hemos creado por consola
        return m;
    }
    
    //Leer datos sobre los muebles, son métodos privados porque solo se usan en esta misma clase
    
    private String leerColor() {
        return analizador.leerCadenaTexto("Color del mueble: ");
    }
    
    private int leerAltura() {
        return analizador.leerEnteroTexto("Altura del mueble (en cm): ");
    }
    
    private String leerForma() {
        return analizador.leerCadenaTexto("Forma de la mesa: ");
    }
    
    private boolean leerRespaldo() {
        return analizador.leerBooleanoTexto("¿La silla tendrá respaldo?");
    }
    
    private int leerNumeroBases() {
        return  analizador.leerEnteroTexto("Número de bases que tendrá la mesa: ");
    }
    
    private boolean leerMaderaBarnizada(){
        return analizador.leerBooleanoTexto("¿Desea que la madera esté barnizada?");
    }
    
    private boolean leerCristalTemplado(){
        return analizador.leerBooleanoTexto("¿Desea que el cristal sea templado?");
    }
    
    private boolean leerCajonIncrustado(){
        return analizador.leerBooleanoTexto("¿Desea que la mesa de dormitorio lleve un cajón incrustado?");
    }
    
    private boolean leerExtensible(){
        return analizador.leerBooleanoTexto("¿Desea que la mesa de comedor sea extensible?");
    }
    
    private int leerAlturaReposabrazos(){
        return analizador.leerEnteroTexto("Altura de los reposabrazos respecto de la base de la silla (en cm): ");
    }
    
    private int leerNumeroRuedas(){
        return analizador.leerEnteroTexto("Número de ruedas que se quiere en la silla: ");
    }
    
    private boolean leerElevador(){
        return analizador.leerBooleanoTexto("¿Desea que la silla tenga elevador?");
    }
    
    private boolean leerEstilizada(){
        return analizador.leerBooleanoTexto("¿Desea que la silla de cocina esté estilizada?");
    }
    
    private boolean leerPosavasos(){
        return analizador.leerBooleanoTexto("¿Desea que la silla plegable lleve posavasos?");
    }
    
}
