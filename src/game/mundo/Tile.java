/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.mundo;

import game.renderizado.texturas.Sprite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author aguan
 */
public class Tile {
    
    protected float x, y;
    protected Sprite sprite;
    protected boolean solido;
    
    public Tile(float x, float y, Sprite sprite){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.solido = true;
    }
    
    public void render(Graphics2D g){
        sprite.render(g, x, y);
        g.setColor(Color.red);
        g.draw(getArriba());
        g.setColor(Color.blue);
        g.draw(getAbajo());
        g.setColor(Color.magenta);
        g.draw(getDerecha());
        g.setColor(Color.orange);
        g.draw(getIzquierda());
        g.setColor(Color.YELLOW);
    }
    
    
    
    public Rectangle getLimites(){
        return new Rectangle(   (int)x,                             (int)y, 
                                sprite.getAncho(),                  sprite.getAlto());
    }
    
    public Rectangle getArriba(){
        return new Rectangle(   (int)x + 6,                         (int)y, 
                                sprite.getAncho() - 6,              4);
    }
    
    public Rectangle getAbajo(){
        return new Rectangle(   (int)x + 6,                         (int) y + sprite.getAlto() - 4, 
                                sprite.getAncho() - 6,              4);
    }
    
    public Rectangle getDerecha(){
        return new Rectangle(   (int) x +sprite.getAncho() - 4,     (int)y + 4, 
                                4,                                  sprite.getAlto() - 6);
    }
    
    public Rectangle getIzquierda(){
        return new Rectangle(   (int)x,                             (int)y + 6, 
                                4,                                  sprite.getAlto() - 6);
    }
    
    
    
}
