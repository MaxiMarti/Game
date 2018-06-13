/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.estados;

import game.Juego;
import game.entidades.Entidad;
import game.entidades.Jugador;
import game.input.InputTeclas;
import game.mundo.Mundo;
import game.mundo.Tile;
import game.renderizado.texturas.Textura;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author aguan
 */
public class EstadoJuego implements Estado{

    private ArrayList<Entidad> entidades;
    private ArrayList<Tile> tiles;
    private Mundo mundo;
    
    @Override
    public void inic() {
        entidades = new ArrayList<Entidad>();
        tiles = new ArrayList<Tile>();
        mundo = new Mundo("nivel1", this);
        
    }

    @Override
    public void entrar() {
    }

    @Override
    public void tick(ManagerEstados managerEstado) {
        if(InputTeclas.fuePresionada(KeyEvent.VK_ESCAPE)){
            System.out.println("Salir");
                Juego.INSTANCIA.stop();
                System.exit(0);
        }
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
    
    public void agregarTile(Tile tile){
        tiles.add(tile);
    }
    
    public ArrayList<Tile> getTiles(){
        return tiles;
    }
    
    public ArrayList<Entidad> getEntidad(){
        return entidades;
    }
}
