
/**
 * Calculadora encargada de simplificar polinomios.
 *
 *@author (David Vallejos)
 * @version (23/11/2020)
 */
public class Calculadora
{
    private Polinomio polinomio1;
    private Polinomio polinomio2;
    private Polinomio polinomioResultado;

    public Calculadora()
    {
        polinomio1=null;
        polinomio1=null;
    }

    public void setPolinomio1(Polinomio poliInterno1)
    {
        polinomio1=poliInterno1;
    }

    public void setPolinomio2(Polinomio poliInterno2)
    {
        polinomio2=poliInterno2;
    }

    public void setPolinomioResultado(Polinomio poliInterno3)
    {
        polinomioResultado=poliInterno3;
    }

    public Polinomio getPolinomio1()
    {
        return polinomio1;
    }

    public Polinomio getPolinomio2()
    {
        return polinomio2;
    }

    public Polinomio getPolinomioResultado()
    {
        return polinomioResultado;
    }

    public Polinomio sumar(String signo)
    {
        polinomioResultado=polinomio1;
        Monomio auxiliar=new Monomio();

        if(signo.equals("+"))
        {
            auxiliar=polinomioResultado.getInicio();
            while(auxiliar.getMonomioSiguiente()!=null)
            {
                auxiliar=auxiliar.getMonomioSiguiente();
            }
            auxiliar.setMonomioSiguiente(polinomio2.getInicio());
        }else if(signo.equals("-"))
        {
            auxiliar=polinomio2.getInicio();
            polinomioResultado.agregarAlFinal(-1*auxiliar.getCoeficiente(),auxiliar.getVariable(),auxiliar.getExponente());

            while(auxiliar.getMonomioSiguiente()!=null)
            {
                polinomioResultado.agregarAlFinal(-1*auxiliar.getMonomioSiguiente().getCoeficiente(),auxiliar.getMonomioSiguiente().getVariable(),auxiliar.getMonomioSiguiente().getExponente());
                auxiliar=auxiliar.getMonomioSiguiente();
            } 
        }
        
        return polinomioResultado;
    }

    public Polinomio multiplicarPolinomios()
    {
        Monomio auxiliar=polinomio1.getInicio();

        polinomioResultado=multiplicarMonomioPolinomio(auxiliar, polinomio2);
        
        return polinomioResultado;
    }    

    public Polinomio multiplicarMonomioPolinomio(Monomio miMonomio, Polinomio miPolinomio)
    {
        Polinomio polinomioDeRetorno=new Polinomio();
       
        return polinomioDeRetorno;

    }

    public Polinomio dividir()
    {
        float nuevoCoeficiente=polinomio1.getInicio().getCoeficiente()/polinomio2.getInicio().getCoeficiente();
        int nuevoExponente=polinomio1.getInicio().getExponente()-polinomio2.getInicio().getExponente();
        polinomioResultado=new Polinomio();
        polinomioResultado.agregarAlInicio(nuevoCoeficiente,polinomio1.getInicio().getVariable(),nuevoExponente);
        return polinomioResultado;
    }

    public void operar(String operacion)
    {
        switch(operacion)
        {
            case "+": 
            sumar("+");
            break;

            case "-":
            sumar("-");
            break;

            case "*":
            multiplicarPolinomios();
            break;

            case "/":
            dividir();
            break;

            default:

            break;
        }
    }
}