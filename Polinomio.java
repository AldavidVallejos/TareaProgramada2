
/**
 * Polinomio es una lista enlazada de nodos de la clase Monomio.
 *
 * @author (David Vallejos)
 * @version (23/11/2020)
 */
public class Polinomio{

    // instance variables - replace the example below with your own
    private Monomio inicio;
    private int tamanio;

    public void Polinomio()
    {
        inicio = null;
        tamanio = 0;
    }

    public boolean esVacia()
    {
        return inicio == null;
    }

    public int getTamanio()
    {
        return tamanio;
    }

    public Monomio getInicio()
    {
        return inicio;
    }
    
    public void agregarAlFinal(float valor, String letra, int grado)
    {
        Monomio nuevoMonomio = new Monomio();
        nuevoMonomio.setCoeficiente(valor);
        nuevoMonomio.setVariable(letra);
        nuevoMonomio.setExponente(grado);

        if(esVacia())
        {
            inicio = nuevoMonomio;
        }
        else
        {
            Monomio aux = inicio;

            while(aux.getMonomioSiguiente() != null)
            {
                aux = aux.getMonomioSiguiente();
            }

            aux.setMonomioSiguiente(nuevoMonomio);
        }

        tamanio++;
    }

    public void agregarAlInicio(float valor, String letra, int grado)
    {
        Monomio nuevoMonomio = new Monomio();
        nuevoMonomio.setCoeficiente(valor);
        nuevoMonomio.setVariable(letra);
        nuevoMonomio.setExponente(grado);

        if(esVacia())
        {
            inicio = nuevoMonomio;
        }
        else
        {
            nuevoMonomio.setMonomioSiguiente(inicio);
            inicio = nuevoMonomio;
        }

        tamanio++;
    }

    
    
}
