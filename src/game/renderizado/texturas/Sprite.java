/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.renderizado.texturas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author aguan
 */
public class Sprite {
    
    private BufferedImage imagen;
    
    public Sprite(SpriteSheet spritesheet, int x, int y){
        this.imagen = spritesheet.getTextura().getImagen().getSubimage  ((x * spritesheet.getAncho()) - spritesheet.getAncho(),
                                                                        ((y * spritesheet.getAlto()) - spritesheet.getAlto()),
                                                                        spritesheet.getAncho(),
                                                                        spritesheet.getAlto());
    }
    
    public void render(Graphics g, double x, double y){
        g.drawImage(imagen, (int)x, (int) y, null);
    }
    
}
