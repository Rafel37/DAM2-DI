
import java.io.*;

public class DatoSocket implements Serializable
{
    /** Primer atributo, un int */
    public int c = 45;

    /** Segundo atributo, un String */
    public String d = "DatoSocket.d";

    /** Tercer atributo, una clase Serializable */
    Atributo e = new Atributo();

    /** Método para devolver un String en el que se represente el valor de
     * todos los atributos. */
    public String toString ()
    {
        String resultado;
        resultado = Integer.toString(c) +
                " -- " + d + " -- " + e.toString();
        return resultado;
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
         out.writeInt (c);
         out.writeUTF (d);
         out.writeInt (e.a);
         out.writeUTF (e.b);
     }*/

     /*
     private void readObject(java.io.ObjectInputStream in)
     throws IOException, ClassNotFoundException
     {
         c = in.readInt();
         d = in.readUTF();
         if (e==null) e = new Atributo();
         e.a = in.readInt();
         e.b = in.readUTF();
     }*/
}
