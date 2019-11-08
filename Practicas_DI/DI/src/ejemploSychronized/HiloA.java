package ejemploSychronized;

public class HiloA extends Thread {
    private Contador contador;
    public HiloA(String n, Contador c)
    {
        setName(n);
        this.contador = c;
    }

    public void run()
    {
        synchronized (contador) {
            for (int i = 0; i < 300; i++) {
                contador.decrementa();
            }
            System.out.println(getName() + " contador vale: " + contador.getValor());

        }
    }

}