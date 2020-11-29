
public class Controlador
{
    private Lector lectorInterno;
    private Escritor escritorInterno;
    private Calculadora calculadoraInterna;
    private Vista vistaInterna;

    public Controlador(Lector miLector,Escritor miEscritor,Vista miVista,Calculadora miCalculadora){
        lectorInterno=miLector;
        escritorInterno=miEscritor;
        vistaInterna=miVista;
        calculadoraInterna=miCalculadora;
    }

    public void ejecutar()
    {
        vistaInterna.seleccionEntrada();
        switch(vistaInterna.getEntradaNumericaDeUsuario())
        {
            case 0: 
            modoLecturaArchivo();
            break;

            case 1: 
            modoIngresoDirecto();
            break;

            case -1: 
            break;
        }
    }

    public void modoIngresoDirecto()
    {
        vistaInterna.seleccionOperacion();
        String texto=vistaInterna.getEntradaTextoDeUsuario();

        Polinomio [] misPolinomios=crearPolinomios(texto);

        calculadoraInterna.setPolinomio1(misPolinomios[0]);
        calculadoraInterna.setPolinomio2(misPolinomios[1]);

        String signoOperacion=descomponerTexto(texto)[2];
        calculadoraInterna.operar(signoOperacion);
        Polinomio paraImprimir=calculadoraInterna.getPolinomioResultado().simplificar();
        vistaInterna.imprimirMensaje(misPolinomios[0].toString()+"|"+signoOperacion+"|"+misPolinomios[1].toString()+"|"+paraImprimir.toString());
       escritorInterno = new Escritor ("Archivos/Resultados.txt");
        escritorInterno.escribir(misPolinomios[0].toString()+"|"+signoOperacion+"|"+misPolinomios[1].toString()+"|"+paraImprimir.toString());
        escritorInterno.cerrar();
    }

    public void modoLecturaArchivo()
    {

        vistaInterna.getNombreArchivo();
        String archivoUsuario=vistaInterna.getEntradaTextoDeUsuario();
        lectorInterno = new Lector ("Archivos/"+archivoUsuario);

        String texto=lectorInterno.leerLinea();
        Polinomio [] misPolinomios=crearPolinomios(texto);
        lectorInterno.cerrar();
        String signoOperacion=descomponerTexto(texto)[2];
        calculadoraInterna.setPolinomio1(misPolinomios[0]);
        calculadoraInterna.setPolinomio2(misPolinomios[1]);
        calculadoraInterna.operar(descomponerTexto(texto)[2]);
        Polinomio paraImprimir=calculadoraInterna.getPolinomioResultado().simplificar();
        vistaInterna.imprimirMensaje(misPolinomios[0].toString()+"|"+signoOperacion+"|"+misPolinomios[1].toString()+"|"+paraImprimir.toString());
         escritorInterno = new Escritor ("Archivos/Resultados.txt");
        escritorInterno.escribir(misPolinomios[0].toString()+"|"+signoOperacion+"|"+misPolinomios[1].toString()+"|"+paraImprimir.toString());
        escritorInterno.cerrar();
        
    }

    public Polinomio[] crearPolinomios(String miCadena)
    {
        String[] polinomio1=descomponerPolinomio(descomponerTexto(miCadena)[0]);
        String[] polinomio2=descomponerPolinomio(descomponerTexto(miCadena)[1]);

        Polinomio polinomioUno=new Polinomio();
        Polinomio polinomioDos=new Polinomio();

        for(int contador1=0;contador1<polinomio1.length;contador1++)
        {
            polinomioUno.agregarAlFinal(descomponerMonomio(polinomio1[contador1]).getCoeficiente(),descomponerMonomio(polinomio1[contador1]).getVariable(),descomponerMonomio(polinomio1[contador1]).getExponente());
        }

        for(int contador2=0;contador2<polinomio2.length;contador2++)
        {
            polinomioDos.agregarAlFinal(descomponerMonomio(polinomio2[contador2]).getCoeficiente(),descomponerMonomio(polinomio2[contador2]).getVariable(),descomponerMonomio(polinomio2[contador2]).getExponente());
        }

        Polinomio[] polinomioDeRegreso=new Polinomio[2];
        polinomioDeRegreso[0]=polinomioUno;
        polinomioDeRegreso[1]=polinomioDos;

        return polinomioDeRegreso;
    }

