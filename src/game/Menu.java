/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.input.InputMouse;
import game.input.InputTeclas;
import game.renderizado.iu.Boton;
import game.utils.Fuentes;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author aguan
 */
public class Menu {
    
    private final Boton[] opciones;
    private int seleccion; // subindice de opciones
    
    public Menu(){
        opciones = new Boton[3];
        opciones[0] = new Boton ("Jugar", 200 + 0 * 80, new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48), Color.white, Color.red);
        opciones[1] = new Boton ("Opciones", 200 + 1 * 80, new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48), Color.white, Color.red);
        opciones[2] = new Boton ("Salir", 200 + 2 * 80, new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48), Color.white, Color.red);
    }

    public void tick(){
        boolean clickeado = false;
        
        if(InputTeclas.fuePresionada(KeyEvent.VK_UP) || InputTeclas.fuePresionada(KeyEvent.VK_W)){
            seleccion--;
            if(seleccion < 0)
                seleccion = opciones.length - 1;
        }
        if(InputTeclas.fuePresionada(KeyEvent.VK_DOWN) || InputTeclas.fuePresionada(KeyEvent.VK_S)){
            seleccion++;
            if(seleccion >= opciones.length)
                seleccion = 0;
        }
        
        for(int i = 0; i < opciones.length; i++){
            if(opciones[i].intersects(new Rectangle(InputMouse.getX(), InputMouse.getY(), 1, 1))){
                seleccion = i;
                clickeado = InputMouse.fuePresionado(MouseEvent.BUTTON1);
            }
        }
        
        if(clickeado || InputTeclas.fuePresionada(KeyEvent.VK_ENTER))
            seleccionar();
    }
    
    private void seleccionar(){
        switch(seleccion){
            case 0:
                System.out.println("Jugar");
                break;
            case 1:
                System.out.println("Opciones");
                break;
            case 2:
                System.out.println("Salir");
                Pengu.INSTANCIA.stop();
                break;
        }
    }
    
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Pengu.ANCHO, Pengu.ALTO);
        Fuentes.drawString(g, new Font("Arial", Font.BOLD, 72), Color.yellow, Pengu.TITULO, 80);
        
        for(int i = 0; i < opciones.length; i++){
            if(i == seleccion)
                opciones[i].setSeleccionado(true);
            else
                opciones[i].setSeleccionado(false);
            
            opciones[i].render(g);
                
        }
    }
}


