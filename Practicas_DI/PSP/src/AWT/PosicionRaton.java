package AWT;

import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class PosicionRaton
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("(" + MouseInfo.getPointerInfo().getLocation().x +  ", " + MouseInfo.getPointerInfo().getLocation().y + ")");
    }
}