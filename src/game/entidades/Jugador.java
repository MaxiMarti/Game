/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entidades;

import com.sun.glass.events.KeyEvent;
import game.estados.EstadoJuego;
import game.input.InputTeclas;
import game.renderizado.texturas.Animacion;
import game.renderizado.texturas.Textura;
import java.awt.Graphics2D;
import javafx.animation.Animation;

/**
 *
 * @author aguan
 */
public class Jugador extends Mob{
    
    protected Proyectil proyectil;
    
    public Jugador(double x, double y, EstadoJuego estado) {
        super(new Textura(new Textura("Spritesheet_pengu"), 1, 1, 64), x, y, estado, null);
        proyectil = (new Proyectil(new Textura(new Textura("Machete"), 1, 1, 16, 8), x, y, estado));
    
    }
    
    public int mirar(){
        if(InputTeclas.fuePresionada(KeyEvent.VK_D))
            return 1;
        else if(InputTeclas.fuePresionada(KeyEvent.VK_A))
            return 2;
        else return 0;
    }
    
    @Override
    public void tick(){
        if(InputTeclas.presionada(KeyEvent.VK_W))   saltar(15);
        if(InputTeclas.presionada(KeyEvent.VK_A))   dx = -5;
        if(InputTeclas.presionada(KeyEvent.VK_D))   dx = +5;
//        if(InputTeclas.fuePresionada(KeyEvent.VK_SPACE)) disparar();
        
        
        //if(InputTeclas.fueSoltada(KeyEvent.VK_W)    ||  InputTeclas.fueSoltada(KeyEvent.VK_S))  dy = 0;
        if(InputTeclas.fueSoltada(KeyEvent.VK_A)    ||  InputTeclas.fueSoltada(KeyEvent.VK_D))  dx = 0;
    
        super.tick();
    }

//    @Override
//    protected void disparar() {
//        super.disparar();
//    }
    
    protected double getY(){
        return  y;
    }
    
    protected double getX(){
        return  x;
    }
}
