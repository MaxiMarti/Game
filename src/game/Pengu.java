package game;

import game.input.InputMouse;
import game.input.InputTeclas;
import game.renderizado.texturas.Sprite;
import game.renderizado.texturas.SpriteSheet;
import game.renderizado.texturas.Textura;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Pengu extends Canvas implements Runnable {

    public static final String TITULO = "Pengu";
    public static final int ANCHO = 640;
    public static final int ALTO = ANCHO / 4 * 3;
    
    private boolean andando;
    
    private Menu menu;
    
    public static Pengu INSTANCIA;
    
    public Pengu(){    
        InputMouse im = new InputMouse();
        addMouseListener(im);
        addMouseMotionListener(im);
        addKeyListener(new InputTeclas());
        menu = new Menu();
        
        INSTANCIA = this;
    }
    
    private void tick(){
        menu.tick();
        
    };
    
    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        /////////////////////////////////////////////////////
        
        g.setColor(Color.red);
        g.fillRect(0, 0, ANCHO, ALTO);
        menu.render(g);
        
        /////////////////////////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    private void start(){
        if(andando) return;
        else andando = true;
        new Thread(this, "Pengu.Thread").start();
    }
    
    public void stop(){
        if(!andando) return;
        else andando = false;
    }

    @Override
    public void run() {
        requestFocus();
        double objetivo = 60.0;
        double nsPorTick = 1000000000.0 / objetivo;
        long ultimaVez = System.nanoTime();
        long contador = System.currentTimeMillis();
        double sinProcesar = 0.0;
        int fps = 0;
        int tps = 0;
        boolean puedeRend = false;
        while(andando){
            long ahora = System.nanoTime();
            sinProcesar += (ahora - ultimaVez) / nsPorTick;
            ultimaVez = ahora;
            
            if(sinProcesar >= 1.0){
                tick();
                InputMouse.actualizacion();
                InputTeclas.actualizacion();
                sinProcesar--;
                tps++;
                puedeRend = true;
            }else puedeRend = false;
            
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(puedeRend){
                //renderizar
                render();
                fps++;
            }
            
            if(System.currentTimeMillis() - 1000 > contador){
                contador += 1000;
                System.out.printf("FPS: %d | TPS: %d\n", fps, tps);
                fps=0;
                tps=0;
            }
        }
        
        
        System.exit(0);
    }

    public static void main(String[] args) {
        Pengu game = new Pengu();
        JFrame frame = new JFrame(TITULO);
        frame.add(game);
        frame.setSize(ANCHO, ALTO);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.err.println("Saliendo del Juego");
                game.stop();
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }

}
