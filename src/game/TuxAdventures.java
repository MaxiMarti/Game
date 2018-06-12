/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author aguan
 */
public class TuxAdventures {
    public static void main(String[] args) {
        Juego juego = new Juego();
        JFrame frame = new JFrame(Juego.TITULO);
        frame.add(juego);
        frame.setSize(Juego.ANCHO, Juego.ALTO);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.err.println("Saliendo del Juego");
                juego.stop();
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        juego.start();
    }
}
