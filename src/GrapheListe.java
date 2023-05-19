import java.util.List;

public class GrapheListe implements Graphe {

    //attributs
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public void ajouterArc(String depart, String destination, double cout){
        this.ensNom.add(depart);
        
        List<Arc> tmp = new List<Arc>();
        tmp.add(new Arc(destination, cout));
        this.ensNoeuds.add(new Noeud(depart, tmp));
    }

    public List<String> listeNoeuds(){
        return ensNom;

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
    
}
