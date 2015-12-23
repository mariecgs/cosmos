/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.Graphics;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class Satellite extends Astre {
    int grandAxe;
    int petitAxe;
    int periodeRotation;

    public Satellite(String nom,String image,int grandAxe,int petitAxe,int periodeRotation) { 
        super(nom,image);
        this.grandAxe = grandAxe;
        this.petitAxe = petitAxe;
        this.periodeRotation = periodeRotation;
    }
    
    /**
     *
     * @param a
     * @return
     */
    @Override
    protected Position getPosition(Astre a){
        Position posAstre=a.getPosition(a);
        Position posSatellite = new Position();
        posSatellite.x=(int) ((grandAxe/2) * Math.cos((System.currentTimeMillis() * 3.14 )/periodeRotation) + posAstre.x);
        posSatellite.y=(int) ((petitAxe/2) * Math.sin((System.currentTimeMillis() * 3.14 )/periodeRotation) + posAstre.y);
        //System.out.println("t : "+System.currentTimeMillis()+" || x = "+posSatellite.x+" || y = "+posSatellite.y);
        return posSatellite;
    }

    void draw(BackgroundPanel b, Graphics g, Astre e) {
        System.out.println("Etoile -> Satellite ->"+this+"  "+this.image);
        ImageIcon img;
        img=new ImageIcon(this.image);
        img.paintIcon(b, g, this.getPosition(e).x-(img.getIconWidth()/2), this.getPosition(e).y-(img.getIconHeight()/2));
        if(listSatellite!=null&& !listSatellite.isEmpty()){
            for(Satellite s : this.listSatellite){
                s.draw(b,g,this);
            }  
        }
    }
}
