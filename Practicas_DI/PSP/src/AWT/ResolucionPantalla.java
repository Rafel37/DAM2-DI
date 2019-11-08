package AWT;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.*;

public class ResolucionPantalla
{
    public static void main(String[] args) throws Exception
    {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        System.out.println("(" + gd.getDisplayMode().getWidth() +  " x " + gd.getDisplayMode().getHeight() + ")");
    }
}