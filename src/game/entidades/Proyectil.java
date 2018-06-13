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

/**
 *
 * @author aguan
 */
public class Proyectil extends Mob{

    public Proyectil(Textura sprite, double x, double y, EstadoJuego estado) {
        super(sprite, x, y, estado, null);
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
    
}
