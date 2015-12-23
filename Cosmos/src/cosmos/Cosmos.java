/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cosmos;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class Cosmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException 
    {
        Fenetre test=new Fenetre();
        
        ArrayList<Etoile> listEtoile = new ArrayList();
        listEtoile.add(new Etoile("Soleil","",new Position(200,200)));
        listEtoile.get(0).listSatellite.add(new Satellite("Terre","",50,50,999));
    }

}
