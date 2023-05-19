import java.util.List;

public class Noeud{
    //Attributs

    private String nom;
    private List<Arc> adj;

    //Constructeur
    public Noeud(String n, List<Arc> a){
        this.nom = n;
        this.adj = a;
    }

    public String getNom() {
        return nom;
    }

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

    public void ajouterArc(String destination, double cout){
        adj.add(new Arc(destination, cout));
    }
    

}