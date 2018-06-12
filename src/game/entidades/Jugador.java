/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entidades;

import com.sun.glass.events.KeyEvent;
import game.estados.EstadoJuego;
import game.input.InputTeclas;
import game.renderizado.texturas.Sprite;

/**
 *
 * @author aguan
 */
public class Jugador extends Mob{
    
    public Jugador(Sprite sprite, double x, double y, EstadoJuego estado) {
        super(sprite, x, y, estado);
    }
    
    @Override
    public void tick(){
        if(InputTeclas.presionada(KeyEvent.VK_W))   dy = -2;
        if(InputTeclas.presionada(KeyEvent.VK_S))   dy = +2;
        if(InputTeclas.presionada(KeyEvent.VK_A))   dx = -2;
        if(InputTeclas.presionada(KeyEvent.VK_D))   dx = +2;
        
        if(InputTeclas.fueSoltada(KeyEvent.VK_W)    ||  InputTeclas.fueSoltada(KeyEvent.VK_S))  dy = 0;
        if(InputTeclas.fueSoltada(KeyEvent.VK_A)    ||  InputTeclas.fueSoltada(KeyEvent.VK_D))  dx = 0;
    
        super.tick();
    }
}
