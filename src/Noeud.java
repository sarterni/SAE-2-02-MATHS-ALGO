public class Noeud{
    //Attributs

    private String nom;
    private List<Arc> adj;

    //Constructeur
    public Noeud(String n, List<Arc> a){
        this.nom = n;
        this.adj = a;
    }
    
}