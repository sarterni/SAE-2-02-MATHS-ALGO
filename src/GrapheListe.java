import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    //attributs
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public void ajouterArc(String depart, String destination, double cout){
        boolean present = false;
        for(int i = 0; i < this.ensNom.size();i++){
            if(this.ensNom.get(i).equals(depart)){
                present = true;
                this.ensNoeuds.get(i).ajouterArc(destination, cout);
            }
        }
        if(!present){
            this.ensNom.add(depart);
            List<Arc> tmp = new ArrayList<>();
            tmp.add(new Arc(destination, cout));
            this.ensNoeuds.add(new Noeud(depart, tmp));
        }
        
    }

    public List<String> listeNoeuds(){
        return this.ensNom;
    }

    public List<Arc> suivants(String n){
        List<Arc> res = null;
        for(int i = 0; i < this.ensNom.size(); i++){
            if(this.ensNom.get(i).equals(this.ensNoeuds.get(i).getNom())){
                res = this.ensNoeuds.get(i).getAdj();
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i = 0; i < this.ensNom.size(); i++){
            res += this.ensNom.get(i) + " -> ";
            for(int j = 0; j < this.ensNoeuds.get(i).getAdj().size();i++){
                res += this.ensNoeuds.get(i).getAdj().get(i).getDest() + "(" + this.ensNoeuds.get(i).getAdj().get(i).getCout() + ") ";
            }
            res += "/n";
        }
        return res;
    }
    
    
}
