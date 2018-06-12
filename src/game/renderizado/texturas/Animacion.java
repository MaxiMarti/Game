/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.renderizado.texturas;

import java.awt.Graphics2D;

/**
 *
 * @author aguan
 */
public class Animacion {
    
    private int indice;
    private int cont;
    private int vel;
    private int numFrames;
    private Textura frameActual;
    private Textura[] frames;
    
    public Animacion(int vel, Textura... frames){
        this.vel = vel;
        this.frames = frames;
        this.numFrames = frames.length;
    }
    
    private void sigFrame(){
        frameActual = frames[cont++];
        if(cont >= numFrames)
            cont = 0;     
    }
    
    public void andar(){
        indice++;
        if(indice > vel){
            indice = 0;
            sigFrame();
        }
    }
    
    public void render(Graphics2D g, double x, double y){
        if(frameActual != null)
            frameActual.render(g, x, y);
        
    }
    
}
