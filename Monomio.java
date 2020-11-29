
/**
 * Monomio es un nodo de la clase Polinomio.
 *
 * @author (David Vallejos)
 * @version (23/11/2020)
 */
public class Monomio
{
    // instance variables - replace the example below with your own
    private float coeficiente;
    private String variable;
    private int exponente;
    private Monomio monomioSiguiente;
    
    /**
     * Constructor Monomio con valores predeterminados 
     */
    public Monomio()
    {
        this.coeficiente=0;
        this.variable="x";
        this.exponente=0;
        monomioSiguiente=null;
    }

      
    //Métodos get
    
    
    /**
     *@return float
     */
    public float getCoeficiente()
    {
        return coeficiente;
    }
    
    
    /**
     *@return String
     */
    public String getVariable()
    {
        return variable;
    }
    
    /**
     *@return int 
     */
    public int getExponente()
    {
        return exponente;
    }
    
    
    /**
     *@return Monomio 
     */
    public Monomio getMonomioSiguiente()
    {
        return monomioSiguiente;
    }
    
    
    //Métodos set
    
    
    /**
     *@param int 
     */
    public void setCoeficiente(float valor)
    {
        this.coeficiente = valor;
    }

    /**
     *@param String
     */
    public void setVariable(String letra)
    {
        this.variable = letra;
    }
    
    /**
     *@param int 
     */
    public void setExponente(int valor)
    {
        this.exponente = valor;
    }
    
    /**
     *@param Monomio
     */
    public void setMonomioSiguiente(Monomio siguiente)
    {
        this.monomioSiguiente = siguiente;
    }
    
}
