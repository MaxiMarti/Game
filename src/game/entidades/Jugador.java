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
import javafx.animation.Animation;

/**
 *
 * @author aguan
 */
public class Jugador extends Mob{
    
    protected Animacion animDerecha;
    
    public Jugador(double x, double y, EstadoJuego estado) {
        super(new Textura(new Textura("Spritesheet_pengu"), 1, 1, 64), x, y, estado, new Animacion(4, 
                new Textura(new Textura("Spritesheet_pengu"), 2, 1, 64),
                new Textura(new Textura("Spritesheet_pengu"), 1, 1, 64),
                new Textura(new Textura("Spritesheet_pengu"), 3, 1, 64),
                new Textura(new Textura("Spritesheet_pengu"), 1, 1, 64)));
    
    }
    
    @Override
    public void tick(){
        if(InputTeclas.presionada(KeyEvent.VK_W))   saltar(15);
        if(InputTeclas.presionada(KeyEvent.VK_A)){
            dx = -5;
            new Animacion(4, 
                new Textura(new Textura("Spritesheet_pengu"), 2, 1, 64),
                new Textura(new Textura("Spritesheet_pengu"), 1, 1, 64),
                new Textura(new Textura("Spritesheet_pengu"), 3, 1, 64),
                new Textura(new Textura("Spritesheet_pengu"), 1, 1, 64));
    
        }
        if(InputTeclas.presionada(KeyEvent.VK_D))   dx = +5;
        
        //if(InputTeclas.fueSoltada(KeyEvent.VK_W)    ||  InputTeclas.fueSoltada(KeyEvent.VK_S))  dy = 0;
        if(InputTeclas.fueSoltada(KeyEvent.VK_A)    ||  InputTeclas.fueSoltada(KeyEvent.VK_D))  dx = 0;
    
        super.tick();
    }
}
