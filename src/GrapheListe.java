import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    /**
     * ensNom : Liste contenant le nom de tout les noeuds du graphe
     * ensNoeud : Liste contenant tout les noeuds du graphe
     */
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    
    /**
     * constructeur permettant de construire un nouveau graphe
     */
    public GrapheListe() {
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();        
    }
    /**
     * constructeur permettant de construire un graphe à partir d'un fichier
     * @param nomFichier nom du fichier
     */
    public GrapheListe(String nomFichier){
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
        String[] tmp = nomFichier.split("\t");
        for(int i = 0; i < tmp.length; i++){
            String[] tmp2 = tmp[i].split(" ");
            this.ajouterArc(tmp2[0], tmp2[1], Double.parseDouble(tmp2[2]));
        }
    }
    /**
     * méthode permettant d'ajouter un arc à un noeud
     * crée un nouveau noeud si le départ n'est pas encore présent dans ensNom
     * @param depart point de départ du noeud
     * @param destination destination du noeud
     * @param cout cout du trajet
     */
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
    /**
     * méthode permettant de récupérer la liste de tous les points de départs de noeuds
     * @return this.ensNoeud
     */
    public List<String> listeNoeuds(){
        return this.ensNom;
    }
    /**
     * méthode permettant d'accéder à la liste des arcs auxquels 
     * un noeud à accès
     * @param n nom du noeud
     * @return liste des arcs auxquels n à accès
     */
    public List<Arc> suivants(String n){
        List<Arc> res = null;
        for(int i = 0; i < this.ensNom.size(); i++){
            if(this.ensNom.get(i).equals(this.ensNoeuds.get(i).getNom())){
                res = this.ensNoeuds.get(i).getAdj();
            }
        }
        return res;
    }
    /**
     * méthode permettant d'afficher les informations du graphe
     * @return les informations du graphe
     */
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
    /**
     * méthode permettant d'afficher les information du graphe de
     * façon qu'on puisse utiliser l'afficage dans graphviz
     * @return informations utilisable dans graphviz
     */
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

    /**
     * méthode permettant d'afficher les informations sous forme de matrice
     * @return les informations du graphe sous forme de matrice
     */
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
                k = 0;
            }
            res += "\n";
        }
        return res;
    }
}