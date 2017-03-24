/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author xp
 */
public class Suelo extends Rectangle2D.Double{
    
    Image suelo; 
    
    public Suelo(double _anchoPantalla, double _posicionY){
        super();
        
        suelo = new ImageIcon(getClass().getResource("/imagenes/suelo.png")).getImage();
        
        this.x = 0;
        this.y = _posicionY;
        this.width = suelo.getWidth(null);
        this.height = suelo.getHeight(null);
    }
    
    public void mueve(Graphics2D g2){
        
        this.x--;
                
        g2.drawImage(suelo, (int)this.x, (int)this.y, null);
        if(this.x+this.width <= 400){
            this.x = 400;
        }
        
        
    }


}
