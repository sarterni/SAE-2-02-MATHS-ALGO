public class BellmanFord {

    public  Valeur resoudre(Graphe g, String depart) {
        Valeur res = new Valeur();
        int changement = 1;

        for (String s : g.listeNoeuds()) {
            if (s.equals(depart)) {
                res.setValeur(s, 0);
            } else {
                res.setValeur(s, Double.POSITIVE_INFINITY); // Double.MAX_VALUE
            }
            res.setParent(s, null);
        }
        while(changement > 0){
            changement = 0;
            for (int i = 1; i < g.listeNoeuds().size(); i++) {
                for (String s : g.listeNoeuds()) {
                    for (Arc a : g.suivants(s)) {
                        if (res.getDistance(a.getDest()) > res.getDistance(s) + a.getCout()) {
                            res.setValeur(a.getDest(), res.getDistance(s) + a.getCout());
                            res.setParent(a.getDest(), s);
                            changement++;
                        }
                    }
                }
            }
        }
        for (String s : g.listeNoeuds()) {
            for (Arc a : g.suivants(s)) {
                if (res.getDistance(a.getDest()) > res.getDistance(s) + a.getCout()) {
                    System.out.println("Erreur");
                }
            }
        }
        return res;
    }

}
