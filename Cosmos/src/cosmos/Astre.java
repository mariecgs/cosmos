/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cosmos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public abstract class Astre implements Serializable {
    ArrayList<Satellite> listSatellite;
    String image;
    String nom;
    
    public Astre(String nom, String image) {
        this.listSatellite = new ArrayList();
        this.nom = nom;
        this.image = image;
    }
    
    protected Position getPosition(){
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

    String serializer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
