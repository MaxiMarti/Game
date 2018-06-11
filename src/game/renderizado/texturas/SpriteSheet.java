/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.renderizado.texturas;


/**
 *
 * @author aguan
 */
public class SpriteSheet {
    
    private Textura textura;
    private int ancho, alto;
    
    public SpriteSheet(Textura textura, int tamaño){
        this(textura, tamaño, tamaño);
    }
    
    public SpriteSheet(Textura textura, int alto, int ancho){
        this.textura = textura;
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public Textura getTextura(){
        return textura;
    }
    
    public int getAncho(){
        return ancho;
    }
    
    public int getAlto(){
        return alto;
    }
    
}
