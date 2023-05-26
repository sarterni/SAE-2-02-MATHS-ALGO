import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    public  Valeur resoudre(Graphe g, String depart) {
        Valeur res = new Valeur();
        int changement = 1;
        List<Arc> tmp = new ArrayList<Arc>();
        for (String s : g.listeNoeuds()) {
            if (s.equals(depart)) {
                res.setValeur(s, 0);
            } else {
                res.setValeur(s, Double.POSITIVE_INFINITY); // Double.MAX_VALUE
            }
            res.setParent(s, null);
        }
        while(changement != 0){
            changement = 0;
            for (int i = 1; i < g.listeNoeuds().size(); i++) {
                for (String s : g.listeNoeuds()) {
                    tmp = g.suivants(s);
                    for (Arc a : tmp) {
                        int j = 0;
                        if (res.getDistance(a.getDest()) > res.getDistance(a.getDest())) {
                            res.setValeur(a.getDest(), res.getDistance(a.getDest()) + a.getCout());
                            res.setParent(a.getDest(), s);
                            changement++;
                        }
                    }
                }
            }
        }
        return res;
    }

}
