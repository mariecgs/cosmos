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
    Position pos;

    public Astre(ArrayList<Satellite> listSatelitte, Position pos) {
        this.listSatelitte = listSatelitte;
        this.pos = pos;
    }
    
    


}
