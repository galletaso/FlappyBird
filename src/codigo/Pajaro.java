/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

/**
 *
 * @author jorgecisneros
 */
public class Pajaro extends Ellipse2D.Double{
    
    int i=0;
    
    Color colorPajaro;
    double yVelocidad = -1;
    Image skin, skin2, skin3;
    
    public Pajaro(int _radio, Color _color){
        super(100, 100, _radio, _radio);
        colorPajaro = _color;
        precargaImagenes();
    }
    
    private void precargaImagenes(){
         
        skin= (new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/birdp1.png")).
               getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT))).getImage();
        skin2= (new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/birdp2.png")).
               getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT))).getImage();
        skin3= (new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/birdp3.png")).
               getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT))).getImage();
    }
    
    public void mueve(Graphics2D g2){
        
        this.y = this.y - yVelocidad;
        
        //tope para que no se salga por el techo o suelo
        if(this.y<0){
            this.y = 0;
            yVelocidad = -0.4;
        }else if(this.y>700){
            this.y=0;
            yVelocidad=0;
        }
        g2.setColor(colorPajaro);
        
        //g2.drawImage(skin2, (int)this.getX(), (int)this.getY(), null);
        yVelocidad -=0.25;
        if(yVelocidad == 0){
            yVelocidad -= 0.25;
        }
        i++;
        if(i%3==0){
            g2.drawImage(skin, (int)this.getX(), (int)this.getY(), null);
        }else if (i%2==0){
            g2.drawImage(skin2, (int)this.getX(), (int)this.getY(), null);
        }else{
            g2.drawImage(skin3, (int)this.getX(), (int)this.getY(), null);
        }
    }
    
    public boolean chequeaColision(Columna c){
        
        
        return (this.intersects(c.capitel)||this.intersects(c.base));
    }

}
