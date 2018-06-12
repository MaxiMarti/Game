/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.estados;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aguan
 */
public class ManagerEstados {
    
    private Map<String, Estado> mapa;
    private Estado estadoActual;
    
    public ManagerEstados(){
        mapa = new HashMap<String, Estado>();
    }
    
    public void agregarEstado(Estado estado){
        mapa.put(estado.getNombre().toUpperCase(), estado);
        estado.inic();
        if(estadoActual == null){
            estado.entrar();
            estadoActual = estado;
        }
    }
    
    public void setEstado(String nombre){
        Estado estado = mapa.get(nombre.toUpperCase());
        if(estado == null){
            System.err.println("Estado < " + nombre + " > no existe!");
            return;
        }
        estadoActual.salir();
        estado.entrar();
        estadoActual = estado;
    }
    
    public void tick(){
        estadoActual.tick(this);
    }
    public void render(Graphics2D g){
        estadoActual.render(g);
    }
    
}
