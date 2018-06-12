/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entidades;

import game.estados.EstadoJuego;
import game.mundo.Tile;
import game.renderizado.texturas.Animacion;
import game.renderizado.texturas.Textura;
import java.awt.Graphics2D;

/**
 *
 * @author aguan
 */
public abstract class Mob extends Entidad {
    
    protected double dx, dy;
    protected double maxDY;
    protected double gravedad;
    protected boolean cayendo;
    protected boolean puedeSaltar;
    protected boolean moviendose;
    protected Animacion animDerecha;
    
    public Mob(Textura textura, double x, double y, EstadoJuego estado, Animacion anim) {
        super(textura, x, y, estado);
        animDerecha = anim;
        
        cayendo = true;
        gravedad = 0.5;
        maxDY = 12;
    }
    
    @Override
    public void tick(){
        mover();
        caer();
        if(dx != 0) 
            moviendose = true;
        else
            moviendose = false;
        if(moviendose)
            animDerecha.andar();
    }
    
    @Override
    public void render(Graphics2D g){
        if(!moviendose)
            super.render(g);
        else if(moviendose && y > dy)
            animDerecha.render(g, x, y);
        else animDerecha.render(g, x, y);
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
            if(getAbajo().intersects(t.getArriba()) && dy >= 0) {
                puedeSaltar = true;
                cayendo = false;
                dy = 0;
                return true;
            }else cayendo = true;
            if(getLimites().intersects(t.getAbajo()) && dy <= 0){
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
    
    protected void caer(){
        if(cayendo){
            dy += gravedad;
            if(dy > maxDY)
                dy = maxDY;
        }
    }
    protected void saltar(double alturaSalto){
        if(puedeSaltar){
            dy -= alturaSalto;
            puedeSaltar = false;
        }
    }
    
}
