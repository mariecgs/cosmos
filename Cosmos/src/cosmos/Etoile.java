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
public class Etoile extends Astre {
    Position pos;
    
    public Etoile(String nom, String image, Position pos) {
        super(nom,image);
        this.pos=pos;
    }
    
    @Override
    protected Position getPosition(Astre a){
        return this.pos;
    }
}
