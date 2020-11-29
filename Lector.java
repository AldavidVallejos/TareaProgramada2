import java.io.*;

public class Lector
{
    private BufferedReader lector;
    private boolean enUso;

    public Lector(String ruta)
    {
        try
        {
            lector = new BufferedReader( new FileReader(ruta));
            enUso = true;
        }
        catch(IOException e)
        {
            enUso = false;
            System.out.println("Error " + e);
        }
    }
    
    public void cerrar()
    {
        if(enUso)
        {
            try
            {
                lector.close();
            }
            catch(IOException e)
            {
                System.out.println("Error " + e);
            }
        }
        
        enUso = false;
    }
    
    public String leerLinea()
    {
        String contenido = null;
        
        if(enUso)
        {
            try
            {
                contenido = lector.readLine();
            }
            catch(IOException e)
            {
                System.out.println("Error " + e);
            }
        }
        
        return contenido;
    }
    
    public String leerArchivo()
    {
        String contenido = "";
        
	if(enUso){
		String linea = "";
		while((linea = leerLinea()) != null){
			contenido += linea;
			contenido += "\r\n";
		}
	}
	return contenido;
    }
}
