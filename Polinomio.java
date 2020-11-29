
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

    public String toString()
    {

        String etiqueta="";
        Monomio auxiliar = inicio;

        if(esVacia())
        {

            return "Polinomio vacío";
        }else
        {
            etiqueta+=String.valueOf(auxiliar.getCoeficiente())+auxiliar.getVariable()+"^"+String.valueOf(auxiliar.getExponente());
            while(auxiliar.getMonomioSiguiente()!=null){

                etiqueta+="+"+String.valueOf(auxiliar.getMonomioSiguiente().getCoeficiente())+auxiliar.getMonomioSiguiente().getVariable()+"^"+auxiliar.getMonomioSiguiente().getExponente();
            auxiliar=auxiliar.getMonomioSiguiente();
        }
        }
        return etiqueta;
    }

    
    public Polinomio simplificar()
    {
    
        Polinomio resultado=new Polinomio();
        Monomio interno=inicio;
    int exponenteMaximo=inicio.getExponente();
    
    while(interno.getMonomioSiguiente()!=null)
    {
        if(interno.getMonomioSiguiente().getExponente()>exponenteMaximo)
        {
            exponenteMaximo=interno.getMonomioSiguiente().getExponente();
        }
        interno=interno.getMonomioSiguiente();
    }
    
    for(int contador=0;contador<exponenteMaximo+1;contador++)
    {
    interno=inicio;
    float coeficienteInterno=0;
         while(interno!=null)
    {
        if(interno.getExponente()==contador)
        {
            coeficienteInterno+=interno.getCoeficiente();
        }
        
        interno=interno.getMonomioSiguiente();
    }
    
    if(coeficienteInterno!=0)
    {
    resultado.agregarAlFinal(coeficienteInterno,inicio.getVariable(),contador);
    }
    }
    
    
    return resultado;
    }
    
    
}
