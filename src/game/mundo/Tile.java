/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.mundo;

import game.renderizado.texturas.Textura;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aguan
 */
public class Tile {
    
    private static final Textura TERRENO = new Textura("Spritesheet_terreno");
    private static final Map<Integer, Tile> TILE_MAP = new HashMap<Integer, Tile>();
    protected float x, y;
    protected Textura sprite;
    protected boolean solido;
    protected int id;
    
    public static final Tile TILE1 = new Tile(0xFFFFFFFF, new Textura(TERRENO, 1, 1, 64));
    public static final Tile TILE2 = new Tile(0xFFFF0000, new Textura(TERRENO, 1, 2, 64));
    
    private Tile(int id, Textura sprite){
        this.id = id;
        this.sprite = sprite;
        TILE_MAP.put(id, this);
    }
    
    public Tile(int id, int x, int y){
        this.sprite = getDesdeID(id).sprite;
        this.x = x * sprite.getAncho();
        this.y = y * sprite.getAlto();
        this.solido = true;
    }
    
    public void render(Graphics2D g){
        sprite.render(g, x, y);
/*        g.setColor(Color.red);
        g.draw(getArriba());
        g.setColor(Color.blue);
        g.draw(getAbajo());
        g.setColor(Color.white);
        g.draw(getDerecha());
        g.setColor(Color.orange);
        g.draw(getIzquierda());
*/    }
    
    
    
    public Rectangle getLimites(){
        return new Rectangle(   (int)x,                             (int)y, 
                                sprite.getAncho(),                  sprite.getAlto());
    }
    
    public Rectangle getArriba(){
        return new Rectangle(   (int)x + 3,                             (int)y, 
                                sprite.getAncho() - 6,                  6);
    }
    
    public Rectangle getAbajo(){
        return new Rectangle(   (int)x + 4,                         (int) y + sprite.getAlto() - 4, 
                                sprite.getAncho() - 10,              4);
    }
    
    public Rectangle getDerecha(){
        return new Rectangle(   (int) x +sprite.getAncho() - 4,     (int)y + 6, 
                                4,                                  sprite.getAlto() - 10);
    }
    
    public Rectangle getIzquierda(){
        return new Rectangle(   (int)x,                             (int)y + 6, 
                                4,                                  sprite.getAlto() - 10);
    }
    
    public static Tile getDesdeID(int id){
        return TILE_MAP.get(id);
    }
    
}
