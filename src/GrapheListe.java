import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    

    public GrapheListe() {
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();        
    }

    public void ajouterArc(String depart, String destination, double cout){
        boolean present = false;
        Noeud tmp = new Noeud(depart);
        for(int i = 0; i < this.ensNom.size();i++){
            if(this.ensNoeuds.get(i).equals(tmp)){
                present = true;
                this.ensNoeuds.get(i).ajouterArc(destination, cout);
            }
        }
        
        if(!present || this.ensNom.size() == 0){
            tmp.ajouterArc(destination, cout);
            this.ensNoeuds.add(tmp);
            
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



    public GrapheListe(String nomFichier) throws IOException{
        this.ensNoeuds = new ArrayList<Noeud>();
        this.ensNom = new ArrayList<String>();
        File file = new File(nomFichier);
        BufferedReader Br = new BufferedReader(new FileReader(file));
        String line = Br.readLine();
        while(line != null){
            String[] tmp = line.split("\t");
            ajouterArc(tmp[0], tmp[1], Double.parseDouble(tmp[2]));
            line = Br.readLine();
        }
        Br.close();
    }

    public List<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }

    
}