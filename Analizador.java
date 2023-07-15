import java.util.Scanner;
/**
 * Clase que lee y analiza los datos introducidos con teclado.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */

public class Analizador
{
    
    private enum DatosLectura {
        BOOL, INT, STRING
    }
    
    private Scanner sc;
    /**
     * Construye un analizador con su objeto scanner para leer datos del usuario
     */
    public Analizador()
    {
        sc = new Scanner(System.in);
    }
    
    //Métodos para hacer una pregunta y luego devolver cada tipo de dato
    
     /**
     * Muestra por terminal un texto
     * enviado por parámetro, y luego analiza datos
     * introducidos para devolver una respuesta.
     * 
     * @param      texto Un texto, que se mostrará por terminal antes de la lectura de la cadena.
     * @return     Un string correcto para el sistema, que servirá de respuesta al texto.
     */
    public String leerCadenaTexto(String texto){
        System.out.println(texto);
        return leerCadena();
    }
    
    /**
     * Muestra por terminal un texto
     * enviado por parámetro, y luego analiza datos
     * introducidos para devolver una respuesta.
     * 
     * @param      texto Un texto, que se mostrará por terminal antes de la lectura de el entero.
     * @return     Un entero correcto para el sistema, que servirá de respuesta al texto.
     */
    public int leerEnteroTexto(String texto){
        System.out.println(texto);
        return leerEntero();
    }
    
    /**
     * Muestra por terminal un texto
     * enviada por parámetro, y luego analiza datos
     * introducidos para devolver una respuesta.
     * 
     * @param      texto Un texto, que se mostrará por terminal antes de la lectura de la cadena.
     * @return     Un booleano, que servirá de respuesta al texto.
     */
    public boolean leerBooleanoTexto(String texto){
        System.out.println(texto);
        return leerBooleano();
    }
    
    /**
     * Con el límite como máximo de opciones, lee una opción del 0 al límite,
     * volviendo a leer un entero hasta que se introduzca uno en rango correcto.
     * 
     * @param      limite Debe ser mayor que 0. Es el número de opciones totales.
     * @return     Un entero introducido por el usuario, menor que el límite, y que no es negativo.
     */
    public int leerOpcion(int limite){
        int entero = 0;
        String cadena;
        boolean terminar = false;
        
        if (limite < 0) {
            System.err.println("El límite introducido debe ser mayor de 0. Devolviendo 0 como opción.");
            return 0;
        }
        
        System.out.println("Inserte opción: ");
        do {
            cadena = sc.nextLine();                 //Asignamos al String cadena una línea escrita con teclado
            cadena = cadena.trim();                 //Quitamos espacios al final y al principio del string
            /*Comprobamos que la cadena sea un número entero sin espacios
            //entre si, y que sea menor que el parámetro limite y mayor o
            igual que 0*/
            if (isNumeroEntero(cadena) && Integer.parseInt(cadena) < limite && Integer.parseInt(cadena) >= 0){         
                terminar = true;
            } else {
                System.out.println("Opción no válida, introduzca un número entre 0 y "+ (limite-1) + ": ");
            }
        } while (!terminar);
        //Convertimos la cadena en entero, que ya sabemos que
        //es un entero sin espacios (y dentro del rango).
        entero = Integer.parseInt (cadena);                 
        return entero;
    }
    
    /**
     * Devuelve una cadena leída por teclado, que no es un cáracter en blanco.
     * 
     * @return     Una cadena ya analizada introducida por el usuario (menos de 25 carácteres).
     */
    public String leerCadena(){
        DatosLectura datos = DatosLectura.STRING;
        String cadena = analizadorDeCadenas(datos);     //Envíamos la cadena al analizador
        return cadena;
    }

