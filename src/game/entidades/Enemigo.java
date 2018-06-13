/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entidades;

import game.estados.EstadoJuego;
import game.renderizado.texturas.Textura;
import java.awt.Rectangle;

/**
 *
 * @author aguan
 */
public class Enemigo extends Mob{

    private final Textura sprite;
    protected int id;

    public Enemigo(Textura sprite, int x, int y, EstadoJuego estado) {
        super(sprite = new Textura(new Textura("Ventana_azul"), 1, 1, 64), x, y, estado, null);
        this.sprite = sprite;
        id = 1;
    }

    @Override
    public Rectangle getLimites(){
        return new Rectangle(   (int)x,                             (int)y, 
                                sprite.getAncho(),                  sprite.getAlto());
    }
    
    @Override
    public Rectangle getArriba(){
        return new Rectangle(   (int)x + 3,                             (int)y, 
                                sprite.getAncho() - 6,                  6);
    }
    
    @Override
    public Rectangle getAbajo(){
        return new Rectangle(   (int)x + 4,                         (int) y + sprite.getAlto() - 4, 
                                sprite.getAncho() - 10,              4);
    }
    
    @Override
    public Rectangle getDerecha(){
        return new Rectangle(   (int) x +sprite.getAncho() - 4,     (int)y + 6, 
                                4,                                  sprite.getAlto() - 10);
    }
    
    @Override
    public Rectangle getIzquierda(){
        return new Rectangle(   (int)x,                             (int)y + 6, 
                                4,                                  sprite.getAlto() - 10);
    }
    
}
