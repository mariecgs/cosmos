/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cosmos;

import java.util.ArrayList;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public abstract class Astre {
    ArrayList<Satellite> listSatelitte;

    public Astre() {
        this.listSatelitte = new ArrayList();
    }
    
    protected Position getPosition(Astre a){
        return new Position(0,0);
    }
    
    


}