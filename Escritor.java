import java.io.*;

public class Escritor
{
    private BufferedWriter escritor;
    private boolean enUso;
    
    public Escritor(String ruta, boolean agregarAlFinal)
    {
        abrir(ruta, agregarAlFinal);
    }
    
    public Escritor(String ruta)
    {
        abrir(ruta, true);
    }
    
    public void abrir(String ruta, boolean agregarAlFinal)
    {
        try{
            escritor = new BufferedWriter(new FileWriter(ruta, agregarAlFinal));
            enUso = true;
        }   
        catch(IOException e)
        {
            enUso = false;
            System.err.println("Ocurrio un error al abrir el archivo: "+ e);
        }
    }
    
    public void cerrar()
    {
        if(enUso)
        {
            try
            {
                escritor.close();
            }
            catch(IOException e)
            {
                System.out.println("Error " + e);
            }
        }
        
        enUso = false;
    }
    
    public boolean escribir(String texto)
    {
        boolean escrito = false;
        
        if(enUso)
        {
            try
            {
                escritor.write(texto);
                escrito = true;
            }
            catch(IOException e)
            {
                System.out.println("Error " + e);
            }
        }
        
        return escrito;
    }
}