    /**
     * Devuelve un entero leído de un String por teclado, positivo.
     * 
     * @return     Un entero ya analizado introducido por el usuario (menos de 25 dígitos)
     */
    public int leerEntero(){
        int entero = 0;
        DatosLectura datos = DatosLectura.INT;
        String cadena;

        System.out.println("(Inserte número entero)");
        cadena = analizadorDeCadenas(datos);     //Envíamos la cadena al analizador
        entero = Integer.parseInt (cadena);      //Convertimos la cadena en entero, que ya sabemos que es un entero sin espacios
        return entero;
    }

    /**
     * Devuelve un booleano leído de un String introducido por teclado.
     * 
     * @return     True si ha escrito "sí" y false si ha escrito "no"
     */
    public boolean leerBooleano(){
        DatosLectura datos = DatosLectura.BOOL;
        String cadena;

        System.out.println("(Inserte 'Sí' o 'No')");        
        cadena = analizadorDeCadenas(datos);                //Envíamos la cadena al analizador

        if (cadena.equals("no")){                           //Como ya sabemos que la cadena será "si" o "no" en minúsculas, devolvemos el booleano en consecuencia
            return false;
        }
        return true;
    }

    /**
     * Devuelve una cadena analizada, con longitud correcta, y adaptada a cada tipo pedido (string, entero o booleano).
     * 
     * @param datos  El tipo de datos al que se quiere transformar este String una vez devuelto.
     * @return     String de menos de 25 caracteres, que cada tipo de dato necesita (String normal, entero sin espacios,"si" o "no" para los booleanos)
     */
    private String analizadorDeCadenas(DatosLectura datos){
        boolean terminar = false;
        String cadena;
        do {
            cadena = sc.nextLine();                         //Asignamos al String cadena una línea escrita con teclado
            if (cadena.length() > 25) {
                System.out.println("Por favor, inserte menos de 25 caracteres: ");
            } else {
                cadena = cadena.trim();                     //Quitamos espacios al final y al principio del string
                
                switch (datos) {
                    case STRING:
                        if (!cadena.equals("")) {
                            terminar = true;
                        } else {
                            System.out.println("La cadena no puede estar vacía o formada solo por espacios.");
                        }
                    break;
                    case INT:
                        if (isNumeroEntero(cadena) && isNumeroPositivo(cadena)){
                            terminar = true;
                        } else {
                            System.out.println("Debe escribir un número entero y positivo, sin espacios: ");
                        } 
                    break;
                    case BOOL:
                        cadena = cadena.toLowerCase();      //Cambiamos el string a minúsculas, para comprobar el booleano así
                        if (isBooleano(cadena)) {
                            terminar = true;
                        } else {
                            System.out.println("Por favor, inserte solamente 'Sí' o 'No': ");
                        }
                    break;
                }
            }
        } while (!terminar);
        return cadena;
    }

    /**
     * Comprueba que un string es un número entero.
     * 
     * @param  cadena  El string a analizar
     * @return     Devuelve true si es un entero, y false si no lo es
     */
    private boolean isNumeroEntero(String cadena) {
        boolean esNumero = false;
        try {
            Integer.parseInt(cadena);                 //Este método dará una excepción si la cadena no es un número entero sin espacios
            esNumero = true;
        } catch (NumberFormatException e) {
            esNumero = false;
        }
        return esNumero;
    }
    
    /**
     * Comprueba que un string es un número positivo, mayor que 0.
     * 
     * @param  cadena  El string a analizar, debe ser un entero confirmado
     * @return     Devuelve true si es positivo, y false si no lo es
     */
    private boolean isNumeroPositivo(String cadena) {
        return Integer.parseInt(cadena) > 0;
    }

    /**
     * Comprueba que un string es "si" o "no".
     * 
     * @param  cadena  El string a analizar, debe estar convertido en minúsculas.
     * @return     Devuelve true si es una respuesta válida (si, no), y false si no lo es.
     */
    private boolean isBooleano(String cadena) {
        if (cadena.equals("si") || cadena.equals("no") || cadena.equals("sí")) {
            return true;
        }
        return false;
    }
}
