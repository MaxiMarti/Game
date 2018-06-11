/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Alumno
 */
public class InputMouse extends MouseAdapter{
    
    private static final int NUM_BOTONES = 5;
    
    private static final boolean[] BOTON = new boolean[NUM_BOTONES];
    private static final boolean[] ULTIMO_BOTON = new boolean[NUM_BOTONES];
    private static int x = -1, y = -1;
    private static int ultX = x, ultY = y;
    private static boolean moviendo = false;
    
    @Override
    public void mousePressed(MouseEvent e){
        BOTON[e.getButton()] = true;
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        BOTON[e.getButton()] = false;
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        super.mouseDragged(e);
    }
    
    @Override
    public void mouseMoved(MouseEvent e){
        x = e.getX();
        y = e.getY();
        moviendo = true;
    }
    
    public static void actualizacion(){
        for(int i = 0; i < NUM_BOTONES; i++){
            ULTIMO_BOTON[i] = BOTON[i];
        }
        if(x == ultX && y == ultY) moviendo = false;
        ultX = x;
        ultY = y;
    }
    
    public static boolean presionado(int boton){
        return BOTON[boton];
    }
    
    public static boolean fuePresionado(int boton){
        return presionado(boton) && !ULTIMO_BOTON[boton];
    }
    
    public static boolean fueSoltado(int boton){
        return !presionado(boton) && ULTIMO_BOTON[boton];
    }
    
    public static boolean moviendose(){
        return moviendo;
    }
    
    public static boolean arrastrandose(int boton){
        return moviendo && presionado(boton);
    }
    
    public static int getX(){
        return x;
    }
    
    public static int getY(){
        return y;
    }
    
}
