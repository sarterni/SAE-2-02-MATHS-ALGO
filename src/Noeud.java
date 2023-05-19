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
        if (o instanceof(Noeud) && this.nom == o.getNom()){
            return true;
        } else {
            return false;
        }
    }

    

}