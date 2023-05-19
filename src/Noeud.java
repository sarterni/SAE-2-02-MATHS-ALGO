import java.util.List;

public class Noeud{
    //Attributs

    /**
     * nom: nom du noeud
     * adj: liste des arcs adjacents
     */
    private String nom;
    private List<Arc> adj;

    //Constructeur
    /**
     * Constructeur permettant de construire un nouveau noeud
     * @param n nom du noeud
     * @param a liste de tous les arcs du noeud
     */
    public Noeud(String n, List<Arc> a){
        this.nom = n;
        this.adj = a;
    }

    /**
     * getteur permettant d'utiliser l'attribut nom dans d'autres classes
     * @return nom du noeud
     */
    public String getNom() {
        return nom;
    }

    /**
     * méthode permettant de comparer si les deux noeuds sont le même
     * @param o noeud a comparer
     * @return true si les noms des deux noeuds sont égaux
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Noeud){
            if(this.nom == ((Noeud) o).getNom()){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * méthode permettant d'ajouter un arc
     * @param destination destination du nouveau arc
     * @param cout cout du nouveau arc
     */
    public void ajouterArc(String destination, double cout){
        adj.add(new Arc(destination, cout));
    }
    

}