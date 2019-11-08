package ejemploSychronized;

public class CompartirInfl {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Contador c = new Contador(500);

        HiloA a = new HiloA("HiloA", c);
        HiloB b = new HiloB("HiloB", c);
        a.start();
        b.start();
    }

}