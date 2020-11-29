import javax.swing.JOptionPane;

public class Vista
{
     // matriz de botones para seleccionar el modo de juego
    Object[]botones={"Lectura desde el archivo","Entrada directa", "Salir"};

    Object[]botones2={"+","-", "*","/"};
    
    //variable encargada de recolectar la información numérica del usuario
    private int entradaNumericaDeUsuario;

    //variable encargada de recolectar la información de texto del usuario
    private String entradaTextoDeUsuario="vacio";

    /**
     * Permite acceder a la entradaNumericaDeUsuario
     * @return int
     */
    public int getEntradaNumericaDeUsuario(){
        return entradaNumericaDeUsuario;
    }

    /**
     * Permite asignar la entradaNumericaDeUsuario
     * @return
     */
    public void setEntradaNumericaDeUsuario(int nuevaEntradaNumerica){
        this.entradaNumericaDeUsuario=nuevaEntradaNumerica;
    }

    /**
     * Permite acceder a la entradaTextoDeUsuario
     * @return String
     */
    public String getEntradaTextoDeUsuario(){
        return entradaTextoDeUsuario;
    }

    /**
     * Permite asignar la entradaTextoDeUsuario
     * @return
     */
    public void setEntradaTextoDeUsuario(String nuevaEntradaTexto){
        this.entradaTextoDeUsuario=nuevaEntradaTexto;
    }

    /**
     * Constructor por defecto de la clase
     */
    public Vista()
    {
    }

    /**
     * Menú para seleccionar el programa que se quiere verificar
     */
    public void seleccionEntrada()
    {
        entradaNumericaDeUsuario=JOptionPane.showOptionDialog(null, "Seleccione la forma en la que desea ingresar la información:",
            "Operaciones con polinomios",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,botones,botones[0]);    

    }
    
    public void seleccionOperacion()
    {
        entradaTextoDeUsuario=JOptionPane.showInputDialog(null, "Ingrese la operación que desea realizar. Utilice el formato P(x)|operación|Q(x)"+
        "\n Como operaciones puede usar * para multiplicación, / para división, + para suma y - para resta"+
        "\n Para escribir los polinomios use el formato ax^n para cada término, con n entero y a entero");
    }
    
    public void imprimirMensaje(String mensaje)
    {
    JOptionPane.showMessageDialog(null,mensaje);
}

public void getNombreArchivo()
{
entradaTextoDeUsuario=JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo que desea leer con el formato: nombre.txt");
}
}