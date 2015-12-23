/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cosmos;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public abstract class Astre {
    ArrayList<Satellite> listSatellite;
    String image;
    String nom;
    
    public Astre(String nom, String image) {
        this.listSatellite = new ArrayList();
        this.nom = nom;
        this.image = image;
    }
    
    protected Position getPosition(Astre a){
        return new Position(0,0);
    }
    
    public DefaultMutableTreeNode construitNoeuds(){
        DefaultMutableTreeNode noeud = new DefaultMutableTreeNode(this);
        Iterator<Satellite> i = this.listSatellite.iterator();
        while (i.hasNext()) {
          noeud.add(((Satellite)i.next()).construitNoeuds());
        }
        return noeud;
    }
    
    @Override
    public String toString(){
        return this.nom;
    }


}
