
/**
 * Clase del método main que inicializa la ejecución.
 *
 * @author (David Vallejos)
 * @version (23/11/2020)
 */
public class Principal
{
   
    
    public static void main (String args [])
    {
    Lector miLector=new Lector("Prueba.txt");
    Escritor miEscritor=new Escritor("Prueba.txt");
    Calculadora miCalculadora=new Calculadora();
    Vista miVista=new Vista();
    
    Controlador miControlador=new Controlador(miLector,miEscritor,miVista,miCalculadora);
    miControlador.ejecutar();  
   
    }
}
