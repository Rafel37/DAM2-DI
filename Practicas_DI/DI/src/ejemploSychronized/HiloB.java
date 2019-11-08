
package ejemploSychronized;

public class HiloB extends Thread{

    private Contador contador;

    public HiloB(String n, Contador c)
    {
        setName(n);
        contador = c;
    }

    public void run()
    {
        synchronized (contador) {
            for (int i = 0; i < 400; i++) {
                contador.incrementa();
            }
            System.out.println(getName() + " contador vale: " + contador.getValor());

        }
    }
}
