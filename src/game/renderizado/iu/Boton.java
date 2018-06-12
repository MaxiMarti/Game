/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.renderizado.iu;

import game.Juego;
import game.utils.Fuentes;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author aguan
 */
public class Boton extends Rectangle{
    
    private Font fuente, fuenteSeleccionada;
    private Color color, colorSeleccionado;
    private boolean seleccionado;
    private String texto;
    private int textoY;
    
    public Boton(String texto, int textoY, Font fuente, Font fuenteSeleccionada, Color color, Color colorSeleccionado){
        this.texto = texto;
        this.textoY = textoY;
        this.fuente = fuente;
        this.fuenteSeleccionada = fuenteSeleccionada;
        this.color = color;
        this.colorSeleccionado = colorSeleccionado;
    }
    
    public void setSeleccionado(boolean seleccionado){
        this.seleccionado = seleccionado;
    }
    
    public void render(Graphics g){
        if(seleccionado)
            Fuentes.drawString(g, fuenteSeleccionada, colorSeleccionado, texto, textoY);
        else
            Fuentes.drawString(g, fuente, color, texto, textoY);
        FontMetrics fm = g.getFontMetrics();
        this.x = (Juego.ANCHO - fm.stringWidth(texto)) / 2;
        this.y = textoY - fm.getHeight();
        this.width = fm.stringWidth(texto);
        this.height = fm.getHeight();
        g.drawRect(x, y, width, height);
    }
}
