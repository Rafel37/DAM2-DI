
import java.io.*;

public class Atributo implements Serializable
{
    /** Primer atributo, un int */
    int a = 3;

    /** Segundo atributo, un String */
    String b = "Atributo.d";

    /**  Método para devolver un String que represente los valores de los
     * atributos */
    public String toString()
    {
        return Integer.toString(a) + " -- " + b;
    }

    /*******
     *
     * LOS SIGUIENTES MÉTODOS SON INNECESARIOS SALVO QUE QUERAMOS QUE SE
     * ENVIEN Y RECIBAN LOS DATOS DE FORMA NO STANDARD.
     * Puedes descomentarlos y todo funcionará exactamente igual
     *
     *******/
     /*
     private void writeObject(java.io.ObjectOutputStream out)
         throws IOException
     {
         out.writeInt (a);
         out.writeUTF (b);
     }*/

     /*
     private void readObject(java.io.ObjectInputStream in)
     throws IOException, ClassNotFoundException
     {
         a = in.readInt();
         b = in.readUTF();
     }*/
}
