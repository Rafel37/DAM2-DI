import javax.swing.*;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main m = new Main();
                m.setVisible(true);;
            }
        });
    }
}