    /*
    descompone el texto en 3 string, los primeros 2 guardan las cadenas que se transformarán en polinomios,
    en el tercero guarda la operación que se desea realizar 
     */

    public String [] descomponerTexto(String texto)
    {
        String [] vectorPolinomios=new String[3];

        int buscadorBarras1=texto.indexOf("|");
        int buscadorBarras2=texto.lastIndexOf("|");

        vectorPolinomios[0]=texto.substring(0,buscadorBarras1);
        vectorPolinomios[1]=texto.substring(buscadorBarras2+1);
        vectorPolinomios[2]=Character.toString(texto.charAt(buscadorBarras1+1));

        return vectorPolinomios;
    }

    /*
    Genera una matriz de enteros que guarda las posiciones de los signos y en la ultima posicion el tama;o de la cadena de texto, sin incluir signos que aparecen al inicio,
     */
    public int[] posicionSignos(String texto)
    {
        int [] matrizRetorno=null;
        int cantidadSignos=0;

        for(int contador=1; contador<texto.length();contador++)
        {
            if(texto.charAt(contador)=="+".charAt(0) || texto.charAt(contador)=="-".charAt(0))
            {
                cantidadSignos++;
                if(cantidadSignos==1)
                {
                    matrizRetorno=new int[1];
                    matrizRetorno[0]=contador;
                }else
                {
                    int[] matrixAuxiliar=matrizRetorno;
                    matrizRetorno=new int[cantidadSignos];
                    for(int contadorRelleno=0;contadorRelleno<cantidadSignos-1;contadorRelleno++)
                    {
                        matrizRetorno[contadorRelleno]=matrixAuxiliar[contadorRelleno];
                    }

                    matrizRetorno[cantidadSignos-1]=contador;
                }

            }
        }

        int[] matrixAuxiliar=matrizRetorno;
        matrizRetorno=new int[cantidadSignos+1];

        for(int contadorRelleno=0;contadorRelleno<cantidadSignos;contadorRelleno++)
        {
            matrizRetorno[contadorRelleno]=matrixAuxiliar[contadorRelleno];
        }

        matrizRetorno[cantidadSignos]=texto.length();

        return matrizRetorno;

    }

    /*
    Genera una matriz de string que guarda los terminos en una cadena, realizando la separacion por sumas y restas
     */
    public String[] descomponerPolinomio(String miTexto)
    {
        int [] misPosiciones=posicionSignos(miTexto);
        String[] matrizMonomios=new String[1];

        if(misPosiciones==null)
        {
            matrizMonomios[0]=miTexto;
        }else
        {
            matrizMonomios=new String[misPosiciones.length];
            matrizMonomios[0]=miTexto.substring(0,misPosiciones[0]);

            for(int contador1=0; contador1<misPosiciones.length-1;contador1++)
            {
                if("+".equals(Character.toString(miTexto.charAt(misPosiciones[contador1]))))
                {
                    matrizMonomios[contador1+1]=miTexto.substring(misPosiciones[contador1]+1,misPosiciones[contador1+1]);

                }
                if("-".equals(Character.toString(miTexto.charAt(misPosiciones[contador1]))))
                {
                    matrizMonomios[contador1+1]=miTexto.substring(misPosiciones[contador1],misPosiciones[contador1+1]);
                }
            }

        }

        return matrizMonomios;
    }

    /*
    Genera un objeto monomio a partir de un String de la forma ax^n
     */
    public Monomio descomponerMonomio(String miTexto)
    {
        int buscador;
        Monomio monomioInterno=new Monomio();
        buscador=miTexto.indexOf("^");
        monomioInterno.setCoeficiente(Integer.valueOf(miTexto.substring(0,buscador-1)));
        monomioInterno.setVariable(Character.toString(miTexto.charAt(buscador-1)));
        monomioInterno.setExponente(Integer.valueOf(miTexto.substring(buscador+1)));
        return monomioInterno;
    }

}
