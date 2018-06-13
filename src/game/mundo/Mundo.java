/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.mundo;

import game.entidades.Enemigo;
import game.entidades.Jugador;
import game.entidades.Objetivo;
import game.estados.EstadoJuego;
import game.renderizado.texturas.Textura;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author aguan
 */
public class Mundo {
    
    private String nombre;
    private int ancho;
    private int alto;
    private int[] pixeles;
    
    
    
    public Mundo(String nombre, EstadoJuego estado){
        BufferedImage imagen = null;
        try{
            System.out.println(nombre);
            imagen = ImageIO.read(new File("./recursos/niveles/" + nombre + ".png"));
            
        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        this.nombre = nombre;
        this.ancho = imagen.getWidth();
        this.alto = imagen.getHeight();
        pixeles = imagen.getRGB(0, 0, ancho, alto, null, 0, ancho);
        for(int y = 0; y < alto; y++){
            for(int x = 0; x < ancho; x++){
                int id = pixeles[x + y * ancho];
                if(id == 0xFF0000FF)
                    new Jugador(x * 64, y * 64, estado);
                if(Tile.getDesdeID(id) != null)
                    estado.agregarTile(new Tile(id, x, y));
            }
        }
    }
}
