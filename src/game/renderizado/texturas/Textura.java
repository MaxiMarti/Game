package game.renderizado.texturas;

import game.utils.managers.ManagerDeTexturas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class Textura {
    
    private final static Map<String, ManagerDeTexturas> texMap = new HashMap<String, ManagerDeTexturas>();
    private ManagerDeTexturas manager;
    private String fileName;
    
    public Textura(String fileName) {
        this.fileName = fileName;
        ManagerDeTexturas texturaVieja = texMap.get(fileName);
        if(texturaVieja != null){
            manager = texturaVieja;
            manager.addReference();
        }
        else{
            try {
                System.out.println("Cargando textura: " + fileName);
                manager = new ManagerDeTexturas(ImageIO.read(new File("./recursos/texturas/" + fileName + ".png")));
                texMap.put(fileName, manager);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }   
    @Override
    protected void finalize() throws Throwable{
        if(manager.removeReference() && !fileName.isEmpty()) texMap.remove(fileName);
        super.finalize();
    }
    
    public void render(Graphics g, double x, double y){
        g.drawImage(manager.getImagen(), (int) x, (int) y, null);
    }
    
    public BufferedImage getImagen(){
        return manager.getImagen();
    }
}
