/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.utils.managers;

import java.awt.image.BufferedImage;

/**
 *
 * @author aguan
 */
public class ManagerDeTexturas extends ManagerDeRecursos {
    
    private BufferedImage imagen;
    
    public ManagerDeTexturas(BufferedImage imagen){
        this.imagen = imagen;
    }
    
    public BufferedImage getImagen(){
        return imagen;
    }

}
