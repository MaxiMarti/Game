/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entidades;

import game.estados.EstadoJuego;
import game.mundo.Tile;
import game.renderizado.texturas.Sprite;

/**
 *
 * @author aguan
 */
public abstract class Mob extends Entidad {
    
    protected double dx, dy;
    
    public Mob(Sprite sprite, double x, double y, EstadoJuego estado) {
        super(sprite, x, y, estado);
    }
    
    @Override
    public void tick(){
        mover();
    }
    
    public void mover(){
        if(!tieneColisionHorizontal())
                x += dx;
        if(!tieneColisionVertical())
            y += dy;
    }
    
    protected boolean tieneColisionVertical(){
        for(int i = 0; i < estado.getTiles().size(); i++){
            Tile t = estado.getTiles().get(i);
            if(getLimites().intersects(t.getArriba()) && dy > 0) {
                dy = 0;
                return true;
            }
            if(getLimites().intersects(t.getAbajo()) && dy < 0){
                dy = 0;
                return true;
            }
        }
        return false;
    }
    
    protected boolean tieneColisionHorizontal(){
        for(int i = 0; i < estado.getTiles().size(); i++){
            Tile t = estado.getTiles().get(i);
            if(getLimites().intersects(t.getDerecha()) && dx < 0) {
                dx = 0;
                return true;
            }
            if(getLimites().intersects(t.getIzquierda()) && dx > 0){
                dx = 0;
                return true;
            }
        }
        return false;
    }
}
