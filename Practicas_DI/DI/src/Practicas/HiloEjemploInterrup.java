package Practicas;

public class HiloEjemploInterrup extends Thread {

    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println("En el hilo");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Fin de hilo");
    }

    public void interrumpir() {
        interrupt();
    }

    public static void main(String[] args) {
        HiloEjemploInterrup h = new HiloEjemploInterrup();
        h.start();
        for(int i=0;i<99999999;i++){}
        h.interrumpir();
    }
}