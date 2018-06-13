package game;

import game.estados.EstadoJuego;
import game.estados.EstadoMenu;
import game.estados.ManagerEstados;
import game.input.InputMouse;
import game.input.InputTeclas;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Juego extends Canvas implements Runnable {

    public static final String TITULO = "Tux's Adventures";
    public static final int ANCHO = 1280;
    public static final int ALTO = ANCHO / 4 * 3;
    
    private boolean andando;
    
    private ManagerEstados managerEstado;
    
    public static Juego INSTANCIA;
    
    public Juego(){    
        InputMouse im = new InputMouse();
        addMouseListener(im);
        addMouseMotionListener(im);
        addKeyListener(new InputTeclas());
        managerEstado = new ManagerEstados();
        
        managerEstado.agregarEstado(new EstadoMenu());
        managerEstado.agregarEstado(new EstadoJuego());
        INSTANCIA = this;
    }
    
    private void tick(){
        managerEstado.tick();
        
    };
    
    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(-6, -28);
        /////////////////////////////////////////////////////
        
        g.setColor(Color.black);
        g.fillRect(0, 0, ANCHO, ALTO);
        managerEstado.render(g2d);
        
        /////////////////////////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    protected void start(){
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

    

}
