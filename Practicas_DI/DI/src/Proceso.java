import java.io.IOException;
import java.util.Arrays;

public class Proceso
{
    public static void main(String[] args) throws IOException
    {
        if (args.length <= 0)
        {
            System.err.println("Introducir programa a ejecutar");
            System.exit(-1);
        }

        ProcessBuilder pb = new ProcessBuilder(args);
        try
        {
            Process process = pb.start();
            int retorno = process.waitFor(); //El padre espera bloqueado hasta que el hijo finalice su ejecución, volviendo inmediatamente si el hijo ha finalizado con anterioridad o si alguien le interrumpe
            System.out.println("El proceso " + Arrays.toString(args) + " acabó con el valor " + retorno);
        }
        catch(IOException ex)
        {
            System.err.println("Error");
            System.exit(-1);
        }
        catch(InterruptedException ex)
        {
            System.err.println("Error");
            System.exit(-1);
        }
    }
}