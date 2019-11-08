package AWT;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class ClickRaton
{
    public static void main(String[] args) throws Exception
    {
        Robot r = new Robot();
        r.mouseMove(800,10);
        r.delay(500);
        r.mousePress(InputEvent.BUTTON2_MASK);
    }
}