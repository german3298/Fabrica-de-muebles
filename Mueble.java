
/**
 * Muebles que hace la fábrica.
 * 
 * @author Germán Rodríguez Díez
 * @version 0.1
 */
public class Mueble
{
    private String color;
    private int altura;
    private TipoMueble tipoMueble;          //Enum del tipo de mueble
    
    /**
     * Construye un mueble con el color y la altura indicados
     */
    public Mueble(String color, int altura)
    {
        this.color = color;
        this.altura = altura;
    }
    /**
     * Devuelve el color de este mueble
     * @return     El atributo color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Cambia el color de este mueble
     * @param   c  El string que será el nuevo color
     */
    public void setColor(String c) {
        color = c;
    }
    
    /**
     * Devuelve la altura de este mueble
     * @return     El atributo altura, en cm
     */
    public int getAltura() {
        return altura;
    }
    
    /**
     * Cambia la altura de este mueble
     * @param   a  Un entero positivo que será la nueva altura
     */
    public void setAltura(int a) {
        altura = a;
    }
    
    /**
     * Devuelve el tipo de mueble
     * @return     El tipo de este mueble
     */
    public TipoMueble getTipoMueble() {
        return tipoMueble;
    }
    
    /**
     * Cambiar el tipo de mueble
     * @param   tM  El nuebo tipo de mueble
     */
    public void setTipoMueble(TipoMueble tM) {
        tipoMueble = tM;
    }
    
    /**
     * Devuelve los atributos de este mueble en texto
     * @return     El tipo de mueble, el color y la altura, en un string
     */
    public String toString() {
        return getTipoMueble().toString() + ".\n\t\tColor del mueble: " + color + ".\n\t\tAltura del mueble: " + altura + " cm";
    }
}
