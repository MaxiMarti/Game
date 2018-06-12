/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.utils;

import game.Juego;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author aguan
 */
public class Fuentes {
    
    public static void drawString(Graphics g, Font f, Color c, String texto, int x, int y){
        g.setColor(c);
        g.setFont(f);
        g.drawString(texto, x, y);
    }
    
    public static void drawString(Graphics g, Font f, Color c, String texto){
        FontMetrics fm = g.getFontMetrics(f);
        int x = (Juego.ANCHO - fm.stringWidth(texto)) / 2;              //centro horizontal
        int y = ((Juego.ALTO - fm.getHeight()) / 2) + fm.getAscent();   //centro vertical
        drawString(g, f, c, texto, x, y);    
    }
    public static void drawString(Graphics g, Font f, Color c, String texto, int y){
        FontMetrics fm = g.getFontMetrics(f);
        int x = (Juego.ANCHO - fm.stringWidth(texto)) / 2;              //centro horizontal
        drawString(g, f, c, texto, x, y);
        
    }
    public static void drawString(Graphics g, Font f, Color c, String texto, double x){
        FontMetrics fm = g.getFontMetrics(f);
        int y = ((Juego.ALTO - fm.getHeight()) / 2) + fm.getAscent();   //centro vertical
        drawString(g, f, c, texto, (int) x, y);
        
    }
    
}
