/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.estados;

import game.Juego;
import game.entidades.Entidad;
import game.entidades.Jugador;
import game.mundo.Tile;
import game.renderizado.texturas.Sprite;
import game.renderizado.texturas.SpriteSheet;
import game.renderizado.texturas.Textura;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author aguan
 */
public class EstadoJuego implements Estado{

    private ArrayList<Entidad> entidades;
    private ArrayList<Tile> tiles;

    @Override
    public void inic() {
        entidades = new ArrayList<Entidad>();
        tiles = new ArrayList<Tile>();
        Jugador jugador = new Jugador(new Sprite(new SpriteSheet(new Textura("Spritesheet_pengu"), 64),1,1), 100.0, 100.0, this);
        float x = 0;
        float y = Juego.ALTO - 74;
        for(int i = 0; i < 10; i++){
            tiles.add(new Tile(x, y, new Sprite(new SpriteSheet(new Textura("Spritesheet_terreno"), 64), 1, 1)));
            x += 70;
                    
        }
    }

    @Override
    public void entrar() {
    }

    @Override
    public void tick(ManagerEstados managerEstado) {
        for(Entidad e : entidades)
            e.tick();
    }

    @Override
    public void render(Graphics2D g) {
        for(Entidad e : entidades)
            e.render(g);
        for(Tile t : tiles)
            t.render(g);
        
    }

    @Override
    public void salir() {
        entidades.clear();
    }

    @Override
    public String getNombre() {
        return "nivel1";
    }

    public void agregarEntidad(Entidad entidad) {
        entidades.add(entidad);
    }
    
    public ArrayList<Tile> getTiles(){
        return tiles;
    }
}
