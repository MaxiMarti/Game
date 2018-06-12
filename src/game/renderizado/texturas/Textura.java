package game.renderizado.texturas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class Textura {
    
    private final static Map<String, BufferedImage> texMap = new HashMap<String, BufferedImage>();
    
    private BufferedImage imagen;
    private String fileName;
    private int ancho, alto;
    
    public Textura(String fileName) {
        this.fileName = fileName;
        BufferedImage texturaVieja = texMap.get(fileName);
        if(texturaVieja != null)
            this.imagen = texturaVieja;
        else{
            try {
                System.out.println("Cargando textura: " + fileName);
                this.imagen = ImageIO.read(new File("./recursos/texturas/" + fileName + ".png"));
                texMap.put(fileName, imagen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.alto = imagen.getHeight();
        this.ancho = imagen.getWidth();
    }   
    
    public Textura(Textura spriteSheet, int x, int y, int ancho, int alto){
        this.alto = alto;
        this.ancho = ancho;
        String clave = spriteSheet.fileName + "_" + x + "_" + y;
        BufferedImage vieja = texMap.get(clave);
        if(vieja != null)
            this.imagen = vieja;
        else
            this.imagen = spriteSheet.imagen.getSubimage(x * ancho - ancho, y * alto - alto, ancho, alto);
    }
    
    public Textura(Textura spriteSheet, int x, int y, int tamaño){
        this(spriteSheet, x, y, tamaño, tamaño);
    }
    
    public void render(Graphics g, double x, double y){
        g.drawImage(imagen, (int) x, (int) y, null);
    }
    
    public int getAncho(){
        return ancho;
    }
    
    public int getAlto(){
        return alto;
    }
}
