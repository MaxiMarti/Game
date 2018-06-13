/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entidades;

import game.estados.EstadoJuego;
import game.renderizado.texturas.Textura;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author aguan
 */
public class Proyectil extends Mob{

        private Textura sprite;
    public Proyectil(Textura sprite, double x, double y, EstadoJuego estado) {
        super(sprite = new Textura(new Textura("Machete"), 1, 1, 16, 8), x, y, estado, null);
        this.sprite = sprite;
    }

    @Override
    public void tick() {
        x += dx;
    }
    
    @Override
    public void render(Graphics2D g){
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 16, 8);
    }
    
    public Rectangle getLimites(){
        return new Rectangle((int) x, (int) y, 16, 8);
    }
    
    public Textura getSprite(){
        return this.textura;
    }
    
}
