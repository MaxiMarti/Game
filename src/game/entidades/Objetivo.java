/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entidades;

import game.estados.EstadoJuego;
import game.renderizado.texturas.Textura;

/**
 *
 * @author aguan
 */
public class Objetivo extends Entidad{

    public Objetivo(int x, int y, EstadoJuego estado) {
        super(new Textura(new Textura("Manzana"), 1, 1, 64), x, y, estado);
    }

    @Override
    public void tick() {
    }
    
}
