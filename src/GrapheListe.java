import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    

    public GrapheListe() {
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();        
    }

    public GrapheListe(String nomFichier){
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
        String[] tmp = nomFichier.split("\t");
        for(int i = 0; i < tmp.length; i++){
            String[] tmp2 = tmp[i].split(" ");
            this.ajouterArc(tmp2[0], tmp2[1], Double.parseDouble(tmp2[2]));
        }
    }

    public void ajouterArc(String depart, String destination, double cout){
        boolean present = false;
        for(int i = 0; i < this.ensNom.size();i++){
            if(this.ensNom.get(i).equals(depart)){
                present = true;
                this.ensNoeuds.get(i).ajouterArc(destination, cout);
            }
        }
        
        if(!present || this.ensNom.size() == 0){
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
            for(int j = 0; j < this.ensNoeuds.get(i).getAdj().size();j++){
                res += this.ensNoeuds.get(i).getAdj().get(j).getDest() + "(" + this.ensNoeuds.get(i).getAdj().get(j).getCout() + ") ";
            }
            res += "\n";
        }
        return res;
    }
    
    public String toGraphviz(){
        String res = "digraph G {\n";
        for(int i = 0; i < this.ensNom.size(); i++){
            for (int j = 0; j < this.ensNoeuds.get(i).getAdj().size();j++){
                res += this.ensNom.get(i) + " -> " + this.ensNoeuds.get(i).getAdj().get(j).getDest() + "[label = " + this.ensNoeuds.get(i).getAdj().get(j).getCout() + "]\n";
            }
        }
        res += "}";
        return res;
    }

    public String toMatrice(){
        String res = " \t";
        boolean present = false;
        int k = 0;
        for(int i = 0; i < this.ensNom.size();i++){
            res += this.ensNom.get(i) + "\t";
        }
        res += "\n";
        for(int i = 0; i < this.ensNoeuds.size();i++){
            res += this.ensNom.get(i) + "\t";
            for(int j = 0; j < this.ensNoeuds.size(); j++){
                if(this.ensNoeuds.get(i).getNom().equals(this.ensNoeuds.get(j).getNom())){
                    res += "0. \t";
                } else {
                    while (k < this.ensNoeuds.get(i).getAdj().size() || present){
                        if(this.ensNoeuds.get(j).getNom().equals(this.ensNoeuds.get(i).getAdj().get(k))){
                            present = true;
                        }
                    }
                    if(present){
                        res += this.ensNoeuds.get(i).getAdj().get(k).getCout() + "\t";
                    }
                }
            }
            res += "\n";
        }
        return res;
    }
}