package AWT;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class MoverRaton
{
    public static void main(String[] args) throws Exception
    {
        Robot r = new Robot();
        r.mouseMove(700,500);
        r.delay(500);
        r.mouseMove(800,500);
        r.delay(500);
        r.mouseMove(900,500);
        r.delay(500);
        r.mouseMove(1000,500);
        r.delay(500);
        r.mouseMove(1100,500);
        r.delay(500);
        r.mouseMove(1200,500);
        r.delay(500);


        r.mouseMove(700,500);
        r.delay(500);
        r.mouseMove(800,500);
        r.delay(500);
        r.mouseMove(900,500);
        r.delay(500);
        r.mouseMove(1000,500);
        r.delay(500);
        r.mouseMove(1100,500);
        r.delay(500);
        r.mouseMove(1200,500);
        r.delay(500);
    }
}