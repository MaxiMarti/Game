/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entidades;

import game.estados.EstadoJuego;
import game.mundo.Tile;
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
public abstract class Entidad {

    private static final Map<Integer, Entidad> ENTIDAD_MAP = new HashMap<Integer, Entidad>();
    protected double x, y;
    protected Textura textura;
    protected EstadoJuego estado;
    protected int id;

    private Entidad(int id, Textura textura){
        this.id = id;
        this.textura = textura;
    }
    
    public Entidad(Textura sprite, double x, double y, EstadoJuego estado) {
        this.textura = sprite;
        this.x = x;
        this.y = y;
        this.estado = estado;
        estado.agregarEntidad(this);
    }
    
    public Entidad(int id, int x, int y){
        this.textura = getDesdeID(id).textura;
        this.x = x * textura.getAncho();
        this.y = y * textura.getAlto();
    }

    public abstract void tick();

    public void render(Graphics2D g) {
        textura.render(g, x, y);
        /*      g.setColor(Color.red);
        g.draw(getArriba());
        g.setColor(Color.blue);
        g.draw(getAbajo());
        g.setColor(Color.white);
        g.draw(getDerecha());
        g.setColor(Color.yellow);
        g.draw(getIzquierda());
         */    }

    public Rectangle getLimites() {
        return new Rectangle((int) x, (int) y,
                textura.getAncho(), textura.getAlto());
    }

    public Rectangle getArriba() {
        return new Rectangle((int) x, (int) y,
                textura.getAncho() - 6, 4);
    }

    public Rectangle getAbajo() {
        return new Rectangle((int) x + 4, (int) y + textura.getAlto(),
                textura.getAncho() - 10, 6);
    }

    public Rectangle getDerecha() {
        return new Rectangle((int) x + textura.getAncho() - 10, (int) y + 6,
                4, textura.getAlto() - 10);
    }

    public Rectangle getIzquierda() {
        return new Rectangle((int) x, (int) y + 6,
                4, textura.getAlto() - 10);
    }

    public static Entidad getDesdeID(int id) {
        return ENTIDAD_MAP.get(id);
    }
}
