import java.util.List;

/**
 * Graphe
 */

public interface Graphe {

    public List<String> listeNoeuds();
    public List<Arc> suivants(String n);
    
}