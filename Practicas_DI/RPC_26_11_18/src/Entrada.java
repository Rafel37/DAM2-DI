import javax.swing.*;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Registro v = new Registro();
                Modelo m = new Modelo();
                v.setVisible(true);
            }
        });
    }
}
