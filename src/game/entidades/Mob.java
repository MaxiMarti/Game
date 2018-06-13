/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entidades;

import game.Juego;
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
    protected boolean derecha;
    protected Animacion animDerecha;
    protected Animacion animIzquierda;;
    
    public Mob(Textura textura, double x, double y, EstadoJuego estado, Animacion anim) {
        super(textura, x, y, estado);
        cayendo = true;
        gravedad = 0.5;
        maxDY = 12;
        animDerecha = new Animacion(6, 
                new Textura(new Textura("Spritesheet_pengu"), 2, 1, 64),
                new Textura(new Textura("Spritesheet_pengu"), 1, 1, 64),
                new Textura(new Textura("Spritesheet_pengu"), 3, 1, 64),
                new Textura(new Textura("Spritesheet_pengu"), 1, 1, 64));
        animIzquierda = new Animacion(6, 
                new Textura(new Textura("Spritesheet_pengu"), 2, 2, 64),
                new Textura(new Textura("Spritesheet_pengu"), 1, 2, 64),
                new Textura(new Textura("Spritesheet_pengu"), 3, 2, 64),
                new Textura(new Textura("Spritesheet_pengu"), 1, 2, 64));
        
        
    }
    
    
    @Override
    public void tick(){
        mover();
        caer();
        derecha = dx >= 0;
        
        moviendose = dx != 0;
        
        if(moviendose && derecha)
            animDerecha.andar();
        else if(moviendose && !derecha)
            animIzquierda.andar();
    }
    
    public boolean muerto(){
            
        return false;
    }
    
    @Override
    public void render(Graphics2D g){
        if(!moviendose)
            super.render(g);
        else if(moviendose && derecha)
            animDerecha.render(g, x, y);
        else if(moviendose && !derecha)
            animIzquierda.render(g, x, y);
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
            }else if(y < 0) dy = 0;
            else cayendo = true;
            if(getLimites().intersects(t.getAbajo()) && dy <= 0){
                dy = 0;
                return true;
            }else if(y < 0) y = 0;
            
        }
        return false;
    }
    
    protected boolean tieneColisionHorizontal(){
        for(int i = 0; i < estado.getTiles().size(); i++){
            Tile t = estado.getTiles().get(i);
            if(getLimites().intersects(t.getDerecha()) && dx < 0) {
                dx = 0;
                return true;
            }else if(x < 0) x = 0;
            if(getLimites().intersects(t.getIzquierda()) && dx > 0){
                dx = 0;
                return true;
            }else if(x > Juego.ANCHO - 64) x = Juego.ANCHO - 64;
        }
        return false;
    }
    
    protected boolean tieneColisionPeligrosa(){
        for(int i = 0; i < estado.getEntidad().size(); i++){
        Entidad e = estado.getEntidad().get(i);
        if(getLimites().intersects(e.getLimites())){
            System.out.println("Lo tocó");
            estado.salir();
            return true;
        }else return false;
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
