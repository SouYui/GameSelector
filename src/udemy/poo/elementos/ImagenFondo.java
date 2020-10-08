/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.elementos;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import udemy.poo.interfaz.Actions;

/**
 *
 * @author Sou Akiyama
 */
public class ImagenFondo implements Actions{
    private Image imagen = null;
    private Image imagenDos = null;
    private Image imagenTres = null;
    private Component componente;
    private int x = -20;
    private static ImagenFondo objetoUnico;
    private MediaTracker tracker;
    
    public static ImagenFondo imagenFondo() {
        if (objetoUnico == null) {
            objetoUnico = new ImagenFondo();
        }
        return objetoUnico;
    }

    private ImagenFondo() {
    }
    
    public void configuracion(Component componente, String archivo, String personaje, String orbe) {
        this.componente = componente;
        tracker = new MediaTracker(componente);
        Toolkit herram = Toolkit.getDefaultToolkit();
        imagen = herram.getImage(getClass().getResource("/udemy/poo/recursos/" + archivo));
        imagenDos = herram.getImage(getClass().getResource("/udemy/poo/recursos/" + personaje));
        imagenTres = herram.getImage(getClass().getResource("/udemy/poo/recursos/" + orbe));
        tracker.addImage(imagen, 1);
        tracker.addImage(imagenDos, 2);
        tracker.addImage(imagenTres, 3);
        
        // Espera a que todas las imágenes sean cargadas
        try {
            tracker.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void pintar(Graphics2D g) {
        g.drawImage(imagen, 0, 0, this.componente.getWidth(), this.componente.getHeight(), null);
        g.drawImage(imagenDos, x + 40, 90, 270, 368, null);
        g.drawImage(imagenTres, 470, 100, 50, 50, null);
    }

    @Override
    public void teclado(KeyEvent e) {
    }

    @Override
    public void raton(MouseEvent e) {
    }

    @Override
    public void calculo() {
        /*if (x > this.componente.getWidth() + 20) {
            x = -20;
        } else {
            x += 4;
        }*/
    }
    
}
