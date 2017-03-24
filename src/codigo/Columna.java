/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author xp
 */
public class Columna {
    
    Rectangle2D capitel, base;
    int hueco = 120;
    double alturaColumna =504;
    int anchoColumna = 79;
    private int anchoPantalla;
    Image col_abajo, col_arriba;
    
    public Columna (int _ancho, int _anchoPantalla) {
        
        Random aleatorio = new Random();
        int desplazamiento = aleatorio.nextInt(300)+200;//altura
        capitel = new Rectangle2D.Double(_ancho,-desplazamiento,anchoColumna,alturaColumna);
        base = new Rectangle2D.Double(_ancho, alturaColumna+hueco-desplazamiento, anchoColumna, alturaColumna);
        
        anchoPantalla = _anchoPantalla;
        precargaImagenes();
    }
    
    private void precargaImagenes(){
         
        col_abajo = (new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/pipe.png")).
               getImage().getScaledInstance(79, 500, Image.SCALE_DEFAULT))).getImage();
        col_arriba = (new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/pipe2.png")).
               getImage().getScaledInstance(79, 506, Image.SCALE_DEFAULT))).getImage();
    }
    
    public void mueve(Graphics2D g2){
        mueveColumna();
        g2.setColor(Color.GREEN);
        g2.drawImage(col_abajo, (int)base.getX(), (int)base.getY(), null);
        g2.drawImage(col_arriba, (int)capitel.getX(), (int)capitel.getY(), null);
    }
    
    private void mueveColumna(){
        if(capitel.getX() + anchoColumna <=0){
            Random aleatorio = new Random();
            int desplazamiento = aleatorio.nextInt(300);//separacion
            capitel.setFrame(anchoPantalla, -desplazamiento,capitel.getWidth(),capitel.getHeight());
            base.setFrame(anchoPantalla, alturaColumna+hueco-desplazamiento,base.getWidth(),base.getHeight());
            
        }else{
            capitel.setFrame(capitel.getX()-1, capitel.getY(),capitel.getWidth(),capitel.getHeight());
            base.setFrame(base.getX()-1, base.getY(),base.getWidth(),base.getHeight());
        }
        
        
            
        
    
    }
}
