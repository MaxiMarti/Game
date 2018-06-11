package game.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Alumno
 */
public class InputTeclas extends KeyAdapter{
    
    private static final int NUM_TECLAS = 256;
    
    private static final boolean []TECLA = new boolean[NUM_TECLAS];
    private static final boolean []ULTIMA_TECLA = new boolean[NUM_TECLAS];
    
    @Override
    public void keyPressed(KeyEvent e){
        TECLA[e.getKeyCode()] = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        TECLA[e.getKeyCode()] = false;
    }
    
    public static void actualizacion(){
        for(int i = 0; i < NUM_TECLAS; i++){
            ULTIMA_TECLA[i] = TECLA[i];
        }
    }
    
    public static boolean presionada(int codigoTecla){
        return TECLA[codigoTecla];
    }
    
    public static boolean fuePresionada(int codigoTecla){
        return presionada(codigoTecla) && !ULTIMA_TECLA[codigoTecla];
    }
    public static boolean fueSoltada(int codigoTecla) {
        return !presionada(codigoTecla) && ULTIMA_TECLA[codigoTecla];
    }
    
}
