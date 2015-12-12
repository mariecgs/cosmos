/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.util.Date;

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
        Date date=new Date();
        Position posAstre=a.getPosition(a);
        Position posSatellite = new Position();
        posSatellite.x=(int) ((grandAxe/2) * Math.cos(date.getTime()/periodeRotation) + posAstre.x);
        posSatellite.y=(int) ((petitAxe/2) * Math.sin(date.getTime()/periodeRotation) + posAstre.y);
        return posSatellite;
    }
}
