package AWT;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class TeclaAuto
{
    public static void main(String[] args) throws Exception
    {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_WINDOWS);
        r.keyRelease(KeyEvent.VK_WINDOWS);
    }
}