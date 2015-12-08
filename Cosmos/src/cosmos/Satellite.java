/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class Satellite extends Astre {
    double grandAxe;
    double petitAxe;
    int periodeRotation;
    int t;
    public Satellite(String image) { //A MODIF !
        super(image);
        this.grandAxe = 1;
        this.petitAxe = 1;
        this.periodeRotation = 2;
        this.t = 0;
    }
    
    @Override
    protected Position getPosition(Astre a){
        Position posAstre=a.getPosition(a);
        Position posSatellite = new Position();
        posSatellite.x=(grandAxe/2) * Math.cos(t/periodeRotation) + posAstre.x;
        posSatellite.y=(petitAxe/2) * Math.sin(t/periodeRotation) + posAstre.y;
        return posSatellite;
    }
}
