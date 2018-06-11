/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.estados;

import java.awt.Graphics;

/**
 *
 * @author aguan
 */
public interface Estado {
    
    public void inic();
    public void entrar();
    public void tick();
    public void render(Graphics g);
    public void salir();
    public String getNombre();
    
}